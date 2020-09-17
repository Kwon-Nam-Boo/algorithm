package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2839_설탕배달 {

	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] sugar= {3,5};
		
		int[] DP = new int[N+1];
		int MAX = Integer.MAX_VALUE;
		// 최대값(INT)으로 가득채워
		Arrays.fill(DP, MAX);
		// 시작은 0
		DP[0] = 0;
		// 하위 DP를 기반으로 상위 DP를 구성
		for (int i = 3; i < DP.length; i++) {
			for (int j = 0; j < sugar.length; j++) {
				// i개보다 설탕주머니가 크면 패스
				if(i - sugar[j] <0) continue;
				// 해당 크기의 설탕주머니를 추가하기전의 값이  최대값(INT)라면 ...? 만들수 없는값
				if(DP[i - sugar[j]] == MAX) continue;
				// 현재 값과, 이전값에 해당 주머니 만큼 더해준 값을 비교 
				DP[i] = Math.min(DP[i], DP[i - sugar[j]]+1);
			}
		}
		System.out.println(DP[N] == MAX  ? -1: DP[N]);
	}
}
