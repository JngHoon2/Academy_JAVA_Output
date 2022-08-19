package abstract02.vo;
/*
 * 부모의 추상 메소드인 turnOff() 를 오버라이드 하지 않아서 오류
 */
public class SmartPhone extends Phone {

	// 1. 오버로딩 생성자
	public SmartPhone(String onwer) {
		super(onwer);	// 부모 객체 생성
	}
	
	// 2. 부모 메소드 오버라이딩
	@Override
	public void turnOn() {
		System.out.println(this.getOwner() + "님이 스마트폰의 전원을 켭니다.");
	}

	// 3. 부모 메소드 오버라이딩 안함.
	// 반드시 부모가 만들어놓은 형태 그대로 메소드를 오버라이드 해야함.
	// 컴파일러가 컴파일 타임에 오류를 내주기 때문에 개발자는 정해진
	// 규칙대로 개발할 수 밖에 없음. 주석을 해제 해야 오류가 사라짐
	public void turnOff() {
		System.out.println(this.getOwner() + "님이 스마트 폰의 전원을 끕니다.");
	}

	// 4. 자식이 별도로 추가한 메소드
	public void internetSearch() {
		System.out.println(this.getOwner() + "님이 스마트폰에서 시원하게 인터넷 서핑을 즐깁니다.");
	}

}