package classEx04;

public class EmployeeMain {

	public static void main(String[] args) {
		Employee em = new Employee();
		em.empNo = 2005031002;
		em.eName = "배준섭";
		em.position = "과장";
		em.salary = 500;
		System.out.println(em);
		System.out.println(em.empNo + " " + em.eName + " " + em.position + " " + em.salary);
		
		Employee em2 = new Employee();
		em2.empNo = 2021010003;
		em2.eName = "김홍철";
		em2.position = "사원";
		em2.salary = -250;
		em2.showInfo();
	}

}
