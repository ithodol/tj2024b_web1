
// 입차
const inCar = () => {
	let carNumInput = document.querySelector('.carNumInput').value
	let carLoInput = document.querySelector('.carLoInput').value
	
	let dataObj = {
		carNum : carNumInput,
		carLo : carLoInput
	}
	
	const option = {
		method : 'POST',
		headers : {'Content-Type' : 'application/json'},
		body : JSON.stringify(dataObj)
	}
	
	fetch('/tj2024b_web1/day06/parking/user', option)
		.then(response => response.json())
		.then(data => {
			if(data == true){
				alert('입차 성공');
			}else{
				alert('입차 실패')
			}
		})
		.catch(e => {alert(e + '[시스템 오류] \n 관리자에게 문의하세요')})

}



// 조회
const serchCar = () => {
	let carValue = document.querySelector('.carValue')
	let carNum = document.querySelector('.carNumInput').value
	// 조회 버튼을 누르면 입력된 차량번호를 가져와서
	
	//const obj = {carNum : carNum}
	// 객체에 담고
	
	let html = '';
	
	const option = {
		method : 'GET',
		headers: {'Content-Type': 'application/json'},
		body : JSON.stringify(obj) // body에 요청하려고 했으나
		// get은 body가 없음
		// 페이지 전환을 하지 않는 구조라서 쿼리스트링 getParameter를 할 수 없음
		// 한 페이지에서 해결하려면 어떻게 해야 합니까
	}
	
	fetch('/tj2024b_web1/day06/parking/user', option)
		.then(response => response.json())
		.then(data => {
			data.forEach(car => {
				html += `
							<div>
								입차시간 :
								
								<br/>
								출차시간 : 
								<br/> <hr/>
								주차료 : 
							</div>
							<button onclick="pay()">출차(결제)</button>
						`
			})
			carValue.innerHTML = html;
		})
		.catch(e => {alert(e + '[시스템 오류 : 관리자에게 문의하세요]');})
}

const pay = () => {
	
}

















