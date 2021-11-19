package com.tan;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
@WebServlet(name = "down",urlPatterns = {"/down"})
public class respDown extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String realpath = "C:\\Users\\Administrator\\Desktop\\众创空间\\webdemo\\src\\main\\resources\\1.png";
        System.out.println("文件路径:" + realpath);
        String filename=realpath.substring(realpath.lastIndexOf("\\")+1);
        resp.setHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode(filename,"UTF-8"));
        FileInputStream in = new FileInputStream(realpath);
        int len = 0;
        byte[] buffer = new byte[1024];
        ServletOutputStream out = resp.getOutputStream();
        while((len=in.read(buffer))>0){
            out.write(buffer,0,len);
            System.out.println(len);
        }
        in.close();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}