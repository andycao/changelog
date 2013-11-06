<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登陆</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<script src="./js/jquery.min.v1.8.3.js"></script>
<script type='text/javascript' src="./js/myjs.js"></script>
</head>
<body>
 <div id="header">
 	<h1>用户登陆</h1>
	<hr>
 </div>
 <div id="main">
 <div class="form_s">
 <s:actionerror/>
 <s:form method="post" action="login.action">
 	<s:textfield label="用户名" name="username"></s:textfield>
 	<s:password label="密码" name="password"></s:password>
 </s:form>
 <div class="buttons">
		<a href="#" id="buttons_submit"><span>提交</span></a>
		<a href="#" id="buttons_cancel"><span>取消</span></a>
 </div>
 <div class="comments"><p>请使用用户名登陆，而不是用户ID！</p></div>
 <div id="clear"></div>
 </div>
 </div>
 
</body>
</html>