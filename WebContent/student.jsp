<%@ page language="java" import="entity.User" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>学生页面</title>
<link rel="stylesheet" type="text/css" href="css/Home.css">
<link rel="stylesheet" type="text/css" href="css/table.css">
</head>
<%
	User user=(User)session.getAttribute("user");
%>
<body>
	<ul>
		<li><font color="skyblue" size="4">选择成就梦想，努力造就未来！</font></li>
		<li><a href="Home.jsp">首页</a></li>
		<li><a href="Course.action?opttype=queryall">课程</a></li>
		<li><a href="login.html">登录</a></li>
		<li><a href="student.action?opttype=querycourse">我的</a></li>
		<li><font color="white">欢迎您，<%=user.getId()%> ！</font></li>
	</ul>
	<br>
	<ul>
		<li><a href="student.action?opttype=resetpwd">修改密码</a></li>
		<li><a href="exit.action">退出登录</a></li>
	</ul>
	
	<table width="60%" border="1" align="center">
		<h4 align="center">课程信息</h4>
		<tr><td>课程号</td><td>课程名</td><td>课程详情</td></tr>
		<c:forEach var="c1" items="${clist1}">
		<tr>
			<td>${c1.cid}</td><td>${c1.cname}</td>
			<td>
			<a href="${c1.cname}_student.action?opttype=queryall">点击查看详情</a>
			</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>