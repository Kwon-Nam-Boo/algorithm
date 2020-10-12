package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA_1249_배급로 {

	private static StringBuilder sb = new StringBuilder();
	private static int N;
	private static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int tc = Integer.parseInt(br.readLine());
		
		
		for (int t = 1; t <= tc; t++) {
			N = Integer.parseInt(br.readLine());
			char[][] map = new char[N][N];
			int[][] dist = new int[N][N];
			for (int r = 0; r < N; r++) {
				map[r]=br.readLine().toCharArray();
				Arrays.fill(dist[r], Integer.MAX_VALUE);
			}
			
			sb.append("#").append(t).append(" " + dijkstra(map,dist) + "\n");
		}
		System.out.println(sb);
		
	}
	
	
	
	private static int dijkstra(char[][] map, int[][] dist) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(0,0,0));
		dist[0][0] = 0;
		
		while(!pq.isEmpty()) {
			Edge curr = pq.poll();
			
			if(dist[N-1][N-1]!=Integer.MAX_VALUE) return dist[N-1][N-1];
			if(dist[curr.x][curr.y] != curr.cost) continue;
			
			for (int i = 0; i < dir.length; i++) {
				int nx = dir[i][0] + curr.x;
				int ny = dir[i][1] + curr.y;
				if(isIn(nx,ny) && dist[nx][ny] > dist[curr.x][curr.y] + (map[nx][ny]-'0')){
					dist[nx][ny] = dist[curr.x][curr.y] + (map[nx][ny]-'0');
					pq.remove(new Edge(nx,ny,dist[nx][ny]));
					pq.add(new Edge(nx,ny,dist[nx][ny]));
				}
			}
		}
		return dist[N-1][N-1];
		
	}
	public static boolean isIn(int r, int c) {
		return r>=0 && c>=0 && r<N && c<N;
	}



	public static class Edge implements Comparable<Edge>{
		int x, y, cost;

		public Edge(int x, int y, int cost) {
			super();
			this.x = x;
			this.y = y;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return "Edge [x=" + x + ", y=" + y + ", cost=" + cost + "]";
		}

		@Override
		public int compareTo(Edge o) {
			Integer o1 = this.cost;
			Integer o2= o.cost;
			return o1.compareTo(o2);
		}
		
		
	}
}
