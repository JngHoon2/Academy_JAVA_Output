package chap02;

public class ArrayForloop {

	public static void main(String[] args) {
		int[] array = {83, 90, 87};
		
		double avg = 0;
		double sum = 0;
		
		for(int i=0; i < array.length; i++)
		{
			sum += array[i];
		}
		
		avg = Math.round(sum / array.length * 100) * 0.01;
		
		System.out.println("sum: " + sum + "\navg: " + avg);
	}

}
