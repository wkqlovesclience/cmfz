<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/7/5
  Time: 22:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>

<script type="text/javascript">
    $(function () {
      /*  //初始化 名字
        $("#addpicName").textbox({
            required:true   //必须要填
        });

        //初始化路径
        $("#addpicPath").textbox({
            required:true
        });
        //初始化 描述
        $("#adddescription").textbox({
            required:true
        });
        //初始化 日期
        $("#addcreateTime").textbox({
            required:true
        });
        //初始化 状态
        $("#addstatus").textbox({
            required:true
        });


        //初始化 链接
        $("#addurl").textbox({
            required:true
        });
*/

        //初始化 添加按钮
        $("#addbtn").linkbutton({
            onClick:function () {
                //获取表单对象 手动提交 表单
                $("#addfrom").form("submit",{
                    url:"${pageContext.request.contextPath}/banner/addBanner",
                    onSubmit:function () {
                        //提交前的表单验证
                       // return $(this).form("validate");
                        return true;
                    },
                    success:function () {
                        // 在成功回调里关闭对话框
                        $("#addBannerDialog").dialog("close");
                        $.messager.show({
                           title:"系统提示",
                            msg:"添加成功！"
                        });
                        //在数据表格显示 时 调用load 方法      重新加载显示 第一页  load  用于添加  操作
                        $("#banneredatagrid").datagrid("load");

                    }

                })
            }
        });

            //初始化 重置按钮
        $("#restbtn").linkbutton({
            onClick:function () {
                // 点击后清空数据
                $("#addfrom").form("reset");
            }
            
        })



    });
    //class="easyui-filebox"
</script>


<form id="addfrom" method="post" enctype="multipart/form-data">
    名称：<input  id="addpicName" name="picName"/></br>
    选择图片：<input  id="addpicPath" class="easyui-filebox"  name="img" style="width:300px"/></br>
    描述：<input  id="adddescription" name="description"/></br>
    日期：<input  id="addcreateTime" name="createTime"/></br>
    链接：<input  id="addurl" name="url"/></br>
    状态：
    <select id="status" class="easyui-combobox" name="status" style="width:150px;">
        <option value="1">展示</option>
        <option value="0">不展示</option>
    </select>
    </br>
    <a id="addbtn">添加</a>
    <a id="restbtn">重置</a>
</form>


