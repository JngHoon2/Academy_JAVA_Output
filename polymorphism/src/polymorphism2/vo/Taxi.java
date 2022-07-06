package polymorphism2.vo;

public class Taxi extends Vehicle{

	@Override
	public void run(Vehicle vehicle) {
		System.out.println("택시가 길거리에서 손님을 태워서 목적지까지 한번에 운행하고 있습니다.");
	}
	
	
}
