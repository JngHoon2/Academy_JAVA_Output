package chap02;

public class ReseachTemp {
	static double max = 0;
	static double sum = 0, avg;
	
	public static void main(String[] args) {
		double[] temp = {-2.5, -0.2, 5.2, 21.1, 17.4, 21.9, 24.9, 29.4, 27.8, 14.4, 6.9, 0.2};
		
		max(temp);
		avg(temp);
		
		System.out.println("최고온도: " + max + "\n평균온도: " + avg);
	}
	
	public static void max(double[] array) {
		for(Double d : array) {
			if(max < d)
				max = d;
			sum += d;
		}
	}
	
	public static void avg(double[] array) {
		avg = sum / array.length;
	}
}
