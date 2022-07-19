package database.util;

import java.sql.ResultSet;

import java.sql.SQLException;
/*
 * Html Tag를 만들어주는 메소드 집합(모듈화)
 *  - MethodClass에서 호출함.
 *  - 객체 생성없이 호출할 수 있도록 static 메소드
 */
public class MethodClass {
	public MethodClass() {
	}

	// Html tag 앞부분
	private static String makeTagsBefore() {
		String tags = "";
		tags = tags + "<!doctype html><html><head><title>";
		tags = tags + "</title></head><body><table border = '1'>";
		return tags;
	} // makeTagsBefore() END
	
	// Html tag 뒷부분
	private static String makeTagsAfter() {
		String tags = "";
		tags = tags + "</table></body></html>";
		return tags;
	} // makeTagsAfter() END
	
	// 테이블의 타이틀(제목)
	private static String makeTitleTags(String[] fieldNames) {
		String tags = "";
		/** 전달된 필드명 배열로부터 필드명 추출 **/
		tags = tags + "<tr>";
		for(int idx = 0; idx<fieldNames.length; idx++ ) {
			tags = tags + "<th>";
			tags = tags + fieldNames[idx];
			tags = tags + "</th>";
		}
		tags = tags + "</tr>";
		return tags;
	}
	
	// 퀴즈1의 Html 생성 메소드
	public static String makeTagsQ1(ResultSet rs, String[] fieldNames) {
		String makeTags = "";

		/** 기본 태그 생성 **/
		makeTags = makeTags + makeTagsBefore();

		/** 필드명을 이용한 제목 태그 생성 **/
		makeTags = makeTags + makeTitleTags(fieldNames);
		
		try {
			/** 조회된 레코드의 각 필드 값 추출 **/
			while(rs.next()) {
				makeTags = makeTags + "<tr>";
				makeTags = makeTags + "<td>"  +  rs.getString(1)  +  "</td>";
				makeTags = makeTags + "<td>" + rs.getString(2) + "</td>";
				makeTags = makeTags + "<td>" + rs.getString(3) + "</td>";
				makeTags = makeTags + "</tr>";
			}
	
		} catch (SQLException e) {
			System.out.println("ResultSetMetaData ERR : " + e.getMessage());
		} 
		
		/** 최종 태그 생성 **/
		makeTags = makeTags + makeTagsAfter();

		return makeTags;
	} // makeTagsQ1() END
}