package database.util;

import java.io.FileWriter;
import java.io.IOException;

public class PrintClass {
	// 기본 생성자
	public PrintClass() {
	}

	// Html tag를 파일에 쓰기
	public void writeHtml(String tags) {
		
		// 파일이 만들어질 경로와 이름 지정하는 문자열
		String  uri = "/Users/tuan/Documents/works/chap08_databaseEX02/src/quizList11.html";
		// File을 만들고 내용을 쓰기 위한 FileWriter 스트림 변수 선언
		FileWriter fw = null;	  
		
		try {
			// 파일과 직접 연결되는 스트림(통로) 생성
			fw = new FileWriter(uri);
			
			// 파일 객체를 통해서 내용(tag)을 파일에 씀
			fw.write(tags);
			
			// 파일 스트림 닫기(자원 반환)
			fw.close();
			System.out.println("파일 쓰기 성공");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
