<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<% String basePath = request.getRequestURI();%>
<script type="text/javascript" src="./static/js/jquery.min.js"></script>
<script type="text/javascript">
    var basePath = "${basePath}";
    $.ajax({
        url: basePath + "/bba/item/getCovid.action",
        type: "get",
        data: {},
        success: function (res) {
            console.log(res);
        }
    })
</script>