package com.jbb.manager.controller;

import com.alibaba.fastjson.JSONObject;
import com.jbb.manager.util.JsonResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by sang on 2017/12/29.
 */
@RestController
public class RegLoginController {
    @RequestMapping("/login_p")
    public void login(HttpServletResponse resp) throws IOException {
        PrintWriter out = resp.getWriter();
        JsonResult result = new JsonResult(4, "用户未登录");
        out.write(JSONObject.toJSONString(result));
        out.flush();
        out.close();
    }
}
