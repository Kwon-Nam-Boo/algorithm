package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1253_좋다 {

	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		// 정렬
		Arrays.sort(arr);
		
		
		int ans = 0;
		for (int i = N-1; i >=0 ; i--) {
			
			int start = 0;
			int end = N-1;
			int sum = 0;
			
			while(start < end) {
				// 해당 위치는 구하고싶은곳이니 패스
				if(start == i) {
					start++; continue;
				}
				if(end == i) {
					end--; continue;
				}
				
				sum = arr[start] + arr[end];
				
				// 합이 작거나 크면 이분탐색 진행 답이면, 체크 
				if(sum > arr[i]) end--;
				else if(sum < arr[i]) start++;
				else if(sum == arr[i]) {
					ans++;	
					break;
				}
					
			}
		}
		System.out.println(ans);
	}
}
