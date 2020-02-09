package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2178_미로탐색 {
	
	private static int N;
	private static int M;
	private static int cnt;
	private static int min = Integer.MAX_VALUE;
	private static String[][] maze;
	private static boolean[][] visited;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		maze = new String[N][M];
		for (int r = 0; r < N; r++) {
			maze[r] = br.readLine().split("");
		}
		//System.out.println(Arrays.deepToString(maze));
		find(0,0);
		System.out.println(min);
	}
	public static void find(int r, int c) {
		if(!isIn(r,c) || maze[r][c].equals("0")) {
			return;
		}
		if(r == N-1 && c== M-1) {
			cnt++;
			min = Math.min(min, cnt);
			cnt--;
			return;
		}
		maze[r][c] ="0";
		cnt++;
		find(r-1,c);
		find(r+1,c);
		find(r,c-1);
		find(r,c+1);
		cnt--;
		maze[r][c] ="1";
	}
	public static boolean isIn(int r, int c) {
		return r>=0 && c>=0 && r < N && c < M;
	}

}
