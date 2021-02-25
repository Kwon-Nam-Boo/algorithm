package rhtn_homework;

import java.util.Scanner;

public class BOJ_2718_타일채우기 {
	
	private static int N;
	private static int[][] DP;
	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args){
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		/*
		 * 0: 비어있을경우(세로로 채워진경우를 말한다)
		 * 1: 위에 두개가 이전의 값을 침범한 형태
		 * 2: 가운데 두개가 "
		 * 3: 밑에서 두개가 "
		 * 4: 위 아래 두개가 " 
		 */
		
		for (int i = 0; i < T; i++) {
			N = sc.nextInt();
			// N까지오는 경우에서, 5가지 패턴에 대한 DP
			DP = new int[N+2][5];
			
			DP[1][0] = 1;
			
			for (int j = 2; j < N+2; j++) {
				DP[j][0] = DP[j-2][0]+DP[j-1][0]+DP[j-1][1]+DP[j-1][3]+DP[j-1][4];
				// 맨뒤(n)의 형태가 1일때는 n-1은 0,3의 형태 밖에 없다. 나머지도 상황에 맞는 형태가 존재 
				DP[j][1] = DP[j-1][3] + DP[j-1][0];
				DP[j][2] = DP[j-1][4];
				DP[j][3] = DP[j-1][1] + DP[j-1][0];
				DP[j][4] = DP[j-1][2] + DP[j-1][0];
			}
			sb.append(DP[N+1][0] +"\n");
		}
		System.out.println(sb);
	}

}
