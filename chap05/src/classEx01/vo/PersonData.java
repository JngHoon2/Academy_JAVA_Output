package classEx01.vo;

public class PersonData {
	public Person[] persons = new Person[3];
	
	public PersonData() {
		persons[0] = new Person("홍길동", "010-1234-5678");
		persons[1] = new Person("김길동", "010-5678-1234");
		persons[2] = new Person("정길동", "010-3333-5555");
	}
}
