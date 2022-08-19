package classEx11;
import classEx11.vo.*;

public class FruitMain {

	public static void main(String[] args) {
		
		Fruit fruit = new Fruit();
		fruit.setId(1);
		fruit.setName("사과");
		fruit.setPrice(1000);
		
		Fruit fruit2 = new Fruit();
		fruit2.setId(2);
		fruit2.setName("딸기");
		fruit2.setPrice(500);
		
		Fruit fruit3 = new Fruit(3, "배", 1200);

		Fruit fruitArray[] = { fruit, fruit2,fruit3};
		
		for(Fruit item : fruitArray) {
			item.showInfo();
			System.out.println("----------");
		}
		System.out.println(fruit.toString());
	}

}
