<%@ page language="java"  pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
	   <title>修改管理员密码</title>
	</head>
	<body>
	     <form action="admin.action" method="post">
	       	 管理员ID:<input type=text name="aid_p1" value="${a_p.aid}" readonly><br>
	       	新密码:<input type=password name="acheck_key_new"><br>
	        <input type=hidden name="opttype" value="updatepwd">
	        <input type=submit value="Update">
	     </form>
	</body>
</html>