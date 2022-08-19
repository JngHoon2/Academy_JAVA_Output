package abstract02.vo;

/*
 * 2G Phone
 */
public class TwoGPhone extends Phone {

	public TwoGPhone(String onwer) {
		super(onwer);
	}
	
	@Override
	public void turnOn() {
		System.out.println(this.getOwner() + "님이 2G 폰의 전원을 켭니다.");
	}

	public void turnOff() {
		System.out.println(this.getOwner() + "님이 2G 폰의 전원을 끕니다.");
	}
	
	// 4. 자식이 메소드 추가
	public void instanceMessage() {
		System.out.println(this.getOwner() + "님이 2G 폰에서 문자 정도 보냅니다.");
	}

}