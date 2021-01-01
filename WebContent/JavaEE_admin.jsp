<%@ page language="java"  import="java.util.List,dao.JavaeeDao,entity.JavaEE" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Java EE视频审核</title>
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
	<%
		JavaeeDao jdao=new JavaeeDao();
		List<JavaEE> clist=jdao.allzj();
		request.setAttribute("clist", clist);
	%>
	<h3 align="center">课程详情</h3>
	<table width="60%" border="1" align="center">
		<tr><td>章节号</td><td>章节名</td><td>视频</td><td>删除视频</td></tr>
		<c:forEach var="c" items="${clist}">
		<tr>
			<td>${c.id}</td><td>${c.name}</td>
			<td><a href="Video.jsp?zj_id=${c.id}">${c.video}</a></td>
			<td><a href="JavaEE_teacher.action?opttype=admindeletevideo&vid_d1=${c.id}">删除视频</a></td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>