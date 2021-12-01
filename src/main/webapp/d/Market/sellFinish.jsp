<%@ page import="com.Market.Good" %>
<%--
  Created by IntelliJ IDEA.
  User: Tencent_GO
  Date: 2021/11/4
  Time: 16:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>购物</title>
    <style>
        .header{
            /*background-color: #f1f1f1;*/
            padding: 20px;
            text-align: center;
        }
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
        .left_float{
            float: left;
            width: 350px;
        }
    </style>
</head>
<link href="../bootstrap-5.1.3-dist/css/bootstrap.min.css" rel="stylesheet">
<script src="../bootstrap-5.1.3-dist/js/bootstrap.bundle.min.js" ></script>
<body>
<ul>
    <li><a class="active" href="#home">主页</a></li>
    <li><a href="#news">功能</a></li>
    <li><a href="#contact">联系</a></li>
    <li><a href="#about">关于</a></li>
</ul>
<div style="clear: both">    </div>
<div class="header">
    <br><br>
    <h2>商品清单</h2><br>
    <div style="clear: both;"> </div>
    <hr>
</div>
<div style="margin: 30px 30%;">
    <div style="text-align: center">
        <table class="table" id="table1" align="center" width="90%">
                <tr>
                    <td>商品名</td>
                    <td>单价</td>
                    <td>数量</td>
                    <td>价格</td>
                </tr>
            <c:forEach begin="goods"
            <%
                double cost = 0;
                int i=0;
                int count = (int) request.getAttribute("count");
                Good[] goods = (Good[]) request.getAttribute("goods");
               for (i = 0; i<count;i++) {
                   //System.out.println(i);
                   if (goods[i].getQuantity() != 0) {
                        cost += goods[i].getPrice() * goods[i].getQuantity();
            %>
            <tr>
                <td><%=goods[i].getName()%></td>
                <td><%=goods[i].getPrice()%></td>
                <td><%=goods[i].getQuantity()%></td>
                <td><%=goods[i].getPrice()*goods[i].getQuantity()%></td>
            </tr>
            <%
                    }
                }
            %>

        </table>
        <hr style="clear:both;">
        <div style="float: right;clear:both;">
            总价：<%=cost%>
        </div>
    </div>
</div>

<div style="clear:both;">    </div>
<br>
<hr style="margin: 10px">
<div align="center" style="margin: 100px">
    <p>Copyright©2021</p>
</div>

</body>
</html>
