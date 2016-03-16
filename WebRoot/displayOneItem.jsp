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

<title>My JSP 'displayOneItem.jsp' starting page</title>
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
				<s:action name="browseCategory" executeResult="false" />
				<s:set value="#request.item" id="item"></s:set>
				<s:form action="addOrUpdateItem.action" method="post"
					enctype="multipart/form-data">
					<tr>
						<td></td>
						<td>请在此修改项目的信息</td>
					</tr>

					<s:textfield label="项目名称" name="item.itemname"
						value="%{#item.itemname}"></s:textfield>
					<tr>
						<%-- <td>价格</td>
						<td><input type="text" name="flower.price"
							value="<s:property value="#flower.price"/>"> <label>元</label></td> --%>
					</tr>
					<s:set value="#request.categorys" id="category"></s:set>
					<s:select label="分类" list="#category" listKey="categoryid"
						listValue="categoryname" name="item.category.categoryid"
						value="%{#item.category.categoryid}"></s:select>
					<tr>
						<td></td>
						<td><input type="file" name="upload"
							value="<s:property value="#item.picture"/>" /></td>
						<td><img alt=""
							src="pic/<s:property value="#item.picture"/>"></td>
					</tr>
					<s:hidden name="item.itemid" value="%{#item.itemid}"></s:hidden>
					<s:hidden name="picture" value="%{#item.picture}"></</s:hidden>

   <s:submit value="修改"></s:submit>

				</s:form>
			</div>
		</div>
	</div>
	<jsp:include page="foot.jsp"></jsp:include>
</body>
</html>
