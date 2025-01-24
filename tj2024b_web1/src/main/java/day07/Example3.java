package day07;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Example3 {
	public static void main(String[] args) {
		// [1] hashSet 인스턴스 생성
		Set<String> set = new HashSet<String>();
		
		// [2] set 인터페이스 주요 메소드
			// (1) .add(자료) : set 내 지정한 자료 추가
		set.add("이혁재");	System.out.println(set); // [이혁재]
		set.add("이동해");	System.out.println(set); // [이혁재, 이동해]
		set.add("김종운");	System.out.println(set); // [이혁재, 김종운, 이동해]
			// (2) .size() : set 내 전체 요소 개수 반환
		System.out.println(set.size()); // 3
		
			// (3) remove(자료) : set 내 지정한 자료가 존재하면 삭제
		set.remove("김종운");	System.out.println(set);	// [이혁재, 이동해]
		
			// (4) .contains(자료) : set 내 지정한 자료가 존재하는지 여부 반환
		System.out.println(set.contains("이혁재")); // true
		
			// (5) 순회 / JDBC(DAO) : ResultSet
		Iterator<String> rs = set.iterator();	// iterate : 반복하다 / iterator : 반복자
		while(rs.hasNext()) {
			System.out.println(rs.next());
		}
		
			// 일반 for 사용 불가능 / 왜? 인덱스가 존재하지 않기 때문에 순회 불가능
			// 향상된 for 사용 가능 / 왜? 향상된 for 문법 자체가 Iterator 기반으로 만들었기 때문
		for(String str : set) {System.out.println(str);}
			// forEach() 사용 가능 / 위와 같음
		set.forEach((str) -> {System.out.println(str);});
		
			// (6) set 컬렉션은 중복 허용 x
		set.add("김종운"); System.out.println(set); // [이혁재, 김종운, 이동해]
		set.add("김종운"); System.out.println(set); // [이혁재, 김종운, 이동해]
		
		// [3] TreeSet 인스턴스 생성
		TreeSet<String> set2 = new TreeSet<String>();
		set2.add("이혁재");
		set2.add("이동해");
		set2.add("김종운");
		System.out.println(set2); // 자동으로 오름차순 정렬 / [김종운, 이동해, 이혁재]
		System.out.println(set2.descendingSet()); // 내림차순 정렬 / [이혁재, 이동해, 김종운]
		
		
	} // main end
} // class end
