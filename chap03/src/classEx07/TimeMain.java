package classEx07;

public class TimeMain {

	public static void main(String[] args) {
		Time time = new Time();
		
		time.setHour(22);
		time.setMinute(50);
		time.setSecond(30.112f);
		
		time.showTime();
		System.out.println("시간만 : " + time.getHour());
	}
		
}
