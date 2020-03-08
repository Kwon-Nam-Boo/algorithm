package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7562_나이트의이동 {
	
	private static int N;
	private static int count;
	private static int[][] dir = {{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1}};
	private static boolean[][] visited;
	private static Pair start;
	private static Pair end;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int i = 0; i < TC; i++) {			N = Integer.parseInt(br.readLine());
			visited = new boolean[N][N];
			st = new StringTokenizer(br.readLine());
			start = new Pair(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),0);
			st = new StringTokenizer(br.readLine());
			end= new Pair(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),0);
			
			count = 0;
			bfs(start);
			sb.append(count).append("\n");
		}
		System.out.println(sb);
	}
	public static void bfs(Pair start) {
		Queue<Pair> queue = new LinkedList<>();
		queue.offer(start);
		visited[start.x][start.y] = true;
		while(!queue.isEmpty()) {
			Pair tmp = queue.poll();
			if(tmp.x == end.x && tmp.y == end.y) {
				count = tmp.c;
				return;
			}
			for (int i = 0; i < dir.length; i++) {
				int a = tmp.x + dir[i][0];
				int b = tmp.y + dir[i][1];
				if(a>=0 && b>=0 && a<N && b<N && !visited[a][b]) {
					int c = tmp.c+1;
					queue.offer(new Pair(a,b,c));
					visited[a][b] =true;
					
				}
			}
		}
	}
	public static class Pair{
		int x;
		int y;
		int c;
		public Pair(int x, int y, int c) {
			this.x = x;
			this.y = y;
			this.c = c;
		}
	}

}
