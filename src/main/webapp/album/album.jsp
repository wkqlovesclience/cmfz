<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/7/6
  Time: 17:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" %>



<script type="text/javascript">

    $(function () {

    //用js 创建 表格
        $("#albumtreegid").treegrid({
            url:"${pageContext.request.contextPath}/album/queryAllAlbum",
            idField:"id",
            treeField:"name",
            fitColumns:true,
            //fit:true,
            toolbar:"#albumAllToolBar",
            pagination:true,
            pageSize:3,
            pageNumber:1,
            pageList:[3,4,5,7],
            columns:[[
                {title:'名字',field:'name',width:180},
                {title:'章节大小',field:'size',width:80},
                {title:"章节时长",field:'length',width:80},
                {title:'音频路径',field:'url',width:80}
            ]],

            //   定义单击事件
            onClickRow:function () {  // 单击 播放
                //获取选中行
                var row =$("#albumtreegid").treegrid("getSelected");
                // 获取 播放的id 改变 src 的原路径
                $("#videoPlay").prop("src","${pageContext.request.contextPath}/video/"+row.url);
            },
        });




        //初始化 专辑详情按钮
        $("#albumDetail").linkbutton({
            iconCls:"icon-pencil",
            onClick:function () { //点击详情

                //获取选中行
                var row =$("#albumtreegid").treegrid("getSelected");
                if(row==null){  // 判断 如果没选中，提示选中
                    alert("请选中要查看的专辑行");
                }else{
                    // 弹出 详情对话框
                    $("#detailDialog").dialog("open");
                    // 初始化查详情的数据表格
                    $("#allAlbumDetailDatagrid").datagrid({
                        url:"${pageContext.request.contextPath}/album/queryOneById?id="+row.id,
                        fitColumns:true,
                        fit:true
                    });





                  /*  //页面加载后，ajax 查详情
                    $.get(
                        "{pageContext.request.contextPath}/album/queryOneById",
                        "id="+row.id,
                        function (res){
                            $("#detailAlbumTabs").append($("<tr><th>"+res.name+"</th><th>"+res.score+"</th><th>"+res.author+"</th><th>"+res.broadcast+"</th><th>"+res.count+"</th><th>"+res.description+"</th><th>"+res.publishTime+"</th></tr>"));
                        },
                        "json"
                    );
*/






                }
            }
        });


       // $("#allAlbumDetailDatagrid").datagrid("load");



        // 初始化专辑详情对话框
        $("#detailDialog").dialog({
            title:"专辑详情",
            width:500,
            height:300,
            closed:true,
            href:"${pageContext.request.contextPath}/album/albumDetail.jsp",
            modal:true,
            onLoadSuccess:function (data) {

            }

        });



        //初始化 添加专辑按钮
        $("#addAlbumBtn1").linkbutton({
            iconCls:"icon-add",
           onClick:function () {
               $("#addAlbumDialog").dialog("open");
           }

        });

        //初始化 添加专辑对话框
        $("#addAlbumDialog").dialog({
            title:"添加专辑",
            width:500,
            height:300,
            closed:true,
            href:"${pageContext.request.contextPath}/album/addAlbum.jsp",
            modal:true


        });


        //初始化 添加章节按钮
        $("#addCharacter").linkbutton({
            iconCls:"icon-add",
            onClick:function () {
                $("#addChapterDialog").dialog("open");
            }

        });

        //初始化章节对话框
    $("#addChapterDialog").dialog({
        title:"添加章节",
        width:500,
        height:300,
        closed:true,
        href:"${pageContext.request.contextPath}/album/addChapter.jsp",
        modal:true
    });



        //初始化 下载音频按钮
        $("#downloadVideo").linkbutton({
            iconCls:"icon-pencil",
            onClick:function () {
                //
                //获取选中行
                var row =$("#albumtreegid").treegrid("getSelected");
                if(row==null){  // 判断 如果没选中，提示选中
                    alert("请选中要下载的行");
                }else{
                    //点击 选中行
                    var row =$("#albumtreegid").treegrid("getSelected");
                    location.href="${pageContext.request.contextPath}/chapter/downLoad?url="+row.url;
                }

            }
        });

    });

</script>





<div>
    <audio id="videoPlay" src="${pageContext.request.contextPath}/video/seeyou.mp3"
                onclose="true" controls="controls"  loop="true">
    </audio>
</div>



<table id="albumtreegid" style="width:600px;height:400px"></table>
<%--工具栏--%>
<div id="albumAllToolBar">
    <a id="albumDetail">专辑详情</a>
    <a id="addAlbumBtn1">添加专辑</a>
    <a id="addCharacter">添加章节</a>
    <a id="downloadVideo">下载音频</a>

</div>

<%--详情对话框--%>
<div id="detailDialog"></div>
<%--添加专辑对话框--%>
<div id="addAlbumDialog"></div>
<%--添加章节对话框--%>
<div id="addChapterDialog"></div>
<%--下载对话框--%>
<div id="downChapterDialog"></div>



