package ja;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class JA_1863_종교 {
	
	private static int people;
	private static List<Integer>[] graph;
	private static boolean[] visited;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N+1];
		visited = new boolean[N+1];							// 방문 확인용 visit
		
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>(); 
		}
		
		for (int i = 0; i < M; i++) {						// 그래프 제작	
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}
		
		people = N;											// 남은 사람 수(초기값: N)
		int count = 0;										// 종교 수
		
		while(true) {										// 종교 하나를 찾는 반복문
			int start = 0;							
			for (int i = 1; i < visited.length; i++) {		// 아직 종교가 확인 안된 사람 중 숫자가 작은사람을 bfs 돌린다. 
				if(visited[i] == false) {
					start=i;
					break;
				}
			}
		
			bfs(start);										// bfs로 종교 그룹 확인 	
			count++;										// 종교 카운트
			
			if(people ==0) {								// 남은 사람이 없으면 더이상 할필요가 없다.
				break;
			}
		}
		System.out.println(count);
	}
	
	public static void bfs(int start) {						// 일반적인 bfs지만 방문할때마다 people값을 줄여준다.
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		visited[start] =true;
		people--;
		while(!queue.isEmpty()) {
			Integer tmp = queue.poll();
			List<Integer> childs = graph[tmp];
			for (int i = 0; i < childs.size(); i++) {
				int child = childs.get(i);
				if(!visited[child]) {
					queue.offer(child);
					visited[child] = true;
					people--;
				}
			}
		}
		
	}

}
