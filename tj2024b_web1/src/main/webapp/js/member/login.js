console.log('login.js open');

// [1] 로그인 요청 함수
const onLogin = () => {
	// HTML input dom 가져오기
	const midinput = document.querySelector('.midinput')
	const mpwdinput = document.querySelector('.mpwdinput')
	// 2. input 입력값 가져오기
	const mid = midinput.value;
	const mpwd = mpwdinput.value;

	// 3. 유효성 검사
	// 4. fetch
	// * 객체화
	const obj = {
		mid : mid,
		mpwd : mpwd
	}
	// * fetch 옵션
	const option = {
		method : 'POST', // 요청할 http 메소드 선택
		headers : {'Content-type' : 'application/json'}, // 요청할 http body의 타입 설정 
		body : JSON.stringify(obj) // 요청할 http 자료, 자료를 json 형식의 문자열 타입으로 변환
	}
	fetch('/tj2024b_web1/member/login', option)
		.then(respones => respones.json())
		.then(data => {
			if(data > 0){
				alert('로그인 성공');
				location.href="../index.jsp"; // or "/tj2024_web1/index.jsp"
			}else{
				alert('로그인 실패');
			}
		})
		.catch(error => {console.log(error);})
	
}