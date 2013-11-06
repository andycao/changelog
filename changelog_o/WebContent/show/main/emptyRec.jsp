<%@ page import="org.hibernate.Session, changelog.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<% User user = (User)session.getAttribute("user");%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>allProject</title>
<link rel="stylesheet" type="text/css" href="../css/style.css">
<link rel="stylesheet" type="text/css" href="../css/welcome_style.css">
</head>
<body>
<div id="main">
<div class="show">
	<h3>查询错误</h3>
	<p>用户ID：<%=user.getUserID() %></p>
	<p>抱歉<%=user.getName() %>，搜索结果为空请确认查询项目！</p>
	
</div>
</div>
</body>
</html>