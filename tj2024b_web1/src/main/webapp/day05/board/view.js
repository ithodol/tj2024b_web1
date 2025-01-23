


// [3] 게시물 상세(개별) 조회
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
			document.querySelector('.bdatebox').innerHTML = `${data.bdate}`
			document.querySelector('.bwriterbox').innerHTML = `${data.bwriter}`
			document.querySelector('.bviewbox').innerHTML = `${data.bview}`
			document.querySelector('.btitlebox').innerHTML = `${data.btitle}`
			document.querySelector('.bcontentbox').innerHTML = `${data.bcontent}`
			// 다른 함수에서 게시물 정보를 이용하기 위해 게시물 정보를 전역변수로 이동
			boardInfo = data;
		})
		.catch(e => {alert(e + '[시스템 오류 : 관리자에게 문의하세요]')})
}
boardView(); // js가 열릴 때 최초 실행 해야함


// [4-0] 게시물 수정 페이지 이동
const boardUpdate = () => {
	// 비밀번호 검증
	let pwdCheck = prompt('게시물 비밀번호를 입력하세요')
	if(boardInfo.bpwd != pwdCheck){
		alert('비밀번호가 일치하지 않습니다');
		return;
	}
	// 검증되었다면 수정 페이지로 이동
	location.href = `/tj2024b_web1/day05/board/update.jsp?bno=${boardInfo.bno}`
}


// 게시물 정보 객체 전역변수
let boardInfo = null;

// [5] 게시물 삭제
const boardDelete = () => {
	// 어떤 게시물을 삭제할 것인지? 쿼리스트링 존재
		// js에서 현재 페이지 쿼리스트링 매개변수 가져오기
		// - new URL(location.href) : 현재 URL 정보 가져오기
			// - .searchParams : 쿼리스트링 매개변수들
			// - .get('매개변수명') : 매개변수들에서 특정한 매개변수 값 반환
	let bno = new URL(location.href).searchParams.get('bno');
	// 삭제할 게시물의 비밀번호 검증
	let pwdCheck = prompt('게시물 비밀번호를 입력하세요')
	
	if(boardInfo.bpwd != pwdCheck){
		alert('비밀번호가 일치하지 않습니다'); // 안내 후
		return; // 함수 강제 종료 아래 코드(fetch)는 실행되지 않음	
	}
	
	// 검증되었다면 fetch이용한 삭제 요청
	const option = {method : 'DELETE'}
	fetch(`/tj2024b_web1/day05/board/view.jsp?bno=${bno}`, option)
		.then(response => response.json())
		.then(data => {
			// 그에 따른 화면 제어
			if(data == true){
				alert('게시물 삭제 성공');
				location.href="board.jsp";
			}else{alert('게시물 삭제 실패');}
		})
		.catch(e => {alert(e+'[시스템 오류 : 관리자에게 문의하세요]')})
	
}














