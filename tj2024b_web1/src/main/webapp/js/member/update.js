console.log('update.js open');

// [1] 대부분 수정은 기존의 데이터를 먼저 보여줘야 한다
const getMyInfo = () => {
	
	fetch('/tj2024b_web1/member/info', {metiod : 'GET'})
		.then(r => r.json())
		.then(data => {
			if(data != null){
				document.querySelector('.mid').value = data.mid;
				document.querySelector('.mname').value = data.mname;
				document.querySelector('.mphone').value = data.mphone;
				document.querySelector('.mimg').src=`/tj2024b_web1/upload/${data.mimg}`
			}
		})
		.catch(e => {console.log(e);})

} // getMyInfo end
getMyInfo();



// [2] 수정 버튼을 클릭했을 때
const onUpdate = () => {
	// 입력받은 자료/ 값 가져오기
	const mpwd = document.querySelector('.mpwd').value;
	const mname = document.querySelector('.mname').value;
	const mphone = document.querySelector('.mphone').value;
	 
	// 객체화
	const obj = {
		mpwd : mpwd,
		mname : mname,
		mphone : mphone
	}

	// fetch
	const option = {
		method : 'PUT',
		headers : {'Content-Type' : 'application/json'},
		body : JSON.stringify(obj) // 보내고자 하는 데이터를 문자타입의 JSON으로 보냄
	}
	fetch('/tj2024b_web1/member/info', option)
		.then(r => r.json())
		.then(data => {
			if(data == true){
				alert('회원정보 수정 성공');
				location.href="./info.jsp";
			}else{
				alert('회원정보 수정 실패');
			}
		})
		.catch(e => {console.log(e);})
} // onUpdate end





























