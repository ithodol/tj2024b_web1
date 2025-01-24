
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
console.log(inCar);


// 출차(상태변경) + 이용시간, 주차료 안내
const outCar = () => {
	let carValue = document.querySelector('.carValue')
	
	let html = '';
	
	const option = {method : 'PUT'}
	
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
							<button onclick="pay()">결제</button>
						`
			})
			carValue.innerHTML = html;
		})
		.catch(e => {alert(e + '[시스템 오류 : 관리자에게 문의하세요]');})
}

const pay = () => {
	
}

















