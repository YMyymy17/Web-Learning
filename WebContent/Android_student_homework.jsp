<%@ page language="java" import="dao.AndroidDao,entity.Android" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>作业下载</title>
</head>
<%
	String id=request.getParameter("h_id");
	AndroidDao adao=new AndroidDao();
	Android a=adao.queryzjById(id);
	String path=request.getServletContext().getRealPath("/")+"fileupload\\";
	String path1=a.getHomework().toString();
	String real=path1.replace(path,"");
%>
<body>
下载:<a href="android_homework_download.action?filename=<%=real%>"><%=real%></a>
</body>
</html>
