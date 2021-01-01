<%@ page language="java" import="dao.JavaeeDao,entity.JavaEE" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>作业下载</title>
</head>
<%
	String id=request.getParameter("h_id");
	JavaeeDao jdao=new JavaeeDao();
	JavaEE j=jdao.queryzjById(id);
	String path=request.getServletContext().getRealPath("/")+"fileupload\\";
	String path1=j.getHomework().toString();
	String real=path1.replace(path,"");
%>
<body>
下载:<a href="javaee_homework_download.action?filename=<%=real%>"><%=real%></a>
</body>
</html>
