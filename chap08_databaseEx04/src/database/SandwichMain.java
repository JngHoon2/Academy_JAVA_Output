package database;

import java.sql.ResultSet;
import java.sql.SQLException;

import database.db.Jdbc;
import database.db.LocalFileReaderClass;
import database.db.PrintClass;
import database.vo.CafeClass;
import database.vo.DataClass;

public class SandwichMain {

	public static void main(String[] args) {
		// 1. 데이터베이스 관련 클래스 JdbcClass 객체 생성
		Jdbc db = new Jdbc();

		// 2. JdbcClass 클래스의 커넥트 메소드 호출
		db.connectDB();

		// 3. 테이블에 데이터가 한 건이라도 있는지 미리 확인
		System.out.println("데이터 갯수(999 = 오류) : " + db.countDB());

		// 4. 데이터베이스에 없을 경우 다음 작업

		// 4.1. 엑셀 데이터를 읽어들여서 DataClass의 cafes ArrayList에 저장
		// c:/filetest/best_sandwich_cafe_list.xls 읽어들일 엑셀 파일 경로
		// LocalFileReaderClass 클래스에서 static 메소드 loadExcel() 메소드 구현
		// - loadExcel() 메소드에서는 전달된 경로의 엑셀 파일 읽어들임
		// - 읽어들인 내용으로 CafeClass 객체 생성해서 DataClass의 ArrayList에 추가
		String path = "/Users/tuan/Documents/works/chap08_databaseEx04/rawData/best_sandwich_cafe_list.xls";
		
		LocalFileReaderClass lfc = new LocalFileReaderClass();
		lfc.loadExcel(path);
		System.out.println("ArrayList 사이즈 : " + DataClass.cafes.size());
		

		// 4.2 c드라이브의 filetest/images 폴더에 있는 이미지를 읽어들이기
		// 데이터 전담 객체인 DataClass에 있는 cafes ArrayList에 들어 있는
		// CafeClass의 이미지 멤버 변수에 세팅해줌
		
		// 4.3 읽어들일 이미지 경로
		String imgPath = "/Users/tuan/Documents/works/chap08_databaseEx04/rawData/images";

		// 4.4 이미지 경로를 전달해서 파일명 읽어들이기
		LocalFileReaderClass.readFileName(imgPath);
		System.out.println("ArrayList img 형태 : " + DataClass.cafes.get(34).getCafe() + " " + DataClass.cafes.get(34).getImg());
		

		// 5. 데이터 전담 객체인 DataClass에 있는 cafes ArrayList를 데이터베이스에 저장
		// JdbcClass 클래스의 insertDB() 메소드 호출
//		for (CafeClass c : DataClass.cafes) {
//			
//			db.insertDB(c);
//		}
		
		// 6. 데이터베이스에 저장된 내용 조회
		ResultSet rs = db.selectDB();
		try {
			while (rs.next()) {
				System.out.println(
						rs.getString("rank") + "\t" + rs.getString("cafe") + "\t" + rs.getString("menu") + "\t" + rs.getString("price")
								+ "\t" + rs.getString("address") + "\t" + rs.getString("img") + "\t" + rs.getString("url"));
			}
		} catch (SQLException e) {
			System.out.println("SQL ERROR : " + e.getMessage());
		}
		
		// 7. 태크 만들기
		rs = db.selectDB();
		String tags = PrintClass.makeTags(rs);

		// 8. Html 파일 생성 경로
		String htmlPath = "/Users/tuan/Documents/works/chap08_databaseEx04/sandwich.html";
				
		// 9. Html 파일 쓰기
		PrintClass.makeHTML(tags, htmlPath);
		
	}
}
