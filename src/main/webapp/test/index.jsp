<%@ page pageEncoding="UTF-8" %>

<html>
<body>
<h2>Hello World!</h2>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/IconExtension.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.edatagrid.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.etree.js"></script>


<form  action="${pageContext.request.contextPath}/test/testImg" method="post" enctype="multipart/form-data" >
   <%-- 上传 ：<input type="file" name="image"/></br>--%>
  上传：  <input class="easyui-filebox" name="image" style="width:300px">
    <input type="submit" value="提交">

</form>


</body>
</html>
