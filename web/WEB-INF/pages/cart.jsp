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

            //ajax修改单个商品数量
            //1.获取页面所有text文本框，添加onchange()函数，确认对话框（不能输入字母，负数，输入0？）
            $(":text").change(function () {
                //校验用户输入信息（数量）字母？数字？0？
                var quantityVal=$.trim(this.value);
                var flag = false;

                var reg=/^\d+$/g;
                var quantity = -1;
                if(reg.test(quantityVal)){
                    quantity = parseInt(quantityVal);
                    if(quantity>=0){
                        flag=true;
                    }
                }
                if(!flag){
                    alert("输入数量不合法！！")
                    $(this).val($(this).attr("class"));
                    return;
                }

                var $tr = $(this).parent().parent();
                var title = $.trim($tr.find("td:first").text());
                if(quantity==0){
                    var f = confirm("确定要删除购物车商品"+title+"吗？")
                    if(f){
                        //得到了 a 节点
                        var $a = $tr.find("td:last").find("a");
                        //执行 a 节点的 onclick 响应函数.
                        $a[0].onclick();
                        return;
                    }
                }

                var flag = confirm("确定要修改"+title+"的数量吗？");
                if (!flag)
                    $(this).val($(this).attr("class"));//保留刚才的数量
                    return;

            //2.请求地址到servlet，请求参数：method=updateItemQuantity，id=，quantity=text.val，time=new Date()
                var url="BookServlet"
                var idVal=$.trim(this.name);
                //var quantityVal=$.trim(this.value);
                var args={"method":"updateItemQuantity","id":idVal,"quantity":quantityVal,"time":new Date()};
            //3.在servlet中获取quantity、id和购物车对象，然后做修改。
            //4.传回json数据，包含bookNumber=，totalMoney=，

            //5.更新当前页面
                $.post(url,args,function (data) {
                    var bookNumber=data.bookNumber;
                    var totalMoney=data.totalMoney;

                    /*alert(bookNumber);
                    alert(totalMoney);*/
                    $("#totalMoney").text("总金额：￥"+totalMoney)
                    $("#bookNumber").text("您的购物车中共有:"+bookNumber+"本书");
                },"JSON");
            });
        })

    </script>
    <%@include file="/common/queryCondition.jsp"%>
</head>
<body>
    <center>
        <h1>查看购物车</h1>
        <br><br>
        <h4><div id="bookNumber">您的购物车中共有:${sessionScope.cart.bookNumber}本书</div></h4>
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
                    <td>
                        <input class="${item.quantity}" type="text" size="1" name="${item.book.id}" value="${item.quantity}">
                    </td>
                    <td>${item.itemMoney}</td>
                    <td><a href="BookServlet?method=cartRemove&id=${item.book.id}&pageNo=${param.pageNo}" class="delete">删除</a></td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="4" id="totalMoney">总金额：￥${sessionScope.cart.totalMoney}</td>
            </tr>
        </table>
        <a href="BookServlet?method=getBooks&pageNo=${param.pageNo }">继续购物</a>&nbsp;
        <a href="BookServlet?method=cartClear&pageNo=${param.pageNo }" class="clear">清空购物车</a>&nbsp;
        <a href="">结账</a>&nbsp;
    </center>
</body>
</html>
