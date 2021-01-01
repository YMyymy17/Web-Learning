<%@ page language="java"  pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
	   <title>编辑Python章节</title>
	</head>
	<body>
	     <form action="Python_teacher.action" method="post">
	        id:<input type=text name="id_e" value="${p.id}" readonly><br>
	        name:<input type=text name="name_e" value="${p.name}"><br>
	        <input type=hidden name="opttype" value="updatezj">
	        <input type=submit value="Update">
	     </form>
	</body>
</html>