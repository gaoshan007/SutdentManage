<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'foot.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	

  </head>
  
  <body>
  
  <div class="foot">
  	<div> Copyright 2013-2014 All rights reserved. 西南石油大学-计算机科学学院 版权所有 </div>
  	<div> 成都市新都区新都大道8号 邮编:610500  &nbsp;&nbsp;&nbsp;  <a href="admin.jsp" target="_selt">管理入口</a></div>  
<br>


  </body>
</html>
