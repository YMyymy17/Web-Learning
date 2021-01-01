<%@ page language="java" import="dao.python_stuhomeworkDao,entity.python_student_homework" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>作业下载</title>
</head>
<%
	String sid=request.getParameter("sid");
	String zjid=request.getParameter("zjid");
	python_stuhomeworkDao pdao=new python_stuhomeworkDao();
	python_student_homework p=pdao.queryById(sid, zjid);
	
	String path=request.getServletContext().getRealPath("/")+"fileupload\\";
	String path1=p.getHomework();
	String real=path1.replace(path,"");
%>
<body>
	下载:<a href="javaee_teacher_downloadhomework.action?filename=<%=real%>"><%=real%></a>
</body>
</html>
