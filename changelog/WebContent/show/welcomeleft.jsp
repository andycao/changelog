<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="changelog.*;" %>
<% User user = (User) session.getAttribute("user"); int uid = user.getUserID(); String tit = user.getTitle(); %>
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
<div class="function">
	<a href="/changelog/show/showAllProject.action" target="welcomemain">所有项目</a>
	<a href="/changelog/show/showAllProgram.action" target="welcomemain">所有工程</a>
	<a href="/changelog/show/showAllVersion.action" target="welcomemain">所有版本</a>
	<a href="/changelog/show/showAllChange.action" target="welcomemain">所有更改</a>
	<a href="/changelog/show/showMyChange.action" target="welcomemain">我的更改</a>
	<a href="/changelog/show/showRacentChange.action" target="welcomemain">最近更改</a>
	<% if(tit.equals("编辑")){ %>
	<div class="add_function">
	<a href="/changelog/func/addProject.jsp" target="welcomemain">添加项目</a>
	<a href="/changelog/func/addProgram.jsp" target="welcomemain">添加工程</a>
	<a href="/changelog/func/addVersion.jsp" target="welcomemain">添加版本</a>
	</div>
	<% } %>
	<div id="clear"></div>
</div>
</body>
</html>