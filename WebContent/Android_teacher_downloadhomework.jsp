<%@ page language="java" import="dao.android_stuhomeworkDao,entity.android_student_homework" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>作业下载</title>
</head>
<%
	String sid=request.getParameter("sid");
	String zjid=request.getParameter("zjid");
	android_stuhomeworkDao adao=new android_stuhomeworkDao();
	android_student_homework a=adao.queryById(sid, zjid);
	
	String path=request.getServletContext().getRealPath("/")+"fileupload\\";
	String path1=a.getHomework();
	String real=path1.replace(path,"");
%>
<body>
	下载:<a href="javaee_teacher_downloadhomework.action?filename=<%=real%>"><%=real%></a>
</body>
</html>
