package com.jbb.manager.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @ClassName BaseConfig
 * @Author 金斌斌
 * @Description
 * @Date 2018-07-23 16:15
 **/
@Configuration
public class BaseConfig implements WebMvcConfigurer {
    @PersistenceContext
    private EntityManager em;

    @Bean
    public JPAQueryFactory getQueryFactory() {
        return new JPAQueryFactory(em);
    }

    @Bean
    public BCryptPasswordEncoder getEncoder() {
        return new BCryptPasswordEncoder();
    }

}
