package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_3631_줄세우기 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] a = new int[N];
		int[] LIS = new int[N]; // i번째 숫자를 마지막 글자로 사용할 경우의 최장 증가수열의 길이
		
		for (int i = 0; i < N; i++) {
			a[i] = Integer.parseInt(br.readLine());
		}
		
		for (int i = 0; i < N; i++) {
			LIS[i] = 1;	
			for (int j = 0; j < i; j++) { 
				if(a[j] < a[i] &&  LIS[j]+1> LIS[i]) {
					LIS[i] =LIS[j] +1;
				}
			}
		}
		int maxLISIndex = 0;
		for (int i = 0; i < LIS.length; i++) {
			if(LIS[maxLISIndex] < LIS[i]) {
				maxLISIndex = i;
			}
		} 
		System.out.println(N-LIS[maxLISIndex]);
	}

}
