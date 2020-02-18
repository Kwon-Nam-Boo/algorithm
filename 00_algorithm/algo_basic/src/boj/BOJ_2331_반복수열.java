package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2331_반복수열 {
	
	private static int N;
	private static int r;
	private static int result;
	private static int[] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		visited = new int[300000];
		
		dfs(N);
		result=0;
		for (int i = 0; i < visited.length; i++) {
			if(visited[i]==1) {
				result++;
			}
		}
		System.out.println(result);
		
	}
	public static void dfs(int n) {
		visited[n]++;
		if(visited[n] == 3) {
			return;
		}
		int sum =0;
		while(true) {
			sum+=Math.pow((N%10),r);
			if(N<10) {
				break;
			}
			N=N/10;
		}
		N=sum;
		dfs(N);
		
	}
}
