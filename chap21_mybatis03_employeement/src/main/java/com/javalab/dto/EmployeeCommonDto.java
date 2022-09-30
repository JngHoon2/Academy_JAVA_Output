package com.javalab.dto;

import com.javalab.vo.Employee;

import lombok.*;

/*
 * [DTO : Data Transfer Object]
 * 데이터 운송용 객체로서 데이터베이스에서 여러 테이블을 조인해서 결과를 가져올 경우, 
 * 하나의 Vo 객체에 전부 담을 수 없기 때문에 별도의 dto 클래스를 통해서 
 * 데이터를 운송해야한다.
 */


@Getter
@Setter
@NoArgsConstructor
@ToString
public class EmployeeCommonDto extends Employee{
	// Employee 에서 상속 받은 변수 + 하위 5개 변수
	private String jobTitle;
	private String departmentName;
	private String stateProvince;
	private String city;
	private String countryName;
}
