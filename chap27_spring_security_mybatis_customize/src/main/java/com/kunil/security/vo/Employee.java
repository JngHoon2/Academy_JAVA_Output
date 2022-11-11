package com.kunil.security.vo;

import java.sql.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
public class Employee {

	 private int employeeId;
	 private String lastName;
	 private String firstName;
	 private String email;
	 private String phoneNumber;
	 private Date hireDate;
	 private String jobId;
	 private long salary;
	 private int commissionPct;
	 private int managerId;
	 private int departmentId;
	 
}