console.log('chatting.js open');

// [1] WebSoket 클래스 이용하여 클라이언트 소켓 구현 / WebSocket과 fetch는 비동기 통신
// new WebSocket('서버소켓주소');				/ 비동기 통신은 요청하고 응답올 때까지 JS 코드 흐름을 대기하지 않는 구조
let clientSocket = new WebSocket('ws://localhost:8080/tj2024b_web1/chatsocket');

// [2] 접속/연결(상태유지)된 서버 소켓에게 메세지 보내기
// clientSocket.send('서버 소켓 안녕')
	// 오류 발생, 접속 요청 후 응답 성공 전에 실행했기 때문
	

// (전송) 버튼을 클릭했을 때 실행할 함수
const onMsgSend = () => {
	// clientSocket.send('서버 소켓 안녕')
	
	// 1. 입력받은 값 가져오기
	const msginput = document.querySelector('.msginput')
	const msg = msginput.value;
	// 2. 소켓에게 메세지 보내기
	clientSocket.send(msg);
	
	
	
} // f end

// [3] 서버 소켓이 클라이언트로부터 메세지를 보냈을 때
clientSocket.onmessage = (msgEvent) => {
	console.log('서버소켓으로부터 메세지가 도착했다')
	console.log(msgEvent);
	console.log(msgEvent.data);
	
	// (1) 받은 메세지를 html에 출력하기
	// 1. 어디에
	const msgbox = document.querySelector('.msgbox')
	// 2. 무엇을
	let html = `<div> ${msgEvent.data} </div>`;
	// 3. 출력 += 사용한 이유 :  앞전 메세지와 연결하기 위함
	msgbox.innerHTML += html;
}

































