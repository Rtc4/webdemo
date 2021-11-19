<%@ page import="com.MsgBoard.BoardMsg" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Tencent_GO
  Date: 2021/11/5
  Time: 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>留言板</title>
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
            <h5 style="margin: 0px">新寄语:</h5>
            <hr>
            <form method="post" action="msgBoardSend">
                <h5 style="margin: 0px">Title:</h5>
                <input type="text" name="title" style="width: 100%;height: 30px;margin: 10px 0px">
                <h5 style="margin: 0px">Context:</h5>
                <textarea name="text" row="30" style="height: 150px;width: 100%;resize: none"></textarea>
<%--                <input class="form-control" type="text" height="600px"><br>--%>
                <br><br>
                <input type="submit" value="发布">
            </form>
            <br><br>

            <%
                BoardMsg bMsg = (BoardMsg) application.getAttribute("boardMsg");
                BoardMsg.Msg msgnew=new BoardMsg.Msg();
                
                if(bMsg.list.size()!=0){
            %>
            <hr>
            <h5 style="margin: 0px">留言(<%=bMsg.list.size()%>):</h5>
            <%
                }


                for(int i=bMsg.list.size()-1;i>=0;i--){
                    msgnew=bMsg.list.get(i);
            %>

                <br>

            <h8><a href="MsgDetails.jsp?index=<%=i%>"><%=msgnew.getTitle()%></a> </h8>&emsp;&emsp;
            <h8>----<%=msgnew.getUsername()%></h8>
<%--            <h8><%=msgnew.getMsg()%></h8><br>--%>
            &emsp;&emsp;<h8><%=msgnew.getDate()%></h8><br><br>

            <%
                }
            %>

<%--            <div class="card" style="clear: both;border-width: 3px;border-color: black">--%>
<%--                <div class="card" style="border-width: 1px;margin: 10px;border-style: groove;border-radius: 10px">--%>
<%--                    <div style="float: left;width: 100px">--%>
<%--                        <div style="width: 50px;height: 50px;border: 3px black">--%>
<%--                            <img src=https://tse1-mm.cn.bing.net/th?id=OIP-C.P7kST7F08p1l2Oz9oQgnyAAAAA&w=102&h=102&c=8&rs=1&qlt=90&o=6&pid=3.1&rm=2>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    <div style="float: left;">--%>
<%--                        <div style="width: 60%;border: 3px black">--%>
<%--                            username<br>--%>
<%--                            Title<br>--%>
<%--                            MSg<br>--%>
<%--                            Date<br><br>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>

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
