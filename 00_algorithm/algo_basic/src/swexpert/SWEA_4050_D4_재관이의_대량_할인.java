package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_4050_D4_재관이의_대량_할인 {

	private static int n;
	private static int[] closet;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= TC; t++) {
			sb.append("#").append(t).append(" ");
			n = Integer.parseInt(br.readLine());
			closet = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				closet[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(closet);
		
			int result =0;
			for (int i = n-1, j = 1; i >= 0; i--, j++) {
				if(j%3 !=0) {
					result+=closet[i];
				}
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb);

	}

}
