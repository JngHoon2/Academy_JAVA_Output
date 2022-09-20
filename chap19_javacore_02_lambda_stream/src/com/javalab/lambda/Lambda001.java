package com.javalab.lambda;

public class Lambda001 {
	public static void main(String[] args) {
		int max = 0;
		max = max(2, 3);
		System.out.println(max);
	}
	
	public static int max(int a, int b) {
		return a > b ? a : b;
	}
}
