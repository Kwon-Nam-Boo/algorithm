package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_2002_추월 {

	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		HashMap<String, Integer> map = new HashMap<>();
		
		for (int i = 0; i < N; i++) {
			map.put(br.readLine(), i);
		}
		//System.out.println(map);
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = map.get(br.readLine());
		}
		System.out.println(Arrays.toString(arr));
		
		int ans=0;
		for (int i = 0; i < N; i++) {
			for (int j = i+1; j < N; j++) {
				// 현재 숫자가 뒤에있는 숫자보다 크다면 새치기를 무조건 한거다
				if(arr[i] > arr[j]) {
					ans++;
					 break;
				}
			}
		}
		
		
		System.out.println(ans);
	}
}
