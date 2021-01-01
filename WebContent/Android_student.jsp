<%@ page language="java" import="entity.User" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Android</title>
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
		<li><a href="me.jsp">我的</a></li>
	</ul>
	<h3 align="center">课程详情</h3>
	<table width="60%" border="1" align="center">
		<tr><td>章节号</td><td>章节名</td><td>作业</td><td>作业操作</td><td>视频</td></tr>
		<c:forEach var="c" items="${clist}">
		<tr>
			<td>${c.id}</td><td>${c.name}</td>
			<td><a href="Android_student_homework.jsp?h_id=${c.id}">${c.homework}</a></td>
			<td>
				<a href="Android_student.action?opttype=uploadhomework&sid=<%=user.getId()%>&zjid=${c.id}&zjname=${c.name}">上传作业</a>
				<a href="Android_student.action?opttype=deletehomework&sid=<%=user.getId()%>&zjid=${c.id}">删除作业</a>
			</td>
			<td><a href="Video.jsp?zj_id=${c.id}">${c.video}</a></td>
		</tr>
		</c:forEach>
	</table>
	<br>
	<h3 align="center">作业详情</h3>
	<table width="60%" border="1" align="center">
		<tr><td>学号</td><td>章节号</td><td>作业</td><td>评分</td></tr>
		<c:forEach var="c1" items="${clist1}">
			<tr>
				<td>${c1.sid}</td><td>${c1.zjid}</td><td>${c1.homework}</td><td>${c1.score}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>