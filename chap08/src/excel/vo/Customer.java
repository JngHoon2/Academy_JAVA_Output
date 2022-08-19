package excel.vo;

public class Customer {
	private int no;			// 고객번호
	private int age;		// 나이
	private String job;		// 직업
	private String marital;	// 결혼여부
	private String housing;		// 자가여부(집)
	private String loan;		// 대출여부
	private String contact;		// 연락(집전화,이메일,휴대
	private int duration; 		// 대출기간
	
	
	
	public Customer(int no, int age, String job, String marital, String housing, String loan, String contact,
			int duration) {
		super();
		this.no = no;
		this.age = age;
		this.job = job;
		this.marital = marital;
		this.housing = housing;
		this.loan = loan;
		this.contact = contact;
		this.duration = duration;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getMarital() {
		return marital;
	}
	public void setMarital(String marital) {
		this.marital = marital;
	}
	public String getHousing() {
		return housing;
	}
	public void setHousing(String housing) {
		this.housing = housing;
	}
	public String getLoan() {
		return loan;
	}
	public void setLoan(String loan) {
		this.loan = loan;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	@Override
	public String toString() {
		return "Customer [no=" + no + ", age=" + age + ", job=" + job + ", marital=" + marital + ", housing=" + housing
				+ ", loan=" + loan + ", contact=" + contact + ", duration=" + duration + "]";
	}
	
	
}
