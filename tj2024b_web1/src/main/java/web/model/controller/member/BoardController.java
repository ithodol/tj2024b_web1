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
import web.model.dto.PageDto;


@WebServlet("/board")
public class BoardController extends HttpServlet {
	
	
	// [1] 게시물 쓰기
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("post ok");
		
		ObjectMapper mapper = new ObjectMapper();
		// JSON 문자열 --> 특정한 자바 객체 타입으로 변환해주는 기능을 제공하는 라이브러리 객체
		
		BoardDto boardDto = mapper.readValue(req.getReader(), BoardDto.class);
		// HTTP의 request body 로부터 JSON 문자열을 읽어와서 BoardDto 타입으로 변환하는 readValue 함수 실행
		
		// 현재 로그인된 회원번호를 세션에서 찾아 boardDto에 담아주기
			// 요청 정보의 세션 객체 호출
		HttpSession session = req.getSession();
			// 세션 객체내 특정한 속성(로그인된 회원번호)의 값 꺼내기 / .getAttribute("속성명");
			// 모든 세션 객체내 속성은 Object 타입이다
		Object object = session.getAttribute("loginMno");
			// 세션 객체내 로그인된 회원번호 속성이 존재하면 
		if(object != null) {
			// Object 타입 --> int/Integer 타입으로 변환하기(강제 타입변환)
			int loginMno = (Integer)object;
			// boardDto에 로그인된 회원번호 담아주기, 게시물 작성자 == 로그인된 회원
			boardDto.setMno(loginMno);
		}

		boolean result = BoardDao.getInstance().write(boardDto);
		// 읽어온 자료를 DAO에게 전달하고 결과를 받는다
		
		// HTTP로부터  response
		resp.setContentType("application/json");
		resp.getWriter().print(result);
	}
	
	
	
	// [2] 게시물 전체조회
		// 02.07 추가 : 카테고리별 전체 조회
			// 2.10 추가 : 페이징 처리
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("get ok");
		// (1) 요청 매개변수 / cno 카테고리 번호 가져오기
		int cno = Integer.parseInt(req.getParameter("cno")); // 카테고리번호
		int page = Integer.parseInt(req.getParameter("page")); // 페이지번호
		
			// *** 페이징처리에 필요한 자료 준비 ***
			// 1. 한 페이지당 출력할 게시물의 갯수 / 매개변수로 받기
				int display = 5; // 한 페이지당 게시물 5개씩 출력
			// 2. 페이지당 조회할 게시물의 시작 번호 (현재페이지-1)*페이지당게시물수
				int startRow = (page-1) * display;
				// 예) 게시물의 10개 존재한다고 가정 : 0번 1번 2번 3번 ... 9번
				// 1페이지의 시작번호 : 0번 / 2페이지 시작번호 : 4번
			// 3. 특정 카테고리 게시물의 전체 게시물 수 구하기
				int totalSize = BoardDao.getInstance().getTotalSize(cno);
			// 4. 전체 페이지 수 구하기
				int totalPage = 0;
				if(totalSize % display == 0) {
					// 전체 게시물 수 나누기 페이지당 게시물 수 했을 때 나머지가 없으면
					totalPage = totalSize / display;
				}else { // 아니면
					totalPage = totalSize / display +1; // 몫 +1
				}
			// 5. 페이지당 버튼 수
				int btnSize = 5;
			// 6. 시작 버튼 번호 구하기
				int startBtn = ((page-1) / btnSize) * btnSize +1;
			// 7. 끝 버튼 번호 구하기
				int endBtn = startBtn + (btnSize -1);
				// 만약에 끝번호가 전체 페이지 수보다 커지면 안됨.
				// 끝번호가 전체 페이지 수보다 커지면 끝번호에 전체 페이지수 대입
				if(endBtn > totalPage) endBtn = totalPage;

		
		// (2) DAO에게 전체 게시물 요청하고 결과 받기 / (추가) 페이징 처리 자료 넘기기
		ArrayList<BoardDto> result = BoardDao.getInstance().findAll(cno, startRow, display);
		
			// 8. PageDto 객체 만들기			
			PageDto pageDto = new PageDto();
			pageDto.setTotalcount(totalSize); // 조회된 전체 게시물 수
			pageDto.setPage(page); // 현재 페이지
			pageDto.setTotalpage(totalPage); // 전체 페이지 수
			pageDto.setStartbtn(startBtn); // 페이징 버튼 시작 번호
			pageDto.setEndbtn(endBtn); // 페이징 버튼 끝 번호
			pageDto.setData(result); // 
		
		// (3) 받은 전체 게시물을 JSON 형색의 문자열로 변환하기
		ObjectMapper mapper = new ObjectMapper();
		String jsonResult = mapper.writeValueAsString(pageDto); // 9. pageDto를 JSON 으로 변환
		// (4) HTTP response
		resp.setContentType("application/json");
		resp.getWriter().print(jsonResult);
	}
	
	
	
	// [3] 게시물 개별 삭제
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("delete ok");
		// (1) HTTP queryString 매개변수를 가져오기
		// URL?bno=1 , req.getParmeter("매개변수명"); : 반환타입이 문자열이라서 타입변환이 필요하다
		int bno = Integer.parseInt(req.getParameter("bno"));
		
		// (2) DAO에게 삭제할 번호를 전달하고 결과 받기
		boolean result = BoardDao.getInstance().delete(bno);
		// (3) 결과를 HTTP의 response 로 응답하기		
		resp.setContentType("application/json");
		resp.getWriter().print(result);
		
	}
	
	
	// [4] 게시물 개별 수정
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("put ok");
		// 게시물 등록과 동일함
		ObjectMapper mapper = new ObjectMapper();
		BoardDto boardDto = mapper.readValue(req.getReader(), BoardDto.class);
		
		boolean result =  BoardDao.getInstance().update(boardDto);
		
		resp.setContentType("application/json");
		resp.getWriter().print(result);
		
	}
	
	
	
	
}















