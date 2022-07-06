package polymorphism2;

import polymorphism2.vo.*;

public class VehicleMain {

	public static void main(String[] args) {
		Driver driver = new Driver();
		
		System.out.println("==== 자손 객체를 인자로 전달한 경우 ====");
		Taxi taxi = new Taxi();
		driver.drive(taxi);
		
		Bus bus = new Bus();
		driver.drive(bus);
		
		Truck truck = new Truck();
		driver.drive(truck);

	}

}
