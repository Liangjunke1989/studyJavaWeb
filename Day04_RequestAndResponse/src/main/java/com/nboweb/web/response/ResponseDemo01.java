package com.nboweb.web.response;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/responseDemo01")
public class ResponseDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("resp1...");

        //一般方式完成重定向
//        //1、设置响应状态码 302
//        response.setStatus(302);
//        //2、设置响应头 Location
//        response.setHeader("location","/responseDemo02");

        //简化方式完成重定向
       // response.sendRedirect("/responseDemo02");

        //动态获取虚拟目录
        String contextPath = request.getContextPath();
        response.sendRedirect(contextPath+"/responseDemo02");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
