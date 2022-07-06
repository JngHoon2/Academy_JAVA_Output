package polymorphism2;

import polymorphism2.vo.Vehicle;

public class Driver {

	public void drive(Vehicle vehicle) {
		vehicle.run(vehicle);
	}

}
