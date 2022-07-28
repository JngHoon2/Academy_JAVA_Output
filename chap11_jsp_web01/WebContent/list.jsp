<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록 조회 화면</title>
</head>
<body>

	<%
		Connection conn = null;
		Statement stmt = null;
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			out.println("드라이버 로딩 성공 <br />");
			
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			conn = DriverManager.getConnection(url, "company", "1234");
			out.println("사용자 계정 접속 성공 <br />");
			
			String query = "select * from members";
			
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			out.println("SQL 명령어 실행 성공");
			
			ResultSetMetaData rsmd = rs.getMetaData();
			int num = rsmd.getColumnCount();
			
			out.println("<table border=1>");
			out.println("<tr>");
			for(int i = 1; i < num ; i++){
				out.println("<th>" + rsmd.getColumnName(i) + "</th>");
			}
			
			out.println("<tr>");
			while(rs.next()){
				for(int i = 1; i < num ; i++){
					out.println("<th>" + rs.getString(i) + "</th>");
				}
				out.println("<tr>");
			}
			out.println("</table>");
			
			
		} catch(ClassNotFoundException e){
			System.out.println("DRIVER ERROR : " + e.getMessage());
		} catch(SQLException e){
			System.out.println("CONNECT ERROR : " + e.getMessage());
		} finally{
			try{
				if(stmt != null){
					stmt.close();
				}
				if(conn != null){
					conn.close();
				}
			} catch(SQLException e){
				System.out.println("CLOSER ERROR : " + e.getMessage());
			}
		}
		
	%>

</body>
</html>