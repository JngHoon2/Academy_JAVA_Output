package interface01.vo;

public class LGTV implements TV{
	@Override
	public void powerOn() {
		// TODO Auto-generated method stub
		System.out.println("LG TV 전원 켜기");
	}

	@Override
	public void powerOff() {
		// TODO Auto-generated method stub
		System.out.println("LG TV 전원 끄기");
	}

	@Override
	public void volumeUp() {
		// TODO Auto-generated method stub
		System.out.println("LG TV 볼륨 높임");
	}

	@Override
	public void volumeDown() {
		// TODO Auto-generated method stub
		System.out.println("LG TV 볼륨 내림");
	}
}
