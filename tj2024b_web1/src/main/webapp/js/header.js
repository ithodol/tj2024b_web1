console.log('header.js open');

// [1] 로그인 정보 요청 함수
const getLoginInfo = () => {
	// 1.
	const option = {
		method : 'GET' // 생략 가능
	}
	
	let loginmenu = document.querySelector('.loginmenu') // (1) 로그인 메뉴를 출력할 구역 가져오기
	let html = ''; // (2) html 변수 선언

	// 2.
	fetch('/tj2024b_web1/member/info', option)
		.then( r => r.json())
		.then(data => {
			console.log(data); // 코드 변경 후 서버가 자동 재실행이 되면 세션 초기화
			if(data == null){
				console.log('비로그인');
				// (3) 각 상태에 따라 로그인 메뉴 구성
				html += `
						<li class="nav-item"> <a class="nav-link" href="/tj2024b_web1/member/login.jsp">로그인</a> </li>
						<li class="nav-item"> <a class="nav-link" href="/tj2024b_web1/member/signup.jsp">회원가입</a> </li>
						 `
			}else{
				console.log('로그인');
				// (3-1) 각 상태에 따라 로그인 메뉴 구성
				html += `
						<li class="nav-item dropdown">
				        	<a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
				            	<img class="header_profile" src="/tj2024b_web1/upload/${ data.mimg }" /> ${ data.mid } 님 
				            </a>
				            <ul class="dropdown-menu">
								<li class="nav-item"> <a class="nav-link" href="#"> ${ data.mpoint} POINT </a> </li>
					            <li class="nav-item"> <a class="nav-link" href="/tj2024b_web1/member/info.jsp">마이페이지</a> </li>
					            <li class="nav-item"> <a class="nav-link" href="#" onclick="onLogOut()">로그아웃</a> </li>
				            </ul>
				        </li> 
						`
			}
			loginmenu.innerHTML = html;
		})
		.catch(e => {console.log(e);})
}
getLoginInfo(); // js가 열렸을 때 최초 1번 실행

// [2] 로그아웃 요청 함수
const onLogOut = () => {
	const option = {
		method : 'DELETE'
	}
	fetch('/tj2024b_web1/member/login', option)
		.then(r => r.json())
		.then(data => {
			if(data == true){
				alert('로그아웃 되었습니다');
				location.href="/tj2024b_web1/member/login.jsp"
			}
		})
		.catch(e => {console.log(e);})
}



// [3] 클라이언트 웹소켓의 객체를 생성하고 서버 소켓으로부터 접속 연동 시도
const alarmSocket = new WebSocket('ws://localhost:8080/tj2024b_web1/alarmsocket');


// [4] 클라이언트 웹소켓이 서버 소켓으로부터 메세지를 받았을 때 
alarmSocket.onmessage = (msgEvent) => {
	console.log(msgEvent.data); // 알림 메세지를 console.log() 띄우기
	
	// 콘솔이 아닌 부트스트랩을 활용해서 화면에 띄우기
	const alarmbox = document.querySelector('.alarmbox')
	let html = `
				<div class="toast show" role="alert" aria-live="assertive" aria-atomic="true">
				  <div class="toast-header">
				    <strong class="me-auto">${msgEvent.data}</strong>
					<button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"></button>
				  </div>
				</div>
				`
	alarmbox.innerHTML += html;
	
}



















