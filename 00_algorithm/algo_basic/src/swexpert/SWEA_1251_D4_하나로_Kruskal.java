package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1251_D4_하나로_Kruskal {

	private static int[] parents;
	// 트리의 높이
	private static int[] rank;
	
	private static double E;
	private static int N;
	private static int[][] island;
	
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int TC =Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= TC; t++) {
			sb.append("#").append(t).append(" ");
			N = Integer.parseInt(br.readLine());
			island = new int[N][2];
			
			st = new StringTokenizer(br.readLine());
			for (int r = 0; r < N; r++) {
				island[r][0] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				island[c][1] = Integer.parseInt(st.nextToken());
			}
			
			E = Double.parseDouble(br.readLine());
			
			int e = N*(N-1)/2;
			Node[] line = new Node[e];
			
			int cnt = 0;
			for (int i = 0; i < N-1; i++) {
				for (int j = i+1; j < N; j++) {
					double d = Math.sqrt(Math.pow(island[i][0]-island[j][0], 2)+Math.pow(island[i][1]-island[j][1], 2));
					line[cnt] = new Node(i,j,d*d*E);
					cnt++;
				}
			}
			Arrays.sort(line);
			//System.out.println(Arrays.toString(line));
			
			parents = new int[N];
			rank = new int[N];
			
			for (int i = 0; i < N; i++) {
				makeSet(i);
			}
			
			double result = 0;
			cnt = 0;
			
			for (int i = 0; i < e; i++) {
				int a = findSet(line[i].x);
				int b = findSet(line[i].y);
				if(a == b)
					continue;
				union(a,b);
				//System.out.println(result);
				result+=line[i].d;
				
				cnt++;
				if(cnt == N-1)
					break;
			}
			
			sb.append(Math.round(result)).append("\n");
		}
		System.out.println(sb);

	}
	public static class Node implements Comparable<Node>{
		int x;
		int y;
		double d;
		
		public Node(int x, int y, double d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return Double.compare(this.d, o.d);
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", d=" + d + "]";
		}
		
		
	}
	
	public static void makeSet(int x) {
		parents[x] = x;
	}
	public static int findSet(int x) {
		if(x == parents[x]) {
			return x;
		}else {
			parents[x] = findSet(parents[x]);
			return parents[x];
		}
	}
	public static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		
		if(rank[px] > rank[py]) {
			parents[py]= px;
		}else {
			parents[px]= py;
			if(rank[px] == rank[py]) {
				rank[px]++;
			}
		}
	}
}
