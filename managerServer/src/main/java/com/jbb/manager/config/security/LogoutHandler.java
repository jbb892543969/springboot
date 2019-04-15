package com.jbb.manager.config.security;

import com.alibaba.fastjson.JSONObject;
import com.jbb.manager.util.JsonResult;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName LogoutHandler
 * @Author 金斌斌
 * @Description 登出成功Handler
 * @Date 2018-07-25 14:02
 **/
@Component
public class LogoutHandler implements LogoutSuccessHandler {
    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        PrintWriter out = httpServletResponse.getWriter();
        JsonResult result = new JsonResult(5, "登出成功");
        out.write(JSONObject.toJSONString(result));
        out.flush();
        out.close();
    }
}
