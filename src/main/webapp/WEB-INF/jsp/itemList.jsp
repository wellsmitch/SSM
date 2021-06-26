<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    request.setAttribute("basePth", basePath);
    request.setAttribute("path", path);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>查询商品列w表</title>
</head>
<body>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
<hr>
<a href="<%=basePath %>"><%=path%>aaaaaaaaaaaa</a>
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
        <input id="password" type="password" placeholder="请输入密码">
        <input id="sex" type="text" placeholder="性别">
        <button id="post">发起post</button>
        <input type="text" id="TIME" placeholder="时间。。。">
        <input type="text" id="HENAN" placeholder="HENAN">
        <input type="text" id="ZHENGZHOU" placeholder="ZHENGZHOU">
        <input type="text" id="DIANFEI" placeholder="DIANFEI">

    </table>
</form>
<button id="getJson">获取用户信息http</button>
<button id="register">注册用户信息http</button>
<button id="getJsonHttps">获取用户信息https</button>
<button id="getCovid">获取用户信息Covid</button>
<button id="updateCovid">更新Covid信息</button>
<input type="file" id="file">
<button id="uploadFile">上传文件</button>
<%
    Object[] a = {11, 22, "rwe"};
    pageContext.setAttribute("f", a);
%>

</body>
<script type="text/javascript">
    //upload
    $('#uploadFile').click(function () {
        var fm = new FormData();
        console.log($("#file")[0].files);
        fm.append("file", $("#file")[0].files[0]);
        $.ajax({
            type: "post",
            url: "http://localhost:8099/bbb/uploadFile.action",
            data: fm,
            async: true,
            processData: false,
            contentType: false,
            success: function (data) {
                console.log(data);
            }
        });
    });
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
            url: "http://localhost:8099/bbb/item/userLogin.action",
            // url: "http://localhost:8099/bbb/item/getUser.action",
            data: {
                username: $("#username").val(),
                password: $("#password").val()
            },
            async: true,
            success: function (data) {
                console.log(data);
            }
        });
    });
    $('#register').click(function () {
        $.ajax({
            type: "post",
            url: "http://localhost:8099/bbb/item/userRegister.action",
            // url: "http://localhost:8099/bbb/item/getUser.action",
            data: {
                username: $("#username").val(),
                password: $("#password").val()
            },
            async: true,
            success: function (data) {
                console.log(data);
            }
        });
    });
    $('#getJsonHttps').click(function () {
        $.ajax({
            type: "post",
            url: "https://localhost/bbb/item/getUser.action",
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
    $('#getCovid').click(function () {
        $.ajax({
            type: "post",
            url: "http://localhost:8099/bbb/item/getCovid.action",
            async: true,
            dataType: 'json',
            success: function (data) {
                console.log(data);
            }
        });
    });
    $('#updateCovid').click(function () {
        $.ajax({
            type: "post",
            url: "http://localhost:8099/bbb/item/updateCovid.action",
            async: true,
            contentType: 'application/json; charset=utf-8',
            // contentIype: 'application/x-www-form-urlencoded',
            data:
                JSON.stringify(
                    {
                        dianfei: $('#DIANFEI').val(),
                        time: $('#TIME').val(),
                        heNanRes: $('#HENAN').val(),
                        zhengZhouRes: $('#ZHENGZHOU').val(),
                        zhengzhouInc: 12,
                        henNanInc: 12,
                        id: 1
                    }
                )
            ,
            dataType: 'json',
            success: function (data) {
                console.log(data);
            }
        });
    });


</script>
<script type="text/javascript">
    var basePath1 = "${requestScope.get("basePth")}"
    var Path1 = "${requestScope.get("path")}"
    console.log(basePath1, Path1)
</script>
</html>