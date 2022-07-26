package servlet01;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member")
public class MemberServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, 
						HttpServletResponse response)
						throws ServletException, IOException {

		// 1. 사용자에게 보낼 컨텐츠의 인코딩 타입 설정
		response.setContentType("text/html;charset = utf-8");

		// 2. 사용자의 브라우저에 출력할 객체 생성
		PrintWriter out = response.getWriter();

		// 3. 데이터베이스 관련 작업 담당 객체 생성
		MemberDAO dao = new MemberDAO();
		
		// 4. 데이터베이스 관련 담당 클래스에서 전달되온 ArrayList<MemberVO>를 담을 변수
		//ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		
		// 5. 회원목록을 받아옴
//		for(MemberVO vo : dao.listMembers()) {
//			list.add(vo);
//		}

		// 6. Html 생성
		out.print("<html><body>");
		out.print("<table  border = 1>");
		out.print("<tr align = 'center' bgcolor = 'lightgreen'>");
		out.print("<td>아이디</td><td>비밀번호</td><td>이름</td><td>이메일</td><td>가입일</td></tr>");

		for (MemberVO memberVO : dao.listMembers()) { // 따로 ArrayList를 만들 거면 list로 바꿀 것.
			String id = memberVO.getId();
			String pwd = memberVO.getPwd();
			String name = memberVO.getName();
			String email = memberVO.getEmail();
			Date joinDate = memberVO.getJoinDate();

			out.print("<tr>");
			out.print("<td>" + id + "</td>");
			out.print("<td>" + pwd + "</td>");
			out.print("<td>" + name + "</td>");
			out.print("<td>" + email + "</td>");
			out.print("<td>" + joinDate + "</td>");
			out.print("</tr>");
		}
		out.print("</table></body></html>");
	}
}