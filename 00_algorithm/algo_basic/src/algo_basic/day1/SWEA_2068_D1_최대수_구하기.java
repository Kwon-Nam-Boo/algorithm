package algo_basic.day1;

import java.util.Scanner;

public class SWEA_2068_D1_최대수_구하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int TC = s.nextInt();
		
		for (int i = 1; i <= TC; i++) {
			sb.append("#").append(i).append(" ");
			int max = Integer.MIN_VALUE;
			for(int j=1;j <=10; j++) {
				int num = s.nextInt();
				if(num >max) max =num;
			}
			sb.append(max).append("\n");
		}
		System.out.println(sb);
	}

}
