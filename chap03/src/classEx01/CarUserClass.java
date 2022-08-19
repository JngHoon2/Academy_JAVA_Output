package classEx01;
import classEx01.Car;

public class CarUserClass {

	public static void main(String[] args) {
		
		Car car = new Car();
		
		System.out.println("객체의 메모리 주소 : " + car);
		car.showInfo();
		
		car.model = "G80";
		car.color = "black";
		car.speed = 150;
		
		// 멤버 변수 변경 후 값 확
		car.showInfo();
	}

}
