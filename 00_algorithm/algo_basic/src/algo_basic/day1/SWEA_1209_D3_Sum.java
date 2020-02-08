package algo_basic.day1;

import java.util.Scanner;

public class SWEA_1209_D3_Sum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		for (int i = 1; i <= 10; i++) {
			sb.append("#").append(i).append(" ");
            int N = sc.nextInt();
			
			int[][] arr = new int[100][100];
			
			for (int r = 0; r < 100; r++) {
				for (int c = 0; c < 100; c++) {
					arr[r][c] = sc.nextInt();
				}
			}
			
			int max = Integer.MIN_VALUE;
			
			for (int r = 0; r < 100; r++) {
				int sumR =0;
				for (int c = 0; c < 100; c++) {
					sumR+=arr[r][c];
				}
				max = Integer.max(max, sumR);
			}
			
			for (int c = 0; c < 100; c++) {
				int sumR =0;
				for (int r = 0; r < 100; r++) {
					sumR+=arr[r][c];
				}
				max = Integer.max(max, sumR);
			}
			
			int sumCrossX =0;
			int sumCrossY =0;
			
			for (int j = 0; j < 100; j++) {
				sumCrossX += arr[j][j];
				sumCrossY += arr[j][99-j];
			}
			max = Integer.max(max, sumCrossX);
			max = Integer.max(max, sumCrossY);
			
			sb.append(max).append("\n");
		}
		System.out.println(sb);
		
	}
}
