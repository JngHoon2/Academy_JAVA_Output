package chap02;

public class ArrayConsult {

	public static void main(String[] args) {
		String[] array = {"최진형", "이성준", "최기선"};
		for(int i = 0; i< array.length; i++) {
			System.out.println(array[i] + "님이 상담을 받았습니다.");
		}
		
		for(String string : array) {
			System.out.println(string + "님이 상담을 받았습니다.");
		}
	}

}
