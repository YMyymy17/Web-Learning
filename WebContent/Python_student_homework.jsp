<%@ page language="java" import="dao.PythonDao,entity.Python" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>单文件下载</title>
</head>
<%
	String id=request.getParameter("h_id");
	PythonDao pdao=new PythonDao();
	Python p=pdao.queryzjById(id);
	String path=request.getServletContext().getRealPath("/")+"fileupload\\";
	String path1=p.getHomework().toString();
	String real=path1.replace(path,"");
%>
<body>
下载:<a href="python_homework_download.action?filename=<%=real%>"><%=real%></a>
</body>
</html>
