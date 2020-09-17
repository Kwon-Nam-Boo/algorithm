package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2630_색종이_만들기 {
	
	private static int[][] map;
	private static int blue = 0;
	private static int white =0;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		cut(0,0,N);
		sb.append(white).append("\n").append(blue);
		System.out.println(sb);
	}
	public static void cut(int x, int y, int N) {
		if(N==0) return;
		int nx = x+ (N/2);
		int ny = y+ (N/2);
		
		if(!check(x,y,N/2)) {					//  위 아래 방법 둘다 가능
			cut(x,y,N/2);
		}
		if(!check(x,ny,N/2)) {
			cut(x,ny,N/2);
		}
		if(!check(nx,y,N/2)) {
			cut(nx,y,N/2);
		}
		if(!check(nx,ny,N/2)) {
			cut(nx,ny,N/2);
		}	
		/*if(!check(x,y,N)) {
			cut(x,y,N/2);
			cut(x,ny,N/2);
			cut(nx,y,N/2);
			cut(nx,ny,N/2);
		}*/
	}
	
	public static boolean check(int x, int y, int N) {
		
		int a = map[x][y];
		
		for (int i = x; i < x+N; i++) {
			for (int j = y; j < y+N; j++) {
				if(a!= map[i][j]) {
					return false;
				}
			}
		}
		if(a==1) {
			blue++;
		}else {
			white++;
		}
		return true;
	}

}
