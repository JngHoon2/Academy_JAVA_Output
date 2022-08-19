package Circle.vo;

public class CircleStatic {
	public static final double pi = 3.141592;
	private double radius;
	private double area;
	
	public CircleStatic() {}
	
	public CircleStatic(double radius) {
		this.radius = radius;
		this.area = this.pi * radius * radius;
	}

	public double getPi() {
		return pi;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}
	
}
