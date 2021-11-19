<%@page contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>首页</title>
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
<body>
<ul>
    <li><a class="active" href="#home">主页</a></li>
    <li><a href="#news">功能</a></li>
    <li><a href="#contact">联系</a></li>
    <li><a href="#about">关于</a></li>
</ul>
<h2>WELCOME!</h2>
<!--
<img src="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1606471923353&di=b77a1b0bdda54249eef23a1d51ac3ca2&imgtype=0&src=http%3A%2F%2Fa1.att.hudong.com%2F24%2F78%2F20300000291746133783784887147.jpg">
-->

<a href="vote.html">投票网站</a>
<br>
<a href="Market/sell.html">购物</a>
<br>
<a href="Board/msgBoard">留言板</a>
<br>
<a href="ChatRoom/ChatRoomLogin.html">聊天室</a>

</body>
</html>
