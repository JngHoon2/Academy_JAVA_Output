package com.javaworks.shopping.servlet;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
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


@WebServlet("/mypage/deleteCart")
public class CartDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CartDeleteServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("여기는 CartDeleteServlet의 doGet()메소드입니다.");
		String userId = "";
		String contextPath = request.getContextPath();
		
		// 로그인 안했으면 로그인 페이지로 이동(자바스크립트에서 확인하고 재확인)
		User user = (User)request.getSession().getAttribute("user");
		if(user == null) {
			//response.sendRedirect("/WEB-INF/views/user/login.jsp");
			//return;			
		}else {
			userId = user.getUserId();		
		
			// 사용자의 카트 조회
			CartDao cartDao = new CartDao(DbConn.getConnection());
			List<Cart> carts = cartDao.getAllCarts(userId);
			int totalAmt = 0;
			for (Cart cart : carts) {
				totalAmt += cart.getUnitPrice() * cart.getQuantity();
			}
			
			String url = "/WEB-INF/views/mypage/cart.jsp";
			request.setAttribute("carts", carts);
			request.setAttribute("totalAmt", totalAmt);
			
			RequestDispatcher rds = request.getRequestDispatcher(url);
			rds.forward(request, response);	
		}		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 세션에서 로그인 유무 확인 
		// 2. 파라미터 받기
		// 3. 받은 파라미터를 비즈니스 로직에 보내서 원하는 결과 받아오기(카트에 저장후 조회)
		// 4. 받아온 결과를 최종 화면으로 보내기
		
		System.out.println("여기는 CartDeleteServlet의 doPost()메소드입니다.");
		String productId = "";
		String userId = "";
		String contextPath = request.getContextPath();
		
		// 로그인 유무 확인(로그인 안했으면 userId가 없어서 cart 테이블에 저장 불가)
		if(request.getSession().getAttribute("user") == null) {
			//response.sendRedirect(contextPath + "/login");	// 필터를 통해서 로그인 체크하기 때문에 필요 없어짐
			//return;
		}else {
			// 세션에서 userId 조회
			User user = (User)request.getSession().getAttribute("user");
			userId = user.getUserId();
		
			// 파라미터 받기  productId
			if(request.getParameter("productId") != null) {
				productId = request.getParameter("productId").trim();
			}
	
			// cart 삭제
			CartDao cartDao = new CartDao(DbConn.getConnection());
			cartDao.deleteCart(userId, productId);
			
			System.out.println("카트가 정상적으로 삭제되었습니다.");
			
			String url = contextPath + "/mypage/cartList";	
			response.sendRedirect(url);	//cart list servlet 호출
		}
	}

}
