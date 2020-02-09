package com.object;

/*class animal2{}
class tiger2 extends animal2{}
class lion2 extends animal2{}
class tree2{}

*/


class X{
	void go() {
		System.out.println("x go!");
	}
	void play() {
		System.out.println("x play!");
	}
	void run() {
		System.out.println("x run!");
	}
	
}
class Y extends X{
	void go() {
		System.out.println("y go!");
	}
	
}
class Z extends Y{
	void go() {
		System.out.println("z go!");
	}
	void play() {
		System.out.println("z play!");
	}
	void sleep() {
		System.out.println("z sleep!");
	}
	
}

public class Test1 {
	public static void main(String[] args) {
		X x = new Z();
		Y y = new Z();
		Z z = new Z();
		
		x.go();			//  Z의 go 출력 
		x.run();		//  X의 run 출력
		
		y.go();			//  Z의 go 출력 
		y.play();		//  Z의 play 출력 
		
		
		/*animal2 a1 = new animal2();
		//tiger t1 = (tiger)a1; // error 2
		
		animal2 a2 = new tiger2();
		tiger2 t2 = (tiger2)a2; // error 2
		
		animal2 a3 = new tree2();
		tiger2 t3 = (tiger2)a3; // error 2
		
		animal2 a4 = new lion2();
		tiger2 t4 = (tiger2)a4; // error 1
*/					
	}	
}
