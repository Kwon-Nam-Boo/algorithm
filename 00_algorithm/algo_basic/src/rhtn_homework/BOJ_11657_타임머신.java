package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_11657_타임머신 {
	
	private static int N,M;
	private static List<Edge>[] adList;
	// 너무너무 중요한 long형  int의 max값에서 플러스가 되면 값이 변하기 때문
	private static long[] dist;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		adList = new ArrayList[N+1];
		dist = new long[N+1];
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		for (int i = 1; i <= N; i++) {
			adList[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			adList[a].add(new Edge(b,c));
		}
		
		// 벨만-포드를 실행하고 음수순환이 없다면
		if(BF(1)) {
			for (int i = 2; i <= N; i++) {
				if(dist[i]!= Integer.MAX_VALUE) 
					sb.append(dist[i] +"\n");
				else {
					sb.append(-1 + "\n");
				}
			}
		}else {
			sb.append(-1);
		}
		System.out.println(sb);
		
	}
	
	private static boolean BF(int i) {
		dist[i] = 0;
		// N번 반복한다(N-1 이면 충분하지만 음수 순환있는지 확인을 위해 한번더)
		for (int j = 1; j <= N; j++) {
			// 매번 "모든 간선"을 확인한다 
			for (int s = 1; s <= N; s++) {
				for (Edge ed : adList[s]) {
					int e = ed.x;
					int v = ed.v;
					// 현재 간선을 거쳐서 다른 노드를 가는게 더 짧다면 교체
					if(dist[s]!=Integer.MAX_VALUE && dist[e] > dist[s] + v) {
						dist[e] = dist[s] + v;
						// 다만 맨 마지막임에도 불구하고 교체가된다면, 음수 순환이 잇다는것!
						if(j == N) return false;
					}
				}
			}
		}
		return true;
	}

	public static class Edge{
		int x, v;

		public Edge(int x, int v) {
			super();
			this.x = x;
			this.v = v;
		}
		
	}
}
