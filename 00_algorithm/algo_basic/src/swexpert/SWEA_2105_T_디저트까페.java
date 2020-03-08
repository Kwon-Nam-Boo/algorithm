package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2105_T_디저트까페 {

	private static int N;
	private static int ans;
	private static boolean v;
	private static int[][] map;
	private static int[][] dir= {{1,1},{1,-1},{-1,-1},{-1,1}};
	private static boolean[] desert = new boolean[101];

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <= TC; t++) {
			sb.append("#").append(t).append(" ");
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			ans = -1;
			for (int r = 0; r < N-2; r++) {		// 세로는 밑에 두칸을 갈필요가 없고
				for (int c = 1; c < N-1; c++) {
					desert = new boolean[101];
					v = false;
					dfs(0,new Pair(r,c),new Pair(r,c),0);
	
				}
			}
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}
	public static void dfs(int d, Pair start, Pair now, int k) {
		if(start.x == now.x && start.y == now.y && v && d >=4) {		//시작점으로 돌아왔고 방문한적이 있어야됨( 최소 d는 4이상되야한다)
			if(ans < d) {
				ans = d;
			}
			return;
		}
		
		if(start.x == now.x && start.y == now.y) {						// 처음 시작하는 점이면 시작점 true
			v = true;
		}

		for (int i = k; i < dir.length; i++) {
			int nx = dir[i][0] + now.x;
			int ny = dir[i][1] + now.y;
			
			if(isIn(nx,ny) && !desert[map[nx][ny]]) {	// 범위안에 존재, 방문 한적 없음
				desert[map[nx][ny]] =true;
				dfs(d+1,start,new Pair(nx,ny),i);
				desert[map[nx][ny]] =false;
			}
		}
	}
	
	public static class Pair{
		int x;
		int y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
	public static boolean isIn(int r, int c) {
		return r>=0 && c>=0 && r < N && c< N;
	}
}
