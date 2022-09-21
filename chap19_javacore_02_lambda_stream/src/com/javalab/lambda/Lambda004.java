package com.javalab.lambda;

@FunctionalInterface
interface  MyFunctionalInterface2 {
	public int run(int x, int y);  // 유일한 추상 메소드
}

public class Lambda004 {
	public static void main(String[] args) {
		 MyFunctionalInterface2 fi;
		 
		 int sum = 0;
		 
		 fi = (x, y) -> {
			 System.out.println("method cell1");
			 return x + y;
		 };
		 sum = fi.run(2, 3);
		 System.out.println(sum);
		 System.out.println(fi);
		 
		 fi = (a, b) -> {return a > b ? a : b;};
		 sum = fi.run(6, 7);
		 System.out.println(sum);
		 System.out.println(fi);
		 
		 fi = (x, y) -> x + y;
		 sum = fi.run(8, 9);
		 System.out.println(sum);
	}
}
