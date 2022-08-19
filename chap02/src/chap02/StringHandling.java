package chap02;

public class StringHandling {

	public static void main(String[] args) {
		String jumin = "980324-1234567";

		// [1] substring 연습
		// 문자열을 반목문을 통해서 한자씩 추출
		for (int i = 0; i < jumin.length(); i++) {
			System.out.print(jumin.charAt(i) + " ");
		}

		String gender = jumin.substring(7, 8);
		System.out.println(gender);

		if (gender.equals("1")) {
			System.out.println("남성입니다.");
		} else {
			System.out.println("여성입니다.");
		}

		// [2] split 연습
		String[] sbString = jumin.split("-");
		System.out.println(sbString[0] + "-" + sbString[1]);

		if (sbString[1].substring(0, 1).equals("1")) {
			System.out.println("남성입니다.");
		} else {
			System.out.println("여성입니다.");
		}

		String str1 = "홍길동;천안;28;도술;010-2345-6789";
		String[] str2 = str1.split(";");

		for (String string : str2) {
			System.out.print(string + " ");
		}

		String str = "010-1234-5678";
		String[] num = str.split("-");
		System.out.println(num[0]);
		System.out.println(num[1]);
		System.out.println(num[2]);

		// [3] indexOf("구분자") 구분자의 위치 반환
		System.out.println(jumin.indexOf("-")); 
		System.out.println(jumin.substring(jumin.indexOf("-") + 1));

		// [4] replace()
		System.out.println(str.replace("-", "")); 
	}

}
