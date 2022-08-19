package classEx05.vo;

public class Department {
	private int id;			
	private String name;		
	private String office;	
	
	public Department() {}

	public Department(int id, String name, String office) {
		super();
		this.id = id;
		this.name = name;
		this.office = office;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}
	
	
}
