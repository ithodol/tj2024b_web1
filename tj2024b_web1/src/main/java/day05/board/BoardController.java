package day05.board;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day05/board")
public class BoardController extends HttpServlet {
	// 게시물 등록
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 가져오기
		ObjectMapper mapper = new ObjectMapper(); // ???
		BoardDto boardDto = mapper.readValue(req.getReader(), BoardDto.class);
		// DAO 처리
		boolean result = BoardDao.getInstance().write(boardDto);
		
		// body response 보내기
		resp.setContentType("application/json");
		resp.getWriter().print(result);
	}
	
	

	// 게시물 전체 조회
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 매개변수 x
		// DAO 처리
		ArrayList<BoardDto> result = BoardDao.getInstance().printAll();
		// body response 보내기
		ObjectMapper mapper = new ObjectMapper();
		String jsonResult = mapper.writeValueAsString(result); // DTO -> JSON 타입변환
		
		resp.setContentType("application/json");
		resp.getWriter().print(jsonResult);
	}
	
	// 게시물 상세(개별) 조회 -> BoardController2
	
	
	
	// 게시물 수정
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// HTTP 요청의 body 본문을 DTO로 타입 변환하기
		ObjectMapper mapper = new ObjectMapper();
		BoardDto boardDto = mapper.readValue(req.getReader(), BoardDto.class);
		
		boolean result = BoardDao.getInstance().update(boardDto);
		
		resp.setContentType("application/json");
		resp.getWriter().print(result);
		
		
		// DAO 처리
		// 결과를 HTTP 응답하기
	}
	
	
	
	
	// 게시물 삭제
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// HTTP 요청의 쿼리스트링 매개변수 가져오기
		// req.getParameter("bno") = 쿼리스트링의 bno라는 매개변수 값 반환
		// Integer.parseInt(문자열) = 문자열타입 -> 정수타입
		int bno = Integer.parseInt( req.getParameter("bno"));
		
		// DAO 처리
		boolean result = BoardDao.getInstance().delete(bno);
		
		// 결과를 HTTP 응답
		resp.setContentType("application/json");
		resp.getWriter().print(result);
	}
}





















