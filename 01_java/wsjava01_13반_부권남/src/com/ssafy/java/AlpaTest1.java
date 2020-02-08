package com.ssafy.java;

public class AlpaTest1 {
	
	public static void main(String[] args) {
		
		/*char alpa = 'A';
		
		for(int i =0;i<5;i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print(alpa + " ");
				alpa += 1;
			}
			System.out.println();
		}
		System.out.println();
	}*/
	
	char alpha = 'A';
	
		for(int i =0;i<5;i++) {
			for (int j = 0; j <= i; ++j) {
				System.out.printf("%3c", alpha++);
			}
			System.out.println();
		}
	System.out.println();
	}

}
