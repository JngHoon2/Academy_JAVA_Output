package chap02;

public class sheet {

	public static void main(String[] args) {
		// 데이터 수동 삽입 
		String[] column = {"색인", "이름", "나이", "성별", "전화번호", "직업", "급여", "근무국가"};
		int[] indexArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		String[] nameArray = { "kim", "ellis", "park", "james", "tom", "steve", "john", "lee", "moon", "allen" };
		int[] ageArray = { 27, 34, 28, 26, 29, 28, 27, 29, 29, 32 };
		char[] genderArray = { 'F', 'M', 'F', 'M', 'M', 'F', 'M', 'M', 'F', 'M' };
		String[] phoneArray = { "010-8532-0537", "010-9672-5257", "010-9932-4536", "010-4117-0975", "011-8975-7892",
				"010-6251-6976", "010-9482-6059", "010-4845-0105", "010-6283-4849", "010-4510-1609" };
		String[] jobArrayStrings = { "game", "java", "mobile", "it", "mobile", "java", "game", "java", "mobile", "it" };
		int[] salaryArray = { 460, 200, 250, 300, 380, 200, 350, 200, 690, 440 };
		String[] countryArrayStrings = { "JP", "FR", "JP", "US", "CN", "DE", "KR", "JP", "DE", "KR" };
		
		// 컬럼 출력 
		for(String string:column) {
			if(string.equals("전화번호"))
			{
				System.out.print(string + "\t" + "\t");
				continue;
			}
			System.out.print(string + "\t");
		}
		System.out.println();
		System.out.println("-----------------------------------------------------------------------");
		// 데이터 출력 
		for(int i = 0; i < indexArray.length; i++) {
			System.out.println(indexArray[i] + "\t" + nameArray[i] + "\t" + ageArray[i] + "\t" 
		+ genderArray[i] + "\t" + phoneArray[i] + "\t" + jobArrayStrings[i] + "\t" + salaryArray[i] + "\t" + countryArrayStrings[i]);
			
		}
		
		System.out.println("-----------------------------------------------------------------------");
		
		// 전체 사원 나이 평균 연령
		double avgAll = 0;
		int sumAll = 0;
		for(int age:ageArray) {
			sumAll += age;
		}
		avgAll = (double)sumAll / ageArray.length;
		System.out.println("전체 사원 평균 나이 : " + avgAll);
		
		// 남자 사원 평균 연령
		System.out.println("남자 사원 평균 나이 : " + malesAvgAge(genderArray, ageArray));
		
		// 여자 사원 평균 급여 
		System.out.println("여자 사원 평균 급여 : " + femaleAvgSalary(genderArray, salaryArray));
		
		// 일본 근무자의 이름과 연락처 
		japanWorker(countryArrayStrings, nameArray, phoneArray);
	}
	
	public static double malesAvgAge(char[] genderArray, int[] ageArray) {
		double avgMale = 0;
		int sumMale = 0;
		int male_cnt = 0;
		for(int i = 0; i < genderArray.length; i++) {
			if(genderArray[i] == 'M') {
				sumMale += ageArray[i];
				male_cnt++;	// 남자 사원 카운트 
			}
		}
		return avgMale = (double)sumMale / male_cnt;	
	}
	
	public static double femaleAvgSalary(char[] genderArray, int[] salaryArray) {
		double avgSalary = 0;
		int sumFemaleSalary = 0;
		int female_cnt = 0;
		for(int i = 0; i < genderArray.length; i++) {
			if(genderArray[i] == 'F') {
				sumFemaleSalary += salaryArray[i];
				female_cnt++;
			}
		}
		return avgSalary = (double)sumFemaleSalary / female_cnt;
	}
	
	public static void japanWorker(String[] countryArrayStrings, String[] nameArray, String[] phoneArray) {
		String [][] japan = new String[3][2];
		int arrayIndex = 0;
		for(int i = 0; i < countryArrayStrings.length; i++) {
			if(countryArrayStrings[i].equals("JP")) {
				japan[arrayIndex][0] = nameArray[i];
				japan[arrayIndex][1] = phoneArray[i];
				arrayIndex++;
				}
			}
		for(int i = 0; i < japan.length; i++){
			for(int j = 0; j<japan[i].length; j++) {
				System.out.println("japan[" + i + "][" + j + "] : " + japan[i][j]);
			}
		}
	}
}
