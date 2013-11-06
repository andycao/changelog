<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding = "UTF-8"%>
<%@ page import = "changelog.*,org.hibernate.*,java.util.*;" %>
<jsp:useBean id = "mydb" class = "changelog.myDb" scope = "request"></jsp:useBean>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>show All</title>
</head>
<body>
	<h2>所有更改记录</h2>
<table>
  <%
  org.hibernate.Session se=mydb.getSession();
  Query query = se.createQuery("from Change");
	List<Change> list = query.list(); %>
	<tr><th>ID</th>
	<th>工程名</th>
	<th>项目</th>
	<th>版本</th>
	<th>文件</th>
	<th>时间</th>
	<th>用户</th>
	<th>详细内容</th>
	</tr>
	<%for(Change c:list){ %>
	<tr><td><%=c.getChangeId()%></td>
	<td><%=c.getProjectId()%></td>
	<td><%=c.getProgramId() %></td>
	<td><%=c.getVersionId()%></td>
	<td><%=c.getChangeFile() %></td>
	<td><%=c.getChangeDate() %></td>
	<td><%=c.getUserId()%></td>
	<td><%=c.getChangeDetail() %></td></tr>
	<%}%>
</table>
</body>
</html>