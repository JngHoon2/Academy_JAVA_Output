package classEx09;

import classEx08.A;

public class C {
	public C() {
		A a = new A();
		a.field1 = 1; // public
		
		a.method1(); // public
	}
}
