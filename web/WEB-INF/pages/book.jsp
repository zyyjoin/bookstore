<%--
  Created by IntelliJ IDEA.
  User: 我的大神舟
  Date: 2017/9/19
  Time: 20:43
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
        <br><br>
        书名：${book.title}<br><br>
        作者：${book.author}<br><br>
        单价：${book.price}<br><br>
        出版时间：${book.publishingDate}<br><br>
        评论：${book.remark}<br><br>
        <a href="BookServlet?method=getBooks&pageNo=${param.pageNo }">继续购物</a>
    </center>
</body>
</html>
