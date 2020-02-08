package algo_basic.day1;

import java.util.Scanner;

public class SWEA_2050_D1_알파벳 {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		String StringName = s.next();
		
		for (int i = 0; i < StringName.length(); i++) {
			sb.append(StringName.charAt(i)- 64).append(" ");
		}
		System.out.println(sb);
	}
		
}
