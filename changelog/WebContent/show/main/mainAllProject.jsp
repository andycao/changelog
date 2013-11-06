<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>所有项目</title>
<link rel="stylesheet" type="text/css" href="../css/style.css">
<link rel="stylesheet" type="text/css" href="../css/welcome_style.css">
</head>
<body>
<div id="main">
<div class="show">
<h3>所有项目</h3>
<table>
<tr><th>ID</th>
	<th>项目名称</th>
	<th>开始时间</th>
	<th>更改时间</th></tr>
	<s:iterator value="list" status="count">
		<s:if test="#count.odd==true">
		<tr>
		</s:if>
		<s:else>
		<tr class="alt">
		</s:else>
		<td><a href="getProject.action?projectId=<s:property value='projectId'/>" target="welcomemain"><s:property value="projectId" /></a></td>
		<td><a href="getProject.action?projectId=<s:property value='projectId'/>" target="welcomemain"><s:property value="projectName" /></a></td>
		<td><s:property value="startTime" /></td>
		<td><s:property value="lastChangeTime"/></td>
		</tr>
	</s:iterator> 
</table>
<p>总数：<s:property value="#request.list.size" /></p>
</div>
</div>
<div id="clear"></div>
</body>
</html>