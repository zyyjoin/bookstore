<%--
  Created by IntelliJ IDEA.
  User: 我的大神舟
  Date: 2017/9/20
  Time: 18:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <center>
        <h1>查看购物车</h1>
        <br><br>
        <h4>您的购物车中共有${sessionScope.cart.bookNumber}本书</h4>
        <table cellpadding="10">
            <tr>
                <td>书名</td>
                <td>数量</td>
                <td>价格</td>
                <td></td>
            </tr>
            <c:forEach items="${cart.items}" var="item">
                <tr>
                    <td>
                        ${item.book.title}
                        <br>
                    <td><input type="text" size="1" name="" value="${item.quantity}"></td>
                    </td>
                    <td>${item.itemMoney}</td>
                    <td><a href="">删除</a></td>
                </tr>
            </c:forEach>
            <tr><td colspan="4">总金额：￥${cart.totalMoney}</td></tr>
        </table>
        <a href="">继续购物</a>
        <a href="">清空购物车</a>
        <a href="">结账</a>
    </center>
</body>
</html>
