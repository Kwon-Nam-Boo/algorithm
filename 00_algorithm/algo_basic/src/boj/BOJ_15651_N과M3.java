package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15651_N과M3 {
	
	private static int Num;
	private static int Count;
	private static int[] result;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Num = Integer.parseInt(st.nextToken());
		Count = Integer.parseInt(st.nextToken());
		result = new int[Count];
		permutation(0);
		System.out.println(sb);

	}
	public static void permutation(int d) {
		if(d == Count) {
			for (int i = 0; i < result.length; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
			return;
		}else {
			for (int i = 1; i <= Num; i++) {
				result[d] = i;
				permutation(d+1);
			}
			
		}
	}

}
