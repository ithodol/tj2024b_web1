package day06;

import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class ParkingUserDao {
	private Connection conn;
	
	// 싱글톤
	private static ParkingUserDao instance = new ParkingUserDao();
	private ParkingUserDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb0123","root","1234");
		}catch(Exception e) {System.out.println(e);}
	}
	public static ParkingUserDao getInstance() {return instance;}

	
	// 입차
	public boolean inCar(ParkingDto parkingDto) {
		try {
			String sql = "insert into parking(carNum,carLo,outCar) values(?,?,null); ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, parkingDto.getCarNum());
			ps.setInt(2, parkingDto.getCarLo());
			int c = ps.executeUpdate();
			if(c == 1) {return true;}
		}catch(SQLException e) {System.out.println(e);}
		return false;
	}
	
	
	
	// 출차
	public boolean outCar(ParkingDto parkingDto) {
		try {
			 LocalDateTime now = LocalDateTime.now();
		     Timestamp timestamp = Timestamp.valueOf(now);
			String sql = "update parking set state = false, outCar = ? where cno = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setTimestamp(1, timestamp);
			ps.setInt(2, parkingDto.getCno());
			int c = ps.executeUpdate();
			if(c == 1) {return true;}
		}catch(SQLException e) {System.out.println(e);}
		return false;
	}
	
	
	
}





















