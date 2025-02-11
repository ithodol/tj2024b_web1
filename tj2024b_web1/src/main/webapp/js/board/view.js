// [**] 조회할 bno(게시물번호)
// -view.jsp?bno=1

// [1] 게시물 1개 조회
const findByBno = () => {
	
	// 1. URL 주소상의 bno(조회할번호)를 가져오기
	const bno = new URL(location.href).searchParams.get("bno");
	// 2. fetch
	const option = {
		method : 'GET'
	}
	fetch(`/tj2024b_web1/board/view?bno=${bno}`,option)
		.then(r => r.json())
		.then(data => {
			console.log(data);
			document.querySelector('.titlebox').innerHTML = data.btitle;
			document.querySelector('.contentbox').innerHTML = data.bcontent;
			document.querySelector('.midbox').innerHTML = data.mid;
			document.querySelector('.viewbox').innerHTML = data.bview;
			document.querySelector('.datebox').innerHTML = data.bdate;
		})
		.catch(e => {console.log(e);})
}
findByBno();


// [2] 댓글 쓰기
const onReplyWrite = () => {
	// 1. 입력받은 값 가져오기
	const rcontentinput = document.querySelector('.rcontentinput')
	const rcontent = rcontentinput.value;	
	
	// 2. 현재 게시물의 번호 구하기
	const bno = new URL(location.href).searchParams.get("bno");
	console.log(bno);
	
	// 3. 보낼 자료를 객체로 만들기
	const obj = {rcontent : rcontent, bno : bno}
	console.log(obj);
	// 4. fetch 이용한 servlet 통신(주고=request 받기=response)
	const option={
		method : 'POST',
		Headers : {'Content-type' : 'application/json'},
		body : JSON.stringify(obj)
	}
	fetch('/tj2024b_web1/board/reply', option)
		.then(r => r.json()) // json 으로 타입 변환
		.then(data => {
			console.log(data);
			if(data == true){
				alert('댓글 쓰기 성공');
				replyFindAll(); // 댓글 게시물 조회 함수 실행 / 새로고침
			}else{
				alert('댓글 쓰기 실패');
			}
		})
		.catch(e => {console.log(e);})
	
}


// [3] 현재 게시물의 댓글 전체 조회
const replyFindAll = () => {
	// 준비물 = bno
	const bno = new URL(location.href).searchParams.get("bno")	
	
	//fetch queryString
	fetch(`/tj2024b_web1/board/reply?bno=${bno}`)
		.then(r => r.json())
		.then(data => {
			console.log(data);
			
			const replybox = document.querySelector('.replybox')
			let html = ``;
			data.forEach(reply => {
				html += `
						<div class="card mt-3">
							<div class="card-header">
							<img src="/tj2024b_web1/upload/${reply.mimg}" style="width:30px; height:30px;" />
								${reply.mid}
							</div>
							<div class="card-body">
								${reply.rcontent}
						  	</div>
						</div>
						`
			})
			replybox.innerHTML = html;
		})
		.catch(e => {console.log(e);})
}
replyFindAll();



























