<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>持名法州主页</title>
<link rel="stylesheet" type="text/css" href="../themes/default/easyui.css">   
<link rel="stylesheet" type="text/css" href="../themes/IconExtension.css">   
<script type="text/javascript" src="../js/jquery.min.js"></script>   
<script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../js/jquery.edatagrid.js"></script>
<script type="text/javascript" src="../js/jquery.etree.js"></script>
<script type="text/javascript" src="../js/datagrid-detailview.js"></script>
<script type="text/javascript" src="../js/echarts.min.js"></script>
<script type="text/javascript" src="../js/china.js"></script>
<script type="text/javascript" src="../js/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	<!--菜单处理-->
    $(function () {
       $.ajax({
           url:"${pageContext.request.contextPath}/menu/queryAllMenu",
           type:"get",
           dataType:"json",
           success:function (data) {
               $.each(data, function (index, first) {
                // 定义全局， 用来下变引用
                   var c = "";

               //查询子
                   $.each(first.children, function (index1, second) {
                       //console.log(second.title);
                       // c+ ，来防止每次遍历里后新值将旧值覆盖，而让他们拼接显示  最后调格式
                       c += "<p style='text-align: center'><a class='easyui-linkbutton' onclick='addTabs(\""+second.title+"\",\""+second.href+"\")' data-options=''>"+ second.title +"</a></p>";
                       //console.log(c);
                   });

                      $('#aa').accordion('add', { // 手风琴的创建
                       title: first.title,
                       content: c,
                       selected: false,
                       iconCls: first.iconCls
                   });


               });

           }
       });




    });

// 初始化选项卡
    function addTabs(title,href,iconCls){
        //判断 如果选项卡已经打开 则  不在创建 选中
        var flg=$("#tt").tabs("exists",title);
        if(!flg){ // 如果没有打开 则 创建
            $('#tt').tabs('add',{
                title:title,
                href:"${pageContext.request.contextPath}/"+href, // 要手动添加动态路径
                iconCls:iconCls,
                closable:true // 显示选项卡 可关闭 （带有X的图标）
            });
        }else{   //如果选项卡已经打开 则  不在创建 选中
            $("#tt").tabs("select",title);
        }





    }









</script>

</head>
<body class="easyui-layout">   
    <div data-options="region:'north',split:true" style="height:60px;background-color:  #5C160C">
    	<div style="font-size: 24px;color: #FAF7F7;font-family: 楷体;font-weight: 900;width: 500px;float:left;padding-left: 20px;padding-top: 10px" >持名法州后台管理系统</div>
    	<div style="font-size: 16px;color: #FAF7F7;font-family: 楷体;width: 300px;float:right;padding-top:15px">欢迎您:${sessionScope.CurrentAdmin.name} &nbsp;<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改密码</a>&nbsp;&nbsp;<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-01'">退出系统</a></div>
    </div>   
    <div data-options="region:'south',split:true" style="height: 40px;background: #5C160C">
    	<div style="text-align: center;font-size:15px; color: #FAF7F7;font-family: 楷体" >&copy;百知教育 htf@zparkhr.com.cn</div>
    </div>   
       
    <div data-options="region:'west',title:'导航菜单',split:true" style="width:220px;">
    	<div id="aa" title="菜单" class="easyui-accordion" data-options="fit:true">

		</div>
    </div>   
    <div data-options="region:'center'">
    	<div id="tt" class="easyui-tabs" data-options="fit:true,narrow:true,pill:true">   
		    <div title="主页" data-options="iconCls:'icon-neighbourhood',"  style="background-image:url(image/shouye.jpg);background-repeat: no-repeat;background-size:100% 100%;"></div>
		</div>  
    </div>


</body> 
</html>