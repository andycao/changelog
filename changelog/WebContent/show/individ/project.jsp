<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="changelog.*;" %>
<% User user = (User) session.getAttribute("user"); int uid = user.getUserID(); String tit = user.getTitle(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>项目</title>
<link rel="stylesheet" type="text/css" href="../css/style.css">
<link rel="stylesheet" type="text/css" href="../css/welcome_style.css">
<link rel="stylesheet" type="text/css" href="../css/element.css">
<style type="text/css">
#break{
	word-wrap:break-word;
}
</style>
</head>
<body>
<div id="main">
	<div class="show">
		<div class="detail">
		<h3>项目-<s:property value="searchResult.projectName" /></h3>
		<p>项目ID：<s:property value="searchResult.projectId"/></p>
		<p>项目名称：<s:property value="searchResult.projectName"/></p>
		<p>开始时间：<s:property value="searchResult.startTime"/></p>
		<p>最后更改时间：<s:property value="searchResult.lastChangeTime"/></p>
		<p id="break">项目详细信息：<s:property value="searchResult.projectDetail"/></p>
		<p>包含工程总数：<s:property value="#request.list.size" /></p>
		<%if(tit.equals("编辑")){ %>
		<p><a href="/changelog/func/preAddProgram.action?projectId=<s:property value="searchResult.projectId"/>
		&disable=true" target="welcomemain">添加工程</a></p>
		<p><a href="/changelog/func/removeProject.action?projectId=<s:property value='searchResult.projectId' />">删除该项目</a></p>
		<p><a href="/changelog/func/preEditProject.action?projectId=<s:property value='searchResult.projectId' />">编辑项目</a></p>
		<%} %>
		</div>
		
		<div class="lists">
		<h3>包含工程列表</h3>
		<table>
		<tr><th>工程ID</th>
		<th>工程名称</th></tr>
		<s:iterator value="list" status="count">
			<s:if test="#count.odd==true">
				<tr>
			</s:if>
			<s:else>
				<tr class="alt">
			</s:else>
			<td><a href="getProgram.action?programId=<s:property value="programId" />"><s:property value="programId" /></a></td>
			<td><a href="getProgram.action?programId=<s:property value="programId" />"><s:property value="programName" /></a></td>
			</tr>
		</s:iterator> 
		</table>
		</div>
	</div>
</div>
</body>
</html>