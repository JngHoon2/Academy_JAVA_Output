package com.javaworks.shopping.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javaworks.shopping.dao.ProductDao;
import com.javaworks.shopping.model.Product;
import com.javaworks.shopping.model.User;
import com.javaworks.shopping.util.DbConn;


@WebServlet(urlPatterns = {"/index"})
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public IndexServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("여기는 IndexServlet >> doGet() 메소드입니다.!!!!");
		String url = "/WEB-INF/views/index/index.jsp";

		List<Product> proList = new ArrayList<Product>();
		ProductDao pDao = new ProductDao(DbConn.getConnection());
		proList = pDao.getAllProducts();
		List<Product> recentProducts = pDao.getRecentProducts();
		List<Product> hitProducts = pDao.getHitProducts();
		
		//1. 세션에서 사용자 아이디 갖고오기
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		
		request.setAttribute("products", proList);
		request.setAttribute("recentProducts", recentProducts);
		request.setAttribute("hitProducts", hitProducts);
		request.setAttribute("user", user);
		
		RequestDispatcher rds = request.getRequestDispatcher(url);
		rds.forward(request, response);		

	}

}
