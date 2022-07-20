package abstract02.vo;

/*
 * 추상 클래스(abstract Class)
 *  - 클래스들의 공통된 특징을 추출하여 모아 놓은 클래스를 말한다.
 *  - 필드, 생성자, 메소드, 추상메소드 모두 가질 수 있음.
 *  - 추상 메소드가 하나라도 있으면 추상 클래스가 됨
 *  - 추상클래스를 상속한 객체를 자식이라고 하고 추상 클래스를 부모 클래스라고 한다.
 *  - 자식 클래스는 부모의 모든 것을 갖고 추가적인 더 특성을 가질 수 있다.
 *  - 추상 클래스는 직접 객체로 생성할 수 없고 상속한 자식들이 생성될 때 먼저 생성된다.
 *  -[목적]
 *   - 추상클래스는 이를 상속한 자식클래스들의 멤버 변수명과 멤버 메소드명을 통일할 목적
 *   - 자식 클래스들의 설계 시간을 절약할 목적
 *   - 프로젝트에서 설계자는 하위 개발자들이 자신이 정한 의도대로 코드를 작성하길 원함
 *     그래서 미리 추상 클래스를 정의해놓고 개발자들에게 이걸 상속해서 자식 클래스를
 *     만들도록 강요하게 됨. 일관성 유지보수성 향상
 *     	
 */
public abstract class Phone {
	// 1. 멤버 변수
	private String owner;
	// 2. 오버로딩 생성자
	public Phone(String onwer) {
		this.owner = onwer;
	}
	// 3. 전원을 켜는 멤버 메소드 - 추상메소드 : 이름만 있고 내용이 없음 {텅빈}
	//    이 클래스를 상속받는 클래스는 반드시 이 생김새(시그너처)대로 만들것.
	//    반환형 앞에 abstract 붙임
	public abstract void turnOn();
	
	// 4. 전원을 끄는 멤버 메소드 - 추상메소드 : 이름만 있고 내용이 없음 {텅빈}
	//    이 클래스를 상속받는 클래스는 반드시 이 생김새(시그너처)대로 만들것.
	//    반환형 앞에 abstract 붙임
	public abstract void turnOff();
	
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	//getter/setter 메소드 만들것.
	
	
}