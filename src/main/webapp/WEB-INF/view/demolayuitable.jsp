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
<table id="demo" lay-filter="test"></table>

<script src="${pageContext.servletContext.contextPath}/res/layui/layui.js"></script>
<script>
    layui.use('table', function(){

        var table = layui.table;

        //第一个实例
        //render方法就是针对table的属性进行定义渲染
        /*
        * json数据格式
        * {
        *   "code":"0",
        *   "msg":"",
        *   "data":[
        *       {"id":"1","username":"xiaoming","sex":"男","city":"广州市"},
        *       {"id":"2","username":"张三","sex":"男","city":"广州市"}
        *       ]
        * }
        * */
        table.render({
            elem: '#demo'
            ,height: 312
            ,url: '/demo/list' //数据接口
            ,page: false //开启分页
            ,cols: [[ //表头
                {field: 'id', title: 'ID', width:80, sort: true, fixed: 'left'}
                ,{field: 'username', title: '用户名', width:80}
                ,{field: 'sex', title: '性别', width:80, sort: true}
                ,{field: 'city', title: '城市', width:80}
            ]]
        });

    });
</script>
</body>
</html>
