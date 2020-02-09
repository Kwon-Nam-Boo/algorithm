package com.object;

public class Test {
	// data. field attribute		// 전역변수는 default값이 있다.
	int num;
	String name;
	boolean flag;
	double d;
	
	//default 생성자 (클래스 명과 동일해야하고, 리턴 타입은 없다 , 자동호출됨)
	public Test(){
		System.out.println("Test 생성자");
	};
	
	//public Test(int a) {};				// 생성자가 맞다, 파라미터가 있는 생성자
	
	// void Test(){}; 				// void Test는 생성자가 아니다!
	// Test2(){}; 						// 생성자가 아니다.
	
	// method
	public void go() {
		//int a;
		int a =0;
		// a는 초기화가 되지 않았다는 오류(a는 필드가 아니기 때문이다.)
		System.out.println("hello..!"+ a);	
	}
	public void stop() {
			System.out.println(flag);
			System.out.println(num);
			// 지역변수 a는 사용 불가능
			//System.out.println(a);	
	}
	
	public static void main(String[] args) {
		// 객체 생성
		Test t = new Test();
		
		// 객체 t 사용
		/*t.go();
		System.out.println(t.num);
		System.out.println(t.name);
		System.out.println(t.flag);
		System.out.println(t.d);
		t.stop();*/
	}

}
