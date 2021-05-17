package ex07_bean;

/*
 * 자바 빈(Bean)
 * 
 * 1. 자바 빈 개발 규약에 의해 생성하는 자바 클래스이다.
 * 2. 객체 저장용으로 사용된다.
 * 3. 개발 규약
 *    1) 반드시 특정 패키지에 소속되어야 한다. (디폴트 패키지는 안 된다.)
 *    2) 디폴트 생성자를 사용할 수 있어야 한다.
 *       (1) 생성자를 안 만든다.
 *       (2) 필드를 이용한 생성자를 만드는 경우 디폴트를 함께 만든다.
 *    3) getter/setter를 추가해야 한다.
 */

public class Person {

	// field
	private String name;
	private int age;
	
	// constructor
	public Person() {}  // 디폴트 생성자
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	// method
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
