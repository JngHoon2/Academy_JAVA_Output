package com.javaworks.shopping.servlet;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javaworks.shopping.dao.CartDao;
import com.javaworks.shopping.dao.OrderDao;
import com.javaworks.shopping.model.OrderHeader;
import com.javaworks.shopping.model.OrderItem;
import com.javaworks.shopping.model.User;
import com.javaworks.shopping.util.DbConn;

@WebServlet("/mypage/insertOrder")
public class InsertOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InsertOrderServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*[순서]
		*/
		String contextPath = request.getContextPath();
		String url = contextPath + "/mypage/orderList";	// 주문이 정상 저장된 후 이동할 경로 response.sendRedirect(url)
		
		// 1. 세션에서 사용자 아이디 갖고와서 로그인 유무 확인
		String userId = "";
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		// 로그인 유무 확인(로그인 안했으면 userId가 없어서 cart 테이블에 저장 불가)
		if(user != null) {
			user = (User)request.getSession().getAttribute("user");
			userId = user.getUserId();
		}else {		// 로그인 정보 없으면 login.jsp 페이지로 이동 -> 로그인 체크 필터를 통해서 처리하기 때문에 주석처리함
			//response.sendRedirect(contextPath + "/views/user/login.jsp");	//필터에서 담당하므로 필요 없음
			//return;
		}		
		
		// 2. 파라미터 받기
		//Order Header 정보 1건
		String address = "";
		String paymentMethod = "";
		int totalAmt = 0;
		//Order item에 들어갈 정보 여러건
		String arrProduct[] = null;
		String arrQuantity[] = null;
		String arrUnitPrice[] = null;
		
		//Order Header 항목
		//address
		if(!request.getParameter("address").isEmpty()){
			address = request.getParameter("address").trim();
		}
		//total amt
		if(!request.getParameter("totalAmt").isEmpty()){
			totalAmt = Integer.parseInt(request.getParameter("totalAmt").trim());
		}
		//payment method
		if(!request.getParameter("paymentMethod").isEmpty()){
			paymentMethod = request.getParameter("paymentMethod").trim();
		}		
		
		System.out.println(paymentMethod);
		
		// Order Item 항목
		// productId
		if(request.getParameterValues("productId") != null){	//isEmpty()를 써도됨.
			arrProduct = request.getParameterValues("productId");
		}
		// quantity
		if(request.getParameterValues("quantity") != null){
			arrQuantity = request.getParameterValues("quantity");
		}
		// unitPrice
		if(request.getParameterValues("unitPrice") != null){
			arrUnitPrice = request.getParameterValues("unitPrice");
		}
		
		//3. 저장작업 : Order Header는 한번 저장, OrderItem은 여러번(상품ID 수만큼 반복)
		//3-1 헤더 저장
		OrderHeader orderHeader = new OrderHeader();
		orderHeader.setUserId(userId);
		orderHeader.setAddress(address);
		orderHeader.setTotalAmt(totalAmt);
		orderHeader.setPaymentMethod(paymentMethod);
		
		OrderDao orderDao = new OrderDao(DbConn.getConnection());
		int orderId = orderDao.insertOrderHeader(orderHeader);
		
		int i = 0;	//Order Item이 정상적으로 저장되었는지 확인
		Set<String> setCarts = new HashSet<String>();	//Set은 중복 없이 저장 가능한 콜렉션
		
		//3-2 Item 저장 - 위에서 저장한 OrderHeader의 orderId필요(Order Item에 넣어야 됨)
		if(orderId > 0) {	//헤더가 정상적으로 저장되었으면
			for(i=0; i<arrProduct.length; i++) {
				OrderItem orderItem = new OrderItem();

				orderItem.setOrderId(orderId);
				orderItem.setProductId(arrProduct[i]);
				orderItem.setQuantity(Integer.parseInt(arrQuantity[i]));
				orderItem.setUnitPrice(Integer.parseInt(arrUnitPrice[i]));

				orderDao.insertOrderItem(orderItem);	// 디비에 저장
				setCarts.add(arrProduct[i]);			// 여기에 보관했다가 카트 비울때 사용
			}			 
		}
		
		//4. 주문이 저장되었으면 카트를 비운다.(카트 중에서 주문이 된 항목들만 선별적으로 지워야 한다)		
		if(i > 0) {
			CartDao cartDao = new CartDao(DbConn.getConnection());
			for (String productId: setCarts) {
				cartDao.deleteCart(userId, productId);
			}
		}
		
		//5. 저장후 주문  주문 조회화면으로 이동하기 위해서 OrderList 서블릿 호출
		//	 여기서 곧바로 orderList.jsp를 호출하게 되면 보내는 것이 없어서 빈 화면이 나오게됨.
		//	 sendRedirect하게 되면 OrderListServlet을 get방식으로 호출하게 됨.
		session.setAttribute("orderId", orderId);	// OrderList 서블릿에서 사용하도록 세션에 담아줌(리다이렉트는 request에 값을 담을 수 없으니, 쿼리스트링에 달아서 보내도 됨. url?orderId=)
		response.sendRedirect(url);
		
	}

}

