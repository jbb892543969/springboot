package com.jbb.manager.config.security;

import com.alibaba.fastjson.JSONObject;
import com.jbb.manager.util.JsonResult;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName LoginSuccessHandler
 * @Author 金斌斌
 * @Description 登录成功Handler
 * @Date 2018-07-25 11:37
 **/
@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        //用户认证成功

        JsonResult result = new JsonResult(200, "登录成功");
        PrintWriter out = httpServletResponse.getWriter();
        out.write(JSONObject.toJSONString(result));
        out.flush();
        out.close();
    }
}
