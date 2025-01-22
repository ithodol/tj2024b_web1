package day05.board;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day05/board/view")
public class BoardController2 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 쿼리스트링의 매개변수 가져오기
		int bno = Integer.parseInt( req.getParameter("bno"));
		// DAO 처리 요청 후 응답 받기
		BoardDto boardDto = BoardDao.getInstance().printById(bno);
		
		// HTTP 응답
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(boardDto);
		resp.setContentType("application/json");
		resp.getWriter().print(jsonString);
	} // f end
}
