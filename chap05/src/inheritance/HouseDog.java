package inheritance;

public class HouseDog extends Animal{
	
	void sleep() {
		System.out.println(super.name + "집에서 zzzz");
	}
	
	void sleep(int hour) {
		System.out.println(this.name + "Zzzzz " + hour + "동안");
	}
}
