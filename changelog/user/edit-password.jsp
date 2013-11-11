<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改密码</title>
<link rel="stylesheet" type="text/css" href="../css/style.css">
<link rel="stylesheet" type="text/css" href="../css/change_main.css">
</head>
<body>
<s:label>修改密码</s:label>
<s:form action="editPassword.action" target="_parent">
	<s:password label="新密码" name="password"></s:password>
	<s:submit value="提交"></s:submit>
	<s:reset value="重置"></s:reset>
</s:form>
</body>
</html>