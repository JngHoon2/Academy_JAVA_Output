package database;
import database.db.DatabaseClass;
import database.util.PrintClass;

public class MainClass {

	public static void main(String[] args) {
		// 1. 데이터베이스 관련 객체 생성
		DatabaseClass dbc = new DatabaseClass();
		// 데이터베이스 커넥션,연결(문자열을 인자로 전달하고 있음)
		dbc.connectDB("company", "1234");

		String resultTags = "";

		// [문제.1] 사원의 이름과 급여와 입사일자만을 출력하기
		resultTags = dbc.quiz1();
		System.out.println("dbc.quiz1() : " + resultTags);

		// [공통]만들어진 Html tags를 파일에 쓰기위해서 writeHtml() 메소드로 보낸다.
		PrintClass pc = new PrintClass();
		pc.writeHtml(resultTags);

	}

}
