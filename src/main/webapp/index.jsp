<%--
  Created by IntelliJ IDEA.
  User: cheng
  Date: 2021/9/26
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/res/layui/css/layui.css">
</head>
<body>
<script src="${pageContext.servletContext.contextPath}/res/layui/layui.js"></script>
<script>
    layui.use(['layer', 'form'], function(){
        var layer = layui.layer
            ,form = layui.form;
        layer.msg('Hello World');
    });
</script>
</body>
</html>
