package com.javalab.domain;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

/**
 * 업로드 파일들을 담는 저장소(그릇)
 * @author test
 *
 */
@Getter
@Setter
public class FileUploadForm {
   
   private List<MultipartFile> files;

}