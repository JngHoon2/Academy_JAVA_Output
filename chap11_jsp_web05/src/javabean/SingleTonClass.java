package javabean;

public class SingleTonClass {
	private static SingleTonClass single_instance = null;
	public String s;
	
	private SingleTonClass() {
		s = "싱글톤 클래스의 생성자";
		System.out.println(s);
	}
	
	public static SingleTonClass getInstance() {
		if(single_instance == null)
			single_instance = new SingleTonClass();
		return single_instance;
	}
	
}
