package excel;

import java.io.FileWriter;

public class PrintClass {
	public PrintClass() {}
	
	public static void writeHtml(String tags) {
		String strPath = "/Users/tuan/Documents/works/chap08/src/data/bank_data.html";
		FileWriter fw = null;
		
		try {
			fw = new FileWriter(strPath);
			fw.write(tags);
			fw.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
