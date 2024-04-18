<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구구단3</title>
</head>
<body>
	<h2>구구단 페이지</h2>
	<form action=gugudanMain.jsp method="get">
	<input type="radio" name="sel" value=1>Type1
	<br />
	<input type="radio" name="sel" value=2>Type2
	<br />
	<input type="text" name="col" />단수/열수
	<br />
	<input type="submit" value="선택" />
	
	</form>
	
</body>
</html>