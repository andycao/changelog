<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑项目</title>
<link rel="stylesheet" type="text/css" href="../css/style.css">
<link rel="stylesheet" type="text/css" href="../css/func.css">
<link rel="stylesheet" type="text/css" href="../css/welcome_style.css">
<script type="text/javascript" src="../datepicker/WdatePicker.js"></script>
<script src="../js/jquery.min.v1.8.3.js"></script>
<script type='text/javascript' src="../js/myjs_without_key.js"></script>
</head>
<body>
<div id="main">
<div class="form_s show">
<h3>修改项目</h3>
<s:set id="pojid" value="#request.projectId"/>
<s:set id="pojname" value="#request.projectName"/>
<s:set id="pojstime" value="#request.projectStartTime"></s:set>
<s:set id="pojdetail" value="#request.projectDetail"></s:set>
	<s:form method="post" action="editProject.action">
		<s:textfield name="projectId" label="项目ID" value="%{#pojid}" readonly="true"></s:textfield>
		<s:textfield name="projectName" label="项目名" value="%{#pojname}"></s:textfield>
		<s:textfield name="startTime" label="开始时间" onClick="WdatePicker()" value="%{#pojstime}"></s:textfield>
		<s:textarea name="projectDetail" label="详细信息" rows="11" cols="45" value="%{#pojdetail}"></s:textarea>
	</s:form>
	<div class="buttons">
		<a href="#" id="buttons_submit"><span>提交</span></a>
		<a href="#" id="buttons_cancel"><span>取消</span></a>
 	</div>
</div>
<div class="comments"><p></p>
</div>
</div>
</body>
</html>

