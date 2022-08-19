package classEx05;
import classEx05.vo.*;

public class SchoolManagementMain {

	public static void main(String[] args) {
		//데이터 생성(객체들이 생성되어 메모리에 올라감)
				//MakeData data = new MakeData();
				
				/**
				 * [문제.1] 전체 학생 명단을 출력하시오.
				 */
				//학생 데이터 생성
				Student[] students = new Student[8];
				students[0] = new Student("1292001", "900424-1825409", "김광식", 3, "서울", 920);
				students[1] = new Student("1292002", "900305-2730021", "김정현", 3, "서울", 923);
				students[2] = new Student("1292003", "891021-2308302", "김현정", 4, "대전", 925);		
				students[3] = new Student("1292301", "880902-2704012", "김정숙", 2, "대구", 923);
				students[4] = new Student("1292303", "910715-1524390", "박광수", 3, "광주", 920);
				students[5] = new Student("1292305", "921011-1809003", "김우주", 4, "부산", 925);
				students[6] = new Student("1292501", "900825-1506390", "박철수", 3, "대전", 923);
				students[7] = new Student("1292502", "911011-1809003", "백태성", 3, "서울", 925);

				/**
				 * [문제.1] 전체 학생 리스트를 출력하시오.
				 */
				// 교수 데이터 생성
				System.out.println("======================== 1.전체 학생 정보 리스트 ======================");
				for(Student s : students) {
					System.out.println(s.getId() + " " + s.getName() +  " " + s.getJumin() +  " " + s.getYear() +  " " + s.getAddress() +  " " + s.getDepartment());
				}
				System.out.println();	//한줄을 띄는 용도
				
				/**
				 * [문제.2] 교수 리스트를 출력하시오.
				 */
				// 교수 데이터 생성
				Professor[] professors = new Professor[6];
				professors[0] = new Professor("92001", "590327-1839240", "이태규", 920, "교수", "1997");
				professors[1] = new Professor("92002", "690702-1350026", "고희석", 923, "교수", "2003");
				professors[2] = new Professor("92301", "741011-2765501", "최성희", 920, "부교수", "2005");		
				professors[3] = new Professor("92302", "750728-1102458", "김태석", 923, "부교수", "1999");
				professors[4] = new Professor("92501", "620505-1200546", "박철재", 925, "교수", "2007");		
				professors[5] = new Professor("92502", "740101-1830264", "장민석", 920, "조교수", "2005");

				System.out.println("======================= 2.교수 리스트 ======================");
				for(Professor p : professors) {
					System.out.printf("%s  %s  %s  \n", p.getId(), p.getJumin(), p.getName());
					}
				System.out.println();	//한줄을 띄는 용도

				/**
				 * [문제.3] 학과 리스트를 출력하시오.
				 */
				// 학과 데이터 생성
				Department[] departments = new Department[3];		
				departments[0] = new Department(920, "컴퓨터공학과", "201호");
				departments[1] = new Department(923, "산업공학과", "207호");
				departments[2] = new Department(925, "전자공학과", "308호");

				System.out.println("=================== 3.학과 리스트 =====================");
				for(Department d : departments) {
					System.out.println(d.getId() + "\t" + d.getName() + " \t" + d.getOffice());
				}
				System.out.println();	//한줄을 띄는 용도

				/**
				 * [문제.4] 성적 데이터를 출력하시오.
				 */
				// 성적 데이터 생성
				Takes[] takes = new Takes[12];
				takes[0] = new Takes("1292001", "C101-01", "B+");
				takes[1] = new Takes("1292001", "C103-01", "A+");
				takes[2] = new Takes("1292001", "C301-01", "A");
				takes[3] = new Takes("1292002", "C102-01", "A");
				takes[4] = new Takes("1292002", "C103-01", "B+");
				takes[5] = new Takes("1292002", "C502-01", "C+");
				takes[6] = new Takes("1292003", "C103-02", "B");
				takes[7] = new Takes("1292003", "C501-02", "A+");
				takes[8] = new Takes("1292301", "C102-01", "C+");
				takes[9] = new Takes("1292303", "C102-01", "C");
				takes[10] = new Takes("1292303", "C103-02", "B+");
				takes[11] = new Takes("1292303", "C501-01", "A+");	
				System.out.println("=================== 4.성적 데이터 =====================");
				for(Takes t : takes) {
					System.out.println(t.getId() + "\t" + t.getSubject() + " \t" + t.getScore());
				}
				
				System.out.println();
				System.out.println("=================== 5.학생정보와 소속 학과 명 =====================");
				for(Student s : students) {
					for(Department d : departments) {
						if(s.getDepartment() == d.getId()) {
							System.out.println(s.getId() + " " + s.getName() +  " " + s.getJumin() +  " " + s.getYear() +  " " + s.getAddress() 
							+  " " + s.getDepartment()+  " " + d.getName());
						}
					}
				}
				System.out.println();
				System.out.println("=================== 6.특정 학생 정보 출력 =====================");
				for(Takes t : takes) {
					for(Student s:students) {
						if(t.getId() == s.getId()) {
							System.out.println(s.getId() + " " + s.getName() +  " " + s.getJumin() +  " " + s.getYear() +  " " + s.getAddress() 
							+  " " + s.getDepartment()+  " " + t.getSubject() + " " + t.getScore());
						}
					}
				}
				
	}

}
