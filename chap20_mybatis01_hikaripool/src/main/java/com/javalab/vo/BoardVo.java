package com.javalab.vo;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;


/** VO : Value Object **/
@Data
public class BoardVo {
	private int no;
	private String title;
	private String id;
	private String content;
	private Date regDate;
	private int hit;
	
	private MultipartFile uploadFile;
}
