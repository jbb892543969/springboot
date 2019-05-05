package com.jbb.manager.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @ClassName CodeFilter
 * @Author 金斌斌
 * @Description 请求编码过滤器
 * @Date 2018-07-25 11:46
 **/
public class CodeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletResponse.setCharacterEncoding("UTF-8");
        servletRequest.setCharacterEncoding("UTF-8");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
