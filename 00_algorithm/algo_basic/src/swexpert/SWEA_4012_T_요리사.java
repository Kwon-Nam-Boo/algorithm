package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_4012_T_요리사 {
	
	private static int N;
	private static int sum;
	private static int[] result;
	private static int[] result_plus;
	private static int min;
	private static List<Integer> score;
	private static int[][] food;
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <= TC; t++) {
			sb.append("#").append(t).append(" ");
			N = Integer.parseInt(br.readLine());
			food = new int[N][N];
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					food[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			result = new int[N/2];
			result_plus = new int[2];
			score = new ArrayList<>();
			sum = 0;
			nCr(0,0);
			
			min = Integer.MAX_VALUE;
			for (int a = 0, b = score.size()-1; a < b; a++,b--) {
				int similar = Math.abs(score.get(a)- score.get(b));
				min= Math.min(min, similar);
			}
			sb.append(min).append("\n");
		}
		System.out.println(sb);
	}
	
	public static void nCr(int r, int k) {
		if(r == N/2) {
			nCr_plus(0,0);
			score.add(sum);
			sum=0;
			return;
		}
		for (int i = k; i < N; i++) {
			result[r] = i;
			nCr(r+1,i+1);
		}
	}
	public static void nCr_plus(int r, int k) {
		if(r == 2) {
			sum += food[result_plus[0]][result_plus[1]]+food[result_plus[1]][result_plus[0]];
			return;
		}
		for (int i = k; i < result.length; i++) {
			result_plus[r] = result[i];
			nCr_plus(r+1,i+1);
		}
	}
}
