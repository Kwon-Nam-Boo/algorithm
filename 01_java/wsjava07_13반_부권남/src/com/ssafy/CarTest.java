package com.ssafy;

import java.util.Arrays;

public class CarTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CarMgr c = new CarMgr();
		c.add(new Car("12", "avante", 5000));
		c.add(new Car("14", "kia", 1000));
		c.add(new Car("16", "ford", 3000));

		for (Car car: c.search()) {		// 전체 search()
			if(car ==null) break;
			System.out.println(car);
		}
		System.out.println();
		
		System.out.println(c.search("12"));		// 번호와 같은 자동차 search(String num)
		
		System.out.println();
		
		for (Car car: c.search(6000)) {	 // 가격보다 적은 자동차 search(int price)
			if(car !=null)
			System.out.println(car);
		}
		System.out.println();
		
		c.update("12",5100);					// 해당 번호의 자동차 가격의 수정한다. update(num, price)
		System.out.println(c.search("12"));		
		
		c.delete("12");							// 해당 번호에 car 정보 삭제
		
		System.out.println(c.search("12"));		// 해당 번호 삭제 되서 null 출력
		
		System.out.println(c.size()); 			// 자동차 대수 구하기 현재 delete 되서 2
		
		System.out.println(c.totlaPrice());
		
		System.out.println("----------------------------------------------------");
		
		c.add(new Bus("18", "toyota", 4000,10));
		c.add(new Bus("20", "nisan", 1000,20));
		c.add(new Bus("22", "benz", 7000,30));
		
		for (Car car: c.search()) {		// 전체 search()
			if(car == null)  break;
			System.out.println(car);
		}
		
		System.out.println();
		
		System.out.println(c.search("18"));		
		
		System.out.println();
		
		for (Car car: c.search(6000)) {	 
			if(car !=null)
			System.out.println(car);
		}
		System.out.println();
		
		c.update("18",5100);				
		System.out.println(c.search("18"));		
		
		c.delete("18");							
		
		System.out.println(c.search("18"));		
		
		System.out.println(c.size()); 			
		
		System.out.println(c.totlaPrice());
		
		System.out.println();
	}

}
