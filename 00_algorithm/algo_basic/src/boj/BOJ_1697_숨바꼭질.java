package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1697_숨바꼭질 {
	
	private static int start;
	private static int end;
	private static int[] visited= new int[100001];

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		bfs(start);
		
		System.out.println(visited[end]-1);
	}
	public static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		visited[start]=1;
		
		while(!queue.isEmpty()) {
			int tmp = queue.poll();
			if(tmp == end) {
				break;
			}
			for (int i = 0; i < 3; i++) {
				if(jump(i, tmp) >= 0 && jump(i, tmp) < 100001 && visited[jump(i, tmp)]==0) {
					queue.offer(jump(i, tmp));
					visited[jump(i,tmp)]=visited[tmp]+1;
				}
			}
			
		}
	}
	
	
	public static int jump(int i,int num) {
		switch(i) {
			case 0:
				return num-1;	
			case 1:
				return num+1;
			case 2:
				return num*2;		
		}
		return 0;
	}
	
}
