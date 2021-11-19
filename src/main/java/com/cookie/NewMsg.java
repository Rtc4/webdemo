package com.cookie;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "ChatRoom/msgSend",urlPatterns = {"/ChatRoom/msgSend"})
public class NewMsg extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");


        ServletContext servletContext = this.getServletContext();
        ChatMsg chatMsg =(ChatMsg) servletContext.getAttribute("chatmsg");
        if(chatMsg == null){
            chatMsg = new ChatMsg();
            servletContext.setAttribute("chatmsg",chatMsg);
        }


        String username = "";
        username=(String)req.getSession().getAttribute("username");
        if(username == null){
            Cookie[] cookies = req.getCookies();
            for (Cookie cookie:cookies) {
                System.out.println(cookie.getName());
                if(cookie.getName().equals("username")){
                    username=cookie.getValue();

                }
            }
            if(username==null){
                System.out.println("fail");
                //resp.sendRedirect("ChatRoomLogin.html");
                return;
            }

        }
        String text="";
        text=(String) req.getParameter("text");

        chatMsg.MsgAdd(username,"",new Date(),text);
        servletContext.setAttribute("chatmsg",chatMsg);
        resp.sendRedirect("send.html");

    }
}
