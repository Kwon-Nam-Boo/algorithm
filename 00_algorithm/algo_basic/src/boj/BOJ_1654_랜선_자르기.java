package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1654_랜선_자르기 {

	private static StringBuilder sb = new StringBuilder();
	private static long[] num;
	private static long max;
	private static long min;
	private static long middle;
	private static int N;
	private static long K;
	private static long ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Long.parseLong(st.nextToken());
		num = new long[N];
		
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(br.readLine());
			max = Math.max(num[i], max);
		}
		
		min = 1;
		
		while(min<=max) {
			middle = (max + min) / 2;
			if(cut(middle)) {
				ans = Math.max(ans, middle);
				min = middle+1;
			}else {
				max = middle-1;
			}
		}
		System.out.println(ans);
	}

	private static boolean cut(long middle) {
		int count =0;
		for (int i = 0; i < num.length; i++) {
			count+=num[i]/middle;
		}
		return count >= K ? true: false;
		
	}
	
}
