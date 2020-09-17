package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2252_줄_세우기 {

	private static int N,M;
	private static int[] idxCnt;
	private static List<Integer>[] graph;
	private static int INF = -1;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N+1];
		idxCnt = new int[N+1];
		
		for (int i = 1; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			// 유향 그래프
			graph[start].add(end);
			idxCnt[end]++;
		}
		
		System.out.println(Arrays.toString(graph));
		System.out.println(Arrays.toString(idxCnt));
		
		Queue<Integer> queue = new LinkedList<>();
		
		for (int i = 1; i < idxCnt.length; i++) {
			if(idxCnt[i] == 0) {
				queue.offer(i);
			}
		}
		
		if(queue.size() == 0) {
			System.out.println("사이클 발생");
			return;
		}
		
		//Queue<Integer> ans = new LinkedList<>();
		int cnt =0;
		while(!queue.isEmpty()) {
			int tmp = queue.poll();
			for (int i = 0; i < graph[tmp].size(); i++) {
				int child = graph[tmp].get(i);
				idxCnt[child]--;
				if(idxCnt[child] == 0) {
					queue.offer(child);
				}
			}
			sb.append(tmp).append(" ");
			cnt++;
		}
		if(cnt==N) {
			System.out.println(sb);
		}else {
			return;
		}
		
	}

}
