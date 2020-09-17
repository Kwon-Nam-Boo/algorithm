package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_5052_전화번호목록 {

	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= t; i++) {
			int N = Integer.parseInt(br.readLine());
			
			String[] arr = new String[N];
			
			for (int j = 0; j < N; j++) {
				arr[j] = br.readLine();
			}
			// 알파벳순 
			Arrays.sort(arr);
			boolean ans = true;
			for (int j = 1; j < N; j++) {
				// 앞에가 길이가 길면 이미 전화가 안걸림
				if(arr[j-1].length()>arr[j].length()) continue;
				if(arr[j-1] .equals(arr[j].substring(0, arr[j-1].length()))) {
					ans = false;
					break;
				}
			}
			sb.append(ans == true ? "YES" : "NO").append("\n");
			
		}
		System.out.println(sb);
	}
}
