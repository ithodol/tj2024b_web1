package day07;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/day07/example7")
public class Example7 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// [1] 톰캣 안에 있는 객체 호출 및 (첫 HTTP 요청) 생성
		HttpSession httpSession = req.getSession();
		System.out.println(httpSession); // HTTP 요청한 클라이언트 브라우저의 세션 객체 주소
		// 1요청시 : org.apache.catalina.session.StandardSessionFacade@7c6a2012
		// 2요청시 : org.apache.catalina.session.StandardSessionFacade@188383a1
		
		// [2] 세션 색체의 주요 메소드
		System.out.println(httpSession.getAttributeNames());	// 세션 객체내 모든 속성 반환 함수
		// 1요청시 : java.util.Collections$3@6a38fd1d
		// 2요청시 : java.util.Collections$3@6db14c71
		
		System.out.println(httpSession.getCreationTime());	// 세션 객체가 만들어진 시간
		// 1요청시 : 1737705809744
		// 2요청시 : 1737706162409
		
		System.out.println(httpSession.getId());	// 세션 객체의 아이디(식별자)
		// 1요청시 : E7399210B37893B8DEF5796709C7B9A6
		// 2요청시 : 5168D5C16B8FD8615676B8E30DA7257F
		
		System.out.println(httpSession.getLastAccessedTime());	// 세션 객체 마지막 사용 시간
		// 1요청시 : 1737705809744
		// 2요청시 : 1737706162411
		
		System.out.println(httpSession.isNew());	// 새로 만들어진 세션인지 여부 반환
		// 1요청시 : true
		// 2요청시 : false
		
		// [3] 세션 객체의 속성명과 속성값
		httpSession.setAttribute("세션속성1", "유재석");
		
		// [4] 세션 객체의 지정한 속성명의 값 호출
		Object object = httpSession.getAttribute("세션속성1");
		System.out.println((String)object);
		
		// [5] 세션 객체의 지정한 속성 제거
		httpSession.removeAttribute("세션속성1");
		
		
		
	} // f end
} // c end
