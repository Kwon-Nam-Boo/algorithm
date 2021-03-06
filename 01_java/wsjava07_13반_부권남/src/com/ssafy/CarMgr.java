package com.ssafy;

import java.util.Arrays;

public class CarMgr{
	
	private Car[] cars = new Car[100];
	private int index;
	
	public void add(Car c) {
		cars[index++] =c;
	}
	public Car[] search(){
		return cars;
	}
	public Car search(String num) {
		for(Car c : cars) {
			if(c==null) break;
			if(c.getNum().equals(num)) {
				return c;
			}
		}
		return null;
		
	}
	public Car[] search(int price) {
		Car[] tmp = new Car[100];
		int idx =0;
		for(Car c : cars) {
			if(c==null) break;
			if(c.getPrice()<price) {
				tmp[idx++]= c;
			}
		}
		return tmp;
	}
	public void update(String num, int price) {
		for(Car c : cars) {
			if(c==null) break;
			if(c.getNum().equals(num)) {
				c.setPrice(price);
				return;
			}
		}
	}
	public void delete(String num) {
		int count = 0;
		for(Car c : cars) {
			if(c==null) break;
			if(c.getNum().equals(num)) {
				for (int i = count; i < cars.length-1; i++) {
					cars[i] = cars[i+1];
				}
				index--;
				return;
			}
		 count++;	
		}
	}
	public int size() {
		return index;
	}
	public int totlaPrice() {
		int sum =0;
		for (int i = 0; i < index; i++) {
			sum+= cars[i].getPrice();
		}
		return sum;
	}
	
	
}
