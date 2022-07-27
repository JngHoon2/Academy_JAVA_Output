package servlet01;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet01.MemberVO;

@WebServlet("/member")
public class MemberServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("여기는 MemberServlet doGet");
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("여기는 MemberServlet doPost");
		doHandle(request, response);
	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("여기는 doHandle()");
		
		// 1. 사용자가 입력한 한글 정보의 인코딩 처리
		request.setCharacterEncoding("utf-8");
		
		// 2. 사용자에게 보낼 컨텐츠의 인코딩 처리
		response.setContentType("text/html; charset = utf-8");

		// 3. 데이터베이스 핸들링 담당 객체 생성
		MemberDAO dao = new MemberDAO();

		// 4. 클라이언트의 브라우저에 쓸 객체 생성
		PrintWriter out = response.getWriter();
		
		// 5. 클라이언트(사용자)가 보낸 파라미터 추출
		//    회원가입폼에서 숨은 필드로 addMember를 보냄
		String command = request.getParameter("command"); 
		System.out.println("MemberServlet : command " + command);

		// 6. 커멘드가 널이 아니고 addMember일 경우
		if (command != null && command.equals("addMember")) {
			// 6.1 입력한 정보 추출
			String _id = request.getParameter("id");
			String _pwd = request.getParameter("pwd");
			String _name = request.getParameter("name");
			String _email = request.getParameter("email");

			// 6.2 입력받은 정보로 MemberVO객체 생성
			MemberVO vo = new MemberVO();
			vo.setId(_id);
			vo.setPwd(_pwd);
			vo.setName(_name);
			vo.setEmail(_email);

			// 6.3 생성된 MemberVO객체를 MemberDAO의 insertMember()
			//    메소드에 전달해서 데이터베이스 저장하도록 작업
			dao.insertMember(vo);
		// 7. 커맨드가 delMember이면 키(id)만 delMember(id) 넘겨서 삭제작업
		} else if (command != null && command.equals("delMember")) {
			String id = request.getParameter("id");
			dao.delMember(id);
		}

		// 8. 입력,삭제 작업 후에 회원 조회 리스트 보여줌
		ArrayList<MemberVO> list = dao.listMembers();
		
		out.print("<html><body>");
		out.print("<table  border  =  1>");
		out.print("<tr align = 'center' bgcolor = 'lightgreen'>");
		out.print("<td>아이디</td><td>비밀번호</td><td>이름</td><td>이메일</td><td>가입일</td><td>삭제</td></tr>");

		// 9. ArrayList에 있는 회원 객체들을 하나씩 뽑아서 바로 사용자에게 전송
		for (MemberVO memberVO : list) {
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
			out.print("<td><a href = '/chap10_servlet_web05/member?command=delMember&id=" + id + "'>회원삭제 </a></td>");
			out.print("</tr>");
			
//			out.print("<tr><td>" + id + "</td><td>" + pwd + "</td><td>" + name + "</td><td>" + email + "</td><td>"
//					+ joinDate + "</td><td>" + "<a href = '/chap10_servlet_web04/member4?command=delMember&id=" + id + "'>회원삭제 </a></td></tr>");

		}
		out.print("</table></body></html>");
		out.print("<a href = '/chap10_servlet_web05/memberForm.html'>회원가입</a");
	}
}