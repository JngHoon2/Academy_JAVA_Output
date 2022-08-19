package chap01;

public class ScannerInput {

	public static void main(String[] args) throws Exception {
		int keyCode;
		char c ;
		while(true) {	//계속해서 키를 입력받는다.
			System.out.println("==========================================");
			System.out.println("영어 알파벳과 숫자를 입력하세요.");
			
			keyCode = System.in.read();	//입력되는 keyCode는 3개인데 그중에서 맨앞의 실제로 눌린 key(실제로 눌린 key + [Enter]13 + LF(라인피드)10)
			c = (char)keyCode;	//강제 형변환(char -> int)
			System.in.read();	//두번째로 입력되는 [Enter]에 대응하는 13이란 숫자를 읽게된다. 의미없는 숫자
			System.in.read();	//세번째로 입력되는 [Enter]에 대응하는 10이란 숫자를 읽게된다. 의미없는 숫자
			
			if(c >= '0' && c <= '9' ) {	//아스키코드 중에서 0~9 사이의 키가 눌렸는지 체크
				System.out.printf("키보드에서 %c key가 눌렸고 그 키와 매핑되는 숫자는 %d 입니다.\n",c, keyCode);
			}else if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')){	//영문 대소문자 key입력 체크
				System.out.printf("키보드에서 %c key가 눌렸고 그 키와 매핑되는 코드는 %s입니다.\n", c, keyCode);				
			}else {	// 영문 숫자 이외의 key 체크
				System.out.println("숫자와 알파벳 이외의 문자가 입력되어서 프로그램을 종료합니다.\n");
				break;
			}
		}
	}
}