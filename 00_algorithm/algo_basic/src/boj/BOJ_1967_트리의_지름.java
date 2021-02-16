package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1967_트리의_지름 {

	private static int N;
	private static List<Node>[] adlist;
	private static boolean visited[];

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		if(N == 1) {
			System.out.println();
		}else {
			adlist = new ArrayList[N+1];
			
			for (int i = 1; i <= N; i++) {
				adlist[i] = new ArrayList<>();
			}
			
			for (int i = 0; i < N-1; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				adlist[a].add(new Node(b, c));
				adlist[b].add(new Node(a, c));
			}
			// 루트에서 가장 먼 정점 far를 구하고
			visited = new boolean[N+1];
			Node far = bfs(1);
			// far에서 가장 먼 정점을 구하면 지름이다
			visited = new boolean[N+1];
			System.out.println(bfs(far.x).v);
		}
		
		
	}
	
	
	private static Node bfs(int start) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(start,0));
		visited[start] = true;
		
		int max = 0;
		int idx = 0;
		
		while(!queue.isEmpty()) {
			Node now = queue.poll();
			for (int i = 0; i < adlist[now.x].size(); i++) {
				Node next = adlist[now.x].get(i);
				if(!visited[next.x]) {
					visited[next.x] = true;
					int v = next.v + now.v;
					// 현재까지의 최대길이일 경우 값과, idx를 저장
					if(max < v) {
						max = v;
						idx = next.x;
					}
					queue.offer(new Node(next.x, v));
				}
			}
		}
		
		return new Node(idx,max);
	}


	public static class Node{
		int x, v;
		
		public Node(int x, int v) {
			super();
			this.x = x;
			this.v = v;
		}	
	}
		
}
