package inheritance;

public class Human {
	String name;
	int age;
	
	public Human(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void humanInfo() {
		System.out.println("[Human Info]");
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);	
	}
	
}
