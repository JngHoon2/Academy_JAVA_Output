package com.javalab.invoice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {

	private String dept_id = "";
	private String dept_name = "";
	private String location = "";
	
}
