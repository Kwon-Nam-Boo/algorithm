package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5642_D3_합 {
	
	private static int N;
	private static int sum;
	private static int[] arr;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <=TC; i++) {
			sb.append("#").append(i).append(" ");
			N= Integer.parseInt(br.readLine());
			arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			sum=Integer.MIN_VALUE;
			findResult();
			sb.append(sum).append("\n");
		}
		System.out.println(sb);
	}
	
	public static void findResult() {
		int s=0;
		for (int i = 0; i < N; i++) {
			s+=arr[i];
			sum = Math.max(sum, s);
			
			if(s<0) {
				s = 0;
			}
		}
	}
}
