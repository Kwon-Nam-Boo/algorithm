package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1967_트리의_지름 {

	private static int N;
	private static int max;
	private static int max1;
	private static int start;
	private static List<Pair>[] graph;
	private static boolean visited[];
	//private static int[][] graph;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		graph = new ArrayList[N+1];
		visited = new boolean[N+1];
		for (int i = 1; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < N-1; i++) {
			//System.out.println("a");
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			graph[a].add(new Pair(b,l));
			graph[b].add(new Pair(a,l));
		}
		//graph = new int[N][N];
		//System.out.println(Arrays.toString(graph));
		max = Integer.MIN_VALUE;
		start = 1;
		visited[1] =true;
		
		dfs(1,0);									// 루트에서 가장 멀리 있는 거리와 그 점을 구한다.
		
		max1 = max;											
		max = Integer.MIN_VALUE;					// 가장먼점 start에서 가장 먼점 까지의 거리를 구하면?(지름)
		Arrays.fill(visited, false);					
		visited[start] =true;						// 초기화 작업들
		
		dfs(start,0);
		System.out.println(max);					// 지름
							
	}
	public static void dfs(int r, int sum) {
		
		for (int i = 0; i < graph[r].size(); i++) {
			int v = graph[r].get(i).v;
			if(!visited[v]) {
				visited[v] =true;
				int s = sum+graph[r].get(i).len;
				if(max <s) {
					max = s;						// 가장 먼 거리	
					start =v;						// 가정 먼 점
				}
				dfs(v,sum+graph[r].get(i).len);
			}
		}
	}
	
	public static class Pair{
		int v;
		int len;
		public Pair(int v, int len) {
			this.v = v;
			this.len = len;
		}
		@Override
		public String toString() {
			return "(v=" + v + ", len=" + len + ")";
		}
		
	}
}
