package com.MsgBoard;

import com.MsgBoard.BoardMsg;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "Board/msgBoardSend",urlPatterns = {"/Board/msgBoardSend"})
public class msgBoard extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("msgBoard.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        ServletContext servletContext = this.getServletContext();
        BoardMsg boardMsg;
        boardMsg=(BoardMsg) servletContext.getAttribute("boardMsg");
        if(boardMsg == null) {
            boardMsg = new BoardMsg();
        }
        //System.out.println((String)req.getSession().getAttribute("username")+"xxxxxx");
        boardMsg.MsgAdd((String) req.getSession().getAttribute("username"),req.getParameter("title"), new Date(),req.getParameter("text"));
        servletContext.setAttribute("boardMsg",boardMsg);
        resp.sendRedirect("msgBoard.jsp");
        //req.getRequestDispatcher("msgBoard.jsp").forward(req,resp);

    }
}
