package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2805_나무자르기 {

	private static StringBuilder sb = new StringBuilder();
	
	private static int N;
	private static long M;
	private static long[] tree;
	private static long max, min ,middle, ans;
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Long.parseLong(st.nextToken());
		tree = new long[N];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < tree.length; i++) {
			tree[i] = Long.parseLong(st.nextToken());
			max = Math.max(max, tree[i]);
		}
		
		min = 0;
		ans = 0;
		
		while(min <= max) {
			middle = (max + min)/2;
			
			// 조건 만족하면
			if(cut(middle)) {
				min = middle +1;
				ans = Math.max(ans, middle);
			}else {
				max = middle-1;
			}
			
		}
		System.out.println(ans);
	}


	private static boolean cut(long middle) {
		long cnt = 0;
		for (int i = 0; i < tree.length; i++) {
			if(tree[i] <= middle) {
				continue;
			}else {
				cnt+=tree[i] - middle;
			}
		}
		if(cnt>=M) return true;
		else return false;
	}	
}
