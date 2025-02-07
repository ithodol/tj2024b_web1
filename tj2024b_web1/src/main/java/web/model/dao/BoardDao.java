package web.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import lombok.Getter;
import lombok.NoArgsConstructor;
import web.model.dto.BoardDto;


@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
// private 생성자가 자동 생성
public class BoardDao extends Dao{
	
	@Getter
	// 싱글톤을 반환하는 메소드를 자동 생성, getInsetance()자동 생성
	private static BoardDao instance = new BoardDao();
	
	// [1] 글쓰기 SQL 메소드
	public boolean write(BoardDto boardDto) {
		try {
			String sql = "insert into board (btitle, bcontent, mno, cno) values(?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, boardDto.getBtitle());
			ps.setString(2, boardDto.getBcontent());
			ps.setInt(3, boardDto.getMno());
			ps.setInt(4, boardDto.getCno());
			int count = ps.executeUpdate();
			if(count == 1) {
				return true;
			}
		}catch(SQLException e) {System.out.println(e);}

		return false;
	}
	
	
	// [2] 게시물 전체 조회
	public ArrayList<BoardDto> findAll(int cno) {
		ArrayList<BoardDto> list = new ArrayList<BoardDto>();
		try {
			// (1) 게시물 테이블의 모든 속성을 전체 조회
			//String sql = "select * from board";
			// (2) 게시물 테이블의 모든 속성과 회원 테이블의 mid 속성까지 조회하려면
				// inner join : 다른 테이블과 함께 조회할 때, join 조건은 주로 : PK-FK
			// select * from 테이블1 inner join 테이블2 on 테이블1.PK필드명 = 테이블2.FK필드명;
			// (3) + 02.07 카테고리별 출력 cno 조건 추가
			String sql = "select * from board b inner join member m on b.mno = m.mno "
					+ "where cno = ? "
					+ "order by b.bno asc";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, cno);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				BoardDto boardDto = new BoardDto();
				boardDto.setBno(rs.getInt("bno"));
				boardDto.setBtitle(rs.getString("btitle"));
				boardDto.setBcontent(rs.getString("bcontent"));
				boardDto.setBview(rs.getInt("bview"));
				boardDto.setBdate(rs.getString("bdate"));
				boardDto.setCno(rs.getInt("cno"));
				boardDto.setMno(rs.getInt("mno"));
				boardDto.setMid(rs.getString("mid")); // 회원테이블과 조인한 결과 회원아이디도 조회 가능하다
				list.add(boardDto);
			}
		}catch(SQLException e) {System.out.println(e);}
		return list;
	}
	
	// [3] 게시물 개별 삭제
	public boolean delete(int bno) {
		try {
			String sql = "delete from board where bno = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, bno);
			int c = ps.executeUpdate();
			if(c == 1) {
				return true;
			}
		}catch(SQLException e) {System.out.println(e);}
		return false;
	}
	
	
	// [4] 게시물 개별 수정
	public boolean update(BoardDto boardDto) {
		try {
			String sql = "update board set btitle = ?, bcontent = ? where bno = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, boardDto.getBtitle());
			ps.setString(2, boardDto.getBcontent());
			ps.setInt(3, boardDto.getBno());
			int c = ps.executeUpdate();
			if(c == 1) {
				return true;
			}
		}catch(SQLException e) {System.out.println(e);}
		
		return false;
	}
	
	
	// [5] 게시물 개별 조회
	public BoardDto findByBno(int bno) {
		try {
			// (1) 
			//String sql = "select * from board where bno = ?";
			// (2) 게시물테이블과 회원테이블의 교집합을 구해서 회원아이디로 조회 가능
			//String sql = "select * from board b inner member b on b.mno = m.mno";
			// (3) 게시물테이블, 회원테이블, 카테고리테이블의 교집합을 구해서 회원아이디, 카테고리명 조회 가능
			String sql = "select * from board b "
					+ "inner join member m on b.mno = m.mno "
					+ "inner join category c on b.cno = c.cno where bno = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, bno);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) { // while 아닌 if 쓰는 이유 : 개별 조회니까 반복 불필요
				BoardDto boardDto = new BoardDto();
				boardDto.setBno(rs.getInt("bno"));
				boardDto.setBtitle(rs.getString("btitle"));
				boardDto.setBcontent(rs.getString("bcontent"));
				boardDto.setBview(rs.getInt("bview"));
				boardDto.setBdate(rs.getString("bdate"));
				boardDto.setCno(rs.getInt("cno"));
				boardDto.setMno(rs.getInt("mno"));
				boardDto.setMid(rs.getString("mid")); // 회원테이블과 join 결과 회원 아이디 출력 가능
				boardDto.setCname(rs.getString("cname")); // 카테고리테이블과 join 결과 카테고리명 출력 가능
				return boardDto;
			}
			
		}catch(SQLException e) {System.out.println(e);}
		return null;
	}
}

























