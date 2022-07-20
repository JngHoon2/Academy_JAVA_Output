package database;

public class MainClass {

	public static void main(String[] args) {
		// 1. 엑셀 파일 로드해서 데이터베이스 테이블에 저장
		//ExcelReader er = new ExcelReader(); // 엑셀 읽어들일 객체 생성
		//er.loadExcel(); // 엑셀 파일 로드해서 데이터베이스에 저장
		
		String tag = "";
		
		DatabaseClass dbc = new DatabaseClass();
		dbc.connectDB();
		tag = dbc.readData();
		
		PrintClass pc = new PrintClass();
		pc.makeHTML(tag);
	}

}
