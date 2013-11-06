<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加版本</title>
<link rel="stylesheet" type="text/css" href="../css/style.css">
<link rel="stylesheet" type="text/css" href="../css/func.css">
<link rel="stylesheet" type="text/css" href="../css/welcome_style.css">
<script src="../js/jquery.min.v1.8.3.js"></script>
<script type='text/javascript' src="../js/myjs_without_key.js"></script>
</head>
<body>
<div id="main">
<div class="form_s show">
<h3>添加版本</h3>
<s:set id="pomid" name="pomid" value="#request.programId"/>
<s:set id="disable" name="disable" value="#request.disable"></s:set>
	<s:form method="post" action="addVersion.action">
		<s:textfield name="programId" label="所属工程ID" value="%{#pomid}" readonly="%{#disable}"></s:textfield>
		<s:textfield name="versionName" label="版本名称"></s:textfield>
		<s:textarea name="detail" label="详细说明" rows="11" cols="45"></s:textarea>
	</s:form>
	<div class="buttons">
		<a href="#" id="buttons_submit"><span>提交</span></a>
		<a href="#" id="buttons_cancel"><span>取消</span></a>
 	</div>
</div>
<div class="comments"><p>所属工程ID须为整数且需真实存在</p>
</div>
</div>
</body>
</html>