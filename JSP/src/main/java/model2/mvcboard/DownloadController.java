package model2.mvcboard;

import java.io.IOException;

import fileupload.FileUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/mvcboard/download.do")
public class DownloadController {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException{
		
		String ofile=req.getParameter("ofile");
		String sfile=req.getParameter("sfile");
		String idx=req.getParameter("idx");
		
		FileUtil.download(req, resp, "C:/Temp/Uploads", sfile, ofile);
		
		MVCBoardDAO dao = new MVCBoardDAO();
		dao.downCountPlus(idx);
		dao.close();
	}
}
