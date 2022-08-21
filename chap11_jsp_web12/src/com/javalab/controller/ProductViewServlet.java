package com.javalab.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalab.dao.ProductDao;
import com.javalab.dto.Product;

@WebServlet("/productView.do")
public class ProductViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDao productDao = ProductDao.getInstance();

    public ProductViewServlet() {
    }

    // 상세보기 화면 호출
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("productView doPost()");

		int code = Integer.parseInt(request.getParameter("code"));

		Product product = productDao.selectProductByCode(code);
		
		System.out.println("ProductViewServlet product : " + product.toString());
		
		request.setAttribute("product", product);
		RequestDispatcher rd = request.getRequestDispatcher("productView.jsp");
		rd.forward(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
