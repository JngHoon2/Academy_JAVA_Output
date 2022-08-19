package Circle;

import Circle.vo.Circle;
import Circle.vo.CircleStatic;

public class CircleMain {

	public static void main(String[] args) {
		System.out.println("========== 객체 마다 동일한 값을 보유 ==========");
		Circle c1 = new Circle(10.2);
		System.out.println("1. 반지름 : " + c1.getRadius() + "인 원의 넓이는 " + Math.round(c1.getArea() * 100) / 100.0);

		Circle c2 = new Circle(10.2);
		System.out.println("1. 반지름 : " + c2.getRadius() + "인 원의 넓이는 " + Math.round(c2.getArea() * 100) / 100.0);

		System.out.println("3. 생성된 객체의 변수를 통해서 pi에 접근 : " + c1.getPi());
		System.out.println("4. 객체 생성 없이 pi에 접근 : " +CircleStatic.pi);
	}

}
