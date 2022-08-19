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
		String resultTags2 = "";
		String resultTags3 = "";
		String resultTags4 = "";
		String resultTags5 = "";
		String resultTags6 = "";
		String resultTags7 = "";
		String resultTags8 = "";
		String resultTags9 = "";
		String resultTags10 = "";
		String resultTags11 = "";

		// [문제.1] 사원의 이름과 급여와 입사일자만을 출력하기
		resultTags = dbc.quiz1();
		System.out.println("dbc.quiz1() : " + resultTags);
		
		//
		resultTags2 = dbc.quiz2();
		System.out.println("dbc.quiz2() : " + resultTags2);

		//
		resultTags3 = dbc.quiz3();
		System.out.println("dbc.quiz3() : " + resultTags3);
		
		//
		resultTags4 = dbc.quiz4("오지호");
		System.out.println("dbc.quiz4() : " + resultTags4);
		
		//
		resultTags5 = dbc.quiz5(250, 300, 500);
		System.out.println("dbc.quiz5() : " + resultTags5);
		
		//
		resultTags6 = dbc.quiz6(250, 300, 500);
		System.out.println("dbc.quiz6() : " + resultTags6);
		
		//
		resultTags7 = dbc.quiz7("김", "기");
		System.out.println("dbc.quiz7() : " + resultTags7);
		
		//
		resultTags8 = dbc.quiz8();
		System.out.println("dbc.quiz8() : " + resultTags8);
		
		//
		resultTags9 = dbc.quiz9();
		System.out.println("dbc.quiz9() : " + resultTags9);
		
		//
		resultTags10 = dbc.quiz10();
		System.out.println("dbc.quiz9() : " + resultTags10);
		
		//
		resultTags11 = dbc.quiz11();
		System.out.println("dbc.quiz11() : " + resultTags11);
		
		// [공통]만들어진 Html tags를 파일에 쓰기위해서 writeHtml() 메소드로 보낸다.
		PrintClass pc = new PrintClass();
		pc.writeHtml(resultTags11);

	}

}
