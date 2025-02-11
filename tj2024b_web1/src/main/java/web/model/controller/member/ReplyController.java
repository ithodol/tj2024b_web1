package web.model.controller.member;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import web.model.dao.BoardDao;

@WebServlet("/board/reply")
public class ReplyController extends HttpServlet{

	// [1] 댓글 쓰기
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("board reply post test");
		
		ObjectMapper mapper = new ObjectMapper();
		// DTO 대신 HashMap 컬렉션 사용한 데이터 관리
		HashMap<String, String> map = mapper.readValue(req.getReader(), HashMap.class);
		//  ** 댓글 쓰기는 회원제 / 현재 로그인된 정보 찾기
			// 1. 세션에 저장딘 로그인 회원번호 조회
		HttpSession session = req.getSession();
		Object object = session.getAttribute("loginMno");
		boolean result = false;
		// 로그인과 비로그인을 구분하기 위해 if 사용
		if(object == null) { // 비로그인 상태
		}else { // 로그인 상태
			// 2. 로그인된 회원번호를 정수로 타입변환
			int loginMno = (Integer)object;
			// 3. 데이터에 담기
			map.put("mno", loginMno + ""); // "" => 문자 타입으로 변환 
			result= BoardDao.getInstance().replyWrite(map);
		}
		
		
		resp.setContentType("application/json");
		resp.getWriter().print(result);
		
		
	}
	// [2] 특정 게시물의 댓글 조회
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("board reply get test");
		// 쿼리스트링의 bno 값 반환
		int bno = Integer.parseInt(req.getParameter("bno"));
		// DTO 대신 List <Map< >> 사용 유연성이 좋음
		List<Map<String, String>> result = BoardDao.getInstance().replyFindAll(bno);
		ObjectMapper mapper = new ObjectMapper();
		String jsonResult = mapper.writeValueAsString(result);
		resp.setContentType("application/json");
		resp.getWriter().print(jsonResult);
	}
}



























