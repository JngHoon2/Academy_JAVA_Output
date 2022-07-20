package database;

import java.io.File;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class ExcelReader {
	public ExcelReader() {
	}

	// 엑셀파일 읽어들여서 데이터베이스에 저장
	public void loadExcel() {

		// 1. 읽어들일 파일 경로
		String path = "/Users/tuan/Documents/works/databaseEX03/local_oil.xls";

		// 2. 파일 경로를 갖는 File 객체 선언(파일과 디렉토리 핸들링 객체)
		File file = new File(path);
		
		// 3. DataClass 객체 생성
		DatabaseClass dbc = new DatabaseClass();

		// 4. DataClass의 데이터베이스 접속 메소드 호출
		dbc.connectDB();
		
		// 5. 셀 객체배열 선언만(갯수는 아래서 설정)
		Cell[] cells = null;

		try {
			// 6. 엑셀 핸들링을 위한 워크북 객체 생성
			Workbook wb = Workbook.getWorkbook(file);
			
			// 6.1 시트 객체 얻기
			Sheet sheet = wb.getSheet(0);

			// 7번째 행(row) 부터 읽기
			int i = 3;

			// 8. 셀 배열 객체 선언(읽어들일 컬럼 갯수 만큼 배열 선언[7개])
			cells = new Cell[7];

			// 9. [엑셀 읽어서 디비 저장반복]while(true) 반복문을 통해서 엑셀 내용 만큼 읽기
			while (true) {
				// 10. 읽은 내용을 셀 배열에 담기
				try {
					cells[0] = sheet.getCell(0, i); // 상호
					cells[1] = sheet.getCell(1, i); // 주소
					cells[2] = sheet.getCell(2, i); // 주소
					cells[3] = sheet.getCell(3, i); // 주소
					cells[4] = sheet.getCell(4, i); // 주소
					cells[5] = sheet.getCell(5, i); // 주소
					cells[6] = sheet.getCell(6, i); // 주소
					

					// 11. 셀을 잘 읽어 왔는지 디버깅(화면에 출력)
//					System.out.println(cells[0].getContents() + " \t" + cells[1].getContents() + " \t"
//							+ cells[2].getContents() + " \t" + cells[3].getContents() + " \t" + cells[4].getContents()
//							+ " \t" + cells[5].getContents() + " \t" + cells[6].getContents());

					// 12. 만든 셀을 테이블에 저장
					dbc.insertData(cells);
					
					// 13. 행 증가
					i++;
				} catch (Exception e) {
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("EXCEL READ ERR : " + e.getMessage());
		}
	}
}
