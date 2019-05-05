package com.jbb.manager.config.security;

import com.alibaba.fastjson.JSONObject;
import com.jbb.manager.util.JsonResult;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName CustomAuthenticationFailureHandler
 * @Author 金斌斌
 * @Description 鉴权后异常处理
 * @Date 2018-07-25 11:02
 **/
@Component
public class CustomAuthenticationFailureHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        PrintWriter out = httpServletResponse.getWriter();
        if (e instanceof AccessDeniedException) {
            JsonResult result = new JsonResult(403, "权限不足请联系管理员");
            out.write(JSONObject.toJSONString(result));
            out.flush();
            out.close();
        }
    }
}
