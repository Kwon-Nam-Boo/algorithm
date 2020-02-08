package com.ssafy.java;

public class AlpaTest2 {
	public static void main(String[] args) {
		/*char alpa = 'A';
		for(int i =0;i<5;i++) {
			String line ="";
			String blank="";
			for (int j = 0; j < 5 ; j++) {
				if(j==0){ 
					line += alpa;
					alpa+=1;
				}else if(j<=i) {
					line += (" " + alpa);
					alpa+=1;
				}
				else {
					blank += "  ";
				}
			}
			System.out.println(blank + line);
		}
		System.out.println();
		*/
		char alpha = 'A';
		
		for(int i =0;i<5;++i) {
			for(int j=4;j>=0;--j) {
				if(j>i) {
					System.out.printf("%3s", " ");
				}else {
					System.out.printf("%3c",alpha++);
				}
			}
			System.out.println();
		}
	}

}
