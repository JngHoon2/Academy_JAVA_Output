package database.db;

import java.io.File;
import java.util.Arrays;

import database.vo.CafeClass;
import database.vo.DataClass;
import jxl.Sheet;
import jxl.Workbook;

public class LocalFileReaderClass {
	public LocalFileReaderClass() {
	}

	// 엑셀 데이터를 읽어들여서 DataClass의 cafes ArrayList에 저장
	public static void loadExcel(String uri_excel) {
		File f  =  new File(uri_excel);
		Workbook wb = null;
		Sheet s = null;
		
		try {
			// 데이터 읽어들여서 vo 객체 생성해서 DataClass의 ArrayList에 추가
			wb = Workbook.getWorkbook(f);
			s = wb.getSheet(0);
			
			int i = 1;
			while (true) {
				try {
					DataClass.cafes.add(new CafeClass(Integer.parseInt(s.getCell(0, i).getContents()),
							s.getCell(1, i).getContents(),
							s.getCell(2, i).getContents(),
							Double.parseDouble(s.getCell(3, i).getContents()),
							s.getCell(4, i).getContents(),
							s.getCell(5, i).getContents()
							));
					i++;
				} catch (Exception e) {
					break;
				}
			}
			
			
			
		}catch (Exception e) {
			System.err.println("EXCEL READ ERR : " + e.getMessage());
		}
	}

	// c드라이브의 filetest/images 폴더에 있는 이미지를 읽어들임
	// 읽어들여서 순서대로 데이터 전담 객체인 DataClass에 있는 cafes 
	// ArrayList에 들어 있는 CafeClass의 이미지 멤버 변수에 세팅해줌.
	public static void readFileName(String imgPath) {
		// 파일을 읽어들일 File 객체 생성
		File file = new File(imgPath);
		
		// 파일이 있는 디렉토리에 있는 파일들의 이름들을 배열로 리턴
		String[] fnames = file.list();
		Arrays.sort(fnames);
		
		for(int idx = 0; idx < fnames.length; idx++) {
			if(fnames[idx].equals(".DS_Store")) {
				continue;
			}
			DataClass.cafes.get(idx - 1).setImg(fnames[idx]);
		}
		
		System.out.println("image 파일 읽기 성공!");
	}
}
