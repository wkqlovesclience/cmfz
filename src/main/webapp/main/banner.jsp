<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/7/5
  Time: 9:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" %>

    <script type="text/javascript">
      $(function () {

            // 初始化  数据表格  记住 不能有head body  因为这个页面是被包含的
          $("#banneredatagrid").edatagrid({
              url: "${pageContext.request.contextPath}/banner/queryAllBanner",
              saveUrl:"${pageContext.request.contextPath}/banner/modifyBanner",
              updateUrl: "",
              destroyUrl:"${pageContext.request.contextPath}/banner/removeBanner",
              toolbar:"#allBannerTools",
              fitColumns:true,
              view: detailview,
              detailFormatter: function(rowIndex, rowData){
                  return '<table><tr>' +
                      '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/img/image/' + rowData.picPath+ '" style="height:50px;"></td>' +
                      '<td style="border:0">' +
                      '<p>创建日期: ' + rowData.createTime + '</p>' +
                      '<p>状态: ' + rowData.status + '</p>' +
                      '<p>描述: ' + rowData.description + '</p>' +
                      '</td>' +
                      '</tr></table>';
              },destroyMsg:{
                  norecord:{    // 在没有记录选择的时候执行
                      title:'Warning',
                      msg:'请选中要删除的行'
                  },
                  confirm:{       // 在选择一行的时候执行		title:'Confirm',
                      msg:'Are you sure you want to delete?'
                  }
              },

          });


          //初始化 添加 dialog表格
        $("#addBannerDialog").dialog({
                title:"添加轮播图",
                width:500,
                height:300,
                href:"${pageContext.request.contextPath}/main/addbanner.jsp", // 远程加载 添加的 jsp
                modal:true,
                closed:true
        });

          // 初始添加按钮
          $("#addBannerBtn").linkbutton({
              iconCls: 'icon-add',
              //点击出后显示对话框
              onClick:function () {
                    $("#addBannerDialog").dialog("open");
              }
          });

          //初始化修改按钮
            $("#modifyBannerBtn").linkbutton({
                iconCls:"icon-pencil",
                onClick:function () {  // 修改的单击事件
                    //获取选中的行
                    var row=$("#banneredatagrid").edatagrid("getSelected");
                        if(row!=null){ // 把当前行变成可编辑模式
                                //获取选中行的下标
                            var index= $("#banneredatagrid").edatagrid("getRowIndex",row);
                            $("#banneredatagrid").edatagrid("editRow",index);
                        }else{
                                alert("请先选中行");
                        }
                }


            });

          //初始化删除按钮
          $("#deleteBannerBtn").linkbutton({
              iconCls:"icon-remove",
              onClick:function () {   // 给删除按钮注册点击 事件
                  // 销毁所有选择的行
                  $("#banneredatagrid").edatagrid('destroyRow');

              }



          });

          //初始化保存按钮
          $("#saveBannerBtn").linkbutton({
              iconCls:"icon-filesave",
                onClick:function () {
                  //点击后 保存编辑行并发送到服务器。
                    $("#banneredatagrid").edatagrid("saveRow");
                }
          });




      });



    </script>


<table id="banneredatagrid" style="width:700px;height:400px"
       title="工具栏"
       singleSelect="true">
    <thead>       <%--这里只让改状态 ，所以只给状态 加上 可编辑 editor--%>
    <tr>
        <th field="picName" width="100" >名字</th>
        <th field="status" width="100" editor="{type:'numberbox'}">状态</th>
        <th field="picPath" width="100" >路径</th>
        <th field="createTime" width="100">创建时间</th>
    </tr>
    </thead>
</table>

<%--工具栏功能按钮--%>
<div id="allBannerTools">
    <a id="addBannerBtn">添加</a>
    <a id="modifyBannerBtn">修改</a>
    <a id="deleteBannerBtn">删除</a>
    <a id="saveBannerBtn">保存</a>
</div>


<%--添加对话框--%>
<div id="addBannerDialog"></div>
<%--修改对话框--%>
<div id="modifyBannerDialog"></div>



