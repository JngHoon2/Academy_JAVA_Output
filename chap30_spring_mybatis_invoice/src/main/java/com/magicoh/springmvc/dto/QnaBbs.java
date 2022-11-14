package com.magicoh.springmvc.dto;
import java.io.Serializable;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/****************************************************************
 * 
 * This is a Qna Bbs
 * Created by magicoh
 * 2020.11.27
 *   
 ****************************************************************/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QnaBbs{

	private int no;			
	private String title;
	private String content;        	
	private String writer;  	
	private int hit;	   	
	private Date regdate;	
	
}
