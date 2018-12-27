<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/7/9
  Time: 8:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


    <h1>请先下载模板
     <a href="${pageContext.request.contextPath}/poi/downLoad?file=user.xls">点击下载</a></h1>

    <form method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath}/poi/importPoiUser">
        <h2 >请选择导入的文件</h2>

        <input  type="file"  name="fileName"></br>
        <input type="submit" value="提交"/>
    </form>

