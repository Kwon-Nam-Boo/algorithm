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
	
	private static int count;
	private static List<Integer>[] graph;
	private static boolean[] visited;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N+1];
		visited = new boolean[N+1];
		
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>(); 
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a].add(b);
			graph[b].add(a);
		}
		
		count = N;
		
		int c = 0;
		
		while(true) {
			int start = 0;
			for (int i = 1; i < visited.length; i++) {
				if(visited[i] == false) {
					start=i;
					break;
				}
			}
		
			bfs(start);
			c++;
			
			if(count ==0) {
				break;
			}
		}
		System.out.println(c);
	}
	
	public static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		visited[start] =true;
		count--;
		while(!queue.isEmpty()) {
			Integer tmp = queue.poll();
			List<Integer> childs = graph[tmp];
			for (int i = 0; i < childs.size(); i++) {
				int child = childs.get(i);
				if(!visited[child]) {
					queue.offer(child);
					visited[child] = true;
					count--;
				}
			}
		}
		
	}

}
