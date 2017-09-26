<%--
  Created by IntelliJ IDEA.
  User: 我的大神舟
  Date: 2017/9/25
  Time: 10:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="script/jquery-1.7.2.min.js"></script>
    <%@include file="/common/queryCondition.jsp"%>
</head>
<body>
    <center>
        <br><br><br>
        <h3>您的购物车为空！！</h3>
        <br><br><br>
        <a href="BookServlet?method=getBooks&pageNo=${param.pageNo }">继续购物</a>
    </center>
</body>
</html>
