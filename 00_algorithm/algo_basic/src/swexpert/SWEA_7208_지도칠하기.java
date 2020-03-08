package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_7208_지도칠하기 {
	
	private static int N;
	private static int min;
	private static int[] color;
	private static int[] result;
	private static int[][] map;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= TC; i++) {
			sb.append("#").append(i).append(" ");
			N = Integer.parseInt(br.readLine());
			color = new int[N];
			map = new int[N][N];
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				color[j] = Integer.parseInt(st.nextToken());
			}
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			result = new int[N];
			min = Integer.MAX_VALUE;
			dfs(0);
			sb.append(min).append("\n");
		}
		System.out.println(sb);
	}
	public static void dfs(int d) {
		if(d == N) {
			boolean flag = true;
			for (int r = 0; r <N; r++) {						// 인접 체크
				for (int c= 0; c < N; c++) {
					if(map[r][c]==1 && result[r] == result[c]) {
						flag = false;
						break;
					}
				}
			}
			if(flag) {											// 바뀐 횟수가 최소 횟수면 저장
				min= Math.min(min, changeCount());
			}
			return;
		}
		for (int i = 1; i < 5; i++) {
			result[d] = i;
			dfs(d+1);
		}
	}
	
	public static int changeCount() {							// 원래의 색깔과 비교해 색깔이 바뀐 횟수 
		int count =0;
		for (int i = 0; i < color.length; i++) {
			if(color[i]!=result[i]) count++;
		}
		return count;
	}

}
