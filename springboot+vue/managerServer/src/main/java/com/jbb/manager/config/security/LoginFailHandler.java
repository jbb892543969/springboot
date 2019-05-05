package com.jbb.manager.config.security;

import com.alibaba.fastjson.JSONObject;
import com.jbb.manager.util.JsonResult;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName LoginFailHandler
 * @Author 金斌斌
 * @Description 登录失败Handler
 * @Date 2018-07-25 11:39
 **/
@Component
public class LoginFailHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        //用户认证失败
        PrintWriter writer = httpServletResponse.getWriter();
        if (e instanceof UsernameNotFoundException) {
            JsonResult result = new JsonResult(1, "用户不存在");
            String json = JSONObject.toJSONString(result);
            writer.write(json);
        }
        if (e instanceof BadCredentialsException) {
            JsonResult result = new JsonResult(2, "密码错误");
            String json = JSONObject.toJSONString(result);
            writer.write(json);
        }
        if (e instanceof LockedException) {
            JsonResult result = new JsonResult(3, "用户被锁定");
            String json = JSONObject.toJSONString(result);
            writer.write(json);
        }
        writer.flush();
        writer.close();
    }
}
