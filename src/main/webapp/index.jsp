<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no"/>
<meta charset="utf-8">
<h1 id="message"></h1>
<h2>qqqq</h2>
<button id="sendMsg">发送webSockt</button>
<script type="text/javascript">
    var websocket = null;

    var host = document.location.host;

    var username = "songyubin"; // 获得当前登录人员的userName

    // console.log(username)

    //判断当前浏览器是否支持WebSocket

    if ('WebSocket' in window) {
        console.log("浏览器支持Websocket");

        websocket = new WebSocket('ws://' + host + '/bbb/webSocket/' + username);

    } else {

        console.log('当前浏览器 Not support websocket')

    }


    //连接发生错误的回调方法

    websocket.onerror = function () {

        console.log("WebSocket连接发生错误");

        setMessageInnerHTML("WebSocket连接发生错误");

    };


    //连接成功建立的回调方法

    /*websocket.onopen = function () {

        console.log("WebSocket连接成功");

        setMessageInnerHTML("WebSocket连接成功");

    };*/


    //接收到消息的回调方法

    websocket.onmessage = function (event) {

        console.log("接收到消息的回调方法");

        console.log(JSON.parse(event.data));

        // websocket.close();

        console.log("webSocket已关闭！")

    };


    //连接关闭的回调方法

    websocket.onclose = function () {

        setMessageInnerHTML("WebSocket连接关闭");

    };
    console.log(document.querySelector('#sendMsg'));
    document.querySelector('#sendMsg').onclick = function () {
        websocket.send(JSON.stringify({a: 123, d: 890}))
    };

    //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。

    window.onbeforeunload = function () {

        closeWebSocket();

    };


    //关闭WebSocket连接

    function closeWebSocket() {

        websocket.close();

    }


    //将消息显示在网页上

    function setMessageInnerHTML(innerHTML) {

        document.getElementById('message').innerHTML += innerHTML + '<br/>';

    }
</script>
</body>
</html>
