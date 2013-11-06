<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="changelog.*,mydbsearcher.mydbsearcher,java.util.List;" %>
<% User user = (User)session.getAttribute("user");
	String username="null";
	if(user != null) username = user.getName();
%>
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
<div id="header">
	<h2><%= username %>您好，日志系统欢迎您! </h2>
	<p>
	<a href="/changelog/show/welcomemain.jsp" target="welcomemain">欢迎页</a>
	当前时间：<label id="timelabel"></label> <a id="logout" href="/changelog/logout.action" target=_parent>登出</a></p>
	<hr>
</div>
</body>
</html>