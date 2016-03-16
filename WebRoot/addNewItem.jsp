<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css" href="css/studentmanage.css">

</head>

<body>

	<div class="content">
		<div class="left"></div>
		<div class="right">
			<div style="padding-left:200px;width: 600px;">

				<s:form action="addOrUpdateItem.action" method="post"
					enctype="multipart/form-data">
					<tr>
						<td></td>
						<td>请在此输入新的信息</td>
					</tr>

					<s:textfield label="作品名称" name="item.itemname"></s:textfield>
					<!-- <tr>
						<td>作品简介</td>
						<td><input type="text" name="item.desc"> <label>元</label></td>
					</tr> -->
					<s:action name="browseCategory" executeResult="false">
					</s:action>

					<s:set value="#request.categorys" id="category"></s:set>
					<s:property value="#category.size" />
					<s:select label="分类" list="#request.categorys" listKey="categoryid"
						listValue="categoryname" name="item.category.categoryid"
						value="%{#item.category.categoryid}">
					</s:select>
					


					<s:file name="upload" label="图片"></s:file>
					<s:submit value="添加"></s:submit>

				</s:form>
			</div>
		</div>
	</div>
	<jsp:include page="foot.jsp"></jsp:include>
</body>
</html>
