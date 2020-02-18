package com.collection;


import java.util.ArrayList;

import com.abst.Circle;
import com.abst.Rect;
import com.abst.Shape;

public class ArrayListTest {

	public static void main(String[] args) {
		ArrayList<Shape> shapes = new ArrayList<>();
		shapes.add(new Rect(10,30));
		shapes.add(new Circle(10));
		shapes.add(new Rect(10,30));
		for (Shape s: shapes) {
			System.out.println(s.getClass().getSimpleName());
			System.out.println(s.getArea());
			System.out.println(s.getCircum());
			System.out.println();
		}
		
		
		ArrayList<Integer> nums = new ArrayList<>();
		nums.add(100);
		nums.add(200);
		nums.add(300);
		nums.add(200);
		nums.add(100);
		
		for(int num:nums) {
			System.out.println(num);
		}
		System.out.println("------------------");
		
		
		// generic Programming
		ArrayList<String> seasons = new ArrayList<>();
		seasons.add("spring");
		seasons.add("summer");
		seasons.add("fall");
		seasons.add("spring");
		seasons.add("winter");
		
		for(String season: seasons) {
			System.out.println(season);
		}
	}

}
