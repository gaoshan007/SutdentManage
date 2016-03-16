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

<title>My JSP 'menu.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

	<!-- <link rel="stylesheet" type="text/css" href="styles.css"> -->

</head>

<body>
	<s:iterator value="#request.categorys" id="category">
		<%-- <a href="" target="_self">
			<s:property value="#category.categoryname"/>
			<br><br>
		</a> --%>
		<a href="brwoseItemPaging.action?categoryid=
		    <s:property value="#category.categoryid"/>&currentPage=1" target="_self">
		    <br>
		    <br>
		    <s:property value="#category.categoryname"/>
		</a>   
     
	</s:iterator>
</body>
</html>
