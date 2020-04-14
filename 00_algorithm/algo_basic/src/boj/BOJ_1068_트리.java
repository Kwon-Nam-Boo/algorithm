package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class BOJ_1068_트리 {

	private static int N;
	private static int D;
	private static int count;
	private static int start;
	private static List<Integer>[] graph;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N =Integer.parseInt(br.readLine());
		graph = new ArrayList[N];
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < graph.length; i++) {
			int a = Integer.parseInt(st.nextToken());
			if(a == -1) {
				start =i;
				continue;
			}
			graph[a].add(i);						// 단방향이고
		}
		
		D = Integer.parseInt(br.readLine());
	
		for (int i = 0; i < graph.length; i++) {
			graph[i].remove((Integer) D);			// 제거해야할 부분을 그래프에서 지워준다.
		}
		
		dfs(start);
		
		System.out.println(count);
	}
	public static void dfs(int r) {
		if(r == D) {								// 해당 지역에서는 뒤돌아가기
			return;
		}	
		if(graph[r].isEmpty()) {		
			count++;
			return;
		}
		for (int i = 0; i < graph[r].size(); i++) {
			int a = graph[r].get(i);
			dfs(a);
		}
	}
}
