package com.collection;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.TreeSet;

import com.abst.Circle;
import com.abst.Rect;

// hashset: Set 타입 클래스 -> 데이터 중복 x, 데이터간 순서 x
public class HashSetTest {
	public static void main(String[] args) {
		TreeSet<Circle> t2 = new TreeSet<>();
		
		t2.add(new Circle(10));
		t2.add(new Circle(20));
		t2.add(new Circle(30));
		
		
		for (Circle circle : t2) {
			System.out.println(circle);
		}
		
		
		TreeSet<String> t = new TreeSet<>();
		
		t.add("hello");
		t.add("123");
		t.add("잘자요");
		t.add("Good");
		t.add("banana");
		t.add("10");
		t.add("2");
		
		System.out.println(t);
		System.out.println(t.first());
		System.out.println(t.last());
		
		HashSet<String> set = new HashSet<>();
		set.add("kim");
		set.add("lee");
		set.add("kim");
		set.add("park");
		set.add("han");
		set.add("oh");
		set.add("park");
		
		set.remove("oh");
		
		System.out.println(set);
	}
}
