package classEx09;

import classEx08.A;

public class D extends A{
	public D() {
		super();
		
		this.field1 = 1; // public
		this.field3 = 1; // protected
		
		this.method1(); // public 
		this.method3(); // protected
	}
}
