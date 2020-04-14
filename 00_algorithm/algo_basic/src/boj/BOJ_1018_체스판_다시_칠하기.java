package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1018_체스판_다시_칠하기 {
	
	private static int N;
	private static int M;
	private static int min;
	private static char[][] chess;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		chess = new char[N][M];
		
		for (int i = 0; i < N; i++) {
			chess[i] = br.readLine().toCharArray();
		}

		min = Integer.MAX_VALUE;
		for (int r = 0; r <= N - 8; r++) {
			for (int c = 0; c <= M - 8; c++) {
				check(r,c);
			}
		}
		System.out.println(min);
	}
	public static void check(int r, int c) {
		int countW = 0;
		int countB = 0;
		
		for (int i = r; i < r + 8; i++) {
			for (int j = c; j < c + 8 ; j++) {		// 흰색이 먼저

				if((i+j)%2==0) {
					if(chess[i][j]=='W') {
						countB++;
					}else {
						countW++;
					}
				}else {
					if(chess[i][j]=='B') {
						countB++;
					}else {
						countW++;
					}
				}
			}
		}
	
		if(countW>countB) {
			min = Math.min(min, countB);
		}else {
			min = Math.min(min, countW);
		}
		return;
	}

}
