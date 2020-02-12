package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class testing {
	
	private static int N;
	private static int count;
	private static int result;
	private static boolean[] room;
	
	private static boolean[] onOff;
	private static boolean[] visited;

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= TC; i++) {
			N = Integer.parseInt(br.readLine());
			room = new boolean[N+1];
			onOff = new boolean[N+1];
			
			visited = new boolean[N+1];
			
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				int a =Integer.parseInt(st.nextToken());
				if(a==1) room[j] =true;
			}
			count =0;
			result =0;
			bfs(1);
			System.out.println(result);
		}
		
		
		
		
		
	}
	
	public static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		visited[start] =true;
		count++;
		if(check()) {
			result = count;
			return;
		}
		
		while(!queue.isEmpty()) {
			int x = queue.poll();
			button(x);
			for (int i = x+1; i <=N; i++) {
				queue.offer(i);
				count++;
			}
			
		}
	}
	
	public static void button(int n) {
		for (int i = 0; i < onOff.length; i++) {
			if((i+1)% (n+1) ==0) {
				onOff[i]=!onOff[i];
			}
		}
	}
	public static boolean check() {
		for (int i = 0; i < room.length; i++) {
			if(!room[i] == onOff[i]) {
				return false;
			}	
		}
		return true;
	}

}
