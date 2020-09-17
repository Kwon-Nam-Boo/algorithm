package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class BOJ_1992_쿼드트리 {
	
	private static char[][] arr;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
	
		for (int r = 0; r < N; r++) {
			String tmp = br.readLine();
			for (int c = 0; c < N; c++) {
				arr[r][c]= tmp.charAt(c);
			}
		}
		if(!check(0,0,N)) {
			cut(0,0,N);
		}
		System.out.println(sb);
	}
	
	public static void cut(int x, int y, int n) {
		
		int hn = n/2;
		int hx = x + hn;
		int hy = y + hn;
		
		sb.append("(");
		
		if(!check(x,y,hn)) {
			cut(x,y,hn);
		}
		if(!check(x,hy,hn)) {
			cut(x,hy,hn);
		}
		if(!check(hx,y,hn)) {
			cut(hx,y,hn);
		}
		if(!check(hx,hy,hn)) {
			cut(hx,hy,hn);
		}
		sb.append(")");
	}
	
	public static boolean check(int x, int y, int n) {

		char f = arr[x][y];
		
		for (int r = x; r < x + n; r++) {
			for (int c = y; c < y+n; c++) {
				if(f != arr[r][c]) return false;
			}
		}
		if(f == '0') {
			sb.append("0");
		}else {
			sb.append("1");
		}
		return true;
	}
	
}
