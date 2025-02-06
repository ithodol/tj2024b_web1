package day05.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BoardDao {
	private Connection conn;
	
	// 싱글톤
	private static BoardDao instance = new BoardDao();
	private BoardDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/board","root","1234");
		}catch(Exception e) {System.out.println(e);}
	}
	public static BoardDao getInstance() {return instance;}
	
	
	// 게시물 등록
	public boolean write(BoardDto boardDto) {
		try {
			String sql = "insert into board(bno, btitle, bcontent, bwriter, bpwd) values(?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, boardDto.getBno());
			ps.setString(2, boardDto.getBtitle());
			ps.setString(3, boardDto.getBcontent());
			ps.setString(4, boardDto.getBwriter());
			ps.setString(5, boardDto.getBpwd());
			//ps.setString(6, boardDto.getBdate());
			//ps.setInt(7, boardDto.getBview());
			int c = ps.executeUpdate();
			if(c == 1) {return true;}			
		}catch(SQLException e) {System.out.println(e);}
		return false;
	}
	

	// 게시물 전체 조회 / select
	public ArrayList<BoardDto> printAll(){
		ArrayList<BoardDto> list = new ArrayList<BoardDto>();
		try {
			String sql = "select * from board;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				BoardDto boardDto = new BoardDto();
				boardDto.setBno(rs.getInt("bno"));
				boardDto.setBtitle(rs.getString("btitle"));
				boardDto.setBcontent(rs.getString("bcontent"));
				boardDto.setBwriter(rs.getString("bwriter"));
				boardDto.setBpwd(rs.getString("bpwd"));
				boardDto.setBdate(rs.getString("bdate"));
				boardDto.setBview(rs.getInt("bview"));
				list.add(boardDto);
			}
		}catch(SQLException e) {System.out.println(e);}
		return list;
	}
	
	
	// 게시물 개별 조회
	public BoardDto printById(int bno) {
		try {
			String sql = "select * from board where bno = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, bno);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				BoardDto boardDto = new BoardDto();
				boardDto.setBno(rs.getInt("bno"));
				boardDto.setBtitle(rs.getString("btitle"));
				boardDto.setBcontent(rs.getString("bcontent"));
				boardDto.setBwriter(rs.getString("bwriter"));
				boardDto.setBpwd(rs.getString("bpwd"));
				boardDto.setBdate(rs.getString("bdate"));
				boardDto.setBview(rs.getInt("bview"));
				return boardDto;
			}
		}catch(SQLException e) {System.out.println(e);}
		return null;
	}
	
	
	
	
	// 게시물 수정
	public boolean update(BoardDto boardDto) {
		try {
			String sql = "update board set btitle = ?, bcontent = ? where bno = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, boardDto.getBtitle());
			ps.setString(2, boardDto.getBcontent());
			ps.setInt(3, boardDto.getBno());
			int c = ps.executeUpdate();
			if(c == 1) {return true;}
		}catch(SQLException e) {System.out.println(e);}
		return false;
	}
	

	
	// 게시물 삭제
	public boolean delete(int bno) {
		try {
			String sql = "delete from board where bno = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, bno);
			int c = ps.executeUpdate();
			if(c == 1) {return true;}
		}catch(SQLException e) {System.out.println(e);}
		return false;
	}
	
	
	
	
	
	
	
	
	
} // class end

