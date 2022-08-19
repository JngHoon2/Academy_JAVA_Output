package polymorphism2;

import java.util.ArrayList;

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

		
		System.out.println("==== ArrayList에 넣어서 ====");
		ArrayList<Vehicle> array = new ArrayList<Vehicle>();
		array.add(taxi);
		array.add(bus);
		array.add(truck);
			
		for(Vehicle v : array) {
			driver.drive(v);
		}
	}

}
