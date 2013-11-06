<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑更改记录</title>
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
<h3>编辑更改记录</h3>
<s:set id="chnid" value="#request.changeId"/>
<s:set id="chnfile" value="#request.changeFile"/>
<s:set id="chndate" value="#request.changeDate"/>
<s:set id="chndetail" value="#request.changeDetail"></s:set>
	<s:form method="post" action="editChange.action">
		<s:textfield name="changeId" label="更改ID" value="%{#chnid}" readonly="true"></s:textfield>
		<s:textfield name="changeFile" label="更改文件" value="%{#chnfile}"></s:textfield>
		<s:textfield name="changeDate" label="更改时间" onClick="WdatePicker()" value="%{#chndate}"></s:textfield>
		<s:textarea name="changeDetail" label="详细信息" rows="11" cols="45" value="%{#chndetail}"></s:textarea>
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

