<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="changelog.*,util.myutil;" %>
<% User user = (User) session.getAttribute("user"); int uid = user.getUserID(); String tit = user.getTitle(); %>
<%	
	request.setAttribute("users", myutil.getUsers());
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>版本</title>
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
		<h3>版本-<s:property value="versionResult.versionName" /></h3>
		<p>版本ID：<s:property value="versionResult.versionId"/></p>
		<p>版本名称：<s:property value="versionResult.versionName" /></p>
		<p id="break">详细信息：<s:property value="versionResult.detail"/></p>
		<p><a href="getProgram.action?programId=<s:property value="versionResult.programId" />">所属工程ID：<s:property value="versionResult.programId" /></a></p>
		<p><a href="getProgram.action?programId=<s:property value="versionResult.programId" />">所属工程名：<s:property value="belongedProgramName" /></a></p>
		<p>更改记录总数：<s:property value="#request.list.size" /></p>
		<%if(tit.equals("edit")){ %>
		<p><a href="#" onclick="show_confirm('/changelog/func/removeVersion.action?versionId=<s:property value="versionResult.versionId" />')">删除该版本</a></p>
		<p><a href="/changelog/func/preEditVersion.action?versionId=<s:property value="versionResult.versionId" />">编辑版本</a></p>
		<p><a href="#" onclick="show_confirm('/changelog/func/removeChangesByVID.action?versionId=<s:property value="versionResult.versionId" />')">清空更改记录</a></p>
		<%} %>
		<%if(tit.equals("edit") || tit.equals("make")) {%>
		<p><a href="/changelog/func/preAddChange.action?versionId=<s:property value='versionResult.versionId' />
		&userId=<%=uid %>&disable=true" target="welcomemain">添加更改记录</a></p>
		<%} %>
		</div>
		
		<div class="lists">
		<h3>更改记录列表</h3>
		<table>
		<tr><th>更改ID</th>
		<th>更改时间</th>
		<th>更改文件</th>
		<th>更改人</th>
		</tr>
		<s:iterator value="list" status="count">
			<s:if test="#count.odd==true">
				<tr>
			</s:if>
			<s:else>
				<tr class="alt">
			</s:else>
			<td><a href="getChange.action?changeId=<s:property value="changeId" />"><s:property value="changeId" /></a></td>
			<td><a href="getChange.action?changeId=<s:property value="changeId" />"><s:date name="changeDate" format="MM-dd"/></a></td>
			<td><s:property value="changeFile"/></td>
			<td>${users[userId]}</td>
			</tr>
		</s:iterator> 
		</table>
		</div>
	</div>
</div>
</body>
</html>