package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2470_두_용액 {

	private static StringBuilder sb = new StringBuilder();
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		// 1. 우선 정렬
		Arrays.sort(arr);
		
		// 0에 가장 수렵한 값 찾기 
		int min = Math.abs(arr[0] + arr[arr.length-1]);
		
		// 0에 가장 수렴한 두 수(왼쪽 , 오른쪽
		int ansX = arr[0];
		int ansY = arr[arr.length-1];
		
		// 2. 두수를 찾는다
		for (int i = 0, j = arr.length-1 ; i < j;) {
			// 두수의 합
			int sum = arr[i] + arr[j];
			// 0에 가까운 값이 갱신되면 답도 갱신
			if(min > Math.abs(sum)) {
				ansX = arr[i];
				ansY = arr[j];
				min = Math.abs(sum);
			}
			// 두수의 합이 0 보다 크다면 ? 0 에 가까워지기위해 왼쪽으로, 반대의 경우는 왼쪽으로
			if(sum < 0) i++;
			if(sum > 0) j--;
			
			// 0이면 답이므로 그냥 끝냄 
			if(sum == 0) {
				ansX = arr[i];
				ansY = arr[j];
				break;
			}
		}
		System.out.println(ansX + " " + ansY);
	}
}
