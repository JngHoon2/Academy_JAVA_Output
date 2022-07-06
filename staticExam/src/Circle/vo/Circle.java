package Circle.vo;

public class Circle {
	private double pi = 3.141592;
	private double radius;
	private double area;
	
	public Circle() {}
	
	public Circle(double radius) {
		this.radius = radius;
		this.area = this.pi * radius * radius;
	}

	public double getPi() {
		return pi;
	}

	public void setPi(double pi) {
		this.pi = pi;
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
