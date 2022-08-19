package chap02;

public class EmployeeData {

	public static void main(String[] args) {
		int length = 30;
		int[] age = { 44, 34, 28, 26, 29, 28, 27, 29, 29, 32, 23, 30, 30, 28, 31, 26, 33, 30, 28, 27, 33, 31, 32, 35,
				35, 25, 33, 34, 28, 28 };
		String[] name = { "오성훈", "정동욱", "안정환", "한성탁", "황태욱", "최지연", "이상덕", "윤지선", "정석원", "이경오", "오은지", "안은경", "이상배",
				"조영동", "김윤미", "장한샘", "김지훈", "김철호", "이승철", "윤수연", "박유선", "이혁성", "문경곤", "김병률", "김태환", "곽진영", "조영석", "조요환",
				"김동현", "정선숙" };
		String[] phone = { "010-7730-4737", "010-9679-5257", "010-9962-4536", "010-4617-0975", "011-895-7892",
				"010-6201-6976", "010-9492-6059", "010-4245-0105", "010-6243-4849", "010-4517-1609", "010-3470-5204",
				"010-4311-2563", "010-5131-9058", "010-6515-4454", "010-8565-1746", "010-4875-0827", "010-2034-3054",
				"010-9180-4710", "011-473-8512", "010-3062-2557", "010-3037-1174", "010-8743-0995", "010-5634-5664",
				"010-4220-5355", "010-2211-3901", "010-9190-2303", "010-5277-4620", "010-3013-1022", "010-9977-9804",
				"010-4564-7145" };
		String[] gender = { "M", "M", "M", "M", "M", "F", "M", "F", "M", "M", "F", "F", "M", "M", "F", "M", "M", "M",
				"M", "F", "F", "M", "M", "M", "M", "F", "M", "M", "m", "F" };
		String[] job = { "java", "java", "mobile", "it", "mobile", "java", "game", "java", "mobile", "it", "java",
				"mobile", "it", "mobile", "java", "game", "java", "it", "mobile", "game", "java", "it", "mobile", "it",
				"java", "game", "java", "it", "mobile", "it" };
		int[] pay = { 200, 200, 250, 300, 300, 200, 350, 200, 400, 440, 340, 250, 220, 270, 330, 430, 220, 510, 640,
				320, 280, 290, 310, 410, 500, 370, 290, 405, 440, 530 };
		String[] code = { "US", "FR", "JP", "US", "CN", "DE", "KR", "JP", "DE", "KR", "FR", "JP", "KR", "FR", "CN",
				"US", "US", "CN", "JP", "KR", "DE", "US", "US", "KR", "FR", "KR", "JP", "CN", "DE", "KR" };

		// 데이터 출력 
		System.out.println("색인\t나이\t이름\t연락처\t\t성별\t직업\t급여\t근무국가");
		System.out.println("------------------------------------------------------------");
		for(int i = 0; i < age.length; i++) {
			System.out.println(i+1 + "\t" + age[i] + "\t" + name[i] + "\t" + phone[i] + "\t" + gender[i] + "\t" + job[i] + "\t" + pay[i] + "\t" + code[i]);
		}
		System.out.println("------------------------------------------------------------");
		
		// 사원의 평균 연령
		System.out.println("전체 사원의 평균 연령 : " + avgAgeAll(age));
		
		// 성별 수 
		System.out.println("남성: " + countGender(gender));
		System.out.println("여성: " + countGender(gender));
	}
	
	public static double avgAgeAll(int[] age) {
		int ageSum = 0;
		double avgAge = 0;
		for(int item:age) {
			ageSum += item;
		}
		avgAge = (double)ageSum / age.length;
		
		return avgAge;
	}
	
	public static int[] countGender(String[] gender) {
		int[] gender_cnt = {0,0};
		
		for(String item:gender) {
			if(item.equals("M")) {
				gender_cnt[0]++;
			} else {
				gender_cnt[1]++;
			}
		}
		
		return gender_cnt;
	}
	
	
}
