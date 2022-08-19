package chap01;

import java.util.*;

public class GradeCheckSwitch {
	public static void main(String[] args) {
		int score = 0;
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.print("점수를 입력하세요.(1~100) 종료:q>");
			System.out.println();
			String tmp = scanner.nextLine(); // 키보드에서 Scanner를 사용해서 점수 입력받음
			if (tmp.equals("q")) {
				System.out.println("q가 입력되어 프로그램을 종료합니다.");
				break;
			} else if (tmp.equals("")) {
				System.out.println("빈칸(Empty)이 입력되어 프로그램을 종료합니다.");
				break;
			}
			score = Integer.parseInt(tmp);
			
			System.out.println("당신의 등급은 " + checkLevel(score) + "점입니다.");
		}
	} // end of main

	// 모듈
	public static String checkLevel(int score) {
		switch (score / 10) { // 점수/10(예, 95/10
		case 10:
		case 9:
			if (score * 1.0 / 10 >= 9.8) {
				return "A+";
			} else {
				return "A-";
			}
		case 8:
			return "B";
		case 7:
			return "C";
		default:
			return "F";
		} // end of switch
	}
}