<%@ page language="java"  pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
	   <title>修改学生密码</title>
	</head>
	<body>
	     <form action="student.action" method="post">
	     学生ID:<input type=text name="sid_p1" value="${s_p.sid}" readonly><br>
	     学生姓名：<input type=text name="sname_p1" value="${s_p.sname}" readonly><br>
	     新密码:<input type=password name="scheck_key_new"><br>
	        <input type=hidden name="opttype" value="updatepwd">
	        <input type=submit value="Update">
	     </form>
	</body>
</html>