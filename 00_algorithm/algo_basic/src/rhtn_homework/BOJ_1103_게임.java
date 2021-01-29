package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1103_게임 {
	
	private static int[][] dir ={{-1,0},{1,0},{0,-1},{0,1}};
	private static int N,M;
	private static char[][] map;
	private static int[][] memo;
	private static boolean[][] visited;
	private static int ans;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		memo = new int[N][M];
		visited = new boolean[N][M];
		
		for (int r = 0; r < N; r++) {
			map[r] = br.readLine().toCharArray();	
		}
		ans =0;
		dfs(0,0,1);
		System.out.println(ans);
	}

	private static void dfs(int r, int c, int d) {
		if(ans ==-1) return;
		
		// 최고 횟수 갱신
		if(d>ans) {
			ans = d;
		}
		
		// 메모이제이션
		memo[r][c] = d;
		
		for (int i = 0; i < dir.length; i++) {
			int nr = dir[i][0] + r;
			int nc = dir[i][1] + c;
			// 해당방향이 아무것도 없다면 패스
			if(!isIn(nr,nc)) continue;
			
			nr = dir[i][0]*(map[r][c] -'0') +r;
			nc = dir[i][1]*(map[r][c] -'0') +c;
			
			// 범위를 벗어나지 않고, 구멍에 안빠질때
			if(isIn(nr,nc) && map[nr][nc]!='H'){
				// 방문 한곳이라면 , 순환구조 즉, 무한루프가 가능해진다
				if(visited[nr][nc]) {
					ans = -1;
					return;
				}
				// 해당위치로 오는 횟수가, 더적은 것은 굳이 dfs를 할필요가 없다(가지치기)
				if(memo[nr][nc] > d) continue;
				
				visited[nr][nc] = true;
				dfs(nr,nc,d+1);
				visited[nr][nc] = false;
			}
			
		}
	}
	
	private static boolean isIn(int r, int c) {
		return r>=0 && c>=0 && r<N && c<M;
	}
	

}
