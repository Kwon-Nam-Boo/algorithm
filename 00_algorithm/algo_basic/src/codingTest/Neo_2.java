package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Neo_2 {

	private static StringBuilder sb = new StringBuilder();
	static int[] parents;
	static int[] rank;
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[][] network = {{1,2},{3,5},{4,2},{5,6}};
		int[][] repair = {{5,4,15},{3,2,10}};
//		int[][] network = {{1,2}};
//		int[][] repair = {{3,1,12},{2,3,10}};
		System.out.println(solution(6,network, repair));
		
	}
	
	 public static int solution(int n, int[][] network, int[][] repair) {
	        int answer = -1;
	        
	        parents = new int[n+1];
			rank = new int[n+1];
			
			int E = network.length + repair.length;
			
			int[][] edges = new int[E][3];
			int c;
			for (c = 0; c < network.length; c++) {
				edges[c][0] = network[c][0];	// 출발점
				edges[c][1] = network[c][1];	// 도착점
				edges[c][2] = 0;	// 도착점
			}
			
			for (; c < E; c++) {
				edges[c][0] = repair[c-network.length][0];	// 출발점
				edges[c][1] = repair[c-network.length][1];	// 도착점
				edges[c][2] = repair[c-network.length][2];	// 도착점
			}
			// 간성들을 가중치 오름차순 정렬
			Arrays.sort(edges , new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					//o1[2] o2[2]
					return Integer.compare(o1[2], o2[2]);
				}
				
			});
//			for (int[] a : edges) {
//				System.out.println(Arrays.toString(a));
//			}
	        
			// 각 정점에 대해 유니온 파인드 준비
			for (int i = 0; i < n; i++) {
				makeSet(i);
			}
			
			int result = 0;
			int cnt = 0;
			for (int i = 0; i < E; i++) {
				int a = findSet(edges[i][0]);
				int b = findSet(edges[i][1]);
				if(a == b)
					continue;
				union(a,b);
				// 간선을 선택
				result += edges[i][2];
				// 정점의 갯수 -1번 반복하면서
				cnt++;
				if(cnt == n-1)
					break;
			}
			if(cnt == n-1) {
				answer = result;
			}
	        return answer;
	 }
	
	// 세팅
		static void makeSet(int x) {
			parents[x] =x;
		}
		static int findSet(int x) {
			
			if(x == parents[x])	// 자기 자신이 부모라면 --> 본인이 팀의 식별자!
				return x;
			else {		// 그게 아니면  다시 탐색한다
				parents[x] = findSet(parents[x]);
				return parents[x];
			}
		}
		static void union(int x, int y) {
			int sx = findSet(x);
			int sy = findSet(y);
			
			// 짧은 놈을 긴쪽에 붙여주면 좀더 효율적이다
			if(rank[sx] > rank[sy]) {
				// sy의 부모를 sx로 지정
				parents[sy] = sx;
			}else {
				parents[sx] = sy;
				if(rank[sx] == rank[sy]) {
					// 해당 트리 높이 상승
					rank[sy]++;
				}
			}
		}
}
