package com.nboweb.web.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/responseDemo03")
public class ResponseDemo03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //System.out.println("resp3...");
        //设置输出流的编码格式
        response.setContentType("text/html;charset=utf-8");
        //1、获取字符输出流
        PrintWriter writer=response.getWriter();//默认编码格式为iso-88591
//        //设置content-type
//        response.setHeader("content-type","text/html");
        writer.write("<h2>LJK response，你好啊！！！</h2>");

        //细节：流不需要关闭
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
