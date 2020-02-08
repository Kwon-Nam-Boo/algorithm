package com.korea.seoul;

import com.object.Car;

public class Pink extends Red{
	void test() {
		Pink r = new Pink();
		System.out.println(r.a);
		System.out.println(r.b);
		System.out.println(r.c);
		
		Car c = new Car();
		c.info();
	}
}