package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1182_부분수열의합 {
	
	private static int N,S ,cnt;
	private static int[] arr;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		cnt =0;
		dfs(0,0);
		// 예외가 존재한다 S가 0인경우 공집합인 경우가 생겨 -1이 필요
		System.out.println(S == 0  ? cnt-1:cnt);
	}

	private static void dfs(int v, int d) {
		if(d == N) {
			if(v == S) cnt++;
			return;
		}
		v+=arr[d];
		dfs(v,d+1);
		v-=arr[d];
		dfs(v,d+1);
		
	}

}
