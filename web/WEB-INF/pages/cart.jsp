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
    <script type="text/javascript" src="script/jquery-1.7.2.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $(".delete").click(function () {
                var $tr = $(this).parent().parent();
                var title = $.trim($tr.find("td:first").text());
                var flag = confirm("确定要删除"+title+"的购物车信息吗？");

                if(flag){
                    return true;
                }

                return false;
            });
            
            $(".clear").click(function () {
                var flag = confirm("确定要清空购物车吗？");
                if(flag){
                    return true;
                }
                return false;

            });
        })

    </script>
    <%@include file="/common/queryCondition.jsp"%>
</head>
<body>
    <center>
        <h1>查看购物车</h1>
        <br><br>
        <h4>您的购物车中共有:${sessionScope.cart.bookNumber}本书</h4>
        <table cellpadding="10">
            <tr>
                <td>书名</td>
                <td>数量</td>
                <td>价格</td>
                <td>&nbsp;</td>
            </tr>
            <c:forEach items="${sessionScope.cart.items}" var="item">
                <tr>
                    <td>${item.book.title}</td>
                    <td><input type="text" size="1" name="" value="${item.quantity}"></td>
                    <td>${item.itemMoney}</td>
                    <td><a href="BookServlet?method=cartRemove&id=${item.book.id}&pageNo=${param.pageNo}" class="delete">删除</a></td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="4">总金额：￥${sessionScope.cart.totalMoney}</td>
            </tr>
        </table>
        <a href="BookServlet?method=getBooks&pageNo=${param.pageNo }">继续购物</a>&nbsp;
        <a href="BookServlet?method=cartClear&pageNo=${param.pageNo }" class="clear">清空购物车</a>&nbsp;
        <a href="">结账</a>&nbsp;
    </center>
</body>
</html>
