package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11404_플로이드 {

	private static StringBuilder sb = new StringBuilder();
	private static int N,M;				// N:도시	 M:버스
	private static int INF = Integer.MAX_VALUE;		//INF
	
	private static int[][] D;			// 거리를 저장한 테이블(인접행렬)
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		
		N =Integer.parseInt(br.readLine());
		M =Integer.parseInt(br.readLine());
		D = new int[N+1][N+1];
		
		// INF로 초기화
		for (int[] d : D) {
			Arrays.fill(d, INF);
		}
		//	r == c면 0
		for (int i = 1; i <= N; i++) {
			D[i][i] = 0;
		}
		
		// 인접 행렬로 데이터 저장
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r =Integer.parseInt(st.nextToken());
			int c =Integer.parseInt(st.nextToken());
			int w =Integer.parseInt(st.nextToken());
			
			D[r][c] = Math.min(D[r][c], w);
		}
		
		
		// 경유 지점
		for (int k = 1; k <= N; k++) {
			// 출발지점
			for (int r = 1; r <= N; r++) {		
				if(k == r) continue;					//출발 지점과 경유지점이 같다면 무시	
				// 도착 지점	
				for (int c = 1; c <=N; c++) {	
					if(k == c || r ==c) continue;		// 경유 ==도착  or 출발 == 도착 이면 무시
					if(D[r][k]!=INF && D[k][c]!=INF && D[r][c] > D[r][k] + D[k][c])		// 경유해서 간 것이 더 짧다면 바꿔준다
						D[r][c] = D[r][k] + D[k][c];
				}
			}
		}
		
		for (int r = 1; r <=N ; r++) {
			for (int c = 1; c <= N; c++) {
				if(D[r][c] == INF) {
					sb.append(0 +" ");
				}else {
					sb.append(D[r][c]+" ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
	}
	

}
