package classEx07;

public class Time {
	private int hour;
	private int minute;
	private float second;
	
	public int getHour() {return hour;}
	public int getMinute() {return minute;}
	public float getSecond() {return second;}
	
	public void setHour(int hour) {
		if (hour < 0 || hour > 23) {
			System.out.println("시간 값이 올바르지 않습니다.");
			this.hour = 1;
			return;
		}
		this.hour = hour;
	}
	public void setMinute(int minute) {
		if (minute < 0 || minute > 59) return;
		this.minute = minute;
	}
	public void setSecond(float second) {
		if (second < 0.0f || second > 59.99f) return;
		this.second = second;
	}
	
	public void showTime() {
		System.out.println(hour + ":" + minute + ":" + second);
	}
}
