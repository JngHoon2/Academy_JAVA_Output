package vo;

public class LGTV implements TV{

	@Override
	public void powerOn() {
		System.out.println("엘지티비 전원 켬");
	}

	@Override
	public void powerOff() {
		System.out.println("엘지티비 전원 끔");
	}

	@Override
	public void volumeUp() {
		System.out.println("엘지티비 볼륨 업");
	}

	@Override
	public void volumeDown() {
		System.out.println("엘지티비 볼륨 다운");
	}
	
}
