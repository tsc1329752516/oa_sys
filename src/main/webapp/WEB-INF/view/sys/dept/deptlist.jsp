<%--
  Created by IntelliJ IDEA.
  User: cheng
  Date: 2021/9/27
  Time: 9:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/inc/taglibs.jsp"%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${path}/res/layui/css/layui.css" media="all" >
</head>
<body>
<blockquote class="layui-elem-quote quoteBox">
    <form class="layui-form">
        <div class="layui-inline">
            部门名：
            <div class="layui-input-inline">
                <input type="text" class="layui-input name" placeholder="请输入搜索的内容" />
            </div>
            <a class="layui-btn search_btn" data-type="reload"><i class="layui-icon">&#xe615;</i>搜索</a>
        </div>
        <div class="layui-inline">
            <a class="layui-btn layui-btn-normal addLink_btn"><i class="layui-icon">&#xe608;</i>添加部门</a>
        </div>
        <div class="layui-inline">
            <a class="layui-btn layui-btn-danger layui-btn-normal delAll_btn"><i class="layui-icon">&#xe640;</i>
                批量删除</a>
        </div>
    </form>
</blockquote>
<table id="departmentlisttableId" lay-filter="departmentlisttable"></table>

<script type="text/html" id="flinkbar">
    <a class="layui-btn layui-btn-xs" lay-event="edit"><i class="layui-icon">&#xe642;</i>编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del"><i class="layui-icon">&#xe640;</i>删除</a>
</script>

<script type="text/javascript">
    var path = "${path}";
</script>
<script type="text/javascript" src="${path}/res/layui/layui.js"></script>
<script type="text/javascript" src="${path}/res/js/custom-js/departmentList.js"></script>
</body>
</html>
