package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class SWEA_3752_D4_가능한_시험_점수 {
	
	private static int N, sum, count;
	private static int[] arr;
	private static boolean[] allNum;
	private static Set<Integer> set = new HashSet<>();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		for (int i = 1; i <= TC; i++) {
			sb.append("#").append(i).append(" ");
			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			st = new StringTokenizer(br.readLine());
			sum =0;
			for (int j = 0; j < N; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
				sum+=arr[j];
			}
			
			allNum = new boolean[sum+1];
			allNum[0] =true;
			for (int j = 0; j < arr.length; j++) {
				for (int k = sum; k >=0 ; k--) {
					if(allNum[k]) {
						allNum[k+arr[j]] = true;
					}
				}
			}
			count=0;
			for (int j = 0; j < allNum.length; j++) {
				if(allNum[j]) count++;
			}
			sb.append(count).append("\n");
		}
		System.out.println(sb);
		
	}

}
