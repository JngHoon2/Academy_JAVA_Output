package polymorphism;

import java.util.ArrayList;

import polymorphism.vo.*;

public class PolyMorphismMain {

	public static void main(String[] args) {
		Parent parent = new Parent();
		parent.viewPersonality();
		System.out.println("---------------------");
		
		Parent p = new TheFirst();
		p.viewPersonality();
		System.out.println();
		
		System.out.println("---------------------");
		p = new TheSecond();
		p.viewPersonality();
		System.out.println();
		
		System.out.println("---------------------");
		p = new TheThrid();
		p.viewPersonality();
		System.out.println();
		
		System.out.println("-------클래스 배열-------");
		Parent[] children = new Parent[3];
		children[0] = new TheFirst();
		children[1] = new TheSecond();
		children[2] = new TheThrid();
		
		for(Parent c : children) {
			c.viewPersonality();
		}
		System.out.println();
		
		System.out.println("-------ArrayList-------");
		ArrayList<Parent> children2 = new ArrayList<Parent>();
		children2.add(new TheFirst());
		children2.add(new TheSecond());
		children2.add(new TheThrid());
		
		for(Parent c : children2) {
			c.viewPersonality();
		}
	}

}
