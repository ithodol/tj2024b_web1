package day03.task1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VisitDao {
	
	private Connection conn;
	// 싱글톤
	private static VisitDao instance = new VisitDao();
	private VisitDao() {
		// DB연동
		try {
				// DB연동 코드 : 코드 작성 전에 필수 : 프로젝트의 jdbc.jar build
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb0120", "root", "1234");
		}catch(Exception e) {System.out.println(e);}
		
	}
	public static VisitDao getInstance() {return instance;}
	
	// 1. 방문록 등록 SQL
	public boolean write(VisitDto visitDto) {
		
		try {
			String sql = "insert into visit(content, age) values(?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, visitDto.getContent());
			ps.setInt(2, visitDto.getAge());
			int count = ps.executeUpdate();
			if(count == 1) return true;
		}catch(SQLException e) {System.out.println(e);}
		return false;
		
	}
	
	// 4. 방문자 삭제 SQL
	public boolean delete(int num) {
		try {
			String sql = "delete from visit where num = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, num);
			int count = ps.executeUpdate();
			if( count == 1) return true;
		}catch(SQLException e){System.out.println(e);}
		return false;
	}
	
	
	
	
}
























