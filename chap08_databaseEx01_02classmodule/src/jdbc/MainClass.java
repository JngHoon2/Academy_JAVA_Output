package jdbc;

import jdbc.db.MethodClass;

public class MainClass {

	public static void main(String[] args) {
		MethodClass dc = new MethodClass("ky","1234");
		
		dc.connectDB();
		
		//dc.selectAll();
		
		//dc.countRecord();
		
		//dc.duplicateID("somi");
		
		//dc.insertTable("홍길동", "honggil", "1234", "hong@naver.com", "010-9854-5478", 1);
		//dc.selectAll();
		
		//dc.updateTable("김명희", "honggil", "3456", "jung@naver.com", "010-8524-6587", 0);
		//dc.selectAll();
		
		dc.deleteTable("honggil");
		dc.selectAll();
	}

}
