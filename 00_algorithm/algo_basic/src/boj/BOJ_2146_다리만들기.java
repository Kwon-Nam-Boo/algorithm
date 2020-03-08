package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2146_다리만들기 {

	private static int N;
	private static int iNum;
	private static int bridge;
	private static int[][] map;
	private static int[][] dir= {{-1,0},{1,0},{0,-1},{0,1}};
	private static boolean[][] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N =Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		iNum=1;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if(!visited[r][c] && map[r][c] == 1) {				// 각 섬을 각각 다른 숫자로 채운다. dfs로 구현
					iNum++;											// ex) 1번째 섬은 2로 채워져있고 2번째섬은 3으로 채워져있고 ...
					dfs(new Pair(r,c,0));							// 이유는 섬을 구분하기 위해서 
				}	
			}
		}
		
		bridge = Integer.MAX_VALUE;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if(map[r][c] > 0) {
					for (int i = 0; i < N; i++) {
						Arrays.fill(visited[i], false);
					}
					bfs(new Pair(r,c,0));							// bfs로 각 위치마다 다른섬을 만나는 최소 다리를 찾는다.
				}
			}
		}
		System.out.println(bridge);
		
	}
	public static void bfs(Pair p){
		Queue<Pair> queue = new LinkedList<>();
		queue.offer(p);
		visited[p.x][p.y] = true;
		
		while(!queue.isEmpty()) {
			Pair tmp = queue.poll();
			if(map[tmp.x][tmp.y]!=0 && map[tmp.x][tmp.y]!=map[p.x][p.y]) {		// 만약 다른섬에 도착했다면?
				bridge = Math.min(bridge, tmp.c-1);								// 시작위치에서의 최소 다리 길이는 구했다. 끝
				return;
			}
			for (int i = 0; i < dir.length; i++) {
				int a = tmp.x + dir[i][0];
				int b = tmp.y + dir[i][1];
				if(a>=0 && b>=0 && a<N && b< N && !visited[a][b] && map[a][b]!=map[p.x][p.y]){	// 자신의 섬을 제외하고 이동
					int c = tmp.c +1;
					queue.offer(new Pair(a,b,c));
					visited[a][b] = true;
				}
			}
		}
		
		
		
	}
	public static void dfs(Pair p) {
		map[p.x][p.y] = iNum;
		
		for (int i = 0; i < dir.length; i++) {
			int a = p.x + dir[i][0];
			int b = p.y + dir[i][1];
			if(a>=0 && b>=0 && a<N && b< N && !visited[a][b] && map[a][b] == 1) {
				visited[p.x][p.y] =true;
				dfs(new Pair(a,b,0));
				visited[a][b] =false;
			}
		}
	}
	public static class Pair{
		int x;
		int y;
		int c;									// 현재 거리
		public Pair(int x, int y, int c) {
			this.x = x;
			this.y = y;
			this.c = c;
		}
		
	}

}
