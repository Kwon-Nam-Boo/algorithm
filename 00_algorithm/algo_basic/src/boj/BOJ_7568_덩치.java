package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_7568_덩치 {

	private static int N;
	private static Pair[] arr;
	private static int[] result;
	private static int[] ranking;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		arr = new Pair[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int W = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());
			arr[i] = new Pair(W,H);
		}
		result = new int[2];
		ranking = new int[N];
		Arrays.fill(ranking, 1);
		nCr(0,0);
		for (int i = 0; i < ranking.length; i++) {
			sb.append(ranking[i]).append(" ");
		}
		System.out.println(sb);
	}
	public static void nCr(int r, int k) {
		if(r == 2) {
			int a = result[0];
			int b = result[1];
			if(arr[a].w >arr[b].w && arr[a].h >arr[b].h) {
				ranking[b]++;
			}else if(arr[a].w <arr[b].w && arr[a].h <arr[b].h) {
				ranking[a]++;
			}
			return;
		}
		
		for (int i = k; i < N; i++) {
			result[r] = i;
			nCr(r+1,i+1);
		}
	}
	
	public static class Pair{
		int w;
		int h;
		public Pair(int w, int h) {
			this.w = w;
			this.h = h;
		}
	}
}
