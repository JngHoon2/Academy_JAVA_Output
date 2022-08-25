package json;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import dto.SportsStar;


@WebServlet("/starList")
public class JsonSportsStarList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		doHandle(request, response);
	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("여기는 JsonSportsStar doHandle() 메소드");

		// 인코딩(한글 깨짐 방지)
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");

		/********** 클라이언트가 보내온 JSON 문자열을 자바 객체로 매핑, 역직렬화(자바빈 처럼) **********/
		
		// ajax를 통해서 전송된 파라미터 추출
		String jsonInfo = request.getParameter("jsonStar");

		Gson gson = new Gson();
		
		/********** JSON 문자열   ------>  자바 객체 **********/
		
		/*
		 * JSON에 저장된 데이터가 배열 형식일때 원래의 Data Type으로 만들기위해서 사용되는 코드
		 * TypeToken 클래스 : com.google.gson에서 제공하는 클래스
		 */
		
		Type userListType = new TypeToken<ArrayList<SportsStar>>(){}.getType();			 
		ArrayList<SportsStar> starList = gson.fromJson(jsonInfo, userListType);
		
		/********** 자바 객체 ------> JSON 문자열로 변환(직렬화) **********/

		//클라이언트로 보내기 위해서 자바 객체를 JSON 문자열 형태로 변환(직렬화) 
		String jsonListString = gson.toJson(starList);
		System.out.println(jsonListString);
		
		PrintWriter out = response.getWriter();
		out.print(jsonListString);	//클라이언트에 내려보냄
			
	}
}