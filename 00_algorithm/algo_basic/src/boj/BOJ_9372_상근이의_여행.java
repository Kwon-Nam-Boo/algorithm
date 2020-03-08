package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9372_상근이의_여행 {
	
	private static int N;
	private static int M;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < TC; i++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			for (int j = 0; j < M; j++) {							// 입력 값받기. 그냥 쓰레기값이나 다름없음
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
			}
			sb.append(N-1).append("\n");							// ㅋㅋㅋㅋㅋ 이게 문제냐
		}
		System.out.println(sb);
		
	}

}
