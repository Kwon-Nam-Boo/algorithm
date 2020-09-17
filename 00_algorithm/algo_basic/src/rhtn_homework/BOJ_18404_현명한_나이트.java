package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_18404_현명한_나이트 {

	private static StringBuilder sb = new StringBuilder();
	private static int N,M;
	private static Pair K;
	private static Pair[] E;
	private static int[][] map;
	private static int[][] dir = {{-2,-1},{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2}};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb =new StringBuilder();
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		st = new StringTokenizer(br.readLine());
		K = new Pair(Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())-1,0);
		E = new Pair[M];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			E[i] = new Pair(Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())-1,0);
		}
		bfs(K);
		
		for (int i = 0; i < M; i++) {
			sb.append(map[E[i].x][E[i].y]).append(" ");
			//System.out.println(map[E[i].x][E[i].y]);
		}
		System.out.println(sb);
//		for (int[] a: map) {
//			System.out.println(Arrays.toString(a));
//		}
		
	}
	private static void bfs(Pair K) {
		Queue<Pair> queue = new LinkedList<>();
		queue.offer(K);
		map[K.x][K.y] = K.cnt;
		
		while(!queue.isEmpty()) {
			Pair p = queue.poll();
			for (int i = 0; i < dir.length; i++) {
				int px = dir[i][0] + p.x;
				int py = dir[i][1] + p.y;
				if(isIn(px,py) && map[px][py] == 0) {
					queue.offer(new Pair(px,py,p.cnt+1));
					map[px][py] = p.cnt+1;
				}
			}
		}
		
		
	}
	public static class Pair{
		int x,y,cnt;

		public Pair(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
		
	}
	public static boolean isIn(int r, int c) {
		return r>=0 && c>=0 && r<N && c< N;
	}
}
