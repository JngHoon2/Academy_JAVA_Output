package polymorphism;

import polymorphism.vo.*;

public class PolyMorphismMain {

	public static void main(String[] args) {
		Parent parent = new Parent();
		parent.viewPersonality();
		System.out.println("---------------------");
		
		Parent p = new TheFirst();
		p.viewPersonality();
		
		System.out.println("---------------------");
		p = new TheSecond();
		p.viewPersonality();
		
		System.out.println("---------------------");
		p = new TheThrid();
		p.viewPersonality();
	}

}
