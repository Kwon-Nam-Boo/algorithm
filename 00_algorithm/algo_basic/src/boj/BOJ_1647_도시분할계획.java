package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_1647_도시분할계획 {
	
	private static int V,E;
	private static int[][] Edge;
	private static int[] parent , rank;
	// rank: 트리의 높이(.... 가 아니라 레벨이라고 보는게 나을듯)

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		Edge = new int[E][3];
		for (int i = 0; i < E ; i++) {
			st = new StringTokenizer(br.readLine());
			// 시작 , 도착 , 가중치
			Edge[i][0] = Integer.parseInt(st.nextToken())-1;
			Edge[i][1] = Integer.parseInt(st.nextToken())-1;
			Edge[i][2] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(Edge, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[2], o2[2]);
			}
		});
		parent = new int[V];
		rank = new int[V];
		
		int ans =0;
		int cnt = 0;
		
		// 1. makeSet
		for (int i = 0; i < V; i++) {
			makeSet(i);
		}
		for (int i = 0; i < E; i++) {
			// a점과 b점의 부모찾기
			int a = findSet(Edge[i][0]);
			int b = findSet(Edge[i][1]);
			// 같은 부모란, 같은 그래프 안이라는 뜻(연결할필요 x)
			if(a == b)
				continue;
			// 같은 부모가 아니라면 , union
			union(a,b);
			ans+=Edge[i][2];
			cnt++;
			if(cnt == V-1) {
				ans-=Edge[i][2];
				break;
			}
		}
		System.out.println(ans);
	}

	private static void union(int a, int b) {
		int sa = findSet(a);
		int sb = findSet(b);
		
		// 짧은 놈을 긴놈에게 붙여주는게 좋다
		if(rank[sa] > rank[sb]) {
			parent[sb] = sa;
		}else {
			parent[sa] = sb;
			if(rank[sa] == rank[sb]) {
				// 같은 경우 붙여주고 트리레벨을 올려주자(작은경우는 굳이 레벨을 높일 필요 없음)
				rank[sb]++;
			}
		}
		
	}

	private static int findSet(int i) {
		if(parent[i] == i)
			return i;
		else {
			parent[i] = findSet(parent[i]);
			return parent[i];
		}
	}

	private static void makeSet(int i) {
		parent[i] = i;
	}
	
}
