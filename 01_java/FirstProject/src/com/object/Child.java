package com.object;


//  부뫀클래스 ,super class
class Parent {
	String name ="Tom";
	String address = "seoul";
	
	Parent(){
		System.out.println("Parent 생성자");
		System.out.println(getClass());
	}
	
	public void printName() {
		System.out.println("name:" + name);
	}
	void printAddress() {
		System.out.println("address:" + address);
	}
}

public class Child extends Parent{
	int age = 25;
	
	Child(){
		System.out.println("child 생성자");
	}
	
	// 메소드 오버라이딩
	/*void printName() {
		System.out.println("name: Tomson");
	}
	void callSuper() {
		super.printName();  // 부오의 printname 호출
		this.printName();// 자식의 printname 호출
	}
	*/
	@Override	//annotaion: 부모 메소드와 동일해야 하는 것 (return type, 메소드 이름, 파라미터 리스트)
	public void printName() {
		// TODO Auto-generated method stub
		//super.printName();
		System.out.println("name: Tomson");
	}
	int printName(int a) {
		return 100;
	}
	
	
	@Override
	void printAddress() {
		// TODO Auto-generated method stub
		super.printAddress();
	}

	public static void main(String[] args) {
		// 다형성: 동일한 타입의 객체에 대해 서로 다른 타입의 래퍼런스 타입으로 나타낼 수 있는 성질
		Child c = new Child();
		Object c3 = new Child();
		Parent c2 = new Child();
		
		c.printAddress();
		//c.printName();
		//c.callSuper();
		c2.printName();
	}

}
