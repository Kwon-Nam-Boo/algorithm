package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14438_수열과쿼리17 {
	
	private static int N, M ,S;
	private static int[] tree;
	private static final int MAX = 1000000000;
	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		S = 1;
		while(S < N)
			S <<=1;
		tree = new int[2*S];
		
		st = new StringTokenizer(br.readLine());
		for (int i = S; i < 2*S; i++) {
			if(i >= S +N) {
				tree[i] = MAX;
			}else {
				tree[i] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = S-1; i > 0; i--) {
			tree[i] = Math.min(tree[2*i], tree[2*i+1]);
		}
		M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int comm = Integer.parseInt(st.nextToken());
			int m1 = Integer.parseInt(st.nextToken());
			int m2 = Integer.parseInt(st.nextToken());
			
			// 1이면 업데이트, 2는 최소값 찾기
			if(comm == 1)
				updateTree(m1-1,m2);
			else
				findTree(m1-1,m2-1);
		}
		System.out.println(sb);
		
	}

	private static void findTree(int m1, int m2) {
		int f = m1 + S;
		int e = m2 + S;
		int min = tree[f];
		
		while(f<=e) {
			if(f%2 == 1) {
				min = Math.min(min, tree[f++]);
			}
			if(e%2 == 0) {
				min = Math.min(min, tree[e--]);
			}
			f/=2;
			e/=2;
		}
		sb.append(min +"\n");
	}

	private static void updateTree(int m1, int m2) {
		int idx = m1 + S;
		tree[idx] = m2;
		
		idx/=2;
		while(idx>0) {
			tree[idx] = Math.min(tree[2*idx], tree[2*idx+1]);
			idx/=2;
		}
		
	}
}
