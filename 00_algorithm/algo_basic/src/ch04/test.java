package ch04;

class Parent {
	long id = 10L;

	public long getId() {
		return id;
	}
}

class Child extends Parent {
	long id = 20L;
	
	public long getId() {
		return id;
	}
}

public class test {

	public static void main(String[] args) {
		Parent c1 = new Child();
		Child c2 = new Child();
		System.out.println(c1.getId());
		System.out.println(c2.getId());
		
	}
}
