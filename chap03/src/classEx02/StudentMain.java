package classEx02;

public class StudentMain {

	public static void main(String[] args) {
		// 첫번째 학생 
		Student student = new Student();
		
		student.name = "김철수";
		student.age = 28;
		student.phone = "010-1234-5678";
		
		System.out.println(student.name);
		System.out.println(student.age);
		System.out.println(student.phone);
		
		// 두번째 학생 
		Student student2 = new Student();
		
		student.name = "이영희";
		student.age = 22;
		student.phone = "010-8765-4321";
		
		System.out.println(student.name);
		System.out.println(student.age);
		System.out.println(student.phone);
	}

}
