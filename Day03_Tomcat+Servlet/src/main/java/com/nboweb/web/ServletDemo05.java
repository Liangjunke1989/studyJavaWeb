package com.nboweb.web;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class ServletDemo05 implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        // 需要根据请求方式的不同，分别进行处理

        //1、获取请求方式
        HttpServletRequest request=(HttpServletRequest) servletRequest;
        String method = request.getMethod();
        //2、判断
        if (method.equals("GET")){
            // get方式的处理逻辑
        }else if (method.equals("POST")){
            // get方式的处理逻辑
        }

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
