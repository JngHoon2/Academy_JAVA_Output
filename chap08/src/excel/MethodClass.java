package excel;

import java.io.File;
import java.util.ArrayList;

import excel.vo.Customer;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class MethodClass {
	public ArrayList<Customer> customers = new ArrayList<Customer>();
	
	public MethodClass() {}
	
	public void loadExcel() {
		String strPath = "/Users/tuan/Documents/works/chap08/src/data/bank_data.xls";
		File file = new File(strPath);
		Workbook wb = null;
		try {
			wb = Workbook.getWorkbook(file);
			Sheet bnkSheet = wb.getSheet(0);
			
			Cell[] cells = new Cell[8];
			
			Customer customer = null;
			
			int i = 1;
			while(true) {
				try {
					cells[0] = bnkSheet.getCell(0, i);
					cells[1] = bnkSheet.getCell(1, i);
					cells[2] = bnkSheet.getCell(2, i);
					cells[3] = bnkSheet.getCell(3, i);
					cells[4] = bnkSheet.getCell(4, i);
					cells[5] = bnkSheet.getCell(5, i);
					cells[6] = bnkSheet.getCell(6, i);
					cells[7] = bnkSheet.getCell(7, i);
				} catch (Exception e) {
					break;
				}
				System.out.println(cells[0].getContents() + "\t"
						+ cells[1].getContents() + "\t"
						+ cells[2].getContents() + "\t"
						+ cells[3].getContents() + "\t"
						+ cells[4].getContents() + "\t"
						+ cells[5].getContents() + "\t"
						+ cells[6].getContents() + "\t"
						+ cells[7].getContents());
				i++;
			}
			System.out.println("우리 은행 총 고객수 : " + i + "명");
		} catch (Exception e) {
			System.out.println("파일 입출력 오류");
		}
	}
}
