package com.MsgBoard;

import com.MsgBoard.BoardMsg;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet(name = "Board/msgBoard",urlPatterns = {"/Board/msgBoard"})
public class msgBoardLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("msgBoardLogin.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        ServletContext servletContext = this.getServletContext();
        BoardMsg boardMsg=(BoardMsg) servletContext.getAttribute("boardMsg");
        if(boardMsg == null) {
            boardMsg = new BoardMsg();
            servletContext.setAttribute("boardMsg",boardMsg);
        }


        String s =req.getParameter("username");
        System.out.println(s);
        HttpSession session = req.getSession();
//        getServletContext().setAttribute("username",(String)req.getParameter("username"));
        session.setAttribute("username",req.getParameter("username"));
        resp.sendRedirect("msgBoard.jsp");
        //req.getRequestDispatcher("msgBoard.jsp").forward(req,resp);
    }
}
