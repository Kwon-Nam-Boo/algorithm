package com.singleton;

// singleton pattern class: 객체 생성을 한번만 수행하고 그 이후로는 생성된 객체를 공유해서 사용하는 방식

/* singleton pattern 설계 조건:
 * 1. field: private, static 
 * 2. 생성자: private
 * 3. public static method: 객체를 생성해서 리턴해주는 method
 */

public class SingletonObject {
	int cnt;
	
	private static SingletonObject instance;
	private SingletonObject() {}
	
	public static SingletonObject getInstance() {
			if(instance == null) {						// 만들어둔 객체를 사용하게 하려고 조건을 걸어줌
				instance = new  SingletonObject();
			}
			return instance;
	}
	public void go() {
		System.out.println("hello! singleton!" + ++cnt);
	}

}
