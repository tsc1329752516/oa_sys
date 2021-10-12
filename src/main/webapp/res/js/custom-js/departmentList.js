layui.use(['form','layer','laydate','table','upload'],function(){

    //定义对应模块对象
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer :
            top.layer,
        $ = layui.jquery,
        laydate = layui.laydate,
        upload = layui.upload,
        table = layui.table;


    //针对部门的表格实现属性定义
    var tableIns = table.render({
        elem: '#departmentlisttableId',
        url : path + '/department/list',
        page : false,
        cellMinWidth : 95,
        height : "full-104",
        id : "tables",
        cols : [[
            {
                type : "checkbox",
                fixed : "left",
                width : 50
            },
            {
                field: 'id',
                width: 80,
                title: 'ID',
                sort: true
            },
            {
                field : 'name',
                title : '部门名',
                width : 200
            },
            {
                field : 'type',
                title : '机构类型',
                width : 100
            },
            {
                field : 'area',
                title : '所属区域',
                width : 100,
                align : 'center'
            },
            {
                field : 'description',
                title : '描述',
                align : 'center',
                width : 300
            },
            {
                field : 'sort',
                title : '排序',
                align : 'center',
                width : 50
            },
            /*{
            field : 'status',
            title : '状态',
            align : 'center',
            width : 200
            },*/
            {
                title : '操作',
                width : 200,
                fixed : "right",
                align : "center",
                templet : '#flinkbar'
            }
        ]]
    });

    $(".search_btn").on('click',function () {
        table.reload("tables",{
            where:{
                name: $(".name").val()
            }
        })
    });

    //点击添加部门，打开一个新的面板窗体
    $(".addLink_btn").click(function(){
        addLink();
    })

    //添加部门
    function addLink(){
        var index = layer.open({
            title : "添加部门",
            type : 2,
            area: ['540px', '550px'],
            content : path +
                "/department/toAddSysDepartMent"
        })
    }


    //绑定批量删除按钮的点击事件方法
    $(".delAll_btn").on("click",function(){

        //获取处于选中状态的复选框对象
        var checkStatus = table.checkStatus('tables'),
            data = checkStatus.data,
            linkId = [];

        if(data.length > 0) {

            for (var i in data) {
                console.log(data[i].id)
                linkId.push(data[i].id);
            }

            layer.confirm('确定删除选中的部门？', {icon: 3, title: '提示信息'},
                function (index) {

                    var ajaxReturnData;
                    //调用jquery实现异步请求提交，以post方式提交
                    $.ajax({
                        url: path +
                            '/department/deleteBatch',
                        type: 'post',
                        async: false,
                        data: {ids:linkId.toString()},
                        success: function (data) {
                            ajaxReturnData = data;
                            //删除结果
                            if (ajaxReturnData == '0') {
                                //重新加载一个table
                                table.reload('tables');
                                layer.msg('删除成功', {icon:
                                        1});
                            } else {
                                layer.msg('删除失败', {icon:
                                        5});
                            }
                        }
                    });

                }
            )
        }else {
            layer.msg("请选择需要删除的部门");
        }
    })

    /*
    * 提交表单会触发此方法
    * */
    form.on("submit(addLink)",function(data){

        console.log("submit form");
        console.log(data.field);

        //弹出loading
        var index = top.layer.msg('数据提交中，请稍候',{icon:
                16,time:false,shade:0.8});

        //返回结果集合
        //如果返回值等于0，则成功，否则失败
        var ajaxReturnData;

        //登陆验证
        $.ajax({
            url: path + '/department/saveSysDepartMent',
            type: 'post',
            async: false,
            data: data.field,
            success: function (data) {
                //获取响应数据结果集
                ajaxReturnData = data;
            }

        });

        //结果回应
        if (ajaxReturnData == '0') {

            top.layer.close(index);
            top.layer.msg('保存成功', {icon: 1});
            layer.closeAll();
            //刷新父页面
            parent.location.reload();

        }else {
            top.layer.msg('保存失败', {icon: 5});
            layer.closeAll();
        }

    });


})