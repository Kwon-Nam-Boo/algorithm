package samsungTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BO_13458_시험감독 {
	
	private static int N,B,C;
	private static int[] A;
	
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		long ans = N;
		for (int i = 0; i < N; i++) {
			int cnt = (A[i]-B)/C;
			if(cnt < 0) continue;
			if((A[i]-B)%C >0) cnt++;
			ans+=cnt;
		}
		System.out.println(ans);
	}

}
