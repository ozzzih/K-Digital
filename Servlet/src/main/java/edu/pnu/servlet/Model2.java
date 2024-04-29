package edu.pnu.servlet;
import model1.board.*;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Model2")
public class Model2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException {
		System.out.println("Model2");
		res.setContentType("text/html; charset=utf-8");
		PrintWriter out = res.getWriter();
		req.getRequestDispatcher("//").forward(req, resp);
		out.close();
	}
	
}
