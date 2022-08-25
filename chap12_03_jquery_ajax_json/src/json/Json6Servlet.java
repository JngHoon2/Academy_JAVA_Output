package json;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
/**
 * 서블릿
 * - JSONObject, JSONArray 자바 객체의 JSON문자열 변환 역할
 * - json-simple-1.1.1.jar 라이브러리 필요함
 * 
 */
@WebServlet("/json2")
public class Json6Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);
	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 캐릭터 인코딩(한글관련 깨짐 방지)
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		// 클라이언트에 쓰기 위한 객체 
		PrintWriter writer = response.getWriter();

		/*
		 * 1. 복잡한 형태의 자바 객체를 JSON 문자로 변환하기 위해서 중간단계로 JSON객체로 변환
		 * 2. 중간 단계의 JSON 객체를 다시 JSON 문자열로 변환
		 * 3. 자바객체 -> JSON객체 -> JSON문자열
		 * - org.json.simple.JSONObject
		 */
		JSONObject totalObject = new JSONObject();
		// 자바 객체 여러개를 JSON으로 변환될 객체에 담는 역할
		JSONArray membersArray = new JSONArray();
		// 자바 객체 하나를 JSON으로 변환될 객체에 담는 역할
		JSONObject memberInfo = new JSONObject();

		// JSONObject 타입 객체 한개 생성
		memberInfo.put("name", "박지성");
		memberInfo.put("age", "25");
		memberInfo.put("gender", "남자");
		memberInfo.put("nickname", "날센돌이");
		
        // 만들어진 하나의 JSON객체를 배열에 저장
		membersArray.add(memberInfo);

		// JSONObject 타입 객체 한개 생성
		memberInfo = new JSONObject();
		memberInfo.put("name", "김연아");
		memberInfo.put("age", "21");
		memberInfo.put("gender", "여자");
		memberInfo.put("nickname", "칼치");
		
		// 만들어진 하나의 JSON객체를 배열에 저장
		membersArray.add(memberInfo);

		// 최종적으로 만들어진 JSON객체를 "members"라는 이름으로 저장
		totalObject.put("members", membersArray);

		// JSON객체를 JSON문자열로 변환(직렬화)
		String jsonInfo = totalObject.toJSONString();
		System.out.print(jsonInfo);
		
		writer.print(jsonInfo); // 클라이언트에 쓰기
	}

}