package com.object;

public class Green {
	public static void main(String[] args) {
		Child1 p = new Child1(1);
		p.go();
	}

}

class Child2 extends Child1{
	Child2() {
		System.out.println("e");
	}

	Child2(int a) {
		super(77);
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
	final void go() {
		System.out.println("aa");
	}

	
}