package rhtn_homework;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;


public class BOJ_2517_달리기 {
	
	private static Pair[] person;
	private static int S;
	private static int[] tree;
	private static int[] ans;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		
		person  = new Pair[N];
		for (int i = 0; i < N; i++) {
			person[i] = new Pair(i,Integer.parseInt(br.readLine()));
		}
		Arrays.sort(person);

		S =1;
		while(S<N)
			S<<=1;

		tree = new int[2*S];
		
		ans = new int[N];
		for (int i = 0; i < N; i++) {
			update(person[i].idx);
			sum(0,person[i].idx);
		}
		for (int i = 0; i < N; i++) {
			bw.append(ans[i] + "\n");
		}
		bw.flush();
		bw.close();
	}
	
	// 부분합을 구한다
	private static void sum(int s, int e) {
		int start = s + S;
		int end = e + S;
		
		int sum =0;
		
		while(start<=end) {
			// 홀수면 따로 있는 경우다
			if(start%2 == 1) {
				sum+=tree[start];
				start++;
			}
			if(end%2== 0) {
				sum+=tree[end];
				end--;
			}
			start/=2;
			end/=2;
		}
		ans[e] = sum;
		
	}

	// bottom-up 하면서 업데이트
	private static void update(int idx) {
		int stand = idx + S;
		tree[stand] = 1;
		stand/=2;
		while(stand>0) {
			tree[stand] = tree[stand*2] + tree[stand*2 +1];
			stand/=2;
		}
	}


	public static class Pair implements Comparable<Pair>{
		int idx, fast;

		public Pair(int idx, int fast) {
			super();
			this.idx = idx;
			this.fast = fast;
		}
		
		@Override
		public String toString() {
			return "Pair [idx=" + idx + ", fast=" + fast + "]";
		}

		@Override
		public int compareTo(Pair o) {
			Integer f1 = this.fast;
			Integer f2 = o.fast;
			
			return f2.compareTo(f1);
		}
		
		
	}
}
