package classEx03;

import classEx03.vo.Book;
import classEx03.vo.BookData;

public class BookMain {

	public static void main(String[] args) {
		BookData bData = new BookData();
		
		showInfo(bData);
		System.out.println();
		lobson(bData);
		System.out.println();
		hanbit(bData);
		
	}
	
	public static void showInfo(BookData bData) {
		System.out.println("[1]. 전체 책 목록");
		for (int i = 0; i < bData.books.length; i++) {
			System.out.println(i+1 + ". " + bData.books[i].getName() + "\t" + bData.books[i].getAuthor() + "\t"
					+ bData.books[i].getPublisher() + "\t" + bData.books[i].getPrice() + "\t" + bData.books[i].getQuantity());
			
		}
	}
	
	public static void lobson(BookData bData) {
		System.out.println("[2]. 엘리자베스 롭슨이 출판한 책");
		for (int i = 0; i < bData.books.length; i++) {
			if(bData.books[i].getAuthor().equals("엘리자베스 롭슨")) {
				System.out.println(bData.books[i].getName() + "\t" + bData.books[i].getAuthor() + "\t"
						+ bData.books[i].getPublisher() + "\t" + bData.books[i].getPrice() + "\t" + bData.books[i].getQuantity());
			}
		}
	}

	public static void hanbit(BookData bData) {
		System.out.println("[3]. 한빛미디어에서 출판한 모든 책");
		for (int i = 0; i < bData.books.length; i++) {
			if(bData.books[i].getPublisher().equals("한빛미디어")) {
				System.out.println(bData.books[i].getName() + "\t" + bData.books[i].getAuthor() + "\t"
						+ bData.books[i].getPublisher() + "\t" + bData.books[i].getPrice() + "\t" + bData.books[i].getQuantity());
			}
		}
	}

}
