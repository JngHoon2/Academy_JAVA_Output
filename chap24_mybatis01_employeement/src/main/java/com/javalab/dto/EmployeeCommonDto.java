package com.javalab.dto;

import java.sql.Date;

import com.javalab.vo.Employee;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * [조회/운송 전용 Dto :Data Transfer Object]
 * - 데이터 운송용 객체로서 데이터베이스에서 여러 테이블을 조인해서 결과를 받아올 경우
 *   하나의 Vo 객체에는 모두 담을 수 없기 때문에 별도의 Dto 클래스를 통해서 데이터 운송
 */

@Getter
@Setter
@NoArgsConstructor
@ToString
public class EmployeeCommonDto extends Employee{
	// Employee에서 상속받은 멤버변수(DB컬럼)
	
	// Vo가 갖고 있지 않는 추가 멤버 변수(DB컬럼 아님, 데이터운송용)
	private String jobTitle;
	private String departmentName;
	private String stateProvince;
	private String city;
	private String countryName;
}
