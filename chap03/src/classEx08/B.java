package classEx08;

public class B {
	public B() {
		A a = new A();
		a.field1 = 1;
		a.field2 = 1;
		a.field3 = 1;
		
		a.method1(); // public
		a.method2(); // default
		a.method3(); // protected
	}
}
