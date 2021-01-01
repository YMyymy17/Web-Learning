<%@ page language="java" import="entity.User" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>管理员页面</title>
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
		<li><a href="admin.action?opttype=queryall">我的</a></li>
		<li><font color="white">欢迎您，<%=user.getId()%> ！</font></li>
	</ul>
	<br>
	<ul>
		<li><a onclick="return show1()">课程管理</a><a onclick="return hidden1()">隐藏</a></li>
		<li><a onclick="return show2()">学生管理</a><a onclick="return hidden2()">隐藏</a></li>
		<li><a onclick="return show3()">教师管理</a><a onclick="return hidden3()">隐藏</a></li>
		<li><a href="admin.action?opttype=resetpwd">修改密码</a></li>
		<li><a href="exit.action">退出登录</a></li>
	</ul>
	
	<script>
		function show1(){
		 var myTable= document.getElementById("coursetable"); myTable.style.display="block";
		}
		function hidden1(){
			var myTable= document.getElementById("coursetable"); myTable.style.display="none";
		}
		function show2(){
			 var myTable= document.getElementById("studenttable"); myTable.style.display="block";
			}
		function hidden2(){
			var myTable= document.getElementById("studenttable"); myTable.style.display="none";
		}
		function show3(){
			 var myTable= document.getElementById("teachertable"); myTable.style.display="block";
			}
		function hidden3(){
			var myTable= document.getElementById("teachertable"); myTable.style.display="none";
		}
	</script>
	
	<table width="60%" id="coursetable" border="1" align="center" style="display:none">
		<th><h4>课程信息</h4></th>
		<tr><td>课程号</td><td>课程名</td><td>视频审核</td><td>上课班级</td><td>授课教师</td><td>Operate</td></tr>
		<c:forEach var="c1" items="${clist1}">
		<tr>
			<td>${c1.cid}</td><td>${c1.cname}</td>
			<td><a href="${c1.cname}_admin.jsp">${c1.cname}</a></td>
			<td>${c1.classid}</td><td>${c1.tid}</td>
			<td><a href="admin.action?opttype=deletecourse&cid_d=${c1.cid}">Delete</a>
				<a href="admin.action?opttype=editcourse&cid_e=${c1.cid}">Edit</a>
			</td>
		</tr>
		</c:forEach>
		<tr><td align="center"><input type="button" value="增加课程" onclick="location='addcourse.html'"></td></tr>
	</table>
	
	
	<table width="60%" id="studenttable" border="1" align="center" style="display:none">
		<th><h4>学生信息</h4></th>
		<tr><td>学号</td><td>姓名</td><td>性别</td><td>班级</td><td>Operate</td></tr>
		<c:forEach var="c2" items="${clist2}">
		<tr>
			<td>${c2.sid}</td><td>${c2.sname}</td><td>${c2.ssex}</td><td>${c2.classid}</td>
			<td><a href="admin.action?opttype=deletestudent&sid_d=${c2.sid}">Delete</a>
				<a href="admin.action?opttype=editstudent&sid_e=${c2.sid}">Edit</a>
			</td>
		</tr>
		</c:forEach>
		<tr><td align="center"><input type="button" value="增加学生" onclick="location='addstudent.html'"></td></tr>
	</table>
		
	
	<table width="60%" id="teachertable" border="1" align="center" style="display:none">
		<th><h4>教师信息</h4></th>
		<tr><td>工号</td><td>姓名</td><td>性别</td><td>授课班级</td><td>Operate</td></tr>
		<c:forEach var="c3" items="${clist3}">
		<tr>
			<td>${c3.tid}</td><td>${c3.tname}</td><td>${c3.tsex}</td><td>${c3.classid}</td>
			<td><a href="admin.action?opttype=deleteteacher&tid_d=${c3.tid}">Delete</a>
				<a href="admin.action?opttype=editteacher&tid_e=${c3.tid}">Edit</a>
			</td>
		</tr>
		</c:forEach>
		<tr><td align="center"><input type="button" value="增加教师" onclick="location='addteacher.html'"></td></tr>
	</table>
</body>
</html>