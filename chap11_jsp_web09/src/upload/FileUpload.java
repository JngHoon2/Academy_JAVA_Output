package upload;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


@WebServlet("/upload.do")
public class FileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public FileUpload() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset = utf-8");
		
		String encoding="utf-8";
		PrintWriter out = response.getWriter();
		
		File currentDirPath = new File("/Users/tuan/Downloads/upload/");
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(currentDirPath);
		factory.setSizeThreshold(1024*1024);
		
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		try {
			List<FileItem> items = upload.parseRequest(request);
			for(int i=0; i< items.size(); i++) {
				FileItem fileItem = (FileItem) items.get(i);
				
				if(fileItem.isFormField()) {
					System.out.println(fileItem.getFieldName() + " = " + fileItem.getString(encoding));
				} else {
					System.out.println("파라미터 명 : " + fileItem.getFieldName());
					System.out.println("파일 명 : " + fileItem.getName());
					System.out.println("파일 크기 : " + fileItem.getSize());
					
					if(fileItem.getSize() > 0) {
						String separator = System.getProperty("file.separator");
						int index = fileItem.getName().lastIndexOf(separator);
						String fileName = fileItem.getName().substring(index + 1);
						File uploadFile = new File(currentDirPath + "/" + fileName);
						System.out.println(currentDirPath + "/" + fileName);
						
						fileItem.write(uploadFile);
					}
				}
			}
			
		} catch (Exception e) {
			
		}
		
	}
}
