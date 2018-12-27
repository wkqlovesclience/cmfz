<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/7/8
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" %>

<script type="text/javascript">
    $(function () {

        // 初始化allUserDatagrid
        $("#allUserDatagrid").datagrid({
            fitColumns:true,
            fit:true,
            url:"${pageContext.request.contextPath }/user/queryAllUser",
            toolbar:"#allexportUserExecleToolBtn"
            //pagination:true,
            //pageSize:5,
            //pageList:[3,5,9,12,15,30],
            //pageNumber:1
        });


        // 初始化 导出按钮
        $("#exportUserExecleBtn").linkbutton({
            iconCls:"icon-pencil",
            onClick:function () { // 定义单击事件
                // 单击打开对话框
                $("#exportUserExecleDialog").dialog("open");
            }
        });

        //初始化 对话框
        $("#exportUserExecleDialog").dialog({
            title:"请选择选择导出数据",
            width:500,
            height:300,
            url:"",
            modal:true,
            closed:true,

        });




        $('#cc').combotree({
            url: 'get_data.php',
            required: true
        });




    });


</script>

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
    <a id="exportUserExecleBtn" ></a>
</div>

<%--导出用户表格对话框--%>
<div id="exportUserExecleDialog">

    <%--//  树形多选框  --%>

</div>
<select id="selectCombobox"  style="width:200px;"
        data-options="checkbox:true,onlyLeafCheck:true,multiple:true,required:true"></select>

<input id="cc" value="01">