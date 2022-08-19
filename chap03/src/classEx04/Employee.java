package classEx04;

public class Employee {
	int empNo;
	String eName;
	String position;
	int salary;
	
	public Employee() {}
	
	public Employee(int empNo, String eName, String position, int salary) {
		this.empNo = empNo;
		this.eName = eName;
		this.position = position;
		this.salary = salary;
	}
	
	public void showInfo() {
		System.out.println("empNo : " + empNo);
		System.out.println("eName : " + eName);
		System.out.println("position : " + position);
		System.out.println("salary : " + salary);
	}
}
