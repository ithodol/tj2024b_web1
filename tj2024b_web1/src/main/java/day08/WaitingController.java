package day08;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.cj.Session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/day08/waiting")
public class WaitingController extends HttpServlet {
//	private ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String,String>>();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("post test");
		ObjectMapper mapper = new ObjectMapper();
		HashMap<String, String> map = mapper.readValue(req.getReader(), HashMap.class);
		System.out.println(map);
		
		HttpSession s =  req.getSession();
		Object object =  s.getAttribute("list");
		
		// 유효성 검사
		// 2개 이상 입력 불가
		// 왜? post 할 때 마다 list 를 새로 생성했기 때문
		//		=> ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String,String>>();
		ArrayList<HashMap<String, String>> list = null;
		if(object == null) { // object가 null 이면
			list = new ArrayList<HashMap<String,String>>();
			// 새로운 ArrayList 생성
		}else {
			list = (ArrayList<HashMap<String, String>>)object;
			// 아니면 기존 object 사용
		}

		list.add(map);
		// list에 map을 넣는다
		
		s.setAttribute("list", list);
		// 키값 "list"에 map을 넣은 list를 넣는다

		resp.setContentType("application/json");
		resp.getWriter().print(list);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("get test");
		
		HttpSession s =  req.getSession();
		Object object =  s.getAttribute("list");
		ArrayList<HashMap<String, String>> list = (ArrayList<HashMap<String, String>>)object;
													// set 할 때는 object 임
													// get 해서 사용할 때는 hashmap 으로 타입 변환 필요함
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonResult = mapper.writeValueAsString(list);;
		resp.setContentType("application/json");
		resp.getWriter().print(jsonResult);
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("put test");
		ObjectMapper mapper = new ObjectMapper();
		HashMap<String, String> map = mapper.readValue(req.getReader(), HashMap.class);
		System.out.println(map);
		
		HttpSession s =  req.getSession();
		Object object =  s.getAttribute("list");
		ArrayList<HashMap<String, String>> list = (ArrayList<HashMap<String, String>>)object;

		for(int index = 0; index <= list.size()-1; index++) {
			HashMap<String, String> map2 = list.get(index);
			if(map.get("wno").equals(map2.get("wno"))) { // map "wno" 새로운 값이 map2 "wno" 기존값과 같으면 
				map2.put("count", map.get("count")); // 기존값(map2) 에 새로운값(map)을 넣겠다
				map2.put("tel", map.get("tel"));
			}
		}
//		System.out.println(result);
		resp.setContentType("application/json");
		resp.getWriter().print(true);
	}
	
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("delete test");
		int wno = Integer.parseInt( req.getParameter("wno")); // 쿼리스트링 사용하기 위해 가져옴

		HttpSession s =  req.getSession();
		Object object =  s.getAttribute("list");
		ArrayList<HashMap<String, String>> list = (ArrayList<HashMap<String, String>>)object;
		
		for(int index = 0; index <= list.size()-1; index++) {
			HashMap<String, String> map2 = list.get(index);
			if(wno == Integer.parseInt(map2.get("wno"))) { // wno의 태생이 String이기때문에 Integer()로 강제 타입변환 불가능.
					// 대신 Integer.parseInt()로 직접 타입 변경
				//s.removeAttribute("wno");
				list.remove(index); // 
				break;
			} // if end
		} // for end
		
		resp.setContentType("application/json");
		resp.getWriter().print("wno");
		
	} // delete end
	
}


























