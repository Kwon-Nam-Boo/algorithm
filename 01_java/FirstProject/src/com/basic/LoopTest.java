package com.basic;

public class LoopTest {
	public static void main(String[] args) {
		
		//for
here:		for (int i = 0; i < 5 ; i++) {
			for (int j = 0; j < 3; j++) {
				if(j == 1) break here;		// 라벨 here는  해당 라벨까지 break된다
				System.out.print(i + "," + j + " ");
			}
			System.out.println();
		}
		
		//while
		int i = 0;
		while(i<5) {
			System.out.println("*");
			i++;
		}
		
		int j = 99;
		do {
			System.out.println("hello");
			j++;
		}while(j > 200);
		
		
		/*for (int i = 0; i < 5; i++) {
			System.out.println(i + " Hello");
		}
		System.out.println();
		for (int i = 5; i > 0; i--) {
			System.out.println(i +" hello");
		}*/
	}
}
