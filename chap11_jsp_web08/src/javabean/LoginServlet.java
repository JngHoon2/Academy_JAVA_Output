package javabean;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javafx.scene.control.Alert;
import sun.rmi.server.Dispatcher;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		MemberDAO dao = MemberDAO.getInstance();
		
		MemberBean member = null;
		
		member = dao.getMember(id, pwd);
		
		if(member == null) {
			System.out.println("로그인 실패");
		} else {
			System.out.println("로그인 성공");
			HttpSession session = request.getSession();
			// 4.5 세션에 객체 저장(Jsp에서 꺼내 쓸때는 ${sessionScope.user.userName}
			// member라는 이름으로 member객체 저장
			session.setAttribute("member", member);
			
			// 4.6 세션의 유지 시간 설정
			session.setMaxInactiveInterval(3600);	// 세션 유지 시간 지정(옵션, 초단위)
			System.out.println("로그인에 성공하여 세션에 사용자 정보 저장 : " + member.toString());
			String contextPath = request.getContextPath();
			String url = contextPath + "/session/welcome.jsp";
			response.sendRedirect(url);	
		}
		
		
//		ArrayList<MemberBean> memberList = dao.listMembers();
//				
//		for(MemberBean m : memberList) {
//			if(m.getId().equals(id)) {
//				if(m.getPwd().equals(pwd)){
//					// 로그인되는 부분
//					System.out.println("로그인 완료");
//					break;
//				} else {
//					
//					System.out.println("비밀번호 불일치.");
//					break;
//				}
//			} else {
//				System.out.println("생성된 아이디가 없음.");
//				continue;
//			}
//			
//		}
	}
}
