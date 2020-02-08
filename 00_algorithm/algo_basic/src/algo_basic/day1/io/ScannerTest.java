package algo_basic.day1.io;

import java.util.Scanner;

import javax.print.DocFlavor.STRING;

public class ScannerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//read0();
		//read1();
		//read2();
		read3();
	}
	
	public static void read0() {
		Scanner scanner = new Scanner(System.in);
		
		while(scanner.hasNext()) {
			String str = scanner.next();
			System.out.println(str);
		}
	}
	
	public static void read1() {
		Scanner scanner = new Scanner(System.in);
		// 1 + 1이라는 입력을 받아서 연산하자
		
	}
	
	public static void read2() {
		// String을 직적 넣는 것도 가능하다.
		String src = "110 + 220";
		Scanner scanner = new Scanner(System.in);
		scanner = new Scanner(src);
		int a = scanner.nextInt();
		String plus = scanner.next();
		int b = scanner.nextInt();
		System.out.println(a + b);
	}
	
	public static void read3() {
		// 반복문을 이용하고 숫자가 아닌 것이 들어오면 종료시켜보자
		String str = "100, 200, 300, 400";
		Scanner scanner = new Scanner(str);
		scanner.useDelimiter(", ");
		int sum = 0;
		while(scanner.hasNextInt()) {
			sum+= scanner.nextInt();
		}	
		System.out.println(sum);			
	}
		
}
