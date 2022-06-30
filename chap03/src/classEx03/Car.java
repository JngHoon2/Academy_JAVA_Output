package classEx03;

public class Car {
	String maker;
	String model;
	int cc;
	String color;
	int price;
	int maxSpeed;
	int speed;
	
	public Car() {}
	
	public Car(String ma, String mo, int cc, String co, int pr, int ms, int sp) {
		maker = ma;
		model = mo;
		this.cc = cc;
		color = co;
		price = pr;
		maxSpeed = ms;
		speed = sp;
	}
	
	public void showInfo() {
		System.out.println("maker : " + maker);
		System.out.println("model : " + model);
		System.out.println("cc : " + cc);
		System.out.println("color : " + color);
		System.out.println("price : " + price);
		System.out.println("maxspeed : " + maxSpeed);
		System.out.println("speed : " + speed);
	}
}
