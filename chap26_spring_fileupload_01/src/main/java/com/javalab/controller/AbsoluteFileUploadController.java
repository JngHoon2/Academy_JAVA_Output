package com.javalab.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.javalab.domain.FileUploadForm;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class AbsoluteFileUploadController {
	@Autowired
	private FileSystemResource uploadDirResource;
	
	
	/*
	 * BindingResult : @ModelAttribute를 통해서 전달되온 객체를 FileUploadForm 객체에 바인딩할 떄 오류 검증
	 * */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("uploadForm") FileUploadForm uploadForm, Model model, BindingResult result) {
		List<MultipartFile> files = uploadForm.getFiles();
		List<String> fileNames = new ArrayList<>();
		List<String> filePathList = new ArrayList<>();
		
		// 오류 처리
		if(result.hasErrors()) {
			for (ObjectError error : result.getAllErrors()) {
				log.error("Error : " + error.getCode() + " - " + error.getDefaultMessage());
			}
			return "/show";
		}
		
		// 파일 유효성 검사
		if (!uploadForm.getFiles().isEmpty() && files != null && files.size() > 0) {
			log.info("파일 갯수 : " + files.size());
			
			// 파일 정보
			for (int i = 0; i < files.size(); i++) {
				String tmpFileName = uploadForm.getFiles().get(i).getOriginalFilename();
				String tmpFileExt = tmpFileName.substring(tmpFileName.lastIndexOf('.') + 1, tmpFileName.length());
				log.info("파일명 - 확장자 : " + tmpFileName + " - " + tmpFileExt);
			}
			
			FileOutputStream fos = null;
			
			for (MultipartFile multipartFile : files) {
				String fileName = multipartFile.getOriginalFilename();
				fileNames.add(fileName);
				
				// 파일 경로를 저장
				String tempPath = uploadDirResource.getPath().replace("/", "\\");
				
				filePathList.add(uploadDirResource.getPath() + fileName);
				log.info("절대 경로 file path : " + tempPath);
				
				// 파일을 저장소에 저장
				try {
					byte[] bytes = multipartFile.getBytes();
					Files.write(Paths.get(tempPath + fileName), bytes);
				} catch (IOException e) {
					log.error("FileUploadController save File wroting error !");
					e.printStackTrace();
				} finally {
					try {
						if (fos != null) fos.close();
					} catch (IOException e) {
						log.error("FileUploadController save IOE : ");
						e.printStackTrace();
					}
					
					log.info("File upload success!");
				}
			}
		} else {
			log.error("File Type error!");
		}
		model.addAttribute("files", fileNames);
		model.addAttribute("filePathList", filePathList);
		
		return "file_upload_success";
	}
}
