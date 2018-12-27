<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/7/7
  Time: 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" %>

<script type="text/javascript">
    //页面加载后
    $(function () {
     /*   //ajax  查所有专辑
        $.get(
            "{pageContext.request.contextPath}/album/queryAll",
            function (res) {
                for(var i=0;i<res.length;i++){
                    $("#selAlbum").append($("<option value='"+res[i].id+"'>"+res[i].name+"</option>"));
                }
            },
            "json"
        );*/

        //方法 2  查所有专辑
        $("#selAlbum").combobox({
            width:100,
            url:"${pageContext.request.contextPath}/album/queryAll",
            valueField:"id",
            textField:"name",
            onLoadSuccess:function(data){
                //console.log(data[0].id);
                $("#selAlbum").combobox("setValue",data[0].id);
            },
            onChange:function(newVal,oldVal){
                $("#selAlbum").combobox("setValue",newVal);
                //console.log(newVal);
            }

        });

        //初始化添加按钮
        $("#addAlbumSaveBtn").linkbutton({
            onClick:function () {
                //获取表单对象
                $("#addAlbumForm").form("submit",{
                    url:"${pageContext.request.contextPath}/chapter/addChapter",
                    onSubmit: function(){
                     return true;
                },
                success:function(){
                    //在成功的回调里 关闭对话框
                    $("#addChapterDialog").dialog("close");
                    $.messager.show({
                        title:"系统提示",
                        msg:"添加成功"
                    });
                    //在数据表格显示 时 调用load 方法      重新加载显示 第一页  load  用于添加  操作
                    $("#albumtreegid").treegrid("load");
                }
            });
            }
        });

        //初始化重置按钮
        $("#resetAlbumBtn").linkbutton({
            onClick:function () {
                // 清空表单数据
                $("addAlbumForm").form("reset");
            }
        })






    });



</script>



<form  id="addAlbumForm" method="post" enctype="multipart/form-data">
          <%--  <input type="hidden" name="id" value="006" >--%>
              章节名称：<input  class="easyui-textbox" name="name"></br>
              章节大小：<input  class="easyui-textbox" name="size"></br>
              音频路径：<input class="easyui-filebox"  name="img"></br>
              时长：&nbsp;&nbsp;<input  class="easyui-textbox" name="length"></br>
              下载次数：<input  class="easyui-textbox" name="times"></br>
              创建时间：<input  class="easyui-textbox" name="createTime"></br>
              选择专辑名称：<select id="selAlbum" name="albumId">

          </select><br/>
    <a id="addAlbumSaveBtn">提交</a>
    <a id="resetAlbumBtn">重置</a>
</form>




