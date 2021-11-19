<%@ page import="com.MsgBoard.BoardMsg" %><%--
  Created by IntelliJ IDEA.
  User: Tencent_GO
  Date: 2021/11/10
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>留言信息</title>
    <style>
        ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            overflow: hidden;
            background-color: #333;
        }

        li {
            float: left;
        }

        li a {
            display: block;
            color: white;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }

        li a:hover {
            background-color: #111;
        }
    </style>
</head>
<body style="background-color: #f4ffbc">
<div style="background-color: #333;position: fixed;width: 100%">
    <ul style="margin:0px 100px">
        <li><a href="#msgboard">留言板</a></li>
        <li><a class="active" href="#个人主页"><%=session.getAttribute("username")%></a></li>
        <li><a href="msgBoard">注销</a></li>
    </ul>
</div>
<br>
<div style="margin: 30px 150px;background-color: white">
    <P style="height: 50px"></P>
    <div style="margin: 20px 100px">

        <br><br>

        <%
            BoardMsg bMsg = (BoardMsg) application.getAttribute("boardMsg");
            BoardMsg.Msg msgnew=new BoardMsg.Msg();
            int index = Integer.valueOf((String)request.getParameter("index"),10);
            if(msgnew==null) System.out.println("MsgDetails_msg==null");
            if(bMsg.list.size()!=0){
        %>
        <hr>
        <h5 style="margin: 0px">留言Details:</h5>
        <%
            }



                msgnew=bMsg.list.get(index);
        %>

        <br>

        <p>Username:&ensp;<%=msgnew.getUsername()%></p>
        <p>Date:&ensp;<%=msgnew.getDate()%></p>

        标题：
        <h4>&emsp;&emsp;&emsp;<%=msgnew.getTitle()%></h4>
        正文：<br>
        <p>&emsp;<%=msgnew.getMsg()%></p><br><br>




        <%

        %>


        <P style="height: 50px"></P>
    </div>
</div>

<P style="height: 50px"></P>
<hr>
<div style="margin: 30px 200px;text-align: center">
    <h5>Copyright © 2005 - 2021 All Rights Reserved.</h5>
</div>
</body>
</html>

