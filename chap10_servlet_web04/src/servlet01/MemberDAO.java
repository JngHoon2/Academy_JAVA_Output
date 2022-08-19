package servlet01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Date;
import java.util.ArrayList;

public class MemberDAO {
	private static final String driver = "oracle.jdbc.driver.OracleDriver";
	private static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String user = "company";
	private static final String pwd = "1234";
	private Connection con;
	private Statement stmt;

	public ArrayList<MemberVO> listMembers() {
		
		// 1. 데이터베이스에 갖고온 레코드로 MemberVO객체 만들어서 담을 ArrayList선언
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		
		try {
			
			// 2. 데이터베이스 커넥션
			connectDB();
			
			// 3. 쿼리작성
			String query = "select * from members ";
			System.out.println(query);
			
			// 4. ResultSet
			ResultSet rs = stmt.executeQuery(query);
			
			// 5.  반복문 돌면서 데이터베이스에서 읽은 레코드 객체 생성
			while (rs.next()) {
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				
				// 6. 읽은 하나의 레코드로 MemberVO객체 생성
				MemberVO vo = new MemberVO(id, pwd, name, email, joinDate);
				// 7. ArrayList에 생성한 객체 담기
				list.add(vo);
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	private void connectDB() {
		try {
			Class.forName(driver);
			System.out.println("1. Oracle 드라이버 로딩 성공");
			con = DriverManager.getConnection(url, user, pwd);
			System.out.println("2. Connection 생성 성공");
			stmt = con.createStatement();
			System.out.println("3. Statement 생성 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}