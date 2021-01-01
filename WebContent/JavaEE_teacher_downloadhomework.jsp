<%@ page language="java" import="dao.javaee_stuhomeworkDao,entity.javaee_student_homework" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>作业下载</title>
</head>
<%
	String sid=request.getParameter("sid");
	String zjid=request.getParameter("zjid");
	javaee_stuhomeworkDao jdao=new javaee_stuhomeworkDao();
	javaee_student_homework j=jdao.queryById(sid, zjid);
	
	String path=request.getServletContext().getRealPath("/")+"fileupload\\";
	String path1=j.getHomework();
	String real=path1.replace(path,"");
%>
<body>
	下载:<a href="javaee_teacher_downloadhomework.action?filename=<%=real%>"><%=real%></a>
</body>
</html>
