package com.object;
// final: class, method, variable

final class Some{			// 상속이 안된다.
	final int num =999;		// 상수라서 값을 바꿀 수 없다.
	void go() {
		//num =100;			// error!
	}
}
class Some2{
	final void go() {
		System.out.println("i");
	}
}

public class FinalTest extends Some2{

	//final void go() {};   			// 오버라이딩이 안된다. error!
										// 그냥 사용은 가능. 즉 고치지만 못할 뿐!
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FinalTest ft = new FinalTest();
		ft.go();
		System.out.println(Math.pow(2, 3));
		System.out.println(Math.abs(-100));
		
	}

}

