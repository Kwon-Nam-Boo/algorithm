package algo_basic.day6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P323_Exercise3_BFS {
	
	private static int v = 7;
	private static int[] minDepth = new int[v+1];
	private static String src= "1 2 1 3 2 4 2 5 4 6 5 6 6 7 3 7";
	private static List<Integer>[] graph = new List[v+1];
	
	private static boolean[] visited = new boolean[v+1];
	
	public static void makeGraph() {
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}
		String[] splited = src.split(" ");
		for (int i = 0; i < splited.length; i+=2) {
			int a = Integer.parseInt(splited[i]);
			int b = Integer.parseInt(splited[i+1]);
			
			graph[a].add(b);
			graph[b].add(a);
		}
		for (int i = 0; i < graph.length; i++) {
			System.out.println(graph[i]);
		}
	}

	public static void bfs(int start) {
		
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			int tmp = queue.poll();
			
			System.out.print(tmp +"-");
			List<Integer> childs = graph[tmp];
			for (int i = 0; i < childs.size(); i++) {
				Integer child = childs.get(i);
				if(!visited[child]) {
					queue.offer(child);
					visited[child] = true;
				}
			}
		}
		
	}
	
	public static void bfs_2(int start) {
		boolean[] visited1 = new boolean[v+1];
		Queue<Integer> queue = new LinkedList<>();
		Arrays.fill(minDepth, Integer.MAX_VALUE);
		
		queue.offer(start);
		visited1[start] = true;
	
		minDepth[start] = 0;
		
		while(!queue.isEmpty()) {
			Integer front = queue.poll();
			System.out.print(front +"-");
			List<Integer> childs = graph[front];
			for (int i = 0; i < childs.size(); i++) {
				Integer child = childs.get(i);
				if(!visited1[child]) {
					if(minDepth[child] > minDepth[front]+1) {
						minDepth[child] = minDepth[front]+1;
					}
					queue.offer(child);
					visited1[child] = true;
				}
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			makeGraph();
			//bfs(1);
			bfs_2(1);
			System.out.println();
			System.out.println(Arrays.toString(minDepth));

	}
}