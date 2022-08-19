package classEx05.vo;

public class Professor {
	private String id;
	private String jumin;
	private String name;
	private int department;
	private String grade;
	private String hiredate;
	
	public Professor() {}

	public Professor(String id, String jumin, String name, int department, String grade, String hiredate) {
		this.id = id;
		this.jumin = jumin;
		this.name = name;
		this.department = department;
		this.grade = grade;
		this.hiredate = hiredate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getJumin() {
		return jumin;
	}

	public void setJumin(String jumin) {
		this.jumin = jumin;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDepartment() {
		return department;
	}

	public void setDepartment(int department) {
		this.department = department;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getHiredate() {
		return hiredate;
	}

	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}

	@Override
	public String toString() {
		return "Professor [id=" + id + ", jumin=" + jumin + ", name=" + name + ", department=" + department + ", grade="
				+ grade + ", hiredate=" + hiredate + "]";
	}
	
	
	
	
}
