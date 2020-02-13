package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2573_빙산 {
	
	private static int R;
	private static int C;
	private static boolean[][] visited;
	private static int[][] map;
	private static int[][] melt;
	private static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		int result =0;
		while(true) {
			visited = new boolean [R][C];
			melt = new int[R][C];
			
			int count =0;
			for (int r = 0; r < R; r++) {					// 방문 한적 없이 빙산이 0보다 작으면
				for (int c = 0; c < C; c++) {
					if(!visited[r][c] && map[r][c] > 0) {
						bfs(r,c);						//bfs를 돌린다.
						count++;
					}
				}
			}
			
			if(count ==0) {									// 빙산이 안줄어들고 끝나버리면 0!
				result = 0;
				break;
			}
			
			if(count >= 2) break;							// 빙산이 두개 이상이면 끝!
			
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					int tmp = map[r][c] - melt[r][c];		// 빙산에서 melt값을 뺴준다.
					if(tmp < 0) {
						tmp =0;
					}
					map[r][c] = tmp;
				}
			}
			result++;
			
		}
		sb.append((result));
		System.out.println(sb);
	}
	
	
	public static class Pair{
		int x;
		int y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return "Pair [x=" + x + ", y=" + y + "]";
		}
		
	}
	
	public static void bfs(int r, int c) {
		Queue<Pair> queue = new LinkedList<>();
		queue.offer(new Pair(r,c));
		visited[r][c]=true;
		
		while(!queue.isEmpty()) {
			Pair p = queue.poll();
			for (int i = 0; i < dir.length; i++) {
				int a = p.x + dir[i][0];
				int b = p.y + dir[i][1];
				
				if(isIn(a,b) && map[a][b] > 0 && !visited[a][b] ) {		// 해당 값이 빙산인 경우 큐에 삽입
					queue.offer(new Pair(a,b));
					visited[a][b]=true;
				}
				if(isIn(a,b) && map[a][b] == 0) {						// 주변이 바다면 melt 값을 증가시킨다.
					melt[p.x][p.y]++;
				}
				
			}
		}
		
		
	}
	
	public static boolean isIn(int r, int c) {
		return r>=0 && c>=0 && r< R && c< C;
	}


}
