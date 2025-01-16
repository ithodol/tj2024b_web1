package day02.task1;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day02/waiting")
public class WaitingController extends HttpServlet{
	// 1. 대기열 등록
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int tel = Integer.parseInt(req.getParameter("tel"));
		int count = Integer.parseInt(req.getParameter("count"));
		
		boolean result = WaitingDao.getInstance().write(tel, count);
		System.out.println(result);
	}
	
	// 2. 대기열 삭제
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num = Integer.parseInt(req.getParameter("num"));
		
		boolean result = WaitingDao.getInstance().delete(num);
		System.out.println(result);
	}
}
