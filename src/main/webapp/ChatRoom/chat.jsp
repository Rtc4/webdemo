<%@ page import="com.cookie.ChatMsg" %><%--
  Created by IntelliJ IDEA.
  User: Tencent_GO
  Date: 2021/11/12
  Time: 11:13
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>

<html>
<head>
    <title>chat</title>
    <meta http-equiv="refresh" content="1">
</head>
<body>
<%

    ChatMsg chatMsg = (ChatMsg)application.getAttribute("chatmsg");
    if(chatMsg == null){
        chatMsg = new ChatMsg();
        application.setAttribute("chatmsg",chatMsg);
    }

    int i=chatMsg.list.size()-6;
    if(chatMsg.list.size()!=0)
    for(;i<chatMsg.list.size();i++){
            while (i<0)i++;
            ChatMsg.Msg msg =chatMsg.list.get(i);
            if(msg==null)break;
            %>
<%=msg.getUsername()%>:<%=msg.getMsg()%><br>
    <%

    }
    %>
</body>
</html>
