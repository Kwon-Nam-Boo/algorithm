package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10830_행렬제곱 {

	private static int N;
	private static long B;
	private static long[][] map;
	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		B = Long.parseLong(st.nextToken());
		
		map = new long[N][N];
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Long.parseLong(st.nextToken());
			}
		}
		
		long[][] ans = DQ(B);
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				sb.append(ans[r][c] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
	}

	private static long[][] DQ(long b) {
		long[][] dq = new long[N][N];
		long[][] tmp = new long[N][N];
		
		// 해당 자연수가 1000일 경우의 예외가 있다(극혐) 
		if(b == 1)
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					dq[r][c] = map[r][c]%1000;
				}	
			}
		// 짝수이면 반으로 나눠서 곱한다
		else if(b % 2 == 0) {
			tmp = DQ(b/2);
			
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					int cn = 0;
					for (int k = 0; k < N; k++) {
						cn+=tmp[r][k]*tmp[k][c];
					}
					dq[r][c] = cn%1000;
				}	
			}
		// 홀수 이면 n-1, 1로 나눠서 곱한다(n-1은 무조건 짝수이므로 위에서 해결해줌)
		}else {
			tmp = DQ(b-1);
			
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					int cn = 0;
					for (int k = 0; k < N; k++) {
						cn+=tmp[r][k]*map[k][c];
					}
					dq[r][c] = cn%1000;
				}	
			}
			
		}
		return dq;
	}

}
