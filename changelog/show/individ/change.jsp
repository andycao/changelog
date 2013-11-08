<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="changelog.*;" %>
<% User user = (User) session.getAttribute("user"); int uid = user.getUserID(); String tit = user.getTitle(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更改日志</title>
<link rel="stylesheet" type="text/css" href="../css/style.css">
<link rel="stylesheet" type="text/css" href="../css/change_main.css">
<script src="../js/delete-confirm.js"></script>
</head>
<body>
<div id="main">
	<div class="show">
		<h3>更改记录--<s:property value="changeResult.changeId" /></h3>
		<table>
		<tr><th id="th1"></th><th id="th2"></th></tr>
		<tr>
		<td><label>更改ID：</label></td><td><s:property value="changeResult.changeId"/></td>
		</tr>
		<tr>
		<td><label>更改日期：</label></td><td><s:date name="changeResult.changeDate" format="yyyy-MM-dd"/></td>
		</tr>
		<tr>
		<td><label>改变文件：</label></td><td><s:property value="changeResult.changeFile"/></td>
		</tr>
		<tr>
		<td><label>更改人ID：</label></td><td><s:property value="changeResult.userId" /></td>
		</tr>
		<tr>
		<td><label>详细信息：</label></td><td><s:property value="changeResult.changeDetail"/></td>
		</tr>
		</table>
		<p><a href="getVersion.action?versionId=<s:property value="changeResult.versionId" />">所属版本：<s:property value="changeResult.versionId" /></a></p>
		<p><a href="getVersion.action?versionId=<s:property value="changeResult.versionId" />">所属版本名：<s:property value="belongedVersionName" /></a></p>
		
		<%if(tit.equals("edit")){ %>
			<p><a href="#" onclick="show_confirm('/changelog/func/removeChange.action?changeId=<s:property value="changeResult.changeId" />')">删除该记录</a></p>
		<%} %>
		<%if(tit.equals("make")){ %>
			<p><a href="#" onclick="show_confirm('/changelog/func/removeSelfChange.action?changeId=<s:property value="changeResult.changeId" />')">删除该记录</a></p>
		<%} %>
		<%if(tit.equals("edit") || tit.equals("make")){ %>
		<p><a href="/changelog/func/preEditChange.action?changeId=<s:property value='changeResult.changeId'/>">编辑更改记录</a></p>
		<%} %>
	</div>
</div>
</body>
</html>