<%@ page language="java"  pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
	   <title>修改学生密码</title>
	</head>
	<body>
	     <form action="teacher.action" method="post">
	     教师ID:<input type=text name="tid_p1" value="${t_p.tid}" readonly><br>
	     教师姓名：<input type=text name="tname_p1" value="${t_p.tname}" readonly><br>
	     新密码:<input type=password name="tcheck_key_new"><br>
	        <input type=hidden name="opttype" value="updatepwd">
	        <input type=submit value="Update">
	     </form>
	</body>
</html>