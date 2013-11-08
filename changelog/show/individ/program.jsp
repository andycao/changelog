<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="changelog.*;" %>
<% User user = (User) session.getAttribute("user"); int uid = user.getUserID(); String tit = user.getTitle(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>工程</title>
<link rel="stylesheet" type="text/css" href="../css/style.css">
<link rel="stylesheet" type="text/css" href="../css/welcome_style.css">
<link rel="stylesheet" type="text/css" href="../css/element.css">
<script src="../js/delete-confirm.js"></script>
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
		<h3>工程-<s:property value="programResult.programName" /></h3>
		<p>工程ID：<s:property value="programResult.programId"/></p>
		<p>工程名称：<s:property value="programResult.programName"/></p>
		<p>开始时间：<s:date name="programResult.startTime" format="yyyy-MM-dd"/></p>
		<p>最后更改时间：<s:date name="programResult.lastChangeTime" format="yyyy-MM-dd"/></p>
		<p id="break">工程详细信息：<s:property value="programResult.detail"/></p>
		<p><a href="getProject.action?projectId=<s:property value="programResult.projectId" />">所属项目ID: <s:property value="programResult.projectId" /></a></p>
		<p><a href="getProject.action?projectId=<s:property value="programResult.projectId" /> ">所属项目名: <s:property value="belongedProjectName" /></a></p>
		<p>包含版本数：<s:property value="#request.list.size" /></p>
		<%if(tit.equals("edit")){ %>
		<p><a href="/changelog/func/preAddVersion.action?programId=<s:property value="programResult.programId"/>&disable=true" target="welcomemain">添加版本</a></p>
		<p><a href="#" onclick="show_confirm('/changelog/func/removeProgram.action?programId=<s:property value="programResult.programId" />')">删除该工程</a></p>
		<p><a href="/changelog/func/preEditProgram.action?programId=<s:property value="programResult.programId" />">编辑工程</a></p>
		<%} %>
		</div>
		
		<div class="lists">
		<h3>包含版本列表</h3>
		<table>
		<tr><th>版本ID</th>
		<th>版本名称</th></tr>
		<s:iterator value="list" status="count">
			<s:if test="#count.odd==true">
				<tr>
			</s:if>
			<s:else>
				<tr class="alt">
			</s:else>
			<td><a href="getVersion.action?versionId=<s:property value="versionId" />"><s:property value="versionId" /></a></td>
			<td><a href="getVersion.action?versionId=<s:property value="versionId" />"><s:property value="versionName" /></a></td>
			</tr>
		</s:iterator> 
		</table>
		</div>
	</div>
</div>
</body>
</html>