package com.javaworks.shopping.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.javaworks.shopping.model.Product;

public class ProductDao {
	// 1. 커넥션 객체 획득
	// 2. 조회/삽입/수정/삭제 메소드 구현
	private Connection conn = null;
	private PreparedStatement psmt = null;
	private ResultSet rs = null;
	private Product product = null;
	private String sql = "";
	
	public ProductDao(Connection conn) {
		this.conn = conn;
	}
	
	//모든 상품 조회
	public List<Product> getAllProducts() {
		List<Product> products = new ArrayList<Product>();
		
		sql =  "SELECT p.product_id, p.product_name, p.category_id, c.category_name, p.unit_price, p.image  ";
		sql += " From product p LEFT OUTER JOIN category c ON p.category_id = c.category_id ";
		sql += " Order BY p.create_date DESC ";
		System.out.println(sql);
		try {
			psmt = this.conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				product = new Product();
				product.setProductId(rs.getString("product_id"));
				product.setProductName(rs.getString("product_name"));
				product.setCategoryName(rs.getString("category_name"));
				product.setUnitPrice(rs.getInt("unit_price"));
				product.setImage(rs.getString("image"));
				products.add(product);
				//System.out.println(product.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if(psmt != null) {
				try {
					psmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return products;
	}
	
	//가장 최근 상품 4건조회
	public List<Product> getRecentProducts() {
		List<Product> products = new ArrayList<Product>();
		Product product = null;
		
		sql =  "Select m.product_id, m.product_name, m.category_id, m.category_name, m.unit_price, m.image";
		sql += " from ( ";
		sql += " 	Select p.product_id, p.product_name, p.category_id, c.category_name, p.unit_price, p.image ";
		sql += " 	From product p Left outer join category c ON p.category_id = c.category_id";
		sql += " 	order by p.create_date desc";
		sql += " )m";
		sql += " where rownum <= 4";
		System.out.println(sql);
		try {
			psmt = this.conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				product = new Product();
				product.setProductId(rs.getString("product_id"));
				product.setProductName(rs.getString("product_name"));
				product.setCategoryName(rs.getString("category_name"));
				product.setUnitPrice(rs.getInt("unit_price"));
				product.setImage(rs.getString("image"));
				products.add(product);
				
				System.out.println(product.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(psmt != null) {
				try {
					psmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}			
		}
		
		return products;
	}
	
	//인기 상품 4건 조회(판매금액 기준 가장 큰 상품 순서)
	public List<Product> getHitProducts() {
		List<Product> products = new ArrayList<Product>();
		sql =  "Select m.product_id, m.product_name, m.category_id, m.category_name, m.unit_price, m.image";
		sql += " from ( ";
		sql += " 	Select o.product_id , p.product_name , p.category_id , c.category_name , p.unit_price , p.image , sum(amt) as amt ";
		sql += " 	from order_item o left outer join product p on o.product_id = p.product_id";
		sql += " 	inner join category c on p.category_id = c.category_id";
		sql += " 	group by o.product_id, p.product_name , p.category_id , c.category_name , p.unit_price , p.image";
		sql += " 	order by amt desc";
		sql += " )m";
		sql += " where rownum <= 4";
		System.out.println(sql);
		try {
			psmt = this.conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				product = new Product();
				product.setProductId(rs.getString("product_id"));
				product.setProductName(rs.getString("product_name"));
				product.setCategoryName(rs.getString("category_name"));
				product.setUnitPrice(rs.getInt("unit_price"));
				product.setImage(rs.getString("image"));
				products.add(product);
				
				System.out.println(product.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {

			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(psmt != null) {
				try {
					psmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return products;
	}

	/**
	 * 한 개 상품에 대한 상세 정보 조회
	 * @return
	 */
	public Product getProduct(String productId) {
		Product product = null;
		sql = "Select * From product where product_id = ?";
		System.out.println(sql);
		try {
			psmt = this.conn.prepareStatement(sql);
			psmt.setString(1, productId);
			rs = psmt.executeQuery();
			if(rs.next()) {
				product = new Product();
				product.setProductId(rs.getString("product_id"));
				product.setProductName(rs.getString("product_name"));
				product.setUnitPrice(rs.getInt("unit_price"));
				product.setImage(rs.getString("image"));
				
				System.out.println(product.toString());	//결과 확인
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}			
			if(psmt != null) {
				try {
					psmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
		return product;
	}	
}
