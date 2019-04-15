package com.jbb.manager.config.security;

import com.jbb.manager.filter.CodeFilter;
import com.jbb.manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

/**
 * @ClassName SecurityConfig
 * @Author 金斌斌
 * @Description
 * @Date 2018-07-23 15:57
 **/
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserService userService;
    @Autowired
    private CustomSecurityMetadataSource customSecurityMetadataSource;
    @Autowired
    private CustomAuthenticationManager customAuthenticationManager;
    @Autowired
    private CustomAuthenticationFailureHandler customAuthenticationFailureHandler;
    @Autowired
    private LoginSuccessHandler loginSuccessHandler;
    @Autowired
    private LoginFailHandler loginFailHandler;
    @Autowired
    private LogoutHandler logoutHandler;

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userService);//用户登录逻辑
        provider.setPasswordEncoder(new BCryptPasswordEncoder());//密码加密
        provider.setHideUserNotFoundExceptions(false);//不隐藏异常
        return provider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/index.html", "/img/**", "/login_p", "/user/login").permitAll()//所有人可访问的请求
                .anyRequest().authenticated()//其他请求登录后可访问
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O o) {
                        //返回url所具有的权限信息，进行鉴权操作
                        o.setSecurityMetadataSource(customSecurityMetadataSource);
                        //进行鉴权操作
                        o.setAccessDecisionManager(customAuthenticationManager);
                        return o;
                    }
                })
                .and().
                formLogin().loginPage("/login_p").loginProcessingUrl("/user/login").usernameParameter("account").passwordParameter("password").permitAll()
                .failureHandler(loginFailHandler).successHandler(loginSuccessHandler)
                .and()
                .logout().logoutSuccessHandler(logoutHandler).permitAll()
                .and().csrf().disable()
                .exceptionHandling().accessDeniedHandler(customAuthenticationFailureHandler);
        //编码过滤器
        http.addFilterBefore(new CodeFilter(), ChannelProcessingFilter.class);
        //token过滤器

    }

}