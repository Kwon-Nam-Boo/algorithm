package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_5644_T_무선충전 {
	
	private static int M,A;
	public static Pair a,b;
	private static int[] moveA,moveB;
	private static boolean[] checkA,checkB;
	private static int[][] AP;
	private static int[][] dir = {{0,0},{-1,0},{0,1},{1,0},{0,-1}};	// 0,1,2,3,4
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int TC =Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= TC; t++) {
			sb.append("#").append(t).append(" ");
			
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			
			moveA = new int[M];
			moveB = new int[M];
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < M; i++) {
				moveA[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				moveB[i] = Integer.parseInt(st.nextToken());
			}
			
			AP = new int[A][4];
			
			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine());
				AP[i][1] = Integer.parseInt(st.nextToken())-1;		//
				AP[i][0] = Integer.parseInt(st.nextToken())-1;
				AP[i][2] = Integer.parseInt(st.nextToken());		// c
				AP[i][3] = Integer.parseInt(st.nextToken());		// p
				
			}
			
			a = new Pair(0,0);
			b = new Pair(9,9);
			checkA = new boolean[A];
			checkB = new boolean[A];
			
			int ans = 0;
			for (int i = 0; i < M+1; i++) {
				checkIsin();
				int max =0;
				int tmpA=0,tmpB = 0;
				for (int r = 0; r < A; r++) {
					if(checkA[r]) tmpA = AP[r][3];
					for (int c = 0; c < A; c++) {
						if(checkB[c] && !(checkA[r] && r==c)) {
							tmpB = AP[c][3];
						}
						max= Math.max(max, tmpA+tmpB);
						tmpB = 0;
					}
					tmpA = 0;
				}
			
				ans+=max;
				if(i == M) break;
				// 이동
				a.x += dir[moveA[i]][0];
				a.y += dir[moveA[i]][1];
				b.x += dir[moveB[i]][0];
				b.y += dir[moveB[i]][1];
			}
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}
	
	

	private static void checkIsin() {
		
		for (int i = 0; i < A; i++) {
			if(AP[i][2] >= Math.abs(a.x- AP[i][0]) +  Math.abs(a.y - AP[i][1])) {
				checkA[i] = true;
			}else {
				checkA[i] = false;
			}
			if(AP[i][2] >= Math.abs(b.x- AP[i][0]) +  Math.abs(b.y - AP[i][1])) {
				checkB[i] = true;
			}else {
				checkB[i] = false;
			}
		}
		
	}



	public static class Pair{
		int x,y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
}
