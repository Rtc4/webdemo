package com.cookie;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "ChatRoom/ChatRoomLogin",urlPatterns ={"/ChatRoom/ChatRoomLogin"})
public class ChatRoomLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String username = "";
        String remember = "";
        username = req.getParameter("username");
        remember = req.getParameter("remember");
        if(username == null ){
            resp.sendRedirect("ChatRoomLogin");
            return;
        }

        ServletContext servletContext = this.getServletContext();
        ChatMsg chatMsg =(ChatMsg) servletContext.getAttribute("chatmsg");
        if(chatMsg == null){
            chatMsg = new ChatMsg();
            servletContext.setAttribute("chatmsg",chatMsg);
        }



        Cookie cookie = new Cookie("username", username);
        cookie.setMaxAge(60*60);
        if(remember != null && remember.equals("true")){
            resp.addCookie(cookie);
        }
        HttpSession session = req.getSession();
        session.setAttribute("username",username);
        resp.sendRedirect("main.html");
    }
}
