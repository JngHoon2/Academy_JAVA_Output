package chap02;

public class MaxNum {

	public static void main(String[] args) {
		int[] array = {5, 2, 14, 20, 8, 31, 45, 61};
		int maxNum = 0;
		int space;
		
		for(int i = 0; i < array.length; i++)
		{
			if(maxNum < array[i])
				maxNum = array[i];
		}
		
		System.out.println("MaxNum: " + maxNum);
		
		for(int i = array.length -1 ; i > 0; i--)
		{
			for(int j = 0; j < i; j++)
			{
				if(array[j] > array[j+1])
				{
					space = array[j];
					array[j] = array[j+1];
					array[j+1] = space;
				}
			}
		}
		
		for(int i = 0; i < array.length; i++)
		{
			System.out.print(array[i] + " ");
		}
		
	}

}
