/*
 서블릿과제4 (식당) 대기번호 발행 프로그램3
   * 강사 git주소의 day03/task3 참고합니다.
   조건1 : day03패키지의 task4 패키지에서 클래스 파일은 WaitingController, WaitingDao , WaitingDto 3개의 클래스만 생성 합니다.
   조건2 : 'WaitingController' 생성하여 HttpServlet 으로 부터 상속 받으시오.
   조건3 : 'WaitingController' 매핑 주소는 '/day03/waiting2' 으로 정의하시오.
   조건4 : [대기번호등록]'WaitingController' 클래스의 doPost() 재정의 하기.
   조건5 : [대기전체조회]'WaitingController' 클래스의 doGet() 재정의 하기.
   조건6 : [대기개별수정]'WaitingController' 클래스의 doUpdate() 재정의 하기.
   조건7 : [대기개별삭제]'WaitingController' 클래스의 doDelete() 재정의 하기.
      - 요청데이터는 post 와 put 매핑은 body 로 , get 와 delete 매핑은 queryString 사용합니다. 
      - 응답은 모두 applicartion/json 타입으로 응답 합니다.
      
   조건6 : 데이터베이스 생성과 테이블 생성은 임의로 하시오.
   
   [제출] 카카오톡방에 URL 과 body 를 제출한다.
      예] 
      http://192.168.40.25:8080/tj2024b_web1/day03/visit2
      { "content" : "안녕! 방문록 남기고 갑니다." , "age" : "40"  }

*/

package day03.task4;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day03/waiting2")
public class WaitingController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. HTTP로부터 요청(request)받은 HTTP HEADER BODY(본문)를 DTO 파싱(변환) 가져오기
		ObjectMapper mapper = new ObjectMapper();
		WaitingDto waitingDto = mapper.readValue(req.getReader(), WaitingDto.class);
		// 2. DAO처리
		boolean result = WaitingDao.getInstance().write(waitingDto);
		
		// 3. DAO 결과를 HTTP HEADER BODY(본문)으로 응답(response) 보내기
		resp.setContentType("application/json");
		resp.getWriter().print(result);
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. 매개변수 x
		// 2. DAO 처리
		ArrayList<WaitingDto> result = WaitingDao.getInstance().printAll();
		// 3. DAO 결과를 HTTP HEADER BODY(본문)으로 응답(response) 보내기
			// 타입변환 필요함 DTO  --> json
		ObjectMapper mapper = new ObjectMapper();
		String jsonResult = mapper.writeValueAsString(result);
		
		resp.setContentType("application/json");
		resp.getWriter().print(jsonResult); 
		
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. HTTP로부터 요청(request)받은 HTTP HEADER BODY(본문)를 DTO 파싱(변환) 가져오기
		ObjectMapper mapper = new ObjectMapper();
		WaitingDto waitingDto = mapper.readValue(req.getReader(), WaitingDto.class);
		
		// 2. DAO 처리
		boolean result = WaitingDao.getInstance().update(waitingDto);
		// 3. DAO 결과를 HTTP HEADER BODY(본문)으로 응답(response) 보내기
		resp.setContentType("application/json");
		resp.getWriter().print(result);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. HTTP로부터 요청(request)받은 HTTP queryString 의 매개변수 가져오기
		int num = Integer.parseInt(req.getParameter("num"));
		
		// 2. DAO 처리
		boolean result = WaitingDao.getInstance().delete(num);
		
		// 3. DAO 결과를 HTTP HEADER BODY(본문)으로 응답(response) 보내기
		resp.setContentType("application/json");
		resp.getWriter().print(result);
	}
}



















