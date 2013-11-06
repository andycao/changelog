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
	<h2>所有用户信息</h2>
<table>
  <%
  org.hibernate.Session se=mydb.getSession();
  Query query = se.createQuery("from User");
	List<User> list = query.list(); %>
	<tr><th>ID</th>
	<th>名称</th>
	<th>职务</th>
	</tr>
	<%for(User c:list){ %>
	<tr><td><%=c.getUserID()%></td>
	<td><%=c.getName()%></td>
	<td><%=c.getTitle() %></td>
	</tr>
	<%}%>
</table>
</body>
</html>