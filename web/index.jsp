<%--
  Created by IntelliJ IDEA.
  User: 我的大神舟
  Date: 2017/9/17
  Time: 11:46
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    response.sendRedirect(request.getContextPath() + "/BookServlet?method=getBooks");
%>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  $END$
    <h1>这个可以访问到？</h1>
  </body>
</html>
