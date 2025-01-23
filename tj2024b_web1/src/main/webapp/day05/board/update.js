// 수정하기 전 정보 조회

// [?] 게시물 상세(개별) 조회
const boardView = () => {
	// 현재 URL이 쿼리스트링 매개변수를 가져온다
	// ** 내가 board.jsp에서 클릭한 게시물 번호가 존재하면 쿼리스트링
	let bno = new URL(location.href).searchParams.get('bno');
	
	// fetch 옵션
	const option = {method : 'GET'}
	
	// fetch 통신
	fetch(`/tj2024b_web1/day05/board/view?bno=${bno}`, option)
		.then(response => response.json())
		.then(data => {
			// fetch 응답에 따른 화면 출력	
				// 마크업 주요 속성
					// 1. innerHTML : 시작마크업, 끝마크업 사이에 HTML문자열 대입/호출 가능 <마크업>innerHTML</마크업>
						// --> div, span, table ... / 불가능 : <input/>, <img/> ...
					// 2. value : 마크업의 입력 속성값 <마크업 value="" /> 대입/호출
						// --> input, select, textarea ... / 불가능 : div, span, table ...
			document.querySelector('.updateTitleInput').value = `${data.btitle}`
			document.querySelector('.updateContentInput').value = `${data.bcontent}`

		})
		.catch(e => {alert(e + '[시스템 오류 : 관리자에게 문의하세요]')})
}
boardView(); // js가 열릴 때 최초 실행 해야함


// [4] 게시물 수정
const boardUpdate2 = (bno) => {
	// input 값 가져오기
	let updateTitleInput = document.querySelector('.updateTitleInput').value
	let updateContentInput = document.querySelector('.updateContentInput').value
	
	// 객체화
	let dataObj = {
		bno : bno,
		btitle : updateTitleInput,
		bcontent : updateContentInput
	}
	
	// fetch
	const option = {
		method : 'PUT',
		headers : {'Content-Type' : 'application/json'},
		body : JSON.stringify(dataObj)
	}
	fetch(`/tj2024b_web1/day05/board/view.jsp?bno=${bno}`, option)
		.then(r => r.json())
		.then(data => {
			if(data == true){
				alert('게시물 수정 성공');
				boardPrintAll();
			}else{
				alert('게시물 수정 실패');
			} // if end
		}) // then2 end
		.catch(e => {alert(e + '[시스템 오류 : 관리자에게 문의하세요]')})	
}