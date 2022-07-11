package excelEx01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class ExcelWriterClass {

	public ExcelWriterClass() {
	}

	public void createExcel() {
		// 파일 경로 설정
		String uri = "/Users/tuan/Documents/works/chap07/data/data.xls";

		// 파일 객체 생성
		File file = new File(uri);

		// 실제 엑셀 파일 관리를 위해 workbook, Sheet 생성
		WritableWorkbook wb = null;

		try {
			// workbook : 엑셀 파일 관리를 위해 기본이 되는 추상 클래스
			wb = Workbook.createWorkbook(file);

			WritableSheet s1 = wb.createSheet("sheet 1", 0);

			for (int i = 0; i < 10; i++) {
				Label label1 = new Label(0, i, "data..." + i);
				Label label2 = new Label(1, i, "data..." + (i + 10));
				s1.addCell(label1);
				s1.addCell(label2);
			}
			wb.write();
			wb.close();
		} catch (FileNotFoundException e) {
			System.out.println("파일 저장 오류 : " + e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (RowsExceededException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}
	}
}
