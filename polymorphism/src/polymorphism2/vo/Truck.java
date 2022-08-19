package polymorphism2.vo;

public class Truck extends Vehicle{

	@Override
	public void run() {
		System.out.println("트럭이 화물을 가득 싣고 서행 운전하고 있습니다.");
	}
	
}
