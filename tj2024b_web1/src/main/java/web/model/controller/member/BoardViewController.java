package web.model.controller.member;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import web.model.dao.BoardDao;
import web.model.dto.BoardDto;


@WebServlet("/board/view")
public class BoardViewController extends HttpServlet {
	// 게시물 개별 조회 
	// get 중복이라서 view 서블릿 생성
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("get ok");
		// (1) 개별 조회할 게시물 번호를 HTTP queryString의 매개변수 값 가져오기
		int bno = Integer.parseInt(req.getParameter("bno"));
		
		// (2) DAO에게 조회할 게시물 번호를 전달하고 결과 응답받기
		BoardDto boardDto = BoardDao.getInstance().findByBno(bno);
		
		// (3) DTO --> JSON 타입변환
		ObjectMapper mapper = new ObjectMapper();
		String jsonResult = mapper.writeValueAsString(boardDto);
		
		// (4) 타입 변환된 JSON 형식의 문자열타입 자료를 HTTP response 응답하기
		resp.setContentType("application/json");
		resp.getWriter().print(jsonResult);
		
	}

}















