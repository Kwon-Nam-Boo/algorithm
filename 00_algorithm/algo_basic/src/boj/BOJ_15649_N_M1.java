package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15649_N_M1 {
	
	private static int N;
	private static int[] res;
	//private static boolean[] visited;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());		// 4
		int M = Integer.parseInt(st.nextToken());	// 2
		res = new int[M];
		//visited = new boolean[N];
		permutation(0);
		
	}
	public static void permutation(int r) {
		if(r == res.length) {
			System.out.println(Arrays.toString(res));
			return;
		}
		
		for (int i = 0; i < N; i++) {
			res[r] = i+1;
			permutation(r+1); 
			
		}
		
	}

}
