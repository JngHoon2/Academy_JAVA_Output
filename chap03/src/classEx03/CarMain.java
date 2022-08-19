package classEx03;

public class CarMain {

	public static void main(String[] args) {
		Car car = new Car();
		
		car.maker = "hyndai";
		car.model = "avante";
		car.cc = 1499;
		car.color = "white";
		car.price = 1700;
		car.maxSpeed = 180;
		car.speed = 100;
		
		car.showInfo();
		
		System.out.println("-----------------");
		
		Car car2 = new Car("KIA", "K9", 3000, "black", 5000, 200, 120);
		car2.showInfo();
		
	}

}
