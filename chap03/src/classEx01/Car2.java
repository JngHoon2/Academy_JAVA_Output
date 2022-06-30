package classEx01;

public class Car2 {
	String model  = "N/A";
	String color = "N/A";
	int speed = 0;
	
	// 기본 생성자
	public Car2() { super(); }
	
	public Car2(String model, String color) { 
		this(model, color, 0); // 매개변수가 3개인 생성자를 통해 객체 생성.
		System.out.println("여기는 파라미터 2개 생성자");
		//this.model = model;
		//this.color = color;
	}
	
	public Car2(String model, String color, int speed) { 
		System.out.println("여기는 파라미터 3개 생성자-1");
		this.model = model;
		this.color = color;
		this.color = color;
		System.out.println("여기는 파라미터 3개 생성자-2");
	}
	
	public void showInfo() {
		System.out.println("model : " + model);
		System.out.println("color : " + color);
		System.out.println("speed : " + speed);
	}
}
