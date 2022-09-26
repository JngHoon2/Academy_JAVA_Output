package com.javalab.vo;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class BoardVo {

	private int no;
	private String title;
	private String id;
	private String content;
	private Date regDate;
	private int hit;
	
	/* 파일 업로드 멤버 변수 추가 */
	private MultipartFile uploadFile;
}
