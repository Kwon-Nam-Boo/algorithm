package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1941_소문난_칠공구 {
	
	private static int N, ans;
	private static char[][] map;
	private static boolean[][] visited;
	private static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = 5;
		map = new char[N][N];
		visited = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		ans = 0;
		for (int i = 0; i < N*N; i++) {
			dfs(i,(1<<25) + (1<<i),1,0);
		}
		System.out.println(ans);
	}

	private static void dfs(int now,int bm, int cnt, int yCnt) {
		int r = now/N;
		int c = now%N;
		
		// 가지치기
		if(map[r][c] == 'Y') {	
			yCnt++;
		}
		if(yCnt >=4) {
			return;
		}
		
		// 종료 조건
		if(cnt == 7) {
			visited = new boolean[N][N];
			bfs(now,bm);
			//System.out.println(Integer.toBinaryString(bm));
			return;
		}
			
		//기본
		for (int i = now+1; i < N*N; i++) {
			if(((1<<i) & bm) == 0) {		// 이미 방문한곳이면 패스 .. 아니면 dfs
				bm = bm | (1<<now); 
				dfs(i,bm,cnt+1,yCnt);
				bm = bm ^ (1<<now); 
			}
		}
		return;
		
	}
	
	private static void bfs(int now, int bm) {
		
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(now);
		visited[now/N][now%N] = true;
		int count = 1;
		
		while(!queue.isEmpty()) {
			int tmp = queue.poll();
			int r = tmp/N;
			int c = tmp%N;
			
			for (int i = 0; i < dir.length; i++) {
				int nr = dir[i][0]+ r;
				int nc = dir[i][1]+ c;
				
				if(isIn(nr,nc) && !visited[nr][nc] && ((1<<nr*N+nc) & bm)>0) {
					visited[nr][nc] = true;
					queue.offer(nr*N+nc);
					count++;
				}
			}
		}
		if(count == 7) {
			ans++;
			//System.out.println(Integer.toBinaryString(bm));
		}
	}

	public static boolean isIn(int r, int c) {
		return r>=0 && c>=0 && r<N && c<N;
	}

}
