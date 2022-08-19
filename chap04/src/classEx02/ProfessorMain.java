package classEx02;

import classEx02.vo.*;

public class ProfessorMain {
	
	public static void main(String[] args) {
		Professor professor0 = new Professor("92001", "590327-1839240", "이태규", 920, "교수", "1997-0129");
		Professor professor1 = new Professor("92002", "690702-1350026", "고희석", 910, "부교수", "2003");
		Professor professor2 = new Professor("92301", "741011-2765501", "최성희", 910, "부교수", "2005");
		Professor professor3 = new Professor("92302", "750728-1102458", "김태석", 920, "교수", "1999");
		Professor professor4 = new Professor("92501", "620505-1200546", "박철재", 900, "조교수", "2007");
		Professor professor5 = new Professor("92502", "740101-1830264", "장민석", 910, "부교수", "2005");
		
		Professor[] professors = {professor0, professor1, professor2, professor3, professor4, professor5};
		
		
		// 문제 1
		System.out.println("[문제.1] printf 문을 통해서 교수들의 교 번호, 주민번호, 이름을 출력");
		System.out.println("아이디\t주민번호\t\t이름");
		System.out.printf("%s\t%s\t%s \n", professor0.getId(), professor0.getJumin(), professor0.getName());
		System.out.printf("%s\t%s\t%s \n", professor1.getId(), professor1.getJumin(), professor1.getName());
		System.out.printf("%s\t%s\t%s \n", professor2.getId(), professor2.getJumin(), professor2.getName());
		System.out.printf("%s\t%s\t%s \n", professor3.getId(), professor3.getJumin(), professor3.getName());
		System.out.printf("%s\t%s\t%s \n", professor4.getId(), professor4.getJumin(), professor4.getName());
		System.out.printf("%s\t%s\t%s \n", professor5.getId(), professor5.getJumin(), professor5.getName());
		System.out.println();
		
		// 문제 2
		System.out.println("[문제.2] 일반적인 for문을 통해서 교수 명단 출력");
		System.out.println("아이디\t주민번호\t\t이름");
		useGeneralFor(professors);
		System.out.println();
		
		// 문제 3
		System.out.println("[문제.3] 910 학과 교수중 입사년도가 2005년 도인 사람은?");
		find(professors);
		
	}
	
	public static void useGeneralFor(Professor[] professors) {
		for(int i = 0 ; i < professors.length; i++) {
			System.out.println(professors[i].getId() + "\t" + professors[i].getJumin() + "\t" + professors[i].getName());
		}
	}
	
	public static void find(Professor[] professors) {
		for(Professor p : professors) {
			if(p.getDepartment() == 910 && p.getHiredate().contains("2005")) {
				System.out.println(p.toString());
			}
		}
	}
}
