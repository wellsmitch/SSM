<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>查询商品列w表</title>
</head>
<body>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
<hr>
<form action="${pageContext.request.contextPath }/item/queryitem.action" method="post">
    查询条件1：
    <table width="100%" border=1>
        <tr>
            <td><input type="submit" value="查询"/></td>
        </tr>
    </table>
    商品列表：
    <table width="100%" border=1>
        <tr>
            <td>商品名称</td>
            <td>商品价格</td>
            <td>生产日期</td>
            <td>商品描述</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${userList}" var="item">
            <tr>
                <td>${item.username }</td>
                <td>${item.sex }</td>
            </tr>
        </c:forEach>
        <input id="username" type="text" placeholder="用户名">
        <input id="sex" type="text" placeholder="性别">
        <button id="post">发起post</button>


    </table>
</form>
<button id="getJson">获取用户信息http</button>
<button id="getJsonHttps">获取用户信息https</button>
</body>
<script type="text/javascript">
    $('#post').click(function () {
        $.ajax({
            type: "post",
            <%--url: "${pageContext.request.contextPath}/item/addUser.action",--%>
            url: "http://localhost:8099/bbb/item/addUser.action",
            data: {
                username: "aaas",
                sex: '男'
            },

            async: true,
            success: function (data) {
                console.log(data);
            }
        });
    });

    $('#getJson').click(function () {
        $.ajax({
            type: "post",
            url: "http://localhost:8099/bbb/item/getUser.action",
            data: {
                id: 3,
                sex: '男'
            },
            async: true,
            success: function (data) {
                alert(data);
                console.log(data);
            }
        });
    });
    $('#getJsonHttps').click(function () {
        $.ajax({
            type: "post",
            url: "https://localhost:8099/bbb/item/getUser.action",
            data: {
                id: 3,
                sex: '男'
            },
            async: true,
            success: function (data) {
                alert(data);
                console.log(data);
            }
        });
    });
</script>
</html>
