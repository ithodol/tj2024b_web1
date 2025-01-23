
// [1] 게시물 등록
const boardWrite = () => {
	// input dom 가져오기
	let writerInput = document.querySelector('.writerInput').value;
	let pwdInput = document.querySelector('.pwdInput').value;
	let titleInput = document.querySelector('.titleInput').value;
	let contentInput = document.querySelector('.contentInput').value;
	
	// 객체화
	let dataObj = {
		bwriter : writerInput,
		bpwd : pwdInput,
		btitle : titleInput,
		bcontent : contentInput
	}
	
	// fetch 통신
	const option = {
		method : 'POST',
		headers : {'Content-type' : 'application/json'},
		body : JSON.stringify(dataObj)
	}
	
	// fetch
	fetch('/tj2024b_web1/day05/board', option)
		.then(response => response.json())
		.then(data => {
			if(data == true){
				alert('게시물 등록 성공');
				location.href="/tj2024b_web1/day05/board/board.jsp";
			}else{
				alert('게시물 등록 실패');
			}
		})
		.catch(e => {alert(e + '[시스템 오류 : 관리자에게 문의하세요]')})
}





