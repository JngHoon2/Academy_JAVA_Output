package board.vo;

import java.util.ArrayList;

public class BoardData {
	
	//public Board[] boards = new Board[18];
	public ArrayList<Board> boardlist = new ArrayList<Board>();
	
	public BoardData() {
		Board []boards = new Board[18];
		boards[0] = new Board(11968, "2021 07 08 클래스연습데이터7 (student/takes)", "김광식", 25);
		boards[1] = new Board(11967, "2021 07 08 클래스연습데이터5 (학과/학생)", "김정현", 62);
		boards[2] = new Board(11965, "2021 07 07 클래스 연습 데이터 4 (부서/사원)", "김현정", 60);
		boards[3] = new Board(11966, "2021 07 07 클래스 연습 데이터 4 도서", "김성주", 34);
		boards[4] = new Board(11964, "2021 07 07 클래스 연습 데이터 3 (도서) ", "이성주", 65);
		boards[5] = new Board(11963, "2021 07 06 클래스 연습 데이터 2 (학생) ", "김현정", 44);
		boards[6] = new Board(11962, "2021 07 06 클래스 연습 데이터 (교수) ", "백태성", 48);
		boards[7] = new Board(11961, "2021 07 03 3가지 문제를 메서드 처리 ", "김광식", 58);
		boards[8] = new Board(11960, "2021 07 03 split() 와 클래스 연습 데이터", "김정현", 54);
		boards[9] = new Board(11959, "2021 07 02 마지막 3가지 문제 ", "박광수", 92);
		boards[10] = new Board(11958, "2021 07 02 split test ", "김현정", 53);
		boards[11] = new Board(11957, "2021 07 02 제어문 연습데이터 ", "김정현", 64);
		boards[12] = new Board(11956, "코드를 엉망으로 작성하는 법 ", "박광수", 43);
		boards[13] = new Board(11955, "유지 보수 어렵게 코딩하는 방법 ", "김광식", 59);
		boards[14] = new Board(11954, "2021 07 01 Java Platform Standard Edition 8 Documentation ","Amor vincit omnia", 29);
		boards[15] = new Board(11641, "2019 01 30 변수, 배열, 객체, 클래스 (기초 문법 간단 요약) ", "박광수", 91);
		boards[16] = new Board(11640, "2019 01 30 변수, 배열, 객체, 클래스 (기초 문법 간단 요약) ", "김성주", 95);
		boards[17] = new Board(11639, "2019 01 30 기본 지식 정리 ", "김성주", 70);
		for(Board b :boards)
		{
			boardlist.add(b);
		}
	}
}
