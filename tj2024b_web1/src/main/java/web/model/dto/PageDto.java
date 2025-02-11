package web.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@AllArgsConstructor @NoArgsConstructor
public class PageDto { // 페이징 처리된 데이터들의 이동 객체
	
	// 필드
	private int totalcount; // 전체 자료 개수(검색결과 조회시 사용)
	private int page; // 현재 페이지
	private int totalpage; // 전체 페이지 수
	private int startbtn; // 페이징 버튼 시작번호
	private int endbtn; // 페이징 버튼 끝번호
	private Object data; // 페이징된 자료
	// ** Object 타입으로 사용한 이유
	// 자바의 최상위 클래스임. 그렇기에 모든 타입들의 자료들을 저장할 수 없다. 단점 : 유지보수가 힘들 수 있음
	// 페이징 처리시 자주 사용
	// - data 에는 List<boardDto>, List<replyDto> 등 여러 타입들을 하나의 타입에서 저장한다

}
