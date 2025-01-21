// 대기열 등록
const waitingWrite = () => {
	let inputTel = document.querySelector('.inputTel').value
	let inputCount = document.querySelector('.inputCount').value
	// 객체화
	let dataObj = {'tel' : inputTel, 'count' : inputCount}
	// fetch
	let option = {
		method : 'POST',
		headers : {'Content-type' : "application/json"},
		body : JSON.stringify(dataObj)
	} // option end
	fetch(`/tj2024b_web1/day03/waiting2`, option)
		.then(r => r.json())
		.then(data => {
			if(data == true){
				alert('등록 성공');
				WaitingPrintAll();
			}else{
				alert('등록 실패')
			}
		}) // then2 end
		.catch(e => {console.log(e);})
} // f end


// 대기열 명단 전체 출력
const WaitingPrintAll = () => {
	// 어디에
	let tbody = document.querySelector('tbody')
		
	// 무엇을
	let html = ''
	
	let option = {method : 'GET'} // ????
	
	fetch(`/tj2024b_web1/day03/waiting2`, option)
		.then(r => r.json())
		.then(data => {
			data.forEach(obj => {
				// 만들어놓은 html 빈 배열에 집어 넣어
				html += `<tr>
							<td>${obj.num}</td>
							<td>${obj.tel}</td>
							<td>${obj.count}</td>
							<td>
								<button onclick="WaitingUpdate(${obj.num})">수정</button>
								<button onclick="WaitingDelete(${obj.num})">삭제</button>
							</td>
						</tr>`
			}) // forEach end
			// 출력 / html을 tbody에 집어넣음
			tbody.innerHTML = html;
		}) // then2 end
		.catch(e => {console.log(e);})
}
WaitingPrintAll();


// 대기열 인원수 수정
const WaitingUpdate = (num) => {
	// 수정 식별자 = num
	let updateTel = prompt('연락처를 입력하세요.')
	let updateCount = prompt('인원수를 입력하세요.')

	let dataObj = {num : num, tel : updateTel, count : updateCount}
	
	const option = {
		method : 'PUT',
		headers : {'Content-type' : 'application/json'},
		body : JSON.stringify(dataObj)
	}
	fetch(`/tj2024b_web1/day03/waiting2`, option)
		.then(r => r.json())
		.then(data => {
			if(data == true){
				alert('수정 성공');
				WaitingPrintAll();
			}else{
				alert('수정 실패');
			}
		}) // then2 end
		.catch(e => {console.log(e);})
}


// 대기열 삭제
const WaitingDelete = (num) => {
	// 삭제 식별자 = num
	const option = {method : 'DELETE'}
	
	fetch(`/tj2024b_web1/day03/waiting2?num=${num}`, option)
		.then(r => r.json())
		.then(data => {
			if(data == true){
				alert('삭제 성공');
				WaitingPrintAll();
			}else{
				alert('삭제 실패');
			}
		})
		.catch(e => {console.log(e);})
}



