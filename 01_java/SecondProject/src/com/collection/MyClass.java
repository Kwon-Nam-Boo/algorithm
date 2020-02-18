package com.collection;

import com.abst.Circle;

public class MyClass<X> {
	private int num;
	private X what;
	
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public X getWhat() {
		return what;
	}
	public void setWhat(X what) {
		this.what = what;
	}
	
	public static void main(String[] args) {
		// 실행할떄 데이터 타입이 결정이 된다.
		MyClass<String> m1 = new MyClass<>();
		MyClass<Circle> m2 = new MyClass<>();
		MyClass<Integer> m3 = new MyClass<>();
	}
	
}
