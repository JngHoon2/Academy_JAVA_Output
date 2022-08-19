package excelEx01;

public class MainClass {
	public static void main(String[] args) {
		
		try {
			ExcelWriterClass ew = new ExcelWriterClass();
			ew.createExcel();
			System.out.println("writting completed...");
			System.out.println();
			
			ExcelReaderClass er = new ExcelReaderClass();
			System.out.println("reading completed...");
			
		}catch (Exception e) {
			System.out.println("엑셀 파일 읽기 오류");
		}
	}
}
