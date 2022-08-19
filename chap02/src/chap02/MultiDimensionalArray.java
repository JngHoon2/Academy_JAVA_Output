package chap02;

public class MultiDimensionalArray {

	public static void main(String[] args) {
		int[][] md = { { 95, 73 }, { 98, 34, 85 }, { 100, 95, 64, 75, 80 } };

		for (int i = 0; i < md.length; i++) {
			System.out.println( i + "번 째 배열의 크기는 " +md[i].length + "입니다.");
		}

		for (int i = 0; i < md.length; i++) {
			for (int j = 0; j < md[i].length; j++) {
				System.out.print("md[" + i + "][" + j+ "] : " + md[i][j] + "\t");
			}
			System.out.println();
		}

	}

}
