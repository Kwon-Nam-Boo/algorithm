package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SWEA_4408_D4_자기방으로_돌아가기 {
	
	private static int[] result;
	
	public static void main(String[] args) throws IOException{
		
		Scanner sc = new Scanner(System.in);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i <= TC; i++) {
			sb.append("#").append(i).append(" ");
			
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			
			result = new int[200];
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				int a = (Integer.parseInt(st.nextToken()) -1) /2;
				int b = (Integer.parseInt(st.nextToken()) -1) /2;
				if (a > b) {
                    int temp = a;
                    a = b;
                    b = temp;
                }
				for (int k = a; k <= b; k++) {
					result[k]++;
				}
			}
			int max = Integer.MIN_VALUE;
			for (int j = 0; j < result.length; j++) {
				max = Math.max(max, result[j]);
			}
			sb.append(max).append("\n");
	
		}
		System.out.println(sb);
	}

}
