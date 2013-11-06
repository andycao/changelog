<%@page import="org.hibernate.Session,changelog.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<% User user = (User)session.getAttribute("user");%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的更改</title>
<link rel="stylesheet" type="text/css" href="../css/style.css">
<link rel="stylesheet" type="text/css" href="../css/welcome_style.css">
</head>
<body>
<div id="main">
<div class="show">
<h3>我的更改内容</h3>
<table>
<tr><th>更改ID</th>
	<th>版本ID</th>
	<th>更改时间</th>
	<th>更改文件</th>
	<th>工程ID</th></tr>
	<s:iterator value="list" status="count">
		<s:if test="#count.odd==true">
		<tr>
		</s:if>
		<s:else>
		<tr class="alt">
		</s:else>
		<td><a href="getChange.action?changeId=<s:property value='changeId' />"><s:property value="changeId" /></a></td>
		<td><a href="getVersion.action?versionId=<s:property value='versionId' />"><s:property value="versionId" /></a></td>
		<td><a href="getChange.action?changeId=<s:property value='changeId' />"><s:property value="changeDate" /></a></td>
		<td><s:property value="changeFile"/></td>
		<td><a href="getProject.action?projectId=<s:property value='projectId' />"><s:property value="projectId" /></a></td>
		</tr>
	</s:iterator> 
</table>
<div class="userinfo">
	<p>用户ID：<%=user.getUserID() %></p>
	<p>权限：<%=user.getTitle() %></p>
	<p>更改总数：<s:property value="#request.list.size"/></p>
</div>
</div>
</div>
<div id="clear"></div>
</body>
</html>