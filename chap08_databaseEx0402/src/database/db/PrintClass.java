package database.db;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;

public class PrintClass {
	public static String makeTagsAllEmp(ResultSet rs) {

		String tags = "";

		// 1. 태그 헤더와 테이블의 타이틀 까지 작업
		tags = tags + "<!doctype html><html><head><title>";
		tags = tags + "</title></head><body><table border = '1'>";
		tags = tags + "<tr>";
		tags = tags + "<th>사번</th><th>이름</th><th>직급</th><th>MGR</th><th>고용일자</th><th>급여</th><th>인센티브</th><th>부서번호</th>";
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
				tags = tags + "<td>" + rs.getString(6) + "</td>";
				tags = tags + "<td>" + rs.getString(7) + "</td>";
				tags = tags + "<td>" + rs.getString(8) + "</td>";
				tags = tags + "</tr>";
			}
			tags = tags + "</table></body></html>";

			System.out.println(tags);
		} catch (Exception e) {
			System.out.println("RESULTSET NEXT() ERR : " + e.getMessage());
		}

		// 4. 태그 반환
		return tags;
	}
	
	public static String makeTagsAVG(ResultSet rs) {

		String tags = "";

		// 1. 태그 헤더와 테이블의 타이틀 까지 작업
		tags = tags + "<!doctype html><html><head><title>";
		tags = tags + "</title></head><body><table border = '1'>";
		tags = tags + "<tr>";
		tags = tags + "<th>직급</th><th>사원수</th><th>급여총합</th><th>평균급여</th>";
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
				tags = tags + "</tr>";
			}
			tags = tags + "</table></body></html>";

			System.out.println(tags);
		} catch (Exception e) {
			System.out.println("RESULTSET NEXT() ERR : " + e.getMessage());
		}

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
