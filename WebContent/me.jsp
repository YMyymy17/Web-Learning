<%@ page language="java" import="entity.User" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>我的页面</title>
<link rel="stylesheet" type="text/css" href="css/Home.css">
</head>
<body>
	<%
		User user=(User)session.getAttribute("user");
		if(user==null){		//验证是否登录
			out.print("<script>alert('您还没有登录，请登录...'); window.location='login.html' </script>");
			out.flush();
			out.close();
		}
		else if(user.role.equals("student")){
			session.setAttribute("sid", user.id);
			response.sendRedirect("student.action?opttype=querycourse");
		}
		else if(user.role.equals("teacher")){
			session.setAttribute("tid", user.id);
			response.sendRedirect("teacher.action?opttype=queryall");
		}
		else if(user.role.equals("admin")){
			response.sendRedirect("admin.action?opttype=queryall");
		}
	%>
	<ul>
		<li><font color="skyblue" size="4">选择成就梦想，努力造就未来！</font></li>
		<li><a href="Home.jsp">首页</a></li>
		<li><a href="Course.action?opttype=queryall">课程</a></li>
		<li><a href="login.html">登录</a></li>
	</ul>
	
</body>
</html>