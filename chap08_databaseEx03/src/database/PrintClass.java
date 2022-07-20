package database;

import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class PrintClass {
	public PrintClass() {
	}

	public static String makeTags(ResultSet rs, String[] fieldNames) {
		
		String tags = "";

		// 1. 태그 헤더와 테이블의 타이틀 까지 작업
		tags = tags + "<!doctype html><html><head><title>";
		tags = tags + "</title></head><body><table border = '1'>";
		tags = tags + "<tr>";
		for (int idx = 0; idx < fieldNames.length; idx++) {
			tags = tags + "<th>";
			tags = tags + fieldNames[idx];
			tags = tags + "</th>";
		}
		tags = tags + "</tr>";
		
		// 2. 인자로 전달받은 ResultSet 만큼 반복 (<tr> 생성)
		try {
			while(rs.next()) {
				tags = tags + "<tr>";
				tags = tags + "<td>" + rs.getString(1) + "</td>";
				tags = tags + "<td>" + rs.getString(2) + "</td>";
				tags = tags + "<td>" + rs.getString(3) + "</td>";
				tags = tags + "<td>" + rs.getString(4) + "</td>";
				tags = tags + "<td>" + rs.getString(5) + "</td>";
				tags = tags + "<td>" + rs.getString(6) + "</td>";
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

	// Html Tag를 파일을 만드는 메소드
	public static void makeHTML(String tags) {
		try {
			// 1. C:/filetest 폴더에 local_oil.html 파일로 결과 생성할것.
			String path = "/Users/tuan/Documents/works/databaseEX03/local_oil.html";

			// 2. 파일 객체 생성
			FileWriter fw = new FileWriter(path);

			// 3. 파일에 쓰기
			fw.write(tags);

			// 4. 쓰기 완료 확인 문자열 출력
			System.out.println(path + "에 HTML 파일이 생성 되었습니다.");

			// 5. 자원 반납
			fw.close();

		} catch (Exception e) {
			System.out.println("HTML FILE ERR : " + e.getMessage());
		}

	}
}
