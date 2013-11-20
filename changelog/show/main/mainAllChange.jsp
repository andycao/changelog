<%@page import="org.hibernate.Session,util.myutil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	request.setAttribute("users", myutil.getUsers());
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>所有更改</title>
<link rel="stylesheet" type="text/css" href="../css/style.css">
<link rel="stylesheet" type="text/css" href="../css/welcome_style.css">
</head>
<body>
<div id="main">
<div class="show">
<h3>所有更改内容</h3>
<table>
<tr>
	<th>更改文件</th>
	<th>所属版本ID</th>
	<th>更改时间</th>
	<th>更改人</th>
	</tr>
	<% int i = 1; %>
	<s:iterator value="list" status="count">
		<s:if test="#count.odd==true">
		<tr>
		</s:if>
		<s:else>
		<tr class="alt">
		</s:else>
		<td><a href="getChange.action?changeId=<s:property value='changeId' />"><s:property value="changeFile"/></a></td>
		<td><a href="getVersion.action?versionId=<s:property value='versionId' />"><s:property value="versionId" /></a></td>
		<td><a href="getChange.action?changeId=<s:property value='changeId' />"><s:date name="changeDate" format="yyyy-MM-dd"/></a></td>

		<td>${users[userId]}</td>
		</tr>
	</s:iterator> 
</table>
<p>总数：<s:property value="#request.list.size" /></p>
</div>
</div>
<div id="clear"></div>
</body>
</html>