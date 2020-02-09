package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class practiceDFSBFS {
	
	private static int N;
	private static int M;
	private static int start;
	private static boolean[] visited;
	private static List<Integer>[] graph;
	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N+1];
		visited = new boolean[N+1];
		
		for (int i = 1; i < graph.length ; i++) {		// 그래프 선언
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);							// 각 번호에 대해 리스트로 간선정보 입력
			graph[b].add(a);							// 양방향
		}
		for (int i = 1; i < graph.length ; i++) {		// 배열안의 각 리스트 정렬
			Collections.sort(graph[i]);
		}
		dfs(start);
		sb.append("\n");
		visited = new boolean[N+1];
		bfs(start);
		System.out.println(sb);
	}
	
	public static void dfs(int d) {
		visited[d] =true;								// 방문 했다고 체크
		sb.append(d).append(" ");
		List<Integer> childs = graph[d];
		for (int i = 0; i < childs.size(); i++) {		// 현재 값에 대한 간선 값들을 보고
			Integer child = childs.get(i);
			if(!visited[child]) {						// 방문 한적 이 없는 값이면 
				dfs(child);								// 재귀 
			}
		}
	}
	
	public static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();			// 큐 생성
		queue.offer(start);									// 초기값을 넣고
		visited[start] =true;								// 방문 체크
		
		while(!queue.isEmpty()) {							// 큐가 빌때까지
			int tmp = queue.poll();							
			sb.append(tmp).append(" ");						// 큐의 값을 뺴서 출력값으로 넣는다
			List<Integer> childs = graph[tmp];		
			for (int i = 0; i < childs.size(); i++) {		// 뺸 큐값의 간선점 들을 뺴낸다
				Integer child = childs.get(i);
				if(!visited[child]) {						// 방문하지 않았으면 큐에 넣는다.
					queue.offer(child);
					visited[child] =true;
				}
			}
		}
	}

}
