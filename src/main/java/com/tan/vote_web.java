package com.tan;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.PublicKey;
import java.util.Locale;

@WebServlet(name = "vote",urlPatterns = {"/vote"})
public class vote_web extends HttpServlet {
    int malenum=0;
    int femalenum=0;
    int a=0,b=0;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset = UTF - 8");
        ServletOutputStream out = resp.getOutputStream();
        resp.sendRedirect("vote.html");

//        String s="";
//        s="<!DOCTYPE html>\n" +
//                "<html lang=\"en\">\n" +
//                "<head>\n" +
//                "    <meta charset=\"UTF-8\">\n" +
//                "    <title>Title</title>\n" +
//                "</head>\n" +
//                "<body>\n" +
//                "       <a href=\"vote.html\">turn</a><br>" +
//                "    <form action=\"test\" method=\"post\">\n" +
//                "        用户名：<input type=\"text\" name=\"user\" ><br>\n" +
//                "        密码&nbsp&nbsp&nbsp：<input type=\"password\" name=\"password\"><br>\n" +
//                "        性别：<input type=\"radio\" name=\"sex\" value=\"Male\">Male\n" +
//                "            <input type=\"radio\" name=\"sex\" value=\"Female\">Female<br>\n" +
//                "        年龄:<input type=\"text\" name=\"age\"><br>\n" +
//                "        院系：<select name=\"select1\">\n" +
//                "        <option value=\"—————请选择—————\">—————请选择—————</option>\n" +
//                "        <option value=\"光电信息与计算机学院\">光电信息与计算机学院</option>\n" +
//                "        <option value=\"信息安全\">信息安全</option>\n" +
//                "        <option value=\"通信\">通信</option>\n" +
//                "    </select><br>\n" +
//                "        兴趣爱好:<input type=\"checkbox\" name=\"checkbox1\" value=\"basketball\">basketball\n" +
//                "        <input type=\"checkbox\" name=\"checkbox1\" value=\"football\">football<br>\n" +
//                "        <input type=\"submit\" value=\"submit\">\n" +
//                "    </form>\n" +
//                "</body>\n" +
//                "</html>";
//        out.write(s.getBytes("utf-8"));

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        int age = -1;

        age = Integer.parseInt(req.getParameter("age"));
        if( age <= 18){
            doGet(req, resp);
            return ;
        }
        resp.setContentType("text/html;charset = UTF - 8");
        String s="<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +

                "</head>\n" +
                "<body>\n";
        s+=     "用户名：";
        s+=req.getParameter("user");
        s+="<br>性别:";
        s+=req.getParameter("sex");
        s+="<br>院系：";
        s+=req.getParameter("select1");
        s+="<br>兴趣爱好：";
        String[] checkb=req.getParameterValues("checkbox1");
        if(checkb!=null)
        for(int i=0;i<checkb.length;i++){
            if(checkb[i].equals("basketball"))a++;
            if(checkb[i].equals("football"))b++;
            s+=" " + checkb[i];
        }

        //统计内容

        s = s + "<br>" + "<br>" + "统计内容" + "<br>";
        if (req.getParameter("sex").equals("Male")){
            malenum++;
        }else {
            femalenum++;
        }
        s = s + "male:" + String.valueOf(malenum) + "<br>";
        s = s + "female:" + String.valueOf(femalenum) + "<br>";
        s = s + "最感兴趣:" + (a>b?"basketball":"football") + "&nbsp有" + (a>b?String.valueOf(a):String.valueOf(b)) + "人<br>";

        s = s + "<a href=\"vote.html\">back</a>";


        s+="</body>\n" +
                "</html>";
        ServletOutputStream out = resp.getOutputStream();
        out.write(s.getBytes("utf-8"));
        //System.out.print(req.getParameter("user"));
    }
}
