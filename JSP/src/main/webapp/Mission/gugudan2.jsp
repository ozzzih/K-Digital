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
int l=0; 
try{
l = Integer.parseInt(request.getParameter("col"));
}
catch(Exception e){
}

for(int k=0; k<l; k++) {
	for(int j=1; j<10; j++) {
		for(int i=2; i<l+2; i++) {
			if((k*l+i)>9)
				break;
			else
				out.print((k*l+i)+"*"+j+"="+(i*j)+"     ");
		}
		out.print("<br />");
	}
	out.print("<br />");
}

%>
</body>
</html>