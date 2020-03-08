package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2817_D3_부분_수열의_합 {
	
	private static int N;
	private static int[] nums;
	private static int sum;
	private static int result;
	private static int count;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());
		for (int i = 1; i <= TC; i++) {
			sb.append("#").append(i).append(" ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			result = Integer.parseInt(st.nextToken());
			nums =new int[N];
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				nums[j] = Integer.parseInt(st.nextToken());
			}
			count=0;
			subset();
			sb.append(count).append("\n");
		}
		System.out.println(sb);
	}
	
	public static void subset(){
		for (int i = 0; i < (1<<N); i++) {
			sum=0;
			for (int j = 0; j < N; j++) {
				if((i & (1<< j))>0){
					sum+=nums[j];
					if(sum>result) break;
				}
			}
			if(sum == result) {
				count++;
			}
		}
	}
	

}
