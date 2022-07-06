package inheritance;

public class Student extends Human {
	int stdNo;
	String major;
	
	public Student(String name, int age, int stdNo, String major) {
		super(name, age);
		this.stdNo = stdNo;
		this.major = major;
	}
	
	public void StudentInfo() {
		this.humanInfo();
		System.out.println("[Student Info]");
		System.out.println("학번 : " + stdNo);
		System.out.println("전공 : " + major);	
	}
}
