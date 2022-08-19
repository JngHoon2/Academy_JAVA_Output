package classEx01;

import classEx01.vo.Person;
import classEx01.vo.PersonData;

public class PersonMain {

	public static void main(String[] args) {
		PersonData pData = new PersonData();
		
		for(Person p : pData.persons) {
			System.out.println(p.toString());
		}
	}

}
