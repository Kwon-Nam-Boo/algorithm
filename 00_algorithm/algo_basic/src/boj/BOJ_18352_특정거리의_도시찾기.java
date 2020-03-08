package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_18352_특정거리의_도시찾기 {
	
	private static int N;
	private static int M;
	private static int K;
	private static int X;
	private static boolean[] visited;
	//private static int[][] graph;
	private static List<Integer>[] graph;
	private static Queue<Integer> queue = new LinkedList<>();	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N+1];
		
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
		}
		
		visited = new boolean[N+1];
		queue.offer(X);
		visited[X] =true;
		for (int i = 0; i < K; i++) {
			bfs();
		}
		if(queue.isEmpty()) {
			System.out.println(-1);
		}else {
			int[] tmp = new int[queue.size()];
			int i =0;
			while(!queue.isEmpty()) {
				tmp[i] =queue.poll();
				i++;
			}
			Arrays.sort(tmp);
			for (int j = 0; j < tmp.length; j++) {
				System.out.println(tmp[j]);
			}
		}
	}
	
	public static void bfs() {
		int size = queue.size();
		
		while(size>0) {
			int tmp = queue.poll();
			List<Integer> childs = graph[tmp];
			for (int i = 0; i < childs.size(); i++) {
				int child = childs.get(i);
				if(!visited[child]) {
					queue.offer(child);
					visited[child] =true;
				}
			}
			size--;
		}
		
	}
	

}
