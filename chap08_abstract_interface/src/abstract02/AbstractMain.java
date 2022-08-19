package abstract02;

import abstract02.vo.SmartPhone;
import abstract02.vo.TwoGPhone;

public class AbstractMain {

	public static void main(String[] args) {
		TwoGPhone tPhone = new TwoGPhone("고인동");
		tPhone.turnOn();
		tPhone.instanceMessage();
		tPhone.turnOff();
		System.out.println();
		
		SmartPhone sPhone = new SmartPhone("안드로이드");
		sPhone.turnOn();
		sPhone.internetSearch();
		sPhone.turnOff();

	}

}
