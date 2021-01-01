<%@ page language="java" import="entity.User" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>教师页面</title>
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
		<li><a href="teacher.action?opttype=queryall">我的</a></li>
		<li><font color="white">欢迎您，<%=user.getId()%> ！</font></li>
	</ul>
	<br>
	<ul>
		<li><a href="teacher.action?opttype=resetpwd">修改密码</a></li>
		<li><a href="exit.action">退出登录</a></li>
	</ul>
	<table width="60%" border="1" align="center">
		<h4 align="center">授课信息</h4>
		<tr><td>课程号</td><td>课程名</td><td>上课班级</td><td>查看学生名单</td><td>课程详情</td></tr>
		<c:forEach var="c1" items="${clist1}">
		<tr>
			<td>${c1.cid}</td><td>${c1.cname}</td><td>${c1.classid}</td>
			<td>
			<a href="teacher.action?opttype=querystudentbyclassid&classid=${c1.classid}">${c1.classid}</a>
			</td>
			<td>
			<a href="${c1.cname}_teacher.action?opttype=queryall">${c1.cname}</a>
			</td>
		</tr>
		</c:forEach>
	</table>
	
	<table width="60%" border="1" align="center">
		<h4 align="center">学生信息</h4>
		<tr><td>学号</td><td>姓名</td><td>性别</td></tr>
		<c:forEach var="c2" items="${clist2}">
		<tr>
			<td>${c2.sid}</td><td>${c2.sname}</td><td>${c2.ssex}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>