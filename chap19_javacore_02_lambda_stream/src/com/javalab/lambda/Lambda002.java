package com.javalab.lambda;

public class Lambda002 {
	public static void main(String[] args) {
		int max = 0;
		MyFunctionalInterface001 fi;
		
		fi = (a, b) -> a > b ? a : b;
		
		Object obj = new Object() {
			int max(int a, int b) {
				return a > b ? a : b;
			}
		};
		
		max = fi.max(2,3);
		System.out.println(max);
		System.out.println(fi);
	}
	
	@FunctionalInterface
	interface MyFunctionalInterface001{
	   public int max(int a, int b);   // 추상 메소드
	}
	
}
