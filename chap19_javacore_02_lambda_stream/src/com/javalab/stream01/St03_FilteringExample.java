package com.javalab.stream01;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class St03_FilteringExample {
	public static void main(String[] args) {
		List<Member> list = Arrays.asList(
					new Member("홍길동", "개발자"),
					new Member("김나리", "디자이너"),
					new Member("신용권", "개발자")	
		);
		
		List<Member> developerList = list.stream()
				// 직업이 개발자인 객체만 걸러서 새로운 스트림을 생성한다.
				.filter(m -> m.getJob().equals("개발자"))
				// 필터로 걸러진 스트림의 요소들을 List 컬렉션에 모아준다.
				.collect(Collectors.toList());
		
		developerList.stream().forEach(m -> System.out.println(m.getName()));
		System.out.println();
		
		list.stream().filter(member -> member.getJob().equals("개발자"))
					 .collect(Collectors.toList())
					 .forEach(m -> System.out.println(m));
		
	}
}
