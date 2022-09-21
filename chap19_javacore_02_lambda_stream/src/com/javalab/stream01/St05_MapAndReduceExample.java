package com.javalab.stream01;

import java.util.Arrays;
import java.util.List;

public class St05_MapAndReduceExample {
	public static void main(String[] args) {
		List<Student> studentList = Arrays.asList(
				new Student("홍길동", 10),
				new Student("김나리", 20),
				new Student("신용권", 30)
		);
		
		double avg = studentList.stream()
					.mapToInt(Student :: getScore) // IntStream을 리턴해줌
					.average()	// 평균값 계산
					.getAsDouble();	// 평균을 Double 타입으로 변환
		
		System.out.println("평균 점수 : " + avg);
	}
}
