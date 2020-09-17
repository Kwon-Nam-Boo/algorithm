package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1337_올바른_배열 {

	private static StringBuilder sb = new StringBuilder();
	private static int N;
	
	private static long[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new long[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		Arrays.sort(arr);
		int start = 0;
		int cnt = 4;
		int ans = 4;	// 정답의 초기값 0일 경우 5니깐 
		for (int end = 1; end < N; end++) {
			--cnt;
			// 현재위치부터 올바른 정렬에 포함된 숫자가 아니라면 ..? start를 증가시키면서 옮겨준다
			while(arr[end] - arr[start] > 4 ) {
				++start;
				++cnt;
			}
			if(cnt == 0) {
				ans = 0;
				break;
			}
			ans = Math.min(ans, cnt);
			
		}
		
		System.out.println(ans);
	}
}
