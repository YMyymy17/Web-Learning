 <%@page contentType="text/html;charset=gb2312"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>作业上传</title>
<link rel="stylesheet" type="text/css" href="css/table.css">
</head>
<body>
<h1 align="center">上传作业</h1>
<FORM METHOD="POST" ACTION="python_homework.action" ENCTYPE="multipart/form-data">
   <input type="hidden" name="TEST" value="good">
  <table width="75%" border="1" align="center">
  <tr>
  	<th>章节号</th><th>章节名</th>
  </tr>
  <tr>
  	<td>${p_homework.id}</td><td>${p_homework.name}</td>
  </tr>
  <tr>
  	<td><div align="center">作业
          <input type="FILE" name="FILE1" size="30">
        </div></td>
    </tr>
    <tr> 
      <td><div align="center">
          <input type="submit" name="Submit" value="上传">
        </div></td>
    </tr>
  </table>
</FORM>
</body>
</html>