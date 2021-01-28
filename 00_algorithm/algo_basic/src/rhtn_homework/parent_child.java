package rhtn_homework;

public class parent_child {

	public static void main(String[] args){
		// 부모
		Parent p = new Parent();
		System.out.println();
		// 자식
		Child c = new Child();
		System.out.println();
		// 선언은  부모 , 실제는 자식 객체
		Parent p2 = new ChildOther();
		System.out.println();
		
		p.printName();
		System.out.println();
		
		c.printName();
		c.test();
		System.out.println();
		
		p2.printName();
		// p2.test()는 에러, 부모를 기준으로 객체가 생성되었기 때문에
		//p2.test()
	}
	
}

class Parent{
	
	public Parent() {
		System.out.println("Parent Constructor");
	}
	
	public void printName() {
		System.out.println("Parent printName()");
	}
}

class Child extends Parent{
	
	
	public Child() {
		System.out.println("Child Constructor");
	}

	// printName 이 없으므로 부모껄 가져다 쓴다
	
	public void test() {
		System.out.println("test logic");
	}
	
}

class ChildOther extends Parent{
	
	
	public ChildOther() {
		System.out.println("ChildOther Constructor");
	}

	public void printName() {
		System.out.println("Child printName()");
	}
	
}
