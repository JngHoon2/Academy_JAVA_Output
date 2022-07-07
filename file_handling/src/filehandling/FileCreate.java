package filehandling;

import java.io.File;
import java.io.IOException;

public class FileCreate {

	public static void main(String[] args) {
		String path = "/Users/tuan/Documents/works11111/file_handling";
		File fi = new File(path);
		
		try {
			fi.createNewFile();
		} catch (IOException e) {
			System.out.println("지정된 경로를 찹을 수 없습니다.");
		}
		

	}

}
