// * 함수명 만들 때 js내장 함수와 겹치는 경우
// 1. 등록 함수 / 실행조건 : 등록 버튼을 클릭했을 때
const visitWrite = () => {
	
	// 1. HTML로부터 input dom 객체 가져오기
	// - document.querySelector(선택자) : 선택자가 마크업을 객체로 반환해주는 함수
	let contentInput = document.querySelector('.contentInput')
	let ageInput = document.querySelector('.ageInput')
	
	// 2. 입력받은 값 가져오기
	// - .value : 마크업의 value 속성 가져오 
	let content = contentInput.value;
	let age = ageInput.value;
	
	// 3. 객체화
	let dataObj = {'content' : content, 'age' : age}
	
	// 4. fetch 통신
	let option = {
		method : 'POST',
		headers : {'Content-Type' : "application/json"}, // HTTP 요청 HEADER CONTENT-TYPE 변환
		body : JSON.stringify(dataObj) // 본문에 보낼 자료를 문자열 타입으로 변환
	}
	fetch(`/tj2024b_web1/day03/visit2`, option)
		.then(r => r.json()) // 응답받은 body 자료를 json 타입으로 변환
		.then(data => { // 변환된 body 자료
			// 5. 결과에 따른 화면 구현
			if(data == true){
				alert('등록 성공');
				visitFintAll(); // 전체 조회 함수 실행
			}else{
				alert('등록 실패');
			}
		})
		.catch(e => {console.log(e);})

} // f end


// 2. 전체 조회 함수 / 실행조건 : js가 열릴 때, 등록/수정/삭제 성공했을 때
const visitFintAll = () => {
	// 1. 어디에 tbody에
	let tbody = document.querySelector('tbody')
	
	// 2. 무엇을 fatch로 받은 자료들을
	let html = '';
		// 2-1. fetch 이용한 서블릿에게 자료를 HTTP  GET METHOD 요청
		const option = {method : 'GET'}
		// 2-2. fetch
		fetch(`/tj2024b_web1/day03/visit2`, option)
			.then(r => r.json()) // 통신 응답 성공시 json타입으로 변환
			.then(data => {
				// 방법1
				// for(let index = 0; index <= data.length-1; index++){}
				// 방법2
				// data.forEach(obj => {})
				data.forEach(obj => {
					html += `<tr>
								<td>${obj.num}</td>
								<td>${obj.content}</td>
								<td>${obj.age}</td>
								<td>
									<button onclick="visitUpdate(${obj.num})">수정</button>
									<button onclick="visitDelete(${obj.num})">삭제</button>
								</td>			
							</tr>`
				})
				// 3. 출력 innerHTML : 지정한 마크업의 html문자열 속성
				tbody.innerHTML = html;
				
			}) // then2 end
			.catch( e => {console.log(e);}) // 통신 응답 오류/실패시
}
visitFintAll();



// 3. 수정 함수 / 누구를 수정할 것인지 = num(pk) 식별자로 확인(매개변수)
const visitUpdate = (num) => {
	// 1. 수정할 식별자(num)
	// 2. 수정할 내용 content/age
	let newContent = prompt('new Content : '); // prompt() 알림창에서 입력input 지원하는 함수
	let newAge = prompt('new Age : ');
	// 3. 객체화
	let dataObj = {num : num, content : newContent, age : newAge}
	// 4. fetch 이용한 서블릿에게 HTTP PUT METHOD 처리 요청, BODY
	const option = {
		method : 'PUT',
		headers : {'Content-Type' : 'application/json'},
		body : JSON.stringify(dataObj)
	}
	fetch(`/tj2024b_web1/day03/visit2?num=${num}`, option)
		.then(r => r.json())
		.then(data => {
			if(data == true){
				alert('수정 성공');
				visitFintAll();
			}else{alert('삭제 실패');}
		})
		.catch(e => {console.log(e);})
}



// 4. 삭제 함수 / 누구를 수정할 것인지 = num(pk) 식별자로 확인(매개변수)
const visitDelete = (num) => {
	// 1. 삭제할 식별자(num)
	// 2. fetch 이용한 서블릿에게 HTTP delete METHOD 처리 요청
	const option = {method : 'DELETE'}
	fetch(`/tj2024b_web1/day03/visit2?num=${num}`, option)
		.then(r => r.json()) // 응답 결과를 json 타입으로 변환
		.then(data =>{
			if(data == true){
				alert('삭제 성공');
				visitFintAll(); // 만약 응답이 true면 alert 안내 후 전체 출력 함수 호출
			}else{alert('삭제 실패');}
		})
		.catch(e => {console.log(e);})
}


