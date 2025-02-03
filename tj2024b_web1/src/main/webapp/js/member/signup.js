console.log('signup.js open');

// [1] 회원가입 요청 함수
const onSignUp = () => {
	
	// 1. 입력받은 자료 가져오기 (form을 한번에 가져오기)
	// application/json --> multipart/form-data(첨부파일)
	// * form-data로 전송할 경우에는 속성명들을 'class'나 'id'가 아닌 'name'을 사용한다
	
	const signupform = document.querySelector('#signupform');
	console.log(signupform);
	
	// ** 2. Fetch 함수를 이용한 'multipart/form-data' 타입으로 전송하는 방법
		// (1) 전송할 폼을 바이트(바이너리/스트림) 데이터로 변환 / FormData 클래스 사용 / new FromData(폼DOM);
	const signupformData = new FormData(signupform);
			// html 폼에 없는 데이터를 폼 데이터에 추가하는 방법
			// signupformData.append("속성명", "값"); 
			
		// (2) fetch 옵션 / post 또는 put
		// content-type 을 생략하면 자동으로 multipart/form-data 적용
	const option = {
		method : 'POST',
		// headers : {'Content-Type' : ''} // 생략한다
		body : signupformData // JSON.stringify() : 폼 전송은 json형식이 아니기 때문에 생략
	}
	
		// (3) fetch 요청, 응답
	fetch('/tj2024b_web1/member/signup', option)
		.then(response => response.json()) // 응답 자료를 'application/json' 타입으로 변환
		.then( data => {
			if(data == true) { // 성공시
				alert('회원가입 성공'); // 알림창을 띄우고
				location.href="login.jsp"; // 로그인 페이지로 이동
			}else{
				alert('회원가입 실패');
			}
		})
		.catch(error => {console.log(error);}) // 오류시 콘솔에 띄움
		
	
	
	
} // f end