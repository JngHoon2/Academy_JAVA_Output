package com.javalab.stream01;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class St02_LambdaExpressionsExample {
	public static void main(String[] args) {
		List<Student> list = Arrays.asList(new Student("홍길동", 90), new Student("신용권", 92));
		
		for(Student student : list) {
			System.out.println(student);
		}
		System.out.println();
		
		Stream<Student> stream = list.stream();
		stream.forEach(s -> {
			String name = s.getName();
			int score = s.getScore();
			
			System.out.println(name + " - " + score + "점");
		});
		
		System.out.println();
		
		list.stream().forEach(student ->{
			System.out.println(student.toString());
		});
	}
}
