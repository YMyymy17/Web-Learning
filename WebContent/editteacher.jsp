<%@ page language="java"  pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
	   <title>编辑教师</title>
	</head>
	<body>
	     <form action="admin.action" method="post">
	        tid:<input type=text name="tid_e1" value="${t.tid}" readonly><br>
	        tname:<input type=text name="tname_e1" value="${t.tname}"><br>
	        tsex:<input type=text name="tsex_e1" value="${t.tsex}"><br>
	        Classid:<input type=text name="tclassid_e1" value="${t.classid}"><br>
	        <input type=hidden name="opttype" value="updateteacher">
	        <input type=submit value="Update">
	     </form>
	</body>
</html>