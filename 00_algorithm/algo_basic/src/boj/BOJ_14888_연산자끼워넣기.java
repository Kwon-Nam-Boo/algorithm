package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14888_연산자끼워넣기 {
	
	private static int N;
	private static int max = Integer.MIN_VALUE;	
	private static int min = Integer.MAX_VALUE;	
	private static int arr[];
	private static int count[];

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		count = new int[4];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			count[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0,arr[0]);
		System.out.println(max);
		System.out.println(min);
	}
	public static void dfs(int r, int sum) {
		//base
		if(r == N-1) {
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			return;
		}
		
		//
		for (int i = 0; i < 4; i++) {
			if(count[i] >0) {
				count[i]--;
				dfs(r+1,Cal(i,sum,arr[r+1]));
				count[i]++;
			}
		}
		
	}
	
	public static int Cal(int cal,int a, int b) {
		switch(cal) {
			case 0:
				return a + b;
			case 1:
				return a - b;
			case 2:
				return a * b;
			case 3:
				return a / b;
		}
		return 0;
			
	}

}
