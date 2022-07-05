package classEx03.vo;

public class BookData {
	public Book[] books = new Book[15];
	
	public BookData() {
		books[0] = new Book("DO it HTML 5 CSS 3", "고경희", "이지스퍼블리싱", 16800, 20);
		books[1] = new Book("모던 웹 디자인을 위한 HTML5 CSS3 입문",  "윤인성", "한빛미디어", 30000, 21);
		books[2] = new Book("HTML5 CSS3와 함께하는 드림위버 CS6 무작정 따라하기",   "고경희", "길벗", 24000, 10);
		books[3] = new Book("Head First HTML5 Programming", "엘리자베스 롭슨", "한빛미디어", 34000, 20);
		books[4] = new Book("만들면서 배우는 HTML5 CSS3 jQuery",  "야무",   "한빛미디어", 25000, 23);
		books[5] = new Book("HTML5 CSS3", "양용석", "로드북", 25000, 15);
		books[6] = new Book("HTML5 CSS3 WebGL로 재미있게 배우는 HTML5 게임 프로그래밍", "제이콥 세이드린",  "제이펍", 30000, 10);
		books[7] = new Book("HTML5 캔버스 완벽 가이드",  "데이비드 기어리", "위키북스",   40000,  10);
		books[8] = new Book("올인원웹실무가이드 HTML 5 CSS 3",    "나인환 김은영 외 1명",     "제우미디어", 28000, 16);
		books[9] = new Book("HTML5와 CSS3로 작성하는 반응형 웹 디자인", "벤 프레인",  "에이콘출판", 30000, 20);
		books[10] = new Book("HTML5가 보이는 그림책","ANK Co Ltd", "성안당", 31500,  21);
		books[11] = new Book("HTML5 Canvas", "스티브 펄튼, 제프 펄튼",   "한빛미디어", 38000,  20);
		books[12] = new Book("세르게이의 HTML5 CSS3 퀵 레퍼런스",  "세르게이 마브로디",  "제이펍", 20000,  10);
		books[13] = new Book("이제 실전이다 HTML5 CSS3 사이트제작의 모든것", "양용석", "로드북", 25000,  10);
		books[14] = new Book("iOS와 안드로이드를 위한 HTML5", "로빈 닉슨",  "한빛미디어", 33000,  10);
	}
}
