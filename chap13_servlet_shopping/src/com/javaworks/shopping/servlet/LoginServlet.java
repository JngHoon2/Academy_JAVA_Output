package com.javaworks.shopping.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.valves.rewrite.Substitution;

import com.javaworks.shopping.dao.UserDao;
import com.javaworks.shopping.model.User;
import com.javaworks.shopping.util.DbConn;

/**
 * [로그인 서블릿]
 *  - 하나의 서블릿에서 요청방식(get/post)에 따라서 두 가지의 역할을 한다.
 *  1. doGet() 
 *   - get 방식 요청 : 로그인 폼 화면을 열어주는 역할  
 *  2. doPost() 
 *   - post 방식 요청
 *   - 로그인 폼에서 아이디와 비밀번호를 입력하고 로그인 버튼을 눌렀을때 로그인 처리하는 역할
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

    /*
     * 로그인 폼 화면을 띄워주는 역할
     *  1. 로그인 화면을 띄워준다.
     *  2. 만약에 세션에 사용자 정보가 있으면 이미 로그인을 했으므로 index.jsp 화면으로 강제로 이동한다.
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("여기는 LoginServelt의 doGet()메소드입니다.");

		String pageName = "";
		String productId = "";
		String url = "/WEB-INF/views/user/login.jsp";	//화면을 직접 띄울때는 반드시 /WEB-INF부터 시작되는 정식 경로를 다 적어야 한다.

		// 이미 로그인을 했으면 index.jsp페이지로 이동
		if(request.getSession().getAttribute("user") != null){
			url = "/WEB-INF/index.jsp";
		}else {
			// pageName과 productId는 로그인 후에 그 이전 페이지로 이동하기 위해서 필요함.
			// 사실 로그인 후에는 메인 화면으로 이동하고 해당 상품을 찾아가도록 해도 무방하다.
			// 단지 사용자의 편의를 위해서 추가한 코드이니 구현하지 않아도 상관없다.
			if(request.getParameter("pageName") != null) {
				pageName = request.getParameter("pageName").trim();		
			}			
			if(request.getParameter("productId") != null) {
				productId = request.getParameter("productId").trim();	
			}
			request.setAttribute("pageName", pageName);		// 로그인 성공후에 찾아갈 페이지(로그인 이전 화면)
			request.setAttribute("productId", productId);	// 로그인 성공후에 찾아갈 상품상세 페이지에 그 전에 보던 상품을 보여주기 위해서 필요
		}
		
		RequestDispatcher rds = request.getRequestDispatcher(url);
		rds.forward(request, response);		
		
	}

	// 로그인 페이지에서 아이디 비밀번호를 넣고 [로그인] 버튼 눌렀을 때
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("여기는 LoginServelt의 doPost()메소드입니다.");
		
		String pageName = ""; 
		String productId = "";		
		String url = "/WEB-INF/views/user/login.jsp";	//로그인 실패시 이동하는 페이지(다시 자신의 페이지)
		String userId = "";
		String userPwd = "";
		
		// 아이디 비밀번호 파라미터 추출
		if (request.getParameter("userId") != null) {
			userId = request.getParameter("userId").trim();			
		}
		if (request.getParameter("userPwd") != null) {
			userPwd = request.getParameter("userPwd").trim();			
		}
		
		// userId 널 체크
		if(userId.isEmpty() || userId == null) {
			request.setAttribute("userIdErr", Boolean.TRUE);
		}
		// userPwd 널 체크
		if(userPwd.isEmpty() || userPwd == null) {
			request.setAttribute("userPwdErr", Boolean.TRUE);
		}
		
		// userId or userPwd 오류가 있으면 다시 로그인 페이지로 이동
		if(request.getAttribute("userIdErr") != null || request.getAttribute("userPwdErr") != null) {
			//System.out.println("userId와 userPwd 둘중에 하나에 오류가 체크됨" + userId + " " + userPwd);
			RequestDispatcher rds = request.getRequestDispatcher(url);
			rds.forward(request, response);
		}else {
		
			/* userId, userPwd가 모두 입력된 경우에는 DB 확인 과정 진행 */			
			UserDao userDao = new UserDao(DbConn.getConnection());
			User user = userDao.login(userId, userPwd);
			
			if(user == null) {	// userId, userPwd에 맞는 사용자가 없을 경우
				// 로그인 오류 세팅
				request.setAttribute("idPwdNotMatch", Boolean.TRUE);	//Id and Password do not match
				System.out.println("아이디와 비밀번호가 맞지 않습니다.");
				RequestDispatcher rds = request.getRequestDispatcher(url);
				rds.forward(request, response);
				//return;	// return을 안해주면 다음 로직을 계속 수행해서 runtime error			
			}else {		// 로그인 성공
				// 세션에 사용자 정보 기록
				HttpSession session = request.getSession();
				session.setAttribute("user", user);		// 세션에 객체 저장(Jsp에서 쓸때는 ${sessionScope.user.userName}
				session.setMaxInactiveInterval(30000);	// 세션 유지 시간 지정(필요시)
				System.out.println("로그인에 성공하여 세션에 사용자 정보 저장 : " + user.toString());
	
				if(!request.getParameter("pageName").isEmpty()) {	// 상품 상세페이지에서 주문을 했는데 로그인이 안되어 있을 경우에는 로그인 후에 다시 그 페이지로 돌아가야 하기 때문에우 쿼리스트링에 상품ID 붙여서 보냄
					
					// 돌아갈 페이지와 상품정보 파라미터 추출
					pageName = request.getParameter("pageName").trim() ;	// 로그인 성공후에 찾아갈 페이지(로그인 이전 화면)	ex) /ShoppingCart/detailView
					productId = request.getParameter("productId").trim() ;	// 로그인 성공후에 상품 상세 페이지로 갈때 찾아갈 어떤 상품인지 상품ID를 달고감
					System.out.println("LoginServelt의 doPost()메소드 pageName : " + pageName);
					
					request.setAttribute("productId", productId);
					url = pageName;		// pageName : /ShoppingCart/detailView
					url = url + "?productId=" + productId;	//상품상세정보 서블릿(DetailViewServlet) 호출
					System.out.println("여기는 LoginServlet doPost()  url : " + url);
				}else {	// 일반적인 경우로서 그냥 로그인 버튼을 눌러서  온 경우에는 인덱스 페이지로 이동
					url = request.getContextPath() + "/index";		//index 서블릿 호출
					System.out.println(url);
				}
				response.sendRedirect(url);	
			}
		}
	}
}
