<%@ page language="java"  pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Java EE</title>
<link rel="stylesheet" type="text/css" href="css/Home.css">
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
	<h3 align="center">课程详情</h3>
	<table width="60%" border="1" align="center">
		<tr><td>章节号</td><td>章节名</td><td>章节操作</td><td>作业</td><td>作业操作</td><td>视频</td><td>视频操作</td></tr>
		<c:forEach var="c" items="${clist}">
		<tr>
			<td>${c.id}</td><td>${c.name}</td>
			<td>
				<a href="JavaEE_teacher.action?opttype=deletezj&id_d=${c.id}">Delete</a>
				<a href="JavaEE_teacher.action?opttype=editzj&id_e=${c.id}">Edit</a>
			</td>
			<td>${c.homework}</td>
			<td>
				<a href="JavaEE_teacher.action?opttype=uploadhomework&hid_u=${c.id}">上传作业</a>
				<a href="JavaEE_teacher.action?opttype=deletehomework&hid_d=${c.id}">删除作业</a>
			</td>
			<td><a href="Video.jsp?zj_id=${c.id}">${c.video}</a></td>
			<td>
				<a href="JavaEE_teacher.action?opttype=uploadvideo&vid_u=${c.id}">上传视频</a>
				<a href="JavaEE_teacher.action?opttype=deletevideo&vid_d=${c.id}">删除视频</a>
			</td>
		</tr>
		</c:forEach>
		<tr>
		<td align="center">
			<input type="button" value="增加章节" onclick="location='addjavaee.html'">
		</td>
		</tr>
	</table>
	<br>
	<h3 align="center">学生作业详情</h3>
	<table width="60%" border="1" align="center">
	<tr><td>学号</td><td>章节号</td><td>作业</td><td>评分</td><td>点此评分</td></tr>
	<c:forEach var="c1" items="${clist1}">
	<tr>
		<td>${c1.sid}</td><td>${c1.zjid}</td>
		<td><a href="JavaEE_teacher_downloadhomework.jsp?&sid=${c1.sid}&zjid=${c1.zjid}">${c1.homework}</a></td>
		<td>${c1.score}</td>
		<td><a href="JavaEE_teacher.action?opttype=setscore&sid=${c1.sid}&zjid=${c1.zjid}">click it!</a></td>
	</tr>
	</c:forEach>
	</table>
</body>
</html>