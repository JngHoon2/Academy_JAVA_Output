package com.javalab.stream01;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class St01_IteratorStreamExample {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("홍길동", "이미나", "권도은");
		
		Iterator<String> iterator = list.iterator();
		while(iterator.hasNext()) {
			String name = iterator.next();
			System.out.println(name);
		}
		
		System.out.println();
		
		for(String string : list) {
			System.out.println(string);
		}
		
		System.out.println();
		
		Stream<String> stream = list.stream();
		
		Consumer<String> anonyObj = new Consumer<String>() {
			@Override
			public void accept(String var1) {
				System.out.println(var1);
			}
		};
		
		Consumer<String> anonyObj2 = (str) -> {
			System.out.println(str);
		};
		
		//stream.forEach(anonyObj);
		stream.forEach(anonyObj2);
		
		System.out.println();
		
		Stream<String> stream2 = list.stream();
		
		stream2.forEach(name ->{
			System.out.println(name);
		});
	}
}
