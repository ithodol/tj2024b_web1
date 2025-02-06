package web.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@AllArgsConstructor @NoArgsConstructor
// 기본생성자 and 전체 매개변수 생성자를 자동 생성
public class BoardDto {
    private int bno;			// 게시물 번호
    private String btitle;      // 제목  
    private String bcontent;	// 내용
    private int bview;			// 조회수
    private String bdate;		// 작성일
    private int mno; 			// 작성자의 회원번호
    private int cno;			// 카테고리 번호
    // + HTML에 출력할 때 작성자의 회원 번호가 아닌 작성자 ID 출력하기 위함
    private String mid;
    // + HTML에 출력할 대 카테고리의 번호가 아닌 카테고리명 출력하기 위함
    private String cname;
   
}