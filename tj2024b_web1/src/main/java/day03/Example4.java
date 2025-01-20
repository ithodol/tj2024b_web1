package day03;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day03/example4")
public class Example4 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[HTTP *get* 방식으로 요청이 왔습니다.]");
		
		boolean result = true; // 1. 응답할 자료 준비
		resp.getWriter().print(result); // 2. .getWrieter().print(보낼자료);
		System.out.println("[HTTP로 자료를 응답했습니다.]");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[HTTP *post* 방식으로 요청이 왔습니다.]");
		String result = "java";
		resp.getWriter().print(result);
		System.out.println("[HTTP로 자료를 응답했습니다.]");
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[HTTP *put* 방식으로 요청이 왔습니다.]");
		int result = 30;
		resp.getWriter().print(result);
		System.out.println("[HTTP로 자료를 응답했습니다.]");
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[HTTP *delete* 방식으로 요청이 왔습니다.]");
		DataDto result = new DataDto("전은서", 50);
		resp.getWriter().print(result);		
		System.out.println("[HTTP로 자료를 응답했습니다.]");
	}
	
	
}
