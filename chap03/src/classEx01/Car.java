package classEx01;

public class Car {
	String model  = "N/A";
	String color = "N/A";
	int speed = 0;
	
	// 기본 생성자
	public Car() { super(); }
	
	public void showInfo() {
		System.out.println("model : " + model);
		System.out.println("color : " + color);
		System.out.println("speed : " + speed);
	}
}
