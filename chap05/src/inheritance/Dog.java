package inheritance;

public class Dog extends Animal{
	void sleep() {
		System.out.println(this.name +  " -> zzzz");
	}
	
	@Override
	void loud() {
		System.out.println("Dog소리를 낸다.");
	}
}
