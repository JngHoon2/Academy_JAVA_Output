package board;

import board.vo.*;
import java.util.ArrayList;


public class BoardMain {

	public static void main(String[] args) {

		BoardData bd = new BoardData();
		// boardsData.bd = boardsData.boards;

		ArrayList<Board> boardArray = bd.boardlist;

//		for (int i = 0; i < bd.boardlist.size(); i++) {
//			boardArray.add(bd.boardlist.get(i));
//		}

		System.out.println("[문제.1] 향상된 for문으로 전체 게시물을 출력하시오.");
		for (Board boardAll : boardArray) {
			System.out.println(boardAll.toString());
		}
		System.out.println();

		System.out.println("[문제.2] 일반 for문으로 전체 게시물을 출력하시오.");
		for (int i = 0; i < bd.boardlist.size(); i++) {
			System.out.println(boardArray.get(i));
		}
		System.out.println();
		
		System.out.println("[문제.3] 김현정, 박광수가 작성한 게시물의 목록을 출력하시오.(향상된 for문)");
		for (Board board_two : boardArray) {
			if(board_two.getAuthor().equals("김현정") || board_two.getAuthor().equals("박광수")) {
				System.out.println(board_two.toString());
			}
		}
		System.out.println();

		System.out.println("[문제.4] 김현정, 박광수가 작성한 게시물의 목록을 출력하시오.(일반 for문)");
		for(int i=0; i<boardArray.size(); i++) {
			if(boardArray.get(i).getAuthor().equals("김현정") || boardArray.get(i).getAuthor().equals("박광수")) {
				System.out.println(boardArray.get(i));
			}
		}
		
	}

}
