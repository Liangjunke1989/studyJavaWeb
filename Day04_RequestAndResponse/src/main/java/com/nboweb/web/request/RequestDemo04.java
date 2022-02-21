package com.nboweb.web.request;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet("/demo04")
public class RequestDemo04 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、解决乱码：提交方式乱码
        request.setCharacterEncoding("UTF-8");//设置字符输入流的编码

        //2、获取请求参数
        String username = request.getParameter("username");
        System.out.println("解决乱码前："+username);

        //3、Get,获取参数的方式：getQueryString
        //3.1 先对乱码数据进行编码：转为字节数组
        byte[] bytes = username.getBytes(StandardCharsets.ISO_8859_1);
        //3.2 字节数组解码
        username=new String(bytes,StandardCharsets.UTF_8);

        System.out.println("解决乱码后："+username);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
