package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2042_구간합구하기 {

	private static int N,M,K, stand;
	private static long[] tree;
	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		// 1. tree를 초기화해서 루트 값들을 넣어주자
		stand = 1; 
		while(stand < N)
			stand <<= 1;
		tree = new long[2*stand+1]; 
		
		for (int i = 1 ; i <=N; i++){
			tree[i+stand] = Integer.parseInt(br.readLine());
		}
		
		for (int i = stand-1; i > 0 ; i--) {
			tree[i] = tree[i * 2] + tree[i * 2 + 1];
		}
		//System.out.println(Arrays.toString(tree));
		// 2. sum과 update를 실행 한다.
		for (int i = 0; i < M + K ; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			
			if(a == 1) {
				update(b,c);
			}else {
				sum(b,( int)c);
			}
		}
		System.out.println(sb);
	}

	private static void sum(int start, int end) {
		int s = start+stand;
		int e = end+ stand;
		long sum =0;
		
		while(s <= e) {
			// 시작점이  홀수라면 떨어져나온 값이다
			if(s%2 == 1) {
				sum+=tree[s];
				s++;
			}
			// 끝점이 짝수라면 떨어져나온 값이다
			if(e%2 == 0) {
				sum+=tree[e];
				e--;
			}
			s/=2;
			e/=2;
		}
		sb.append(sum + "\n");
	}

	private static void update(int b, long c) {
		int idx = b + stand;
		tree[idx] = c;
		idx /= 2;
		 // 루트까지 데이터 업데이트 
        while(idx > 0) {
            tree[idx] = tree[idx * 2] + tree[idx * 2 + 1];
            idx /= 2;
        }
	}

}
