package algo_basic.day1;

import java.util.Scanner;

public class SWEA_2001_D2_파리_퇴치 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		int TC = sc.nextInt();
		
		for (int i = 1; i <= TC; i++) {
			sb.append("#").append(i).append(" ");
			int M =sc.nextInt();
			int N =sc.nextInt();
			
			int[][] arr = new int[M][M];
			for (int r = 0; r < M; r++) {
				for (int c = 0; c < M; c++) {
					arr[r][c]= sc.nextInt();
				}
			}
			int max =Integer.MIN_VALUE;
			
			for (int r = 0; r < M -(N-1); r++) {
				for (int c = 0; c < M -(N-1); c++) {
					int sum =0;
					for (int j = r; j < N +r; j++) {
						for (int j2 = c; j2 < N + c; j2++) {
							sum+=arr[j][j2];  
						}
					}
					max = Integer.max(max, sum);	
				}
			}
			
			sb.append(max).append("\n");
		}
		System.out.println(sb);	
			
	}
}


