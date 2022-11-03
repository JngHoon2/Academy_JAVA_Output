package com.javalab.vo;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
public class BoardVO {

	private int no;
	private String title;
	private String id;	// writer -> id
	private String content;
	private Date regDate;
	private int hit;
	
	/** 파일 업로드 멤버 변수 추가 **/
	private MultipartFile uploadFile;
	
}
