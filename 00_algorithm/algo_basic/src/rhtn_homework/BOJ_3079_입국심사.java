package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_3079_입국심사{
	
	private static int N,M;
	private static long[] arr;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new long[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		Arrays.sort(arr);
		
		long start = 0;
		long end = M *arr[N-1];
		long ans = end;
		
		while(start<=end) {
			long mid = (start + end)/2;
			long sum = 0;
			
			for (int i = 0; i < arr.length; i++) {
				sum+=(mid / arr[i]);
				// 할당양을 채웠으면 여기까지
				if(sum >= M) break;
			}
			// 해당 시간으로는 할당양을 채우지 못했다면? 시간을 늘린다
			if(sum < M) {
				start = mid+1;
			}else {
				end = mid-1;
				ans = Math.min(ans, mid);
			}
		}
		System.out.println(ans);
	}

}
