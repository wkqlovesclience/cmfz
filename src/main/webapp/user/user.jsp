<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script>
    $(function () {

        // 初始化allUserDatagrid
        $("#allUserDatagrid").datagrid({
            fitColumns:true,
            //fit:true,
            url:"${pageContext.request.contextPath }/user/queryAllUserBySplit",
            toolbar:"#allexportUserExecleToolBtn",
            pagination:true,
            pageSize:5,
            pageList:[3,5,9,12,15,30],
            pageNumber:1
        });






        //点击按钮
        $("#btn").linkbutton({
            onClick: function () {
                var texts = $("#cc").combotree("getText");
                var fileds = $("#cc").combotree("getValues");
                var a = "";
                $.each(fileds, function (index, filed) {
                    if (index == fileds.length - 1) {
                        a += filed;
                    } else {
                        a += filed + ",";
                    }

                })
                console.log(a)
                console.log(texts)
                $("#exportForm").form("submit", {
                    url: "${pageContext.request.contextPath}/poi/exportSomeUser",
                    queryParams: {
                        "title": texts,
                        "fileds": a
                    }
                });

            }
        });


        // 初始化 导出按钮
        $("#exportUserExecleBtn").linkbutton({
            iconCls:"icon-pencil",
            onClick:function () { // 定义单击事件
                // 单击打开对话框
                $("#exportUserExecleDialog").dialog("open");
            }
        });






    });




    function submit() {
        $('#exportForm').form({
            url: "${pageContext.request.contextPath}/pic/addPic",

        });
        $('#exportForm').submit();
    }
</script>



<div id="exportUserExecleDialog" class="easyui-dialog" title="请选择要导出的数据" style="width:400px;height:200px;"
     data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true,buttons:[{
				text:'保存',
				handler:function(){
                 submit();
				}
			},{
				text:'关闭',
				handler:function(){
                   $('#dd').dialog('close')
				}
			}]">

    <select id="cc" class="easyui-combotree" style="width:200px;"
            data-options="checkbox:true,onlyLeafCheck:true,multiple:true,required:true,data:
            [{
   'id':'custom',
    'text': '自定义导出',
    'state': 'closed',
    'children': [{
    'id': 'id',
    'text': '编号'
    },{
    'id': 'name',
    'text': '名字'
    },{
    'id': 'dharmName',
    'text': '法名'
    },{
    'id': 'photo',
    'text': '头像'
    },{
    'id': 'phoneNum',
    'text': '电话号码'
    },{
    'id': 'password',
    'text': '密码'
    },{
    'id': 'sex',
    'text': '性别'
    },{
    'id': 'province',
    'text': '省份'
    },{
    'id': 'sign',
    'text': '签名'
    },{
    'id': 'createTime',
    'text': '注册时间'
    }]
    }]"

    ></select>

    <form id="exportForm">

        <a id="btn">确定导出</a>
    </form>
</div>



<table id="allUserDatagrid">
    <thead>
    <tr>
        <th data-options="field:'name',width:1">姓名</th>
        <th data-options="field:'dharmName',width:1">法名</th>
        <th data-options="field:'photo',width:1">头像</th>
        <th data-options="field:'phoneNum',width:1">手机号码</th>
        <th data-options="field:'password',width:1">密码</th>
        <th data-options="field:'sex',width:1">性别</th>
        <th data-options="field:'province',width:1">所在省份</th>
        <th data-options="field:'city',width:1">所在城市</th>
        <th data-options="field:'sign',width:1">用户签名</th>
        <th data-options="field:'status',width:1">状态</th>
        <th data-options="field:'salt',width:1">盐</th>
        <th data-options="field:'createTime',width:1">注册时间</th>
    </tr>
    </thead>
</table>


<%--导出用户表格工具 按钮--%>
<div id="allexportUserExecleToolBtn">
    <a id="exportUserExecleBtn" >自定义导出用户数据</a>
</div>


