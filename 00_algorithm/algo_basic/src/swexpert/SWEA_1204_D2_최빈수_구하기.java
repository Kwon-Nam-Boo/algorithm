package swexpert;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1204_D2_최빈수_구하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int[] school = new int[1000];
		
		int TC = sc.nextInt();
		
		for (int k = 1; k <= TC; k++) {
			sb.append("#").append(k).append(" ");
			int num = sc.nextInt();
			
			for (int i = 0; i < school.length; i++) {
				school[i] = sc.nextInt();
			}
		
			
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < school.length; i++) {
				max = Math.max(max,school[i]);
			}
			
			int[] count = new int[max+1];
			
			for (int i = 0; i < school.length; i++) {
				count[school[i]]++;
			}
			
			int mode = Integer.MIN_VALUE;
			int max_2 = 0 ;
			for (int i = 0; i < count.length; i++) {
				if(max_2 <= count[i]) {
					max_2 =count[i];
					mode = i;
				}
			}
			sb.append(mode).append("\n");
			
		}
		System.out.println(sb);
		
			
	}
		
}


