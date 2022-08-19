package chap01;

//int 타입 범위
public class VarEx01 {
	public static void main(String[] args) {

		// byte type 오버플로
		byte b1 = 126;
		// 코드 타이핑과 동시에 미리 연산을 하여 b2에 저장하려고 한다.
		// 변수가 아니라 단순 리터럴 간의 연산이므로 형변환 없다.
		// 단지 왼쪽 변수 타입의 범위 안 인지만 체크(실무에서 쓸일 없음)
		byte b2 = 126 + 1; // byte 타입 범위 : -128 ~ +127이므로 가능
		// b2 = 126 + 2; // [오류] +128이 되어 오버플로우

		// 정수 타입 연산
		// 정수 변수 간의 연산은 기본적으로 피연산자 보다 int 타입으로 형변환 된 후에 연산되고 그 결과도 int 타입
		// int 타입간의 연산으로 결과가 int형으로 byte 변수 b3에 넣을 수 없음.
		// byte b3 = b1 + 1; // [오류]Type mismatch: cannot convert from int to byte
		// System.out.println(b3);

		// int 오버플로
		// int k = 2147483648;

		int i = 1;
		// i + 2147483646 + 1 결과는 2147483648이 되어 int 범위를 넘어서지만
		// int형을 int형에 넣기 때문에 컴파일 오류가 나지는 않는다. 다만 엉뚱한 값이 들어간다.
		int a = i + 2147483647; // -2147483648 [오버플로]
		// System.out.println(a); // 결과 : -2147483648(int형 범위 초과)

		// 읽기전에 2147483648 메모리에 올리면서 int 타입에 저장하려다.[int 범위 초과 컴파일오류]
		// 읽으면서 범위를 넘어서니 컴파일 오류 발생( type int is out of range )
		a = i + 2147483647 + 1; // 오류 : 정수는 모두 int로 읽어들이는데 The literal 2147483648 of type int is out of range

		// 2147483648L을 붙이면 괜찮을까요?(int 타입 a에 넣을 수 없어서 오류)
		// a = i + 2147483648L + 1; //오류 : 정수는 모두 int로 읽어들이는데

		// [설명]컴파일러는 정수값이 입력되면 기본적으로 int 형으로 간주해버린다. int형으로 간주하고
		// 읽어들이는데 int 타입의 허용 범위(약21억4천)를 넘어서니까 오류를 내는 것이다.
		// 이때는 “이건 long 타입에 저장할 거니까 long 타입으로 해줘”라고 컴파일러에게
		// 미리 알려줘야 한다. 그래서 L을 붙인다.
		// long var1 = 1000000000; //10억은
		// long var2 = 10000000000; //[컴파일 오류]100억 The literal 10000000000 of type int
		// is out of range
		// long var3 = 10000000000L; //L 표시로 이 자료는 long 타입이라고 알려줌 (컴파일 오류 안남)

		// long 타입으로 형변환(작은타입에서 큰타입으로 자동형변환)
		// long l1 = 200;
		// long l2 = 400;
		// int lsum = l1 + l2; // Type mismatch: cannot convert from long to int

		// 정수형 자동 형변환
		// short s = 21300;
		// int ii = s; //short 형인 s변수 값이 int 형인 i변수값으로 자동으로 형변환이 되어 저장됩니다.
		// System.out.println(ii);
		// long longValue = 50000000000L;

		// char charValue = 'A';
		// int intA = charValue; //char 타입이 int 타입으로 자동 형변환 되면서 유니코드 값이 저장된다.(65)

		// 실수형 자동 형변환
		// 컴파일러는 3.14를 실수 타입의 기본 타입인 double 타입으로 읽어들인다.
		// float pi = 3.14; //컴파일 오류, Type mismatch: cannot convert from double to float

		// 정수형 + 실수형 연산시 큰 타입으로 형변환되어 연산
		// int intValue = 10;
		// double doubleValue = 5.5;
		// double result = intValue + doubleValue; // intValue -> double 타입으로 타입 변환되어 연산
		// 진행
		// System.out.println(result);

		// 정수 나눗셈 연산에서 생기기 쉬운 오류
		// 정수간 나눗셈의 결과는 정수이다. 소슷점 이하는 버려진다.
		// int num1 = 9;
		// int num2 = 2;
		// double num3 = num1 / num2; // num1, num2 모두 int 타입이기 때문에 연시하면 소수점 버림
		// System.out.println(num3); // 4.0
		// num3 = (double)num1 / num2; // 한쪽을 형변환하면 다른 쪽도 큰쪽으로 맞춰서 형변환된 후에 연산이 되고 결과도
		// double 타입
		// System.out.println(num3); // 4.5
		// 하지만 이경우는 안됨
		// double num6 = (double)(num1 / num2); // (num1 / num2) 괄호 안에서 이미 결과가 소숫점이 버려진
		// 상태기 때문에 (double)0 해봐야 의미 없음.
		// System.out.println(num6); // 4.0 소숫점 버려짐

		// 논리타입
		// boolean stop = true;
		// Boolean start = false;
		// if(stop)
		// System.out.println("중지합니다"); //중지합니다.
		// else
		// System.out.println("시작합니다");
	}}