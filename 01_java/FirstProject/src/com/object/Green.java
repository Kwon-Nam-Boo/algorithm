package com.object;

public class Green {
	public static void main(String[] args) {
		Child2 p = new Child2(1);
			
	}

}

class Child2 extends Child1{
	Child2() {
		System.out.println("e");
	}

	Child2(int a) {
		//super(77);
		System.out.println("f");
	}
	
}



class Child1 extends Parent1{
	Child1() {
		System.out.println("c");
	}

	Child1(int a) {
		//super(77);
		System.out.println("d");
	}
	
}

class Parent1{
	int a;
	Parent1() {
		System.out.println("a");
	}

	Parent1(int a) {
		System.out.println("b");
	}
	
}