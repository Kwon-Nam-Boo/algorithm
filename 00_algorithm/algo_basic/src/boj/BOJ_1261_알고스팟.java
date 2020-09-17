package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_1261_알고스팟 {
	
	private static int R;
	private static int C;
	private static char[][] map;
	private static boolean[][] visited;
	public static int[][] dir= {{-1,0},{1,0},{0,-1},{0,1}};
	

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[R][C];
		for (int r = 0; r < R; r++) {
			map[r] = br.readLine().toCharArray();
		}
		bfs();
	}
	public static void bfs() {
		Deque<Pair> dq = new ArrayDeque<>();
		dq.offer(new Pair(0,0,0));
		visited[0][0] =true;
		
		while(!dq.isEmpty()) {
			Pair tmp = dq.poll();
			if(tmp.x == R-1 && tmp.y == C-1) {
				System.out.println(tmp.c);
				return;
			}
			for (int i = 0; i < dir.length; i++) {
				int a = dir[i][0] + tmp.x;
				int b = dir[i][1] + tmp.y;
				if(isIn(a,b) && !visited[a][b]) {
					if(map[a][b]=='0') {
						dq.push(new Pair(a,b,tmp.c));		// 우선 순위 앞에 넣어버리기..
					}else {
						dq.add(new Pair(a,b,tmp.c+1));		// 뒤에 넣어버리기..
					}
					visited[a][b] = true;
				}
			}
		}
	
	}
	
	public static class Pair{
		int x;
		int y;
		int c;
		public Pair(int x, int y,int c) {
			this.x = x;
			this.y = y;
			this.c = c;

		}
		
	}
	public static boolean isIn(int r, int c) {
		return r>=0 && c>=0 && r< R && c< C;
	}

}
