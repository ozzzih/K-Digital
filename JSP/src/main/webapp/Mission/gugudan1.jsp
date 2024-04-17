<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
request.setCharacterEncoding("UTF-8");
int dan=0; 
try{
dan = Integer.parseInt(request.getParameter("dan"));
}
catch(Exception e){
}

for(int i = 1; i<10; i++){
	
	out.println(dan+" * "+i+" = "+dan*i);
	out.print("<br />");
}

%>
</body>
</html>