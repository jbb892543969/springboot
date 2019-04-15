package com.jbb.manager.controller;

import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

/**
 * @ClassName Test
 * @Author 金斌斌
 * @Description
 * @Date 2018-07-24 10:42
 **/
public class Test {
    public static void main(String[] args) {
        PathMatcher matcher = new AntPathMatcher();
        // 完全路径url方式路径匹配
//        String requestPath="/user/list.htm?username=aaa&departmentid=2&pageNumber=1&pageSize=20";//请求路径
//        String patternPath="/user/list.htm**";//路径匹配模式

        // 不完整路径uri方式路径匹配
//         String requestPath="/app/pub/login.do";//请求路径
//         String patternPath="/**/login.do";//路径匹配模式
        // 模糊路径方式匹配
//         String requestPath="/app/pub/login.do";//请求路径
//         String patternPath="/**/*.do";//路径匹配模式
        // 包含模糊单字符路径匹配
        //String requestPath = "/app/pub/login.do";// 请求路径
        //String patternPath = "/**/lo?in.do";// 路径匹配模式

        String requestPath = "/user/a/a1";//请求路径
        String patternPath = "/user/a/a1";//路径匹配模式
        boolean result = matcher.match(patternPath, requestPath);
        System.out.println(result);

    }
}
