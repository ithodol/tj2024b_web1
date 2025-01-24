
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



const outCar = () => {
	
}



















