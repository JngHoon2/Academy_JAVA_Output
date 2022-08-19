package Assignment01;

import Assignment01.vo.Student;

public class StudentMain {

	public static void main(String[] args) {
		Student student1 = new Student("1292001", "900424-1825409", "김광식", 3, "서울", 92);
		Student student2 = new Student("1292002", "900305-1730021", "김정현", 3, "서울", 20);
		Student student3 = new Student("1292003", "891021-2308302", "김현정", 4, "대전", 55);
		Student student4 = new Student("1292301", "890902-2704012", "김현정", 2, "대구", 78);
		Student student5 = new Student("1292303", "910715-1524390", "박광수", 3, "광주", 54);
		Student student6 = new Student("1292305", "921011-1809003", "김우주", 4, "부산", 88);
		Student student7 = new Student("1292501", "900825-1506390", "박철수", 3, "대전", 73);
		Student student8 = new Student("1292502", "911011-1809003", "백태성", 3, "서울", 95);

		Student[] students = { student1, student2, student3, student4, student5, student6, student7, student8 };

		// 전체 학생 명단 출력
		showStudents(students);
		System.out.println();

		// 여학생 명단 출력
		showFemaleStudents(students);
		System.out.println();

		// 서울사는 3학년 학생 명단 출력
		showSATStudents(students);
		System.out.println();
	}

	// 전체 학생 출력 메소드
	public static void showStudents(Student[] students) {
		System.out.println("=======================================================================");
		System.out.println("  학번\t\t   주민번호\t\t이름\t학년\t주소\t학과코드");
		System.out.println("=======================================================================");
		for (Student student : students) {
			System.out.println(student.getId() + "\t\t" + student.getJumin() + "\t\t" + student.getName() + "\t"
					+ student.getYear() + "\t" + student.getAddress() + "\t" + student.getDepartment());
		}
		System.out.println("=======================================================================");
	}

	// 여학생 출력 메소드
	public static void showFemaleStudents(Student[] students) {
		System.out.println("============================== 여학생 명단 ===============================");
		for (Student student : students) {
			if (student.getJumin().charAt(7) == '2') {
				System.out.println(student.getId() + "\t\t" + student.getJumin() + "\t\t" + student.getName() + "\t"
						+ student.getYear() + "\t" + student.getAddress() + "\t" + student.getDepartment());
			}
		}
	}

	// 서울 사는 3학년 출겨 메소드 (show Seoul And Third Grand Students)
	public static void showSATStudents(Student[] students) {
		System.out.println("========================== 서울 사는 3학년 명단 ===================================");
		for (Student student : students) {
			if (student.getAddress().equals("서울") && student.getYear() == 3) {
				System.out.println(student.getId() + "\t\t" + student.getJumin() + "\t\t" + student.getName() + "\t"
						+ student.getYear() + "\t" + student.getAddress() + "\t" + student.getDepartment());
			}
		}
	}
}
