package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2003_수들의합2 {

	private static StringBuilder sb = new StringBuilder();
	private static int N,M;	// N:수의 개수  M:원하는 수들의합
	private static int start,end, sum , cnt;	// 시작, 끝, 현재합 , 경우의수
	private static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N =Integer.parseInt(st.nextToken());
		M =Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		start =0;
		sum = arr[0];
		cnt = 0;
		
		if(sum == M) cnt++;			// 시작부터 M이면 일단 카운트 하나 하고 시작하자
		
		for (end = 1; end < N; end++) {		// s~e 가 기준보다 작으면 e를 앞으로 땡긴다, N의 범위 까지
			sum+=arr[end];			
			while(sum > M){
				sum-=arr[start];	//  s~e 가 기준보다 크면 s를 앞으로 땡긴다
				++start;
			}
			if(sum == M) cnt++;		// 해당 합이 나오면 cnt 증가
		}
		System.out.println(cnt);
	}
}
