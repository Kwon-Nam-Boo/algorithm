package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1780_종이의_개수 {
	
	private static int[][] map;
	private static int minusOne;
	private static int zero;
	private static int one;
	

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
		sb.append(minusOne).append("\n").append(zero).append("\n").append(one);
		System.out.println(sb);

	}
	public static void cut(int x, int y, int N) {
		if(N==0) return;
		int nx = x+ (N/3*2);
		int mx = x+ (N/3);
		int ny = y+ (N/3*2);
		int my = y+ (N/3);
		
		if(!check(x,y,N)) {
			cut(x,y,N/3);
			cut(x,my,N/3);
			cut(x,ny,N/3);
			cut(mx,y,N/3);
			cut(mx,my,N/3);
			cut(mx,ny,N/3);
			cut(nx,y,N/3);
			cut(nx,my,N/3);
			cut(nx,ny,N/3);
		}
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
			one++;
		}else if(a==-1) {
			minusOne++;
		}else {
			zero++;
		}
		return true;
	}
}
