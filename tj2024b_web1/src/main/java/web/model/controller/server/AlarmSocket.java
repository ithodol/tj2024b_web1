package web.model.controller.server;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutionException;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

@ServerEndpoint("/alarmsocket")
public class AlarmSocket {
	
	private static List<Session> connList = new Vector<Session>();
	// 접속한 클라이언트 소켓 정보(session)들을 리스트에 저장하기 위함
	
	// 클라이언트가 서버에 성공적으로 접속했을 때 (자동)실행
	@OnOpen 
	public void onOpen(Session session) {
		System.out.println("접속 성공");
		connList.add(session); // 세션을 리스트에 저장
	}
	
	// 클라이언트가 보낸 메세지를 서버가 정삭적으로 받았을 때 (자동)실행
	@OnMessage
	public void onMessage(Session session, String message) {
		// 현재 접속된 모든 클라이언트 소켓드레게 받은 메세지를 보낸다
		for(int index = 0; index <= connList.size()-1; index++) {
			Session client = connList.get(index);
			try {
				client.getBasicRemote().sendText(message);
			}catch(Exception e) {System.out.println(e);}
		} // for end
	} // onMessage end
	
	
	
	
	// 클라이언트와 서버의 연결이 닫혔을 때 (자동)실행
	@OnClose 
	public void onClose(Session session) {
		connList.remove(session); // 세션을 리스트에서 삭제
	}
}

























