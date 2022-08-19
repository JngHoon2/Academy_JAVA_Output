package excel;

import java.io.File;
import java.util.ArrayList;

import excel.vo.Customer;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class MethodClass {
	public ArrayList<Customer> customers = new ArrayList<Customer>();

	public MethodClass() {
	}

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
			while (true) {
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

				customer = new Customer(Integer.parseInt(cells[0].getContents()), Integer.parseInt(cells[1].getContents()),
						cells[2].getContents().toString(), cells[3].getContents().toString(),
						cells[4].getContents().toString(), cells[5].getContents().toString(),
						cells[6].getContents().toString(), Integer.parseInt(cells[7].getContents()));

				customers.add(customer);
				
				i++;
				System.out.println(customer.toString());

			}
			System.out.println("우리 은행 총 고객수 : " + i + "명");
		} catch (Exception e) {
			System.out.println("파일 입출력 오류");
		}
	}

	public static String makeTags(ArrayList<Customer> resultList) {
		String tags = "";
		tags += "<!doctype>";
		tags += "<html>";
		tags += "<head><title>News Stand</title></head>";
		tags += "<body>";

		if (resultList.size() > 0) {
			tags += "총 " + resultList.size() + "명이 검색되었습니다.";
			tags += "<table border ='1'>";
			tags += "<td>순번</td>";
			tags += "<td>고객번호</td>";
			tags += "<td>나이</td>";
			tags += "<td>직업</td>";
			tags += "<td>결혼여부</td>";
			tags += "<td>집소유여부</td>";
			tags += "<td>대졸여부</td>";
			tags += "<td>연락처</td>";
			tags += "<td>가입기간(일)</td>";
			tags += "</tr>";

			int noCount = 1;

			for (Customer c : resultList) {
				tags += "<tr>";
				tags += "<td>" + noCount + "</td>";
				tags += "<td>" + c.getNo() + "</td>";
				tags += "<td>" + c.getAge() + "</td>";
				tags += "<td>" + c.getJob() + "</td>";
				tags += "<td>" + c.getMarital() + "</td>";
				tags += "<td>" + c.getHousing() + "</td>";
				tags += "<td>" + c.getLoan() + "</td>";
				tags += "<td>" + c.getContact() + "</td>";
				tags += "<td>" + c.getDuration() + "</td>";
				tags += "</tr>";
				noCount++;
			}

			tags += "</table>";
		} else {

		}
		tags += "</body>";
		tags += "</html>";

		return tags;
	}
	
	public static void src(ArrayList<Customer> list) {
		System.out.println("-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-");
		for(Customer c : list) {
			if(c.getJob().equals("services") && c.getMarital().equals("single") && c.getLoan().equals("no")) {
				System.out.println(c.toString());
			}
		}
	}
}
