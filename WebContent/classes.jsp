<%@ page language="java" import="entity.User" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>课程</title>
<link rel="stylesheet" type="text/css" href="css/classes.css">
<link rel="stylesheet" type="text/css" href="css/table.css">
</head>
<body>
	<ul>
		<li><font color="skyblue" size="4">选择成就梦想，努力造就未来！</font></li>
		<li><a href="Home.jsp">首页</a></li>
		<li><a href="Course.action?opttype=queryall">课程</a></li>
		<li><a href="login.html">登录</a></li>
		<li><a href="me.jsp">我的</a></li>
	</ul>
	<h2 align="center">开设课程介绍</h2>
	<table width="60%" border="1" align="center">
		<tr><td>课程号</td><td>课程名</td><td>上课班级</td><td>授课老师</td></tr>
		<c:forEach var="c" items="${clist}">
		<tr>
			<td>${c.cid}</td><td>${c.cname}</td><td>${c.classid}</td><td>${c.tid}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>