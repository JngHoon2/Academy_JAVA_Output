package chap01;

public class Gugudan {

	public static void main(String[] args) {
		for(int i = 1 ; i <= 9; i++)
		{
			for(int j = 2; j<= 9; j++)
			{
				if(j*i < 10)
					System.out.print(j + "x" + i + "=0" + j*i + " ");
				else
					System.out.print(j + "x" + i + "=" + j*i + " ");
			}
			System.out.println();
		}

	}

}
