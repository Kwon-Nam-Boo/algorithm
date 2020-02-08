package algo_basic.day5;

import java.awt.font.GraphicAttribute;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P195_Exercise3_stack {
	private static int v = 7;
	private static String src ="1 2 1 3 2 4 2 5 4 6 5 6 6 7 3 7";
	private static List<Integer>[] graph = new List[v+1];
	
	private static boolean[] visited1 = new boolean[v+1];
	private static List<Integer> path1 = new ArrayList<>();
	
	private static void makeGraph() {
		for (int i = 1; i < graph.length; i++) {
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
			System.out.println(i + " -> " + graph[i]);
		}
		
	}
	public static void DFS(int start) {
		boolean[] visited = new boolean[v+1];
		Stack<Integer> stack = new Stack<>();
		List<Integer> path = new ArrayList<>();
		// 출발
		stack.add(start);
		
		while(!stack.isEmpty()) {
			// 가장 마지막에 있는걸 하나 빼본다
			Integer top = stack.pop();
			System.out.println(top);
			// 방문 했던 지점은 넘긴다
			if(visited[top]) {
				continue;
			}
			//처음 방문이면 해야할일 하기
			visited[top]=true;
			path.add(top);
			
			// 갈때 까지 가보자.. - 이 정점을 통해서 갈 수 있는 다음 정점은?
			List<Integer> childs = graph[top];
			// 자식 중 가능한(아직 미방문인) 정점 방문
			for (int c = childs.size()-1; c >=0 ; c--) {
				Integer child = childs.get(c);	// 다음 정점
				if(!visited[child]) {		// 다음을 방문한 적이 없으면
					stack.push(child);		// 
				}
			}
		}
		System.out.println(path);
		
	}
	public static void DFS_2(int start) {
		// 처음 방문이면 해야할 일 하기
		visited1[start] =true;
		path1.add(start);
		
		List<Integer> childs = graph[start];
		// 자식 중 가능한(아직 미방문인) 정점 방문
		for (int c = 0; c <childs.size() ; c++) {
			Integer child = childs.get(c);	// 다음 정점
			if(!visited1[child]) {		// 다음을 방문한 적이 없으면
				DFS_2(child);		 
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		makeGraph();
		//DFS(1);
		DFS_2(1);
		System.out.println(path1);
	}
	

}
