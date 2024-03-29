package com.javaworks.shopping.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javaworks.shopping.dao.CartDao;
import com.javaworks.shopping.model.Cart;
import com.javaworks.shopping.model.User;
import com.javaworks.shopping.util.DbConn;


@WebServlet("/insertCart")
public class InsertCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public InsertCartServlet() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("여기는 InsertCartServlet의 doPost()메소드입니다.");

		//1. 세션에서 사용자 아이디 받기
		//2. 사용자 아이디 없으면 로그인 안해서 로그인 페이지로 이동
		//3. 파라미터 받기(상품ID, 수량)
		//4. 무결성체크(중복체크) : 중복이면 기존 자료 업데이트, 없으면 저장
		
		String contextPath = request.getContextPath();	// /ShoppingCart
		System.out.println("contextPath : " + contextPath);
		String url = contextPath + "/mypage/cartList";			// 카트 저장후 이동할 경로 ex) ShoppingCart/cartList
		System.out.println("url : " + url);
		String userId = "";
		
		//1. 세션에서 사용자 아이디 받기(로그인 확인)
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		if(user == null) {
			//url = "/login";		//2. 로그인 페이지로 이동
		}else {
			//3. 파라미터 받기
			userId = user.getUserId();
			String proudctId = request.getParameter("productId");
			int quantity = Integer.parseInt(request.getParameter("quantity"));
			int unitPrice = Integer.parseInt(request.getParameter("unitPrice"));
			Cart cart = new Cart(userId, proudctId, quantity, unitPrice);
			
			//4. 무결성체크(중복체크)
			CartDao cartDao = new CartDao(DbConn.getConnection());
			
			boolean cartExist = cartDao.cartExist(cart);			
			if(cartExist) {		//이미 존재하면 update
				System.out.println("기존 카트가 있어서 업데이트");
				cartDao.updateCart(cart);
			}else {				//없으면 insert
				System.out.println("기존 카트가 없어서 저장");
				cartDao.insertCart(cart);
			}
		}
		
		/*
		 * [포워드 or 리다이렉트?]
		 * 1. 포워드
		 *	카트에 저장하고 RequestDispatcher forward시키면 처음 요청방식인 post가 그대로 유지되어 
		 *  cartListServlet의 doPost()메소드를 찾아서 실행하려고 한다. 오류 난다. 맞지도 않는다.
		 * 2. 리다이렉트
		 *  response.sendRedirect시키면 cartListServlet의 doGet()이 호출되어 저장한 카트 리스트가
		 *  조회된다. 맞다. 
		 *  저장후 리다이렉트를 시키면 사용자가 실수로 [F5]키를 눌러서 중복 저장하는 것을 막을 수도 있다.
		 */
		
		//RequestDispatcher rds = request.getRequestDispatcher(url);
		//rds.forward(request, response);		

		/*
		 * cartListServlet을 호출한다. 이때 사용자 아이디를 쿼리스트링으로 달아서 보낸다.
		 * 그래야 누구의 카트를 조회할지 알 수 있기 때문이다.
		 * 아이디를 쿼리스트링으로 달아서 보내지 않고 CartListServlet에서 세션조회 해서 
		 * 로그인 사용자의 아이디를 추출해서 사용해도 됨.		  
		 */
		response.sendRedirect(url + "?userId=" + userId);
	}

}
