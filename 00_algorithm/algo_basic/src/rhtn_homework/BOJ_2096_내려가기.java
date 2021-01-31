package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2096_내려가기 {
	
	private static int N;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		// 메모리 절약을 위해 단 두줄만 사용
		int[][] map = new int[2][3];
		int[][] DP = new int[2][3];
		int[][] DP2 = new int[2][3];
		
		int ans = 0;
		int ans2 = Integer.MAX_VALUE;
		
		// 처음 줄 입력 받고 초기화 과정 ...
		st = new StringTokenizer(br.readLine());
		for (int c = 0; c < 3; c++) {
			map[0][c] = Integer.parseInt(st.nextToken());
			DP[0][c] = map[0][c];
			DP2[0][c] = map[0][c];
		}
		
		// 다음줄 입력 및 DP 계산
		for (int r = 1; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < 3; c++) {
				map[1][c] = Integer.parseInt(st.nextToken());
		
				if(r == 1){
					DP2[1][c] = Integer.MAX_VALUE;
				}
			}
			// DP 작업
			for (int c = 0; c < 3; c++) {
				for (int i = -1; i < 2; i++) {
					if(isIn(1,c+i)) {
						DP[1][c] = Math.max(DP[1][c], DP[0][c+i] + map[1][c]);
						DP2[1][c] = Math.min(DP2[1][c], DP2[0][c+i] + map[1][c]);
					}
				}	
			}
			// 해당 값을 위로 옮기고 밑에 값을 초기화
			for (int c = 0; c < 3; c++) {
				map[0][c] = map[1][c]; 
				DP[0][c] = DP[1][c];
				DP2[0][c] = DP2[1][c];
				DP[1][c] = 0;
				DP2[1][c] = Integer.MAX_VALUE;
			}
		}
		
		// 최대, 최소값 찾기
		for (int c = 0; c < 3; c++) {
			ans = Math.max(ans, DP[0][c]);
			ans2 = Math.min(ans2, DP2[0][c]);
		}
		
		System.out.println(ans + " " + ans2);
	}
	
	private static boolean isIn(int r, int c) {
		return r>=0 && c>=0 && r < 2 && c< 3;
	}

}
