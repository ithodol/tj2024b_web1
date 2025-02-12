package web.model.controller.server;

import java.util.List;
import java.util.Vector;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

// 서블릿 클래스가 아닌 웹소켓 클래스로 사용할 예정
// @WebServlet = HTTP / @ServerEndpoint = WS
@ServerEndpoint("/chatsocket")
public class ServerSocket {
	
	// [*] 접속된 세션(접속 성공한 클라이언트 소켓 정보) 저장
	// * 세션이란? 네트워크상의 정보를 저장하는 공간, HTTP 세션 / WS 세션 / DB 세션 각 세션 존재
	
	// * static 이란? 프로젝트내 하나의 변수를 만들 때 사용되는 키워드 (전역변수)
	// list 컬렉션으로 여러개의 Session 저장하기
	private static List<Session> 접속명단 = new Vector<Session>();
	
	
	// [1] 클라이언트 소켓이 서버 소켓에 접속했을 때
	@OnOpen
	public void onOpen(Session session) {
		// (import) Session : jakarta.websocket.Session
		System.out.println("클라이언트가 ws 접속 성공");
		System.out.println(session);
		// * onOpen(클라이언트가 정상적으로 서버와 접속 성공했을 때)
		접속명단.add(session); // list 컬렉션에 접속 성공한 session 정보를 저장
		System.out.println(접속명단);
	} // onOpen end
	
	
	
	
	// [2] 클라이언트 소켓이 서버 소켓으로부터 메세지를 보냈을 때
	@OnMessage
	public void onMessage(Session session, String message) {
		System.out.println("클라이언트 소켓으로부터 메세지가 도착했습니다.");
		System.out.println(message);
		
		// 서버가 클라이언트에게 메세지 전송
		//try {
		//	session.getBasicRemote().sendText("클라이언트 소켓 안녕");
		//}catch(Exception e) {System.out.println(e);}
		
		// (1) 받은 메세지를 접속된 모든 세션(클라이언트소켓)들에게 메세지 보내기
		// 1. 받은 메세지 = 매개변수의 message
		// 2. 접속 명단 : private static List<Session> 접속명단 = new Vector<Session>();
		// 3. 반복문을 이용한 접속 명단 순회
		for(int index = 0; index <= 접속명단.size()-1; index++) {
			// 4. 접속된 명단의 index번재 세션(접속정보) 가져오기
			Session clientSocket = 접속명단.get(index);
			// 5. index번재 세션에 메세지 보내기
			try {
				clientSocket.getBasicRemote().sendText(message);
			}catch(Exception e) {System.out.println(e);}
		} // for end

	} // onMessage end
	
	
	
	// [3] 클라이언트 소켓과의 연결이 닫혔을 때 (JS가 새로고침/리로드(객체가 지워짐)됐을 때) 실행됨
	@OnClose
	public void onClose(Session session) {
		// 클라이언트 소켓과 연결이 닫혔을 때 명단에서 제외
		접속명단.remove(session);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
} // class end
