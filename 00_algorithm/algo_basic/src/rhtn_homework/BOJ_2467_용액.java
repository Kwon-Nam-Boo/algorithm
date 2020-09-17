package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2467_용액 {

	private static StringBuilder sb = new StringBuilder();
	private static int N ,start,end;
	private static int[] arr;
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		start = 0;
		end = N-1;
		int ansX = 0;
		int ansY = N-1;
		
		
		int small = Math.abs(arr[0] + arr[N-1]);
		
		while(start < end) {
			if(arr[start] + arr[end] == 0) {
				ansX = start;
				ansY = end;
				break;
			}
			
			if(Math.abs(arr[start] + arr[end])< small) {
				small = Math.abs(arr[start] + arr[end]);
				ansX = start;
				ansY = end;
			}
			
			if(arr[start] + arr[end] > 0) {
				--end;
			}else {
				++start;
			}
			
		}
		System.out.println(arr[ansX] + " " + arr[ansY]);
		
	}
}
