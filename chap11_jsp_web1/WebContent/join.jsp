<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입 처리</title>
</head>
<body>

	<%
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			out.println("드라이버 로딩 성공 <br />");
			
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			conn = DriverManager.getConnection(url, "company", "1234");
			out.println("사용자 계정 접속 성공 <br />");
			
			String query = "insert into members values (?,?,?,?, sysdate)";
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			
			int n = pstmt.executeUpdate();
			
			if(n > 0){
				out.println("저장 성공");
			} else{
				out.println("저장 실패");
			}
			
		} catch(ClassNotFoundException e){
			System.out.println("DRIVER ERROR : " + e.getMessage());
		} catch(SQLException e){
			System.out.println("CONNECT ERROR : " + e.getMessage());
		} finally{
			try{
				if(pstmt != null){
					pstmt.close();
				}
				if(pstmt != null){
					conn.close();
				}
			} catch(SQLException e){
				System.out.println("CLOSER ERROR : " + e.getMessage());
			}
		}
		
	%>

</body>
</html>