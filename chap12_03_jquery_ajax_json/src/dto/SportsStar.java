package dto;

public class SportsStar {

	private String name;
	private int age;
	private String gender;
	private String nickname;
	
	public SportsStar() {
		super();
	}
	public SportsStar(String name, int age, String gender, String nickname) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.nickname = nickname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	@Override
	public String toString() {
		return "SportsStar [name=" + name + ", age=" + age + ", gender=" + gender + ", nickname=" + nickname + "]";
	}
	
	
}