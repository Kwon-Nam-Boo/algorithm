package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14501_퇴사 {
	
	private static int N;
	private static int max = Integer.MIN_VALUE;
	private static int[] T;
	private static int[] P;
	private static boolean[] visited;
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		T = new int[N+1];
		P = new int[N+1];
		visited = new boolean[N];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		//System.out.println(Arrays.toString(T));
		//System.out.println(Arrays.toString(P));
		
		bfs(new Pair(1,0));
		System.out.println(max);
	}
	public static void bfs(Pair p) {
		Queue<Pair> queue = new LinkedList<>();
		queue.offer(p);
		
		while(!queue.isEmpty()) {
			Pair tmp = queue.poll();
			//System.out.println(tmp.price);
			max = Math.max(max, tmp.price);
			for (int i = tmp.r; i < P.length; i++) {
				int currentR = i + (T[i]-1); 
				int currentPrice = tmp.price + P[i];
				//System.out.println("R"+currentR);
				//System.out.println("P"+currentPrice);
				if(currentR > N) continue;
				queue.offer(new Pair(currentR+1, currentPrice));
			}
		}
		
	}
	public static class Pair{
		int r;
		int price;
		
		public Pair(int r, int price) {
			this.r = r;
			this.price = price;
		}
		
		
	}
	
}
