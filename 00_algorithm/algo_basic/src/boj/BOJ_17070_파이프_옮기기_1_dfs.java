package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17070_파이프_옮기기_1_dfs {

	private static int N,ans;
	private static int[][] map;
	private static int[][] dir = {{0,1},{1,0},{1,1}};	// 오른쪽  , 아래쪽, 대각선
	private static boolean[][] pipeRule = {{true,false,true},{false,true,true},{true,true,true}};
	private static boolean[][][] visited;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N][3];
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		ans = 0;
		dfs(0,1,0);
		
		System.out.println(ans);
		
	}
	private static void dfs(int x, int y, int type) {
		if(x == N-1 && y == N-1) {
			ans++;
			return;
		}
		for (int i = 0; i < dir.length; i++) {	// 오른쪽, 아래 대각선
			
			int rx = x + dir[i][0];
			int ry = y + dir[i][1];
			if(!isIn(rx,ry)) continue;
			
			if(i<2) {	// 오른쪽이나 밑의 경우
				// 해당 타입에  움직일수가 없으며, 벽이라면 못간다
				if(!pipeRule[type][i] || map[rx][ry]==1) continue;
			}else {		// 대각선의 경우
				if(map[rx][ry]==1 || map[x+1][y]==1 || map[x][y+1]==1) continue;
			}
			dfs(rx,ry,i);
		}
	}
		
	public static boolean isIn(int r ,int c) {
		return r>=0 && c >=0 && r< N && c < N;
	}

}
