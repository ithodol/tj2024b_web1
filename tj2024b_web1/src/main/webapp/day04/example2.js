
// [1] 람다식 함수 정의
// const 상수명 = () => {}
const func1 = ( ) =>{
	console.log('func1 execute');
}

// [2] 람다식 함수 정의 안에서 fetch 함수 활용
const func2 = () =>{
	// ** fetch : HTTP 배동기 통신을 제공하는 함수
	// day02 -> example1 서블릿 클래스의 get 메소드 매핑
	fetch('http://localhost:8080/tj2024b_web1/day02/example1');
}

const func3 = () => {
	// POST 메소드 매핑
	fetch(`/tj2024b_web1/day02/example1`, {method : 'POST'});
} 
const func4 = () => {
	// PUT 메소드 매핑
	fetch(`/tj2024b_web1/day02/example1`, {method : 'PUT'});
} 
const func5 = () => {
	// DELETE 메소드 매핑
	fetch(`/tj2024b_web1/day02/example1`, {method : 'DELETE'});
} 

const func6 = () => {
	let name = '전호돌'
	let age = 19
	fetch(`/tj2024b_web1/day02/example2?name=${name}&age=${age}`)
}

const func7 = () => {
	let name = '전은서'
	let age = 100
	const option = {method : 'POST'}
	fetch(`/tj2024b_web1/day02/example2?name=${name}&age=${age}`, option)
}

const func8 = () => {
	let name = '킬리언머피'
	let age = 50
	const option = {method : 'PUT'}
	fetch(`/tj2024b_web1/day02/example2?name=${name}&age=${age}`, option)
}

const func9 = () => {
	let name = '정지원'
	let age = 40
	const option = {method : 'DELETE'}
	fetch(`/tj2024b_web1/day02/example2?name=${name}&age=${age}`, option)
}

const func10 = () => {
	let object = {data1 : '유재석', data2 : 50}
	const option = { 
		method : 'post',
		header : {'Content-Type' : 'application/json'},
		body : JSON.stringify(object) // HTTP 통신은 문자열 자료만 전송 가능하기 때문에 타입변환
	}
	fetch(`/tj2024b_web1/day03/example3`, option)
}

const func11 = () => {
	let object = {data1 : '강호동', data2 : 40}
	const option = {
		method : 'PUT',
		Header : {'Content-Type' : 'application/json'},
		body : JSON.stringify(object)
	}
	fetch(`/tj2024b_web1/day03/example3`, option)
	
}

const func12 = () => {
	const option = {method : 'GET'}
	fetch(`/tj2024b_web1/day03/example5`, option)
		.then((response) => response.json())
		.then(data => {console.log(data);})
}

const func13 = () => {
	const option = {method : 'POST'}
	fetch(`/tj2024b_web1/day03/example5`, option)
		.then(response => response.text())
		// content-type을 text/plain으로 보냈기 때문에 .text로 타입 변환
		.then(data => {console.log(data);})
		.catch(error => {console.log(error);}) // 통신 실패시
}

const func14 = () => {
	const option = {method : 'PUT'}
	fetch(`/tj2024b_web1/day03/example5`, option)
	.then((response) => response.json())
	.then(data => {console.log(data);}) // 통신 성공시
	.catch(error => {console.log(error);}) // 통신 실패시
}

const func15 = () => {
	const option = {method : 'DELETE'}
	fetch(`/tj2024b_web1/day03/example5`, option)
	.then((response) => response.json())
	.then(data => {console.log(data);})
	.catch(e => {console.log(e);}) // 통신 실패시
}


/*
	fetch(`HTTP URL`, {옵션})
		.then(response객체 => response.타입())
		.then(타입변환된자료 => {실행문})	
	
		URL
			1. 통신할 서블릿의 URL 주소
			2. 쿼리스트링
			
		옵션
			1. METHOD	
				- GET : fetch('HTTP URL', {method : `GET`})
						GET METHOD는 생략 가능
				- POST : fetch('HTTP URL', {method : `POST`})
				- PUT : fetch('HTTP URL', {method : `PUT`})
				- DELETE : fetch('HTTP URL', {method : `DELETE`})
				
			2. HEADER
				- {'Content-Type' : "application/json" }
			3. BODY
				- 전송할 데이터 자료
				
		.then()
			1. 응답객체 : 통신한 응답의 정보가 담긴 HTTP 응답 객체 변환
				.then(응답객체명 => 응답객체명.json()) : body 자료를 application/json 으로 타입변환
				.then()
				
			
			
		[참고1] `` : 백틱 탬플릿
			문자열 사이에 변수/함수 호출과 연산식을 넣을 수 있는 탬플릿
			예) `문자열 ${변수명} 문자열${함수명()} 문자열 ${연산}`
			
		[참고2] JSON 문자열 타입 변환
			1. JSON.parse()		: 문자열 타입 --> JSON타입 변환 함수
			2. JSON.stringify	: JSON타입 --> 문자열 타입 변환 함수
*/






















