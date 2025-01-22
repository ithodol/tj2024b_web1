
// [2] 게시물 전체 조회
const boardPrintAll = () => {
	// 어디에
	let tbody = document.querySelector('tbody')
	// 무엇을
	let html = '';
	
	// fetch 옵션
	const option = {method : 'GET'}
	
	// fetch 사용
	fetch('/tj2024b_web1/day05/board', option)
		.then(response => response.json())
		.then(data => {
			data.forEach(board => {
				html += `<tr>
							<td>${board.bno}</td>
							<td>
								<a href="/tj2024b_web1/day05/board/view.jsp?bno=${board.bno}">
									${board.btitle}									
								</a>
							</td>		
							<td>${board.bdate}</td>
							<td>${board.bwriter}</td>
							<td>${board.bview}</td>
						</tr>`
			});
			// 출력
			tbody.innerHTML = html;
		})
		.catch(e => {alert(e + '[시스템 오류 : 관리자에게 문의하세요]');})
} // f end
boardPrintAll();





