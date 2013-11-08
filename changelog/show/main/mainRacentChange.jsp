<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>最近更改</title>
<link rel="stylesheet" type="text/css" href="../css/style.css">
<link rel="stylesheet" type="text/css" href="../css/welcome_style.css">
</head>
<body>	
<div id="main">
<div class="show">
<h3>近期更改内容</h3>
<table>
<tr><th>更改ID</th>
	<th>版本ID</th>
	<th>更改时间</th>
	<th>更改文件</th>
	<th>更改人ID</th>
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
		<td><a href="getChange.action?changeId=<s:property value='changeId' />"><s:date name="changeDate" format="MM-dd"/></a></td>
		<td><s:property value="changeFile"/></td>
		<td><s:property value="userId"/></td>
		<td><a href="getProject.action?projectId=<s:property value='projectId' />"><s:property value="projectId" /></a></td>
		</tr>
	</s:iterator> 
</table>
<p>总数：<s:property value="#request.list.size" /></p>
</div>
</div>
<div id="clear"></div>
</body>
</html>