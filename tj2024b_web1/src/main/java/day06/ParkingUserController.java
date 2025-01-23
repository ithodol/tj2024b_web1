package day06;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day06/parking/user")
public class ParkingUserController extends HttpServlet{
	// 입차
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		ParkingDto parkingDto = mapper.readValue(req.getReader(), ParkingDto.class);
		
		boolean result = ParkingUserDao.getInstance().inCar(parkingDto);
		
		resp.setContentType("application/json");
		resp.getWriter().print(result);

	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("33");
	}
	
	// 출차(주차상태 변경) 
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		ParkingDto parkingDto = mapper.readValue(req.getReader(), ParkingDto.class);
		
		boolean result = ParkingUserDao.getInstance().outCar(parkingDto);
		
		resp.setContentType("application/json");
		resp.getWriter().print(result);
		
	}
}


















