<%@page import="org.hibernate.Session,changelog.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="changelog.*;" %>
<% User user = (User) session.getAttribute("user"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>welcometop</title>
<link rel="stylesheet" type="text/css" href="../css/style.css">
<link rel="stylesheet" type="text/css" href="../css/welcome_style.css">
<script src="../js/jquery.min.v1.8.3.js"></script>
<script type='text/javascript' src="../js/myjs.js"></script>
</head>
<body>
<div id="main">
	<div class="show">
		<h3>欢迎页面</h3>
		<p>用户ID：<%=user.getUserID() %></p>
		<p>用户名：<%=user.getName() %></p>
		<p>操作权限：<%=user.getTitle() %></p>
		<p>欢迎登陆日志系统，祝您工作顺利！</p>
		<div class="image_div">
		<h4>日志系统结构图</h4>
		<img src="/changelog/images/structure.gif" />
		</div>
	</div>
</div>
<div id="clear"></div>
</body>
</html>