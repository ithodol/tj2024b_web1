// [**] 썸머노트 실행
$(document).ready(function() {
  $('#summernote').summernote({
	placeholder : '내용을 입력해주세요.',
	height : 500,
	lang : 'ko-KR'
  });
});


// [1] 글쓰기 요청 메소드 
const onWrite = () => {
	// 첨부파일 있으면 form 전송 / 첨부파일 없으면 from 또는 JSON
	
	// 1. 입력받은 값들을 가져오기 위해 dom 객체 호출
	const cnoselect = document.querySelector('.cnoselect')
	const titleinput = document.querySelector('.titleinput')
	const contentinput = document.querySelector('.contentinput')
	//console.log(cnoselect);
	//console.log(titleinput);
	//console.log(contentinput);
	// 2. dom 객체 
	const cno = cnoselect.value;
	const btitle = titleinput.value;
	const bcontent = contentinput.value;
	// 3. 값들을 묶어주는 객체 json 만들기
	let obj = {
		cno : cno,
		btitle : btitle,
		bcontent : bcontent		
	}
	// 4. fetch option
	const option = {
		method : 'POST',
		headers : {'Content-Type' : 'application/json'},
		body : JSON.stringify(obj) // HTTP 기본 전송 데이터는 문자열, JSON -> 문자열 타입으로 변환해서 전송
	}
	
	// fetch
	fetch(`/tj2024b_web1/board`, option)
		.then(r => r.json())
		.then(data => {
			console.log(data);
			if(data == true){
				alert('글쓰기 성공');
			}else{
				alert('글쓰기 실패');
			}
		})
		.catch(e => {console.log(e);})
	
}