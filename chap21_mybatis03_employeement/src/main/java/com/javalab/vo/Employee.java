package com.javalab.vo;

import java.sql.Date;
import lombok.Data;

@Data
public class Employee {
	private Long employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private Date hireDate;
	private String jobId;
	private Long salary;
	private Long commissionPct;
	private Integer managerId;
	private Integer departmentId;
}
