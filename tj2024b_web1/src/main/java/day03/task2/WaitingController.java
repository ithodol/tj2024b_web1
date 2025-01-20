package day03.task2;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day03/waiting")
public class WaitingController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// BODY(분문)의 JSON을 DTO로 파싱/변환 하기 위한 인스턴스 생성
		ObjectMapper mapper = new ObjectMapper();
		// 변환
		WaitingDto waitingDto = mapper.readValue(req.getReader(), WaitingDto.class);
		System.out.println(waitingDto);
		// DAO 처리
		boolean result = WaitingDao.getInstance().write(waitingDto);
		System.out.println(result);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num = Integer.parseInt(req.getParameter("num"));
		System.out.println("num : " + num);
		boolean result = WaitingDao.getInstance().delete(num);
		System.out.println(result);
	}
}
