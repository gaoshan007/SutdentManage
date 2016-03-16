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
    
    <title>My JSP 'browseAllItemPaging' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/studentmanage.css">
	

  </head>
  
  <body>
 
   <div class="content">
		<div class="left">
		

		</div>
		<div class="right">
		 
			<s:iterator value="#request.items" id="item">
				<div class="newitem">
					
					
					<form action="itemAction" method="post">
       <img src="pic/<s:property value="#item.picture"/>" />
						<br>
						<s:property value="#item.itemname" />
						<br>
						<%-- <s:property value="#item.price" />元 --%>
 <br>

	 <input type="hidden" name="itemid" value="<s:property value="#item.itemid" />"> 					
		
<input type="submit" value="修改" onclick="this.form.action='displayOneItem'"/>
<input type="submit" value="删除" onclick="this.form.action='deleteOneItem'"/>
</form>
					
				</div>
			</s:iterator>
		
		
			</div>
	</div>
	<jsp:include page="foot.jsp"></jsp:include>
  </body>
</html>
