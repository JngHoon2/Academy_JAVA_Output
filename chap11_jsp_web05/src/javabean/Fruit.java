package javabean;


/**
 * [과일 클래스 - getter setter 만들기 연습]
*/
public class Fruit {
	//멤버변수
	private String name;
	private int price;
	//기본 생성자
	public Fruit() {
	}	
	//오버로딩 생성자
	public Fruit(String name, int price) {
		this.name = name;
		this.price = price;
	}	
	//게터/세터
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}	
	
	//객체의 값을 보여주는 메소드(toString()을 사용해도 됨)
	public void showFruitInfo() {
		System.out.println(this.name + " " + this.price);
	}
	@Override
	public String toString() {
		return "Fruit [, name=" + name + ", price=" + price + "]";
	}
	
	// [메소드 오버라이딩 - Object 객체의 equals()메소드] 
	// 	- 객체 비교 : 객체가 갖고 있는 값이 같은지 비교
	// 만약에 같은 값의 서로 다른 객체가 들어오면 이 메소드로 비교해서 같은면 저장 안함.(Set의 경우)
	@Override
	public boolean equals(Object obj) {	//name과 price 값이 같으면 true 리턴
		System.out.println("obj.hashCode() : " + obj.hashCode());
		System.out.println("Fruit equals 메소드");
		if (obj instanceof Fruit) {
			Fruit fruit = (Fruit) obj;
			return fruit.name.equals(name) && (fruit.price == price);
		} else {
			return false;
		}
	}
	
	// [메소드 오버라이딩 - Object 객체의 hashCode()메소드] 
	@Override
	public int hashCode() {		//name과 price 값이 같으면 동일한 hashCode 리턴
		return name.hashCode() + price;
	}	
	
}
