package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_7453_합이0인네정수 {
	
	private static long[] A,B,C,D;
	private static long[] AB, CD;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		A = new long[N];
		B = new long[N];
		C = new long[N];
		D = new long[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			A[i] = Long.parseLong(st.nextToken());
			B[i] = Long.parseLong(st.nextToken());
			C[i] = Long.parseLong(st.nextToken());
			D[i] = Long.parseLong(st.nextToken());
		}
		
		AB = new long[N*N];
		CD = new long[N*N];
		
		// 1. 우선 AB, BC까지는 map으로
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				AB[i*N + j]=A[i]+B[j];
				CD[i*N + j]=C[i]+D[j];
			}
		}
		
		// 2. 정렬
		Arrays.sort(AB);
		Arrays.sort(CD);
		
		// 3. upper - lower
		long ans = 0;
		for (int i = 0; i < N*N; i++) {
			long stand = -AB[i];
			ans+=(upper_Bound(CD, stand)-lower_Bound(CD, stand));
			
		}
		System.out.println(ans);
	}

	private static int lower_Bound(long[] arr, long stand) {
		
		int start = 0;
		int end = arr.length;
		
		while(start<end) {
			int mid = (start + end)/2;
			
			if(stand <= arr[mid]) {
				end = mid;
			}else {
				start = mid+1;
			}
		}
		return start;
	}
	
	private static int upper_Bound(long[] arr, long stand) {
		
		int start = 0;
		int end = arr.length;
		
		while(start<end) {
			int mid = (start + end)/2;
			
			if(stand < arr[mid]) {
				end = mid;
			}else {
				start = mid+1;
			}
		}
		return start;
	}

}
