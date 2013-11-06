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

	<h2>查看所有项目</h2>
	
	<%org.hibernate.Session se=mydb.getSession();
	Query query1 = se.createQuery("from theProject");
	List<theProject> list = query1.list();%>
	<p>工程总数：<%=list.size() %></p>
	<%for(theProject proj : list){ %>
		<h3><%="Projects: "+proj.getProjectName()+" ID:"+proj.getProjectId() %></h3>
	<%}%>
	<%Query query2=se.createQuery("from Program");
	List<Program> list2 = query2.list();%>
	<p>项目总数：<%=list2.size() %></p>
	<%for(Program program : list2){%>
		<h4><%="Programs: "+program.getProgramName() +" ID:"+program.getProgramId()%></h4>
	<%} %>
	<%Query query3=se.createQuery("from Version");
	List<changelog.Version> list3 = query3.list();%>
	<p>版本总数：<%=list3.size() %></p>
	<%for(changelog.Version version : list3){%>
		<p><%="Versions: "+version.getDetail() +" ID:"+version.getVersionId()%></p>
	<%} %>
<hr />
<%se.close(); %>
<a href="/changelog/welcome">我的功能</a>
</body>
</html>