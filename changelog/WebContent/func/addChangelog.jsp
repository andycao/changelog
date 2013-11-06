<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../css/style.css">
<link rel="stylesheet" type="text/css" href="../css/func.css">
<link rel="stylesheet" type="text/css" href="../css/welcome_style.css">
<script src="../js/jquery.min.v1.8.3.js"></script>
<script type='text/javascript' src="../js/myjs_without_key.js"></script>
<script type="text/javascript" src="../datepicker/WdatePicker.js"></script>
<title>添加更改记录</title>
</head>
<body>
<div id="main">
<div class="form_s show">
<h3>添加更改记录</h3>
	<s:set id="userid" name="userid" value="#request.userId"/>
	<s:set id="versionid" name="versionid" value="#request.versionId"></s:set>
	<s:set id="disable" name="disable" value="#request.disable"></s:set>
	<s:form method="post" action="addChangelog.action">
		<s:textfield name="versionId" label="所属版本ID" value="%{#versionid}" readonly="%{#disable}"></s:textfield>
		<s:textfield name="userId" label="更改人ID" value="%{#userid}" readonly="%{#disable}"></s:textfield>
	
		<s:textfield name="changeDate" label="更改时间" onclick="WdatePicker()"></s:textfield>
		<s:textarea name="changeFile" label="更改文件地址" rows="5" cols="45"></s:textarea>
		<s:textarea name="changeDetail" label="更改详细信息" rows="11" cols="45"></s:textarea>
	</s:form>
	<div class="buttons">
		<a href="#" id="buttons_submit"><span>提交</span></a>
		<a href="#" id="buttons_cancel"><span>取消</span></a>
 	</div>
</div>
<div class="comments"><p>版本ID须为整数已存在，更改人ID为当前用户，时间请按照yyyy-mm-dd格式</p>
</div>
</div>
</body>
</html>