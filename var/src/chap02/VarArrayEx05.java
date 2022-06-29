package chap02;

public class VarArrayEx05 {
    //전역변수(클래스 전체에서 사용가능)
	static int[] globalArr1; // 선언만 되어 있고 초기화 안된상태[오류]
	static int[] globalArr2 = new int[5]; //5칸짜리 값을 담을 공간을 메모리 확보

	public static void main(String[] args) {
        //지역변수(main 메소드 안에서만 사용가능)
		int[] localArr1; // 선언만 되어 있고 초기화 안된상태[오류]
		int[] localArr2 = new int[5]; //5칸짜리 값을 담을 공간을 메모리 확보
		
		//System.out.println(globalArr1[0]); // NullPointerException 널포인트익셉션
		System.out.println(globalArr2[0]);
		
		//System.out.println(localArr1[0]);  //초기화 하라고 컴파일러가 알려줌[컴파일오류]
		System.out.println(localArr2[0]);
		sum2(localArr2); // 다른 메소드에서 자신의 변수를 사용할 수 있도록 인자로 전달함.
	}
	

	public static void sum() {
		System.out.println(globalArr2[0]); //전역변수는 클래스의 모든 영역에서 사용가능
		//System.out.println(localArr2[0]);  //[오류]main 메소드의 지역변수는 sum()메소드에서 사용불가
	}
	
	public static void sum2(int[] localArr2) {  //main()의 지역변수를 매개변수로 전달 받음
		System.out.println(globalArr2[0]); //전역변수는 클래스의 모든 영역에서 사용가능
		System.out.println(localArr2[0]);  //전달받은 매개변수값 사용해서 접근 사용가능
	}	
}