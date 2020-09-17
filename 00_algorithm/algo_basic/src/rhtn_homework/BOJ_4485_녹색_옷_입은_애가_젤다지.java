package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class BOJ_4485_녹색_옷_입은_애가_젤다지 {

	private static StringBuilder sb = new StringBuilder();
	private static int cnt,N;
	private static int[][] map;
	private static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
	private static int ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int cnt =1;
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N==0) break;
			map = new int[N][N];
			
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
//			for (int[] a : map) {
//				System.out.println(Arrays.toString(a));
//			}
			
			int d[][] = new int[N][N];
			
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					d[r][c] = Integer.MAX_VALUE;
				}
			}
			
			d[0][0] = map[0][0];
			ans = 0;
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			
			pq.add(new Edge(new Pair(0,0),map[0][0]));
			
			while(!pq.isEmpty()) {
				
				Edge tmp = pq.poll();
				Pair p = tmp.p;
				int cost = tmp.weight;
				if(cost!=d[p.x][p.y]) continue;
				
				for (int i = 0; i < dir.length; i++) {
					int px = dir[i][0] + p.x;
					int py = dir[i][1] + p.y;
					if(isIn(px,py) && d[px][py]> d[p.x][p.y] + map[px][py]) {
						d[px][py] = d[p.x][p.y] + map[px][py];
						pq.add(new Edge(new Pair(px,py), d[px][py]));

					}
				}
			}
			sb.append("Problem ").append(cnt).append(": " + d[N-1][N-1] + "\n");
			cnt++;
		}
		System.out.println(sb);
		
	}
	
	public static class Edge implements Comparable<Edge>{
		Pair p;
		int weight;
		
		public Edge(Pair p, int weight) {
			super();
			this.p = p;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			Integer w1 = this.weight;
			Integer w2 = o.weight;
			
			return w1.compareTo(w2);
		}

		@Override
		public String toString() {
			return "Edge [p=" + p + ", weight=" + weight + "]";
		}
		
		
		
	}
	
	public static class Pair{
		int x,y;

		public Pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Pair [x=" + x + ", y=" + y + "]";
		}

	}
	
	public static boolean isIn(int r, int c){
		return r>=0 && c>=0 && r<N && c<N;
	}
}