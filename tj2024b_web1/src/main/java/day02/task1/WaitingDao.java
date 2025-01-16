package day02.task1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class WaitingDao{
	private Connection conn;
	// 생성자
	private static WaitingDao instance = new WaitingDao();
	private WaitingDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/waiting","root","1234");
		}catch(Exception e) {System.out.println(e);}
	}
	public static WaitingDao getInstance() {return instance;}
	
	// 1. 대기열 등록
	public boolean write(int tel, int count) {
		try {
			String sql = "insert into waiting(tel, count) values(?, ?) ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, tel);
			ps.setInt(2, count);
			int c = ps.executeUpdate();
			if(c == 1) {return true;}
		}catch(SQLException e) {System.out.println(e);}
		
		return false;
	}
	
	
	// 2. 대기열 삭제
	public boolean delete(int num) {
		try {
			String sql = "delete from waiting where num = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, num);
			int c = ps.executeUpdate();
			if(c == 1) {return true;}
		}catch(SQLException e) {System.out.println(e);}
		return false;
	}
}
