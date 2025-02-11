// [1] URL 경로상의 cno 매개변수 값
// /tj2024b_web1/board/board.jsp?cno=1
// /tj2024b_web1/board/board.jsp?cno=2
// /tj2024b_web1/board/board.jsp?cno=3
// - URL 상의 쿼리스트링 매개변수 :  new URL( location.href ).searchParams 
// - URL 상의 쿼리스트링 매개변수의 값 추출 : new URL( location.href ).searchParams.get('매개변수명')
console.log(new URL(location.href).searchParams);
console.log(new URL(location.href).searchParams.get('cno'));

// [2] 지정한 카테고리별 게시물 조회 요청 + 2.11 페이징 처리 추가
const findAll = () => {
	const cno = new URL(location.href).searchParams.get('cno')
	// * 현재 경로상의 page 번호 찾기 
	let page = new URL(location.href).searchParams.get('page')
	if(page == null){
		page = 1; // 만약 page가 없으면 1페이지로 설정
	}

	const option = {method : 'GET'}

	fetch(`/tj2024b_web1/board?cno=${cno}&page=${page}`, option)
		.then(r => r.json())
		.then(data => {
			console.log(data);

			const boardList = document.querySelector('.boardList > tbody')

			let html = ``;

			data.forEach( (board) => {

				html += `<tr>
							<td>${board.bno}</td>
							<td> <a href="view.jsp?bno=${board.bno}"> ${board.btitle}</a></td>
							<td>${board.mid}</td>
							<td>${board.bdate}</td>
							<td>${board.bview}</td>
						</tr>`;
			})

			boardList.innerHTML = html;
			getPageBtn();
		})
		.catch(e => {console.log(e);})
}
findAll();

// [3] 페이지 버튼 생성 함수
const getPageBtn = (page) => {
	
	page = parsInt(page); // parseInt() 정수로 타입 변환 함수
	  // 어디에
	  const pagebtnbox = document.querySelector('.pagebtnbox')
	  
	  // 무엇을
	  let html = ``
	  
	  // 이전 버튼 : 만약 현재 페이지가 1이하 페이지면 1페이지 띄우기 / 아니면 -1 
	  html += `
	  		<li class="page-item">
	  			<a class="page-link" href="board.jsp?cno=1&page=${page <= 1 ? 1 : page-1}">
	  				이전
	  			</a>
	  		</li>
	  		`
	  
	  // 1부터 10까지 버튼 만들기 / 실행조건 : 게시물 출력 후
	  	// 최대페이지, 현재 페이지의 시작 버튼 번호, 현재 페이지의 끝 버튼 번호
	  for(let index = 1; index <= 10; index++){
		html += `
				<li class="page-item">
					<a class="page-link" href="board.jsp?cno=1&page=${index}">
						${index}
					</a>
				</li>
				`
	  }
	  
	  html += `
	  		<li class="page-item">
	  			<a class="page-link" href="board.jsp?cno=1&page=${page <= 1 ? 1 : page+1}">
	  				다음
	  			</a>
	  		</li>
	  		`
	  // 출력
	  pagebtnbox.innerHTML = html;
}







/*
// [2] 지정한 카테고리별 게시물 조회 요청
const findAll = () => {
	// 1. 현재 페이지의 카테고리 구하기
	const cno = new URL(location.href).searchParams.get('cno')
	// 2. fetch option
	const option = {method : 'GET'}
	// 3. fetch, queryString방식 : URL?매개변수명=값
	fetch(`/tj2024b_web1/board?cno=${cno}`, option)
		.then(r => r.json())
		.then(data => {
			console.log(data);
			// 4. 출력할 위치의 dom 객체 반환
			const boardList = document.querySelector('.boardList > tbody')
			// 5. 출력할 내용을 담을 변수 선언
			let html = ``;
			// 6. 서블릿으로부터 응답받은 자료들을 
			data.forEach( (board) => {
				// 7. 게시물 하나씩 html 테이블의 행으로 표현하여 html 변수에 누적
				html += `<tr>
							<td>${board.bno}</td>
							<td> <a href="view.jsp?bno=${board.bno}"> ${board.btitle}</a></td>
							<td>${board.mid}</td>
							<td>${board.bdate}</td>
							<td>${board.bview}</td>
						</tr>`;
			})
			// 8. 반복문 종료. 표현된 html 출력
			boardList.innerHTML = html;
			
		})
		.catch(e => {console.log(e);})
}
findAll(); // 페이지가 열리면 함수 실행
*/