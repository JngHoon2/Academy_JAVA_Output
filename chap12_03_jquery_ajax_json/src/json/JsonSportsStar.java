package json;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;
import dto.SportsStar;

@WebServlet("/starSend")
public class JsonSportsStar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		doHandle(request, response);
	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");

		System.out.println("여기는 JsonSportsStar doHandle() 메소드");
		
		// ajax를 통해서 전송된 파라미터 추출
		// data : { jsonStar: jsonStarInfo}(클라이언트측)
		String jsonInfo = request.getParameter("jsonStar");
		
		/******* 클라이언트에서 받은 JSON 문자열    --------> 자바 객체로 매핑 ******/
		/******* 클라이언트에서 받은 JSON 문자열    --------> 자바 객체로 매핑 ******/		
			
		/*
		 * [방법.1] 자바스크립트에서 넘어온 Json 형태의 문자열을 자바 객체로 매핑
		 *  - JSONObject, JSONParser 이용, 다소 복잡함
		 */
		/*
		String name = "";
		int age = 0;
		String  gender = "";
		String nickname = "";
		
		JSONParser jsonParser = new JSONParser(); 
		JSONObject jsonObject = (JSONObject) jsonParser.parse(jsonInfo); //파싱(해석)
		
		name = (String)jsonObject.get("name");
		age = Integer.parseInt((String)jsonObject.get("age"));
		gender = (String)jsonObject.get("gender");
		nickname = (String)jsonObject.get("nickname");
		
		// 자바 객체 생성해서 전달받은 값 저장
		SportsStar star = new SportsStar();
		star.setName(name);
		star.setAge(age);
		star.setGender(gender);
		star.setNickname(nickname);
		System.out.println("파라미터 : " + star.toString());
		*/
		
		/*
		 * [방법.2] 자바스크립트에서 넘어온 Json 형태의 문자열를 자바 객체로 매핑
		 *  - 구글에서 제공하는 Gson 사용, 문법이 간단하고 사용하기 편함.
		 */
		Gson gson = new Gson();
		gson = new Gson();
		// jsonInfo 문자열을 SportsStar 자바 객체로 변환(매핑, 바인딩)
		SportsStar gstar = gson.fromJson(jsonInfo.toString(), SportsStar.class);
		System.out.println(gstar.toString());
		
		
		/********** 자바 객체    --------> JSON 문자열로 변환(직렬화) **********/
		/********** 자바 객체    --------> JSON 문자열로 변환(직렬화) **********/
		
		/*
		 * [1.방법] 클라이언트로 보내기 위해서 자바 객체를 JSON형태로 변환
		 *  - JSONObject 사용
		 */
		 /*
		JSONObject sportStarJsonObject = new JSONObject();
		sportStarJsonObject.put("name", name);
		sportStarJsonObject.put("age", age);
		sportStarJsonObject.put("gender", gender);
		sportStarJsonObject.put("nickname", nickname);
		
		JSONObject wrapJsonOpject = new JSONObject();
		wrapJsonOpject.put("sportsStar", sportStarJsonObject);

		String jsonStarInfo = wrapJsonOpject.toJSONString();
		System.out.println("json 문자열로 변환된 형태 : " + jsonStarInfo.toString());
		*/
		
		/*
		 * [2.방법] 클라이언트로 보내기 위해서 자바 객체를 JSON형태로 변환
		 *  - Gson 라이브러리를 이용해서 자바 객체를 json 형태로 변환
		 */
		String jsonString = gson.toJson(gstar);
		
		System.out.println("json 문자열로 변환된 형태 jsonString: " + jsonString);
		PrintWriter out = response.getWriter();
		out.print(jsonString);	// 클라이언트에게 전송, 이거 안하면 클라이언트에게 전달안됨.

	}
}