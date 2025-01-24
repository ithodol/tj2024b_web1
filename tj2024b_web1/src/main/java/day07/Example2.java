package day07;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

// 서블릿 x
public class Example2 {
	public static void main(String[] args) {
		// 1. ArrayList 인스턴스 생성
			// 인스턴스 : new AarrayList<String>();	// 클래스 타입
			// 변수명 : list							// 아무거나
			// 변수의 타입 : List<String> list			// 인터페이스 타입
		List<String> list = new ArrayList<String>();	// ArrayList 타입은 List 인터페이스를 구현했으므로
		
		// 2. List 인터페이스 메소드들
			// (1) .add(자료) : 리스트내 지정한 자료를 마지막 요소 추가
		list.add("유재석"); System.out.println(list); // [유재석]
		list.add("강호동"); System.out.println(list); // [유재석, 강호동]
		list.add("신동엽"); System.out.println(list); // [유재석, 강호동, 신동엽]
		list.add("하하"); System.out.println(list); // [유재석, 강호동, 신동엽, 하하]
		
		list.add(2, "김춘추"); // 3번째 자리에 '김춘추' 자료 추가
		System.out.println(list); // [유재석, 강호동, 김춘추, 신동엽, 하하]
		
			// (2) .set(인덱스, 자료) : 리스트내 지정한 인덱스에 지정한 자료의 요소 수정/변경
		list.set(2, "김한주"); // 3번째 위치에 '김한주' 자료를 추가해라
		System.out.println(list); // [유재석, 강호동, 김한주, 하하]
		
			// (3) .get(인덱스) : 리스트내 지정한 인덱스의 요소 값 반환
		System.out.println(list.get(2)); // 3번째 위치한 요소 값 반환 // 김한주
		String str1 = list.get(0); // 1번째 위치한 요소 값 반환
		System.out.println(str1); // 유재석
		
			// (4) .size() : 리스트내 요소 전체 개수 반환
		System.out.println(list.size()); // 5
		
			// (5) .contains(자료) : 리스트내 지정한 자료 존재 여부 반환 / true or false
		System.out.println(list.contains("하하")); // true
		System.out.println(list.contains("최웅희")); // false
		
			// (6) .indexOf(자료) : 리스트내 지정한 자료의 인덱스 반환 / 없으면 -1, 있으면 인덱스 번호 반환
		System.out.println(list.indexOf("신동엽")); // 3 = 3번 인덱스에 위치  
		int result2 = list.indexOf("김건재"); 
		System.out.println(result2);// -1 = 존재하지 않음
		
			// (7) .remove(인덱스/자료) : 리스트내 지정한 인덱스/자료의 요소 삭제
		list.remove(0); // 0번 인덱스 요소 삭제 
		System.out.println(list); // [강호동, 김한주, 신동엽, 하하]
		
			// (8) .clear() : 리스트내 모든 요소 삭제
			// 실행 x
		
			// (9) .isEmpty() : 리스트내 요소가 비어있으면 true, 1개 이상 존재하면 false 반환
		System.out.println(list.isEmpty()); // false
		
			// (10) 리스트내 요소들을 순회하는 방법
				// 1. 일반 for
				for(int index = 0; index <= list.size()-1; index++) {
					System.out.print(list.get(index));
				}
				// 2. 향상된 for  / for(타입 반복변수명 : 리스트명){ }
				for(String str : list) {
					System.out.print(str);
				}
				// 3. forEach() / JS : () => {} / JAVA : () -> {}
				list.forEach(str -> {System.out.print(str);});
		// 3. 클래스
		ArrayList<String> list1 = new ArrayList<String>();	
		Vector<String> list2 = new Vector<String>();			// + 멀티스레드에서 주로 사용함
		LinkedList<String> list3 = new LinkedList<String>();	// + 요소가 중간 삽입/삭제 용이하다
			// 여러 클래스들의 ㅇ니스턴스를 다루기 위해서는 주로 인터페이스 타입 사용
		List<String> list4 = new ArrayList<String>();
		List<String> list5 = new Vector<String>();
		List<String> list6 = new LinkedList<String>();
	} // main end
} // class end




























