package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15652_N과M4 {
	
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
		if(d == Count) {								// 깊이가 개수와 같으면 출력
			for (int i = 0; i < result.length; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
			return;
		}else {											// 아직 깊이만큼 차지 않앗다면
			for (int i = 0; i < Num; i++) {
				result[d] = i+1;									// 현재 숫자 입력
				if(stair(d)) {							// 증가하는수열만 재귀한다.
					permutation(d+1);					
				}	
			}
		}
		
	}
	
	public static boolean stair(int d) {			// 증가하는 수열인가?
		if(d==0) {
			return true;
		}
		if(result[d-1] <= result[d]) {
			return true;
		}
		return false;
	}
	
}
