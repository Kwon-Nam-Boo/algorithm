package rhtn_homework;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_1922_네트워크_연결 {

	private static StringBuilder sb = new StringBuilder();
	private static int N;
	private static int M;
	private static Edge[] edges;
	private static int[] parent;
	private static int[] rank;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		edges = new Edge[M];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			edges[i] = new Edge(x, y, v);
		}
		Arrays.sort(edges , new Comparator<Edge>() {
			@Override
			public int compare(Edge o1, Edge o2) {
				Integer v1 = o1.v;
				Integer v2 = o2.v;
				return v1.compareTo(v2);
			}
		});
		parent = new int[N+1];
		rank = new int[N+1];
		// makeSet set 만들기
		for (int i = 1; i <= N; i++) {
			makeSet(i);
		}
		int cnt = 0;
		int result =0;
		
		for (int i = 0; i < edges.length; i++) {
			// 각 점의 부모를 찾아서
			int px = findSet(edges[i].x);
			int py = findSet(edges[i].y);
			
			// 부모가 같으면 굳이 안해도 됨
			if(px == py) continue;
			
			union(px, py);
			result+=edges[i].v;
			cnt++;
			if(cnt == N-1) break;
		}
		System.out.println(result);
	}
	


	private static void makeSet(int x) {
		parent[x] = x;
	}
	
	private static int findSet(int x) {
		if(x == parent[x]) return x;
		else {
			parent[x] = findSet(parent[x]);
			return parent[x];
		}
	}
	
	private static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		
		if(rank[px] > rank[py]) {
			parent[py] = px;
		}else {
			parent[px] = py;
			if(rank[px] == rank[py]) {
				rank[py]++;
			}
		}
		
	}


	public static class Edge{
		int x,y,v;

		public Edge(int x, int y, int v) {
			super();
			this.x = x;
			this.y = y;
			this.v = v;
		}

		@Override
		public String toString() {
			return "Edge [x=" + x + ", y=" + y + ", v=" + v + "]";
		}
		
	}
	
	
}
