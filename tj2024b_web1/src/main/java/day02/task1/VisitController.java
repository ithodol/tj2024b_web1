package day02.task1;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 컨트롤러 : view, dao 사이의 가교 역할, 서블릿을 이용한 매핑/연결 역할
@WebServlet("/day02/visit") // [2] 매핑 주소 정의
public class VisitController extends HttpServlet{ // [1] HttpServlet 상속 받기
	
	// [3] HTTP METHOD 재정의
	
	// 1. 방문록 등록(쿼리스트링)	: C doPost
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. URL 상의 쿼리스트링 매개변수를 가져온다 / 내용, 나이
		String content = req.getParameter("content");
		//int age = req.getParameter("age"); // *오류발생 : .getParameter() 함수는 무조건 String 반환하기 때문
		int age = Integer.parseInt(req.getParameter("age"));
			// Integer.parseInt("문자열타입자료") : 문자열타입 --> int 타입 (형/타입 변환)
		
		// 2. 매개변수를 DAO에게 전달하고 결과를 받는다
		boolean result = VisitDao.getInstance().write(content, age);
		System.out.println(result);
	}
	
	
	// 2. 방문록 조회(x)		: R doGet
	// 3. 방문록 수정(x)		: U doPut
	
	
	// 4. 방문록 삭제(쿼리스트링)	: D doDelete
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. URL 상의 쿼리스트링 매개변수를 가져온다 / 삭제할번호PK
		//int num = req.getParameter("num"); // *오류발생
		int num = Integer.parseInt(req.getParameter("num"));
		
		// 2. 매개변수를 DAO에게 전달하고 결과를 받는다
		boolean result = VisitDao.getInstance().delete(num);
		System.out.println(result);
	}
}














