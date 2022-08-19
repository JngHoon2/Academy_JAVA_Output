package chap01;
public class IncreaseDecreaseOperator {
	public static void main(String args[]) {

		int i=5;
		System.out.println(i++);		//5 증가되기 전
		System.out.println(i);			//6 증가된 후
		
		int a = 1;
		int b = 2;
		int c = a++;  					//c = 1
		System.out.println("a : " + a);	//a = 2
		System.out.println("c : " + c); //c = 1
		
		int d = ++b + 3;  //[오타] 6 (b를 1증감시키고 그 다음에  + 3 연산 진행)
		System.out.println("d : " + d);  //6
		System.out.println("b : " + b);  //3
		
		int e = c++ + 4;  //11(y값에다 + 10을해서 result에 넣은후 y값을 1증가 시킴)
		System.out.println("e : " + e);  //5
		System.out.println("c : " + c);  //2

	}
}