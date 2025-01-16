package day02;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 1. extends HttpServlet
// 2. @WebServlet("주소정의")
// 3. HTTP method(get/post/put/delete)의 메소드 재정의

@WebServlet("/day02/example2")
public class Example2 extends HttpServlet{
	// 1. get
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("1. 사용자가 서버로부터 get 메소드로 요청했습니다.");
		
		// 쿼리스트링의 매개변수 가져오기
			// http://localhost:8080/tj2024b_web1/day02/example2?name=전은서
			// .getParameter("URL경로상의매개변수명");	// 매개변수명의 값(String 타입) 반환 함수, 없으면 null
		System.out.print("1. URL ? 뒤에 있는 'name'이라는 매개변수명을 가진 변수의 값 가져오기 : ");
		System.out.println(req.getParameter("name"));
			// http://localhost:8080/tj2024b_web1/day02/example2?name=전은서&age=100
		System.out.print("1-1. URL ? 뒤에 'age' 라는 매개변수명을 가진 변수의 값 가져오기 : ");
		System.out.println(req.getParameter("age"));
	}
	
	// 2. post
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("2. 사용자가 서버로부터 post 메소드로 요청했습니다.");
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		System.out.printf("name : %s , age : %s \n", name, age);
	}
	
	
	// 3. put
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("3. 사용자가 서버로부터 put 메소드로 요청했습니다.");
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		System.out.printf("name : %s , age : %s \n", name, age);
	}
	
	// 4. delete
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("4. 사용자가 서버로부터 delete 메소드로 요청했습니다.");
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		System.out.printf("name : %s , age : %s \n", name, age);
	}
}


























