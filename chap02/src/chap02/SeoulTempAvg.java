package chap02;

public class SeoulTempAvg {

	
	public static void main(String[] args) {
		float sum = 0.0f;
		double avg = 0.0;

		float[] monTemp = new float[] {-2.5f, -0.2f, 5.2f, 12.1f, 17.4f, 21.9f, 24.9f, 29.4f, 27.8f, 14.4f, 6.9f, 0.2f};
		
		System.out.println();
		
		avg = maxTemp(monTemp) / monTemp.length; 
		System.out.println("avg : " + avg);
		
		sortAsc(monTemp);
		
		System.out.println();
		
		float maxTemp = monTemp[0]; //맨좌측 최대값 
		float minTemp = monTemp[monTemp.length-1]; //맨우측 최고값	
		
		System.out.printf("서울의 연평균 기온은  %1$5.1f이며 가장 높은 기온은 %2$5.1f, " 
		+  "가장 낮은 기온은 %3$5.1f입니다.", avg, maxTemp, minTemp);
	}
	
	public static float maxTemp(float[] array) {
		float sum = 0;
		for(int i=0; i<array.length; i++) {
			sum = sum + array[i];
			System.out.print(array[i] + " ");
		}
		System.out.println();
		return sum;
	}
	
	
	public static void sortAsc(float[] array) {
		float smallNum = 0.0f;
		//Ascending(오름차순) 맨오른쪽:최대값, 맨왼쪽:최소값
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] < array[j]) {
					smallNum = array[i];
					array[i] = array[j];
					array[j] = smallNum;
				}
			}
		}
	}
}