package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1275_커피숍2 {
	
	private static int N, Q ,S;
	private static long[] tree;
	private static StringBuilder sb = new StringBuilder();
	

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		S = 1;
		while(S<N)
			S <<= 1;
		tree = new long[2*S];
		
		st = new StringTokenizer(br.readLine());
		
		// 초기화 과정
		for (int i = S; i < S+N; i++) {
			tree[i] = Long.parseLong(st.nextToken());
		}
		
		for (int i = S-1; i > 0 ; i--) {
			tree[i] = tree[2*i] + tree[2*i+1];
		}
		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			int idx = Integer.parseInt(st.nextToken())-1;
			Long ch = Long.parseLong(st.nextToken());
			
			
			if(from > to) {
				int tmp = from;
				from = to;
				to = tmp;
			}
			findSum(from ,to);
			updateTree(idx, ch);
		}
		System.out.println(sb);
	}

	private static void updateTree(int idx, Long ch) {
		int i = idx + S;

		tree[i] = ch;
		i/=2;
		while(i>0) {
			tree[i] = tree[2*i] + tree[2*i+1];
			i/=2;
		}
	}

	private static void findSum(int from, int to) {
		int f = from + S;
		int t = to + S;
		long sum =0;
		
		while(f<=t) {
			// 앞에 값이 짝수라면 떨어져있는수일 것이다.
			if(f%2 == 1) {
				sum += tree[f++];
			}
			if(t%2 == 0) {
				sum += tree[t--];
			}
			f/=2;
			t/=2;
		}
		sb.append(sum +"\n");
	}

}
