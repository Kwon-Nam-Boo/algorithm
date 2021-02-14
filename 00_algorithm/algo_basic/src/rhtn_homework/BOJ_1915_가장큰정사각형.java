package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1915_가장큰정사각형 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] DP = new int[N][M];
		int ans = 0;
		
		for (int i = 0; i < N; i++) {
			char[] line = br.readLine().toCharArray();
			for (int j = 0; j < line.length; j++) {
				// 만약 i가 0 이면(첫줄) j가 0이면 (맨 왼쪽), DP랑 같다
				if(i == 0 || j ==0) {
					DP[i][j] = line[j] - '0';
					ans = Math.max(ans, DP[i][j]);
					continue;
				}
				if(line[j] == '1') {
					int min = 0;
					min = Math.min(DP[i-1][j], DP[i][j-1]);
					min = Math.min(DP[i-1][j-1], min);
					DP[i][j] = min +1;
					ans = Math.max(ans, DP[i][j]);
				}
			}
		}
		System.out.println(ans*ans);
	}

}
