package inheritance;

public class AnimalMain {

	public static void main(String[] args) {
		Dog dog = new Dog();
		dog.setName("댕댕이");
		System.out.println(dog.name);
		
		dog.sleep();
		
		Animal dogAnimal = new Dog();
		dogAnimal.setName("댕멍이");
		System.out.println(dogAnimal.name);
		System.out.println();
		
		HouseDog houseDog = new HouseDog();
		houseDog.setName("멍냥이");
		houseDog.sleep(5);
	}

}
