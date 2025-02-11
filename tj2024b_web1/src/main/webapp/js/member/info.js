console.log('info.js open');

// [1] 현재 로그인된 회원정보 요청 함수
const getMyInfo = () => {
	// fetch 옵션
	const option = {method : "GET"}
	// fetch 실행
	fetch('/tj2024b_web1/member/info', option)
		.then(r => r.json())
		.then(data => {
			if(data != null){ // 만약 로그인 상태라면
				// 특정 dom에 정보 대입하기
				document.querySelector('.mid').value = data.mid
				document.querySelector('.mname').value = data.mname
				document.querySelector('.mphone').value = data.mphone
				// ** img 마크업에 이미지 경로를 대입하는 방법 => .src 속성 사용
				document.querySelector('.mimg').src = `/tj2024b_web1/upload/${data.mimg}`
			}
		})
		.catch(e => {console.log(e);})
} // getMyInfo end
getMyInfo();


// [2] 회원탈퇴
const onDelete = () => {
	// alert 알림창 , conrirm 확인/취소 알림창 , prompt 입력상자 알림창
	let result = confirm('정말 탈퇴하시겠습니까?');
	if( result == false ) {
		return; // 만약 취소 버튼을 클릭했다면 리턴
	}
	
	// fetch
	const option = {method : 'DELETE'}
	fetch('/tj2024b_web1/member/info', option)
		.then(r => r.json())
		.then(data => {
			if(data == true){
				alert('회원 탈퇴 성공');
				location.href="/tj2024b_web1/index.jsp";
			}else{
				alert('회원 탈퇴 실패');
			}
		})
		.catch(e => {console.log(e);})
} // onDelete end


// [3] 회원수정 페이지 이동
const onUpdate = () => {
	location.href = "./update.jsp";
	// 게시판에서는 게시물번호가 세션에 없으므로 ?bno=3 처럼 게시물 번호를 넘겼지만,
	// 수정할 회원번호(로그인된 회원번호)가 세션에 있으므로 굳이 필요없음 
	// 현재 페이지와 이동할 페이지가 같은 폴더이면 지정 파일명만 입력, 만일 다른 폴더이면 프로젝트명부터 입력
	// ../ 상대참조 입력
} // onUpdate end





// [4] 내 포인트 내역 조회 요청 
const getPointLog = ( ) => {
        // fetch 옵션 
        const option = { method : 'GET' }
        // fetch 실행 
        fetch( '/tj2024b_web1/point' , option )
                .then( r => r.json() )
                .then( data => { 
                        if( data != null ){ // 로그인 상태이면 
                                const tbody = document.querySelector('tbody');
                                
                                let html = ``;
                                
                                data.forEach(  (point) =>{
                                        html += `<tr>
                                                                <th> ${ point.pono} </th> 
                                                                <th> ${ point.pocomment } </th>
                                                                <th> ${ point.pocount } </th> 
                                                                <th> ${ point.podate } </th>
                                                        </tr>`
                                })
                                
                                tbody.innerHTML = html;
                        }
                })
                .catch( e => { console.log(e) } )
} // f end 
getPointLog();




















