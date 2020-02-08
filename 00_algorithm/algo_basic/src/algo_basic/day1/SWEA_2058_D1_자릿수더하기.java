package algo_basic.day1;

import java.util.Scanner;

import algo_basic.day1.io.ScannerTest;

public class SWEA_2058_D1_자릿수더하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String src = s.next();
		
		String[] splited = src.split("");
		int sum = 0;
		for (int i = 0; i < splited.length; i++) {
			sum += Integer.parseInt(splited[i]);
		}
		System.out.println(sum);
		
	}
	
}
