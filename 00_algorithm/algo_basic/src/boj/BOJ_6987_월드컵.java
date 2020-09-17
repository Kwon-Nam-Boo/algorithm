package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6987_월드컵 {
	
	private static int[][] score;
	private static int A;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		score = new int[4][18];
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 18; j++) {
				score[i][j] = Integer.parseInt(st.nextToken());
			}
			A = 0;
			dfs(0,1,score[i]);
			sb.append(A).append(" ");
			
		}
		System.out.println(sb);
		
	}

	private static void dfs(int a, int b, int[] score) {
		// 종료 조건
		if(a==5) {
			for (int i = 0; i < score.length; i++) {
				if(score[i]>0) {
					A = 0;
					return;
				}
			}
			A = 1;
			return;
		}
		// 일반 조건
		// b가 6이면  팀을 변경해줘야지
		if(b == 6) {
			dfs(a+1,a+2,score);
			return;
		}
		// 0 , 2 j1측이 승리하고 j2측이 패배할수 있다면
		// 1 , 1 j1측과 j2측이 무승부 할수 있다면
		// 2 , 0 j2측이 승리하고 j1측이 패배할수 있다면
		for (int j1 = 0, j2 = 2; j1 < 3; j1++, j2--) {
			if(score[a*3+j1]> 0 && score[b*3+j2] > 0) {
				score[a*3+j1]--;
				score[b*3+j2]--;
				dfs(a,b+1,score);
				score[a*3+j1]++;
				score[b*3+j2]++;
			}
		}
		
	}

}
