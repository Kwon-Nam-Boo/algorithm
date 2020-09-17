package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_5052_전화번호_목록_2 {

	private static StringBuilder sb = new StringBuilder();
	private static int N;	// N:전화번호 목록수		idx:인덱스 	maxL:전화번호 최대길이	visitCnt:체크된수
	private static boolean ans; // ans:답
	private static String[] arr;	// 전화번호 목록

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < TC; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new String[N];
			
			for (int i = 0; i < N; i++) {
				arr[i] = br.readLine();
			}
			
			Arrays.sort(arr);
			ans =true;
			
			for (int i = 1; i < N; i++) {
				if(arr[i-1].length()>= arr[i].length()) continue;
				if(arr[i-1].equals(arr[i].subSequence(0, arr[i-1].length()))) {
					ans = false;
					 break;
				}
				
			}
			
			if(ans) sb.append("YES\n");
			else sb.append("NO\n");
			
		}
		System.out.println(sb);
		
	}
}
