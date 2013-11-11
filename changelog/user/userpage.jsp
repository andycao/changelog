<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户主页</title>
<link rel="stylesheet" type="text/css" href="../css/style.css">
<link rel="stylesheet" type="text/css" href="../css/change_main.css">
<script src="../js/delete-confirm.js"></script>
<style type="text/css">
#main .show table{
	width:380px;
	position:relative;
	left:60px;
	margin-bottom:9px;
}
</style>
</head>
<body>
<div id="main">
	<div class="show">
		<h3>用户中心</h3>
		<table id="user">
		<tr><th>用户ID:</th><td><s:property value="showUser.userID"/></td></tr>
		<tr><th>用户名:</th><td><s:property value="showUser.name" /></td></tr>
		<tr><th>权限:</th><td><s:property value="showUser.title"/></td></tr>
		</table>
		<a href="edit-password.jsp">修改密码</a><br />
		<a href="#">修改权限</a><br />
		<a href="../login.action" target="_parent" onclick="show_confirm('deleteuser.action?userid=<s:property value="showUser.userID"/>')">删除</a>
	</div>
</div>
</body>
</html>