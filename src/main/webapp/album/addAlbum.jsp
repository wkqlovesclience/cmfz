<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/7/6
  Time: 21:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" %>
<script type="text/javascript">
    $(function () {

        //初始化提交按钮
        $("#addAlbumSaveBtn").linkbutton({
            onClick:function () {
                // 获取表单对象 提交表单
                $("#addAlbumForm").form("submit",{
                    url:"${pageContext.request.contextPath}/album/addAlbum",
                    onSubmit: function(){
                    // do some check
                    // return false to prevent submit;
                        return true;
                },
                success:function(){ //成功的回调
                    //关闭对话框
                    $("#detailDialog").dialog("close");
                    $.messager.show({
                        title:"系统提示",
                        msg:"添加成功！"
                    });
                    // 成功后 重新加载首页数据
                    $("#albumtreegid").treegrid("load");

                },


            });

            }


        });


        //初始化  重置按钮
        $("#resetAlbumBtn").linkbutton({
            onClick:function () {
                //清空表单数据
                $("#addAlbumForm").form("reset");
            }

        })



    });



</script>



<form  id="addAlbumForm">
    名称：<input type="text" name="name"></br>
    评分：<input type="text" name="score"></br>
    作者：<input type="text" name="author"></br>
    播音：<input type="text" name="broadcast"></br>
    集数：<input type="text" name="count"></br>
    描述：<input type="text" name="description"></br>
    发布时间：<input type="text" name="publishTime"></br>
    <a id="addAlbumSaveBtn">提交</a>
    <a id="resetAlbumBtn">重置</a>
</form>