package day03.task4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	public boolean write(WaitingDto waitingDto) {
		try {
			String sql = "insert into waiting(tel, count) values(?, ?) ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, waitingDto.getTel());
			ps.setInt(2, waitingDto.getCount());
			int c = ps.executeUpdate();
			if(c == 1) {return true;}
		}catch(SQLException e) {System.out.println(e);}
		
		return false;
	}
	
	// 3. 대기열 출력
	public ArrayList<WaitingDto> printAll(){
		ArrayList<WaitingDto> list = new ArrayList<WaitingDto>();
		try{
			String sql = "select * from waiting";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				WaitingDto waitingDto = new WaitingDto();
				waitingDto.setNum(rs.getInt("num"));
				waitingDto.setTel(rs.getString("tel"));
				waitingDto.setCount(rs.getInt("count"));
				list.add(waitingDto);
			}
			
		}catch(SQLException e) {System.out.println(e);}
		return list;
	}
	
	
	
	// 4. 대기열 수정
	public boolean update(WaitingDto waitingDto) {
		try {
			String sql = "update waiting set tel = ?, count = ? where num = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, waitingDto.getTel());
			ps.setInt(2, waitingDto.getCount());
			ps.setInt(3, waitingDto.getNum());
			int count = ps.executeUpdate();
			if(count == 1) {return true;}
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