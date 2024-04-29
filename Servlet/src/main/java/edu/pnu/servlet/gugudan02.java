package edu.pnu.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/gugudan02")
public class gugudan02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException {
		System.out.println("gugudan02");
		res.setContentType("text/html; charset=utf-8");
		PrintWriter out = res.getWriter();
		String dir=req.getParameter("dir");
		String d="ver";
		if(dir!=null) {
			d=dir;
		}
		out.println(showGugudan(d));
		out.close();
	}
	public static String showGugudan(String dir) {
		StringBuffer sb = new StringBuffer();
		try {
			if(dir.equals("hor")) {
				sb.append("<div style='display:flex'>");
			}	
			for(int i=2; i<=9; i++) {
				sb.append("<div>");
				sb.append("<h5>"+"["+i+"단"+"]"+"</h5>");
				sb.append("<ul>");
				for(int j=1; j<=9; j++) {
					sb.append("<li>"+i+"*"+j+"="+j*i+"</li>");
				}
				sb.append("</ul>");
				sb.append("</div>");
			}
			if(dir.equals("hor")) {
				sb.append("</div>");
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
}
