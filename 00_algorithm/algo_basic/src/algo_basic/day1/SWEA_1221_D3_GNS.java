package algo_basic.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1221_D3_GNS {
	
	public static String[] number = {"ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"};
	public static ArrayList<String> num = new ArrayList<>(Arrays.asList(number));
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= TC; i++) {
			sb.append("#").append(i).append(" ");
			st = new StringTokenizer(br.readLine());
			
			String N  = st.nextToken();
			int M = Integer.parseInt(st.nextToken());
			
			int[] arr = new int[M];
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				String tmp = st.nextToken();
				arr[j] = num.indexOf(tmp);
			}
			
			Arrays.sort(arr);
			
			for (int j = 0; j < M; j++) {
				sb.append(num.get(arr[j])).append(" ");
			}
			sb.append("\n");	
		}
		System.out.println(sb);
		
	}

}
