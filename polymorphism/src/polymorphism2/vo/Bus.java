package polymorphism2.vo;

public class Bus extends Vehicle{

	@Override
	public void run(Vehicle vehicle) {
		System.out.println("버스가 사람들을 태우고 운행중입니다.");
	}
	
}
