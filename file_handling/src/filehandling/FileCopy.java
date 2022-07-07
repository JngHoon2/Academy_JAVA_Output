package filehandling;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {

	public static void main(String[] args) {
//		File file = new File("/Users/tuan/Documents/works/file_handling/text_file.txt");
//		File newFile = new File("/Users/tuan/Documents/works/file_handling/new_text_file.txt");
		File file = new File("/Users/tuan/Documents/works/file_handling/img.png");
		File newFile = new File("/Users/tuan/Documents/works/file_handling/new_img.png");
		
		FileInputStream input;
		FileOutputStream output;
		
		try {
			input = new FileInputStream(file);
			output = new FileOutputStream(newFile);
			
			byte[] buffer = new byte[1024];
			
			int readDate;
			while((readDate = input.read(buffer)) > 0) {
				output.write(buffer, 0, readDate);
			}
			
			input.close();
			output.close();
			
		} catch (FileNotFoundException fe) {
			System.out.println("파일이 존재하지 않습니다.");
		} catch (IOException e) {
			System.out.println("오류 발생");
		}
	}

}
