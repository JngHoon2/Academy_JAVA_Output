package com.javaworks.shopping.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaworks.shopping.dao.CartDao;
import com.javaworks.shopping.model.Cart;
import com.javaworks.shopping.model.User;
import com.javaworks.shopping.util.DbConn;


@WebServlet("/mypage/cartList")
public class CartListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CartListServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("여기는 CartListServelt의 doGet()메소드입니다.");
		String userId = "";
		String url = "/WEB-INF/views/mypage/cartList.jsp";
		
		// 센션을 통해서 로그인 유무 확인, 안했으면 로그인 페이지로 이동
		// 자바스크립트에서 확인했지만 서버단에서 한번 더 확인
		User user = (User)request.getSession().getAttribute("user");
		//System.out.println("user : " + user.toString());
		
		if(user == null || user.getUserId().equals("")) {	// 세션이 없으면 로그인 페이지로 이동
			//url = "/WEB-INF/views/user/login.jsp";		// LoginCheckFilter 필터에 걸었기 때문에 여기서 이 코드는 필요 없음
		}else {
			userId = user.getUserId();
			
			// 사용자의 카트 조회
			CartDao cartDao = new CartDao(DbConn.getConnection());
			List<Cart> carts = cartDao.getAllCarts(userId);
			int totalAmt = 0;
			for (Cart cart : carts) {
				totalAmt += cart.getUnitPrice() * cart.getQuantity();
			}
			System.out.println("총합계금액 : totalAmt : " + totalAmt);
			
			request.setAttribute("carts", carts);
			request.setAttribute("totalAmt", totalAmt);
			request.setAttribute("userId", userId);						
		}		

		RequestDispatcher rds = request.getRequestDispatcher(url);
		rds.forward(request, response);	
		//response.sendRedirect(url);
	}

	/**
	 * 미사용
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("여기는 CartListServlet의 doPost()메소드입니다.");

		// 1. 세션에서 로그인 유무 확인 
		// 2. 파라미터 받기
		// 3. 받은 파라미터를 비즈니스 로직에 보내서 원하는 결과 받아오기(카트에 저장후 조회)
		// 4. 받아온 결과를 최종 화면으로 보내기
		
		/*

		String userId = "";
		
		// 로그인 유무 확인(로그인 안했으면 userId가 없어서 cart 테이블에 저장 불가)
		if(request.getSession().getAttribute("user") != null) {
			User user = (User)request.getSession().getAttribute("user");
			userId = user.getUserId();
		}else {		// 세션이 없으면 login.jsp 페이지로 이동
			response.sendRedirect(request.getContextPath() + "/WEB-INF/views/user/login.jsp");
			return;
		}

		// 비지니스 로직으로 파라미터 전달해서 저장
		CartDao cartDao = new CartDao(DbConn.getConnection());

		// 해당 사용자의 전체 cart 조회		
		List<Cart> carts = cartDao.getAllCarts(userId);
		request.setAttribute("carts", carts);
		
		RequestDispatcher rds = request.getRequestDispatcher(request.getContextPath() + "/WEB-INF/views/mypage/cartList.jsp");
		rds.forward(request, response);
			
		*/
	}
	
}
