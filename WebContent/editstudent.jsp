<%@ page language="java"  pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
	   <title>编辑学生</title>
	</head>
	<body>
	     <form action="admin.action" method="post">
	        sid:<input type=text name="sid_e1" value="${s.sid}" readonly><br>
	        sname:<input type=text name="sname_e1" value="${s.sname}"><br>
	        ssex:<input type=text name="ssex_e1" value="${s.ssex}"><br>
	        Classid:<input type=text name="sclassid_e1" value="${s.classid}"><br>
	        <input type=hidden name="opttype" value="updatestudent">
	        <input type=submit value="Update">
	     </form>
	</body>
</html>