package excelEx01;

import java.io.File;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class ExcelReaderClass {
	public ExcelReaderClass() throws Exception {
		String path = "/Users/tuan/Documents/works/chap07/data/data.xls";

		File file = new File(path);

		Workbook wb = Workbook.getWorkbook(file);

		Sheet sheet = wb.getSheet(0);

		int i = 0;

		Cell c;
		Cell c1;

		while (true) {
			try {
				c = sheet.getCell(0, i);
				c1 = sheet.getCell(1, i);
				System.out.println(c.getContents() + " \t" + c1.getContents());
				i++;
			} catch (Exception e) {
				break;
			}
		}
	}
}
