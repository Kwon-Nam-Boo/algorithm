package com.collection;

import java.util.Vector;
import com.computer.Mouse;

// Vector: List타입의 클래스(데이터 간 순서  o,
public class VectorTest {
	public static void main(String[] args) {
		
		
		Vector<Mouse> v4 = new Vector<>();  // 초기 사이즈 2, 배열이 모자랄때 늘리는 크기 2
		System.out.println(v4.capacity()); // 백터의 크기
		
		v4.add(new Mouse("logitec", 10000, false));
		
		
		for (int i = 0; i < v4.size(); i++) {
			System.out.println(v4.get(i).toString());
		}
		
		/*Vector v1 = new Vector(2,2);  // 초기 사이즈 2, 배열이 모자랄때 늘리는 크기 2
		System.out.println(v1.capacity()); // 백터의 크기
		
		v1.add("hello");
		v1.add(123);
		v1.add(12.55);
		v1.add(true);
		v1.add(123);
		
		for (int i = 0; i < v1.size(); i++) {
			System.out.println(v1.get(i));
		}*/
	}
}
