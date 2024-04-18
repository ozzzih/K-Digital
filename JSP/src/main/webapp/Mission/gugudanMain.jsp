<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
int type = Integer.parseInt(request.getParameter("sel"));

int dan = Integer.parseInt(request.getParameter("col"));

if (type==1){
	request.getRequestDispatcher("gugudan1.jsp?dan="+dan)
	.forward(request, response);

}else{
	request.getRequestDispatcher("gugudan2.jsp?col="+dan)
	.forward(request, response);
}
%>
