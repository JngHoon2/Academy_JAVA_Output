package database.db;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;

public class PrintClass {
	public static String makeTags(ResultSet rs) {

		String tags = "";

		// 1. 태그 헤더와 테이블의 타이틀 까지 작업
		tags = tags + "<!doctype html><html><head><title>";
		tags = tags + "</title></head><body><table border = '1'>";
		tags = tags + "<tr>";
		tags = tags + "<th>랭크</th><th>이름</th><th>메뉴</th><th>가격</th><th>주소</th><th>이미지</th><th>URL</th>";
		tags = tags + "</th>";
		tags = tags + "</tr>";

		// 2. 인자로 전달받은 ResultSet 만큼 반복 (<tr> 생성)
		try {
			while (rs.next()) {
				tags = tags + "<tr>";
				tags = tags + "<td>" + rs.getString(1) + "</td>";
				tags = tags + "<td>" + rs.getString(2) + "</td>";
				tags = tags + "<td>" + rs.getString(3) + "</td>";
				tags = tags + "<td>" + rs.getString(4) + "</td>";
				tags = tags + "<td>" + rs.getString(5) + "</td>";
				tags = tags + "<td>" + "<img src = /Users/tuan/Documents/works/chap08_databaseEx04/rawData/images/" + rs.getString(6) + "></td>";
				tags = tags + "<td>" + rs.getString(7) + "</td>";
				tags = tags + "</tr>";
			}
			tags = tags + "</table></body></html>";

			System.out.println(tags);
		} catch (Exception e) {
			System.out.println("RESULTSET NEXT() ERR : " + e.getMessage());
		}

		// 3. 테이블 태그 닫기

		// 4. 태그 반환
		return tags;
	}
	
	public static void makeHTML(String tags, String uri) {
		try {
			FileWriter fw = new FileWriter(uri);
			
			fw.write(tags);
			
			System.out.println(uri+"에 HTML 파일이 생성 되었습니다.");
			
			fw.close();
		} catch (IOException e) {
			System.out.println("HTML FILE ERR : " + e.getMessage());
		}		
	}
}
