package day02;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 자바의 클래스를 서블릿 클래스로 만들기
// 1. 클래스명 extends HttpServlet
// 2. 클래스선언부 위에 @WebServlet("http주소체계정의")
	// 주소는 임의로 설정하되 프로젝트내 중복 불가능
	// 절대경로 : @WebServlet("http://localhost:8080/tj2024b_web/day02/example1") 
	// 상대경로 : @WebServlet("(프로젝트명 이하생략)/day02/example1")
// 3. 요청받은 방법 정의(함수==기능==메소드==행위) 정의
	// 1.doGet	2.doPost	3.doPut		4.doDelete -> 4종 구현하면 rest(휴식)
	// 2. HttpServlet 클래스에서 이미 http method와 매핑하는 자바 메소드를 상속한다
@WebServlet("/day02/example1")
public class Example1 extends HttpServlet {
	// 이클립스는 코드가 변경/수정 자동으로 서버에 빌드/배포 : 메뉴 -> 상단[project] -> build auto
		// 1. 서블릿 안에 코드 변경할 경우는 자동으로 리로드 됨 ctrl+f11 하지 않아도 됨
		// 2. [서버 재실행]새로운 서블릿은 새로운 매핑HTTP 주소가 서버에 등록(web.xml대신)해야 하므로 서버를 수동 restart 한다. ctrl+alt+r
			
	// Restful 구축 : 1.post 2.get 3.put 4.delete
	
	// 1. post
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("1. HTTP 프로토콜 통신이 post 방법으로 요청이 왔습니다. 코드 수정");
	}
	
	// 2. get
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("2. HTTP 프로토콜 통신이 get 방법으로 요청이 왔습니다.");
	}
	
	// 3. put
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("3. HTTP 프로토콜 통신이 put 방법으로 요청이 왔습니다.");
	}
	
	// 3. delete
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("4. HTTP 프로토콜 통신이 delete 방법으로 요청이 왔습니다.");
	}
}

