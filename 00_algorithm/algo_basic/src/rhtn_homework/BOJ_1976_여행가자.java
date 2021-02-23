package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1976_여행가자 {
	
	private static int N,M;
	private static int[][] map;
	private static int[] ans;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		ans = new int[M];
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(r == c) map[r][c] = 1;
			}
		}
		// 플로이드 와샬
		for (int k = 0; k < N; k++) {
			for (int r = 0; r < N; r++) {
				if(k == r) continue;
				for (int c = 0; c < N; c++) {
					if(k ==c || r == c) continue;
					// 주의: 자기자신으로 가는경우를 여기서는 가능하다 그러므로 1로 바꿔준다 ..
					if(map[r][k] == 1 && map[k][c] == 1) map[r][c] =1;
				}
			}
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			ans[i] = Integer.parseInt(st.nextToken())-1;
		}
		String answer ="YES";
		for (int i = 0; i < M-1; i++) {
			if(map[ans[i]][ans[i+1]] != 1) {
				answer = "NO";
				break;
			}
		}
		System.out.println(answer);
	}

}
