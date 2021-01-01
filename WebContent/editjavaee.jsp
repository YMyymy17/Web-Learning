<%@ page language="java"  pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
	   <title>编辑JavaEE章节</title>
	</head>
	<body>
	     <form action="JavaEE_teacher.action" method="post">
	        id:<input type=text name="id_e1" value="${j.id}" readonly><br>
	        name:<input type=text name="name_e1" value="${j.name}"><br>
	        <input type=hidden name="opttype" value="updatezj">
	        <input type=submit value="Update">
	     </form>
	</body>
</html>