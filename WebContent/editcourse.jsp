<%@ page language="java"  pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
	   <title>编辑课程</title>
	</head>
	<body>
	     <form action="admin.action" method="post">
	        cid:<input type=text name="cid_e1" value="${c.cid}" readonly><br>
	        cname:<input type=text name="cname_e1" value="${c.cname}"><br>
	        Classid:<input type=text name="cclassid_e1" value="${c.classid}"><br>
	        tid:<input type=text name="ctid_e1" value ="${c.tid}"><br>
	        <input type=hidden name="opttype" value="updatecourse">
	        <input type=submit value="Update">
	     </form>
	</body>
</html>