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

<title>My JSP 'newItem.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<div>

		<div>作品展示</div>
		<br>
		<s:set value="#request.newitems" id="newitem"></s:set>
		<s:iterator value="#newitem" id="item">
			<div class="newitem">
				<s:form theme="simple" action="shoppingAction" method="post">
					<img src="pic/<s:property value="#item.picture"/>" />
					<br>
					<s:property value="#item.itemname" />
					<br><br>
					
					<input type="hidden" name="id"
						value="<s:property value="#item.itemid" />">
				</s:form>
			</div>
		</s:iterator>
	</div>
</body>
</html>
