package chap01;

public class WhileSumBreak {

	public static void main(String[] args) {
		int sum = 0;
		int cnt = 0;
		
		while(cnt < 100)
		{
			sum += ++cnt;
		}
		
		System.out.println(sum);
	}
}
