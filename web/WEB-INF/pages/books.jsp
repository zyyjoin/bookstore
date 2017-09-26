<%--
  Created by IntelliJ IDEA.
  User: 我的大神舟
  Date: 2017/9/19
  Time: 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <title>Title</title>
    <script type="text/javascript" src="script/jquery-1.7.2.min.js"></script>
    <script type="text/javascript">
        //实现点击首页、上下页、末页时，页面刷新而保证查询数据仍有效。
        $(function () {
            //序列化隐藏域内容为字符串
            //复用，包含另一个页面。

            //使用JS对不合法输入进行校验
            $("#pageNo").change(function () {
                //1.页码不是数字
                //得到当前页码
                var val = $(this).val();
                val = $.trim(val);
                var flag = false;
                //正则判断
                var reg = /^\d+$/g;
                if (reg.test(val)){
                    //2.页码不在正确范围内
                    var pageNo = parseInt(val);
                    if (pageNo>=1&&pageNo<=parseInt("${bookpage.totalPageNumber}")){
                        flag = true;
                    }
                }
                //页面跳转
                if (flag){
                    var criteria = $(":hidden").serialize();
                    window.location.href = "BookServlet?method=getBooks&pageNo="
                        + pageNo+"&"+criteria;
                }else {
                    $(this).val("");
                    alert("输入页码不合法！！");
                    return;
                }
            });
        });
    </script>
    <!-- 代码重用 -->
    <%@include file="/common/queryCondition.jsp"%>
</head>
<body>
     <center>

        <c:if test="${param.title!=null}">
            您已经将${param.title}加入购物车成功！
            <br><br>
        </c:if>
        <c:if test="${!empty sessionScope.cart.books}">
            您的购物车中有${sessionScope.cart.bookNumber}本书,<a href="BookServlet?method=toCartPage&pageNo=${bookpage.pageNo}">查看购物车</a>
        </c:if>
        <br><br>
        <form action="BookServlet?method=getBooks" method="post">
            Price:
            <input type="text" size="1" name="minPrice"> -
            <input type="text" size="1" name="maxPrice">

            <input type="submit"  value="查找">
        </form>
        <br><br>
            <table cellpadding="10">
                <c:forEach items="${bookpage.list}" var="book">
                    <tr>
                        <td>
                            <a href="BookServlet?method=getBook&pageNo=${bookpage.pageNo}&id=${book.id}">${book.title}</a>
                            <br>
                            ${book.author}
                        </td>
                        <td>${book.price}</td>
                        <td>
                            <a href="BookServlet?method=addToCart&pageNo=${bookpage.pageNo}&id=${book.id}&title=${book.title}">加入购物车</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        <br><br>
        共${bookpage.totalPageNumber}页&nbsp;&nbsp;
        当前第${bookpage.pageNo}页&nbsp;&nbsp;
        <c:if test="${bookpage.hasPrev}">
            <a href="BookServlet?method=getBooks&pageNo=1">首页</a>&nbsp;&nbsp;
            <a href="BookServlet?method=getBooks&pageNo=${bookpage.prePage}">上一页</a>&nbsp;&nbsp;
        </c:if>
        <c:if test="${bookpage.hasNext}">
            <a href="BookServlet?method=getBooks&pageNo=${bookpage.nextPage}">下一页</a>&nbsp;&nbsp;
            <a href="BookServlet?method=getBooks&pageNo=${bookpage.totalPageNumber}">末页</a>&nbsp;&nbsp;
        </c:if>
        转到<input type="text" size="1" id="pageNo">页
    </center>
</body>
</html>
