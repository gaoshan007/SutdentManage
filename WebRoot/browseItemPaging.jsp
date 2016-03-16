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

<title>My JSP 'browseItemPaging.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">


</head>

<body>
	<jsp:include page="head.jsp"></jsp:include>
	<div class="content">
		<div class="left">
			<s:action name="browseCategory" executeResult="true"></s:action>
		</div>
		<div class="right">
		<div ></div>
  
			<s:iterator value="#request.items" id="item">
				<div class="newitem">
					<s:form action="shoppingAction" method="post" theme="simple">
						<img src="pic/<s:property value="#item.picture"/>" />
						<br>
						<s:property value="#item.itemname" />
						<br>
					 <br>
 
 					</s:form>
				</div>
			</s:iterator>
			<div style="clear: both">
			 
			 <s:set name="pager" value="#request.page" />
					<s:if test="#pager.hasFirst">
						<a href="browseItemPaging.action?currentPage=1">首页</a>
					</s:if>
					<s:if test="#pager.hasPrevious">
						<a
							href="browseItemPaging.action?currentPage=
								<s:property  value="#pager.currentPage-1"/>">上一页</a>
					</s:if>
					<s:if test="#pager.hasNext">
						<a
							href="browseItemPaging.action?currentPage=
							<s:property  value="#pager.currentPage+1"/>">下一页</a>
					</s:if>
					<s:if test="#pager.hasLast">
						<a
							href="browseItemPaging.action?currentPage=
							<s:property  value="#pager.totalPage"/>">尾页</a>
					</s:if>
					<br>
					当前第
					<s:property value="#pager.currentPage" />
					页, 总共
					<s:property value="#pager.totalPage" />
					页
			 
			 </div>
		</div>


	</div>

	<jsp:include page="foot.jsp"></jsp:include>
</body>
</html>
