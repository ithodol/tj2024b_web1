
console.log('example.js실행');

// 1. JS 자료
console.log(3);			// number	정수
console.log(3.14);		// number	실수
console.log(true);		// boolean	논리
console.log(null);		// null 	객체 없다
console.log(undefined);	// undefined	정의없다
console.log("안녕1");		// String " "
console.log('안녕1');		// String ' '
console.log(`안녕3`);		// String ` `
console.log([3, 3.14, true, `안녕4`]);			// Array	배열 [ ]
console.log(function 함수명(){})					// function		함수
console.log( {"속성명" : 3, "속성명" : `안녕4`} );	// Object	객체 { }

// 2. JS 함수
// (1) 선언적 함수 : function 함수명(매개병수명, 매개변수명){실행문;}
// (정의/만들기)
function func1(a,b){
	console.log(`func1 execute`)
	let c= a + b;
	return c;
} // f end
let result = func1(3, 4)	// 함수호출/사용
console.log(result);

// (2) 익명 함수 : function(매개변수명, 매개변수명) {실행문;}
const func2 = function(a, b){ // 정의/만들기
	console.log(`func2 execute`)
	let c = a + b ; return c;
}
let result2 = func2(5, 1);	// 함수호출/사용
console.log(result2);

// (3) 람다식(화살표) 함수 : (매개변수명, 매개변수명) => {실행문;}
const func3 = (a, b) => {
	console.log(`func3 execute`)
	c = a + b; return c;
}
let result3 = func3(10, 7);
console.log(result3);


// 3. 람다식 함수의 활용처 : 다양한 라이브러리(미리 만들어지 함수)들에서 널리 사용됨
const words = ['사과', '수박', '딸기', '오렌지']
// 예) 배열내 모든 요소 값들을 하나씩 출력하시오
// (1) 일반 for문
for(let index = 0; index <= words.length-1; index++){
	console.log(words[index]);
}
// (2) .forEach( (반복변수명) => {실행문} ) 함수 / 배열내 요소를 하나씩 반복변수명에 대입 반복실행
words.forEach( (word) => {console.log(word)} );

// (3) 배열변수명.map( (반복변수명) => {실행문} ) / 배열내 요소를 하나씩 반복변수명에 대입 반복실행
words.map( (word) => {console.log(word)} );

// (**) forEach와 map 함수의 차이점
// 			forEach : return 없음
//			map : return 지원함
let newWords1 = words.forEach((i) => {return i;})
console.log(newWords1); // undefined

let newWords2 = words.map( (j) => {return j;} )
console.log(newWords2); // ['사과', '수박', '딸기', '오렌지']


















