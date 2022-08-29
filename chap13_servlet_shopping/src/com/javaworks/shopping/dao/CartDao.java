package com.javaworks.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.startup.Tomcat.ExistingStandardWrapper;

import com.javaworks.shopping.model.Cart;
import com.javaworks.shopping.model.Product;

public class CartDao {
	// 1. 커넥션 객체 획득
	// 2. 조회/삽입/수정/삭제 메소드 구현
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	private String sql = "";
	
	// 기본 생성
	public CartDao(Connection conn) {
		this.conn = conn;
	}

	// 카트 저장
	public int insertCart(Cart cart) {
		sql = "insert into cart(product_id, user_id, quantity, unit_price) values(?,?,?,?)";
		int rows = 0;
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, cart.getProductId());
			psmt.setString(2, cart.getUserId());
			psmt.setInt(3, cart.getQuantity());
			psmt.setInt(4, cart.getUnitPrice());
			rows = psmt.executeUpdate();
			
			if(rows > 0) {
				System.out.println("성공적으로 저장되었습니다.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			if(psmt != null) {
				try {
					psmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
		return rows;
	}
	
	//모든 상품 조회
	public List<Cart> getAllCarts(String userId) {
		List<Cart> carts = new ArrayList<Cart>();
		Cart cart = null;
		
		sql =  "SELECT p.product_id, p.product_name, p.image, c.quantity, c.unit_price , p.image , c.user_id, c.create_date";
		sql += " From cart c inner join product p on c.product_id = p.product_id";
		sql += " inner join users u on c.user_id = u.user_id";
		sql += " where c.user_id = ?";
		sql += " Order BY p.create_date DESC";

		try {
			psmt = this.conn.prepareStatement(sql);
			psmt.setString(1, userId);
			rs = psmt.executeQuery();
			while(rs.next()) {
				cart = new Cart();
				// 상품명, 가격(단가), 수량, 총금액, 사용자ID (숨김필드 product_id)
				cart.setProductId(rs.getString("product_id"));
				cart.setProductName(rs.getString("product_name"));
				cart.setQuantity(rs.getInt("quantity"));
				cart.setUnitPrice(rs.getInt("unit_price"));
				cart.setUserId(rs.getString("user_id"));
				cart.setImage(rs.getString("image"));
				cart.setCreateDate(rs.getDate("create_date"));
				carts.add(cart);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
		
		return carts;
	}	
	
	// Cart 삭제
	public void deleteCart(String userId, String productId) {
		
		sql =  "delete from cart where user_id = ? and product_id = ?";

		try {
			psmt = this.conn.prepareStatement(sql);
			psmt.setString(1, userId);
			psmt.setString(2, productId);
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(psmt != null) {
				try {
					psmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}		
	}


	/**
	 * 사용자가 선택한 상품에 대한 카트 목록이 있는지 체크
	 * @return
	 */
	public boolean cartExist(Cart cart) {
		boolean exist = false;
		sql = "Select * From cart where user_id = ? and product_id = ?";
		try {
			psmt = this.conn.prepareStatement(sql);
			psmt.setString(1, cart.getUserId());
			psmt.setString(2, cart.getProductId());
			rs = psmt.executeQuery();
			if (rs.next()) {	
				exist = true;
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
		return exist;
	}

	// Cart update
	public void updateCart(Cart cart) {
		
		sql =  "update cart set quantity = ?, unit_price = ? where user_id = ? and product_id = ?";

		try {
			psmt = this.conn.prepareStatement(sql);
			psmt.setInt(1, cart.getQuantity());
			psmt.setInt(2, cart.getUnitPrice());
			psmt.setString(3, cart.getUserId());
			psmt.setString(4, cart.getProductId());
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(psmt != null) {
				try {
					psmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}		
	}
}
