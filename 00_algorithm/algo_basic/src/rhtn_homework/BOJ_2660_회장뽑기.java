package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2660_회장뽑기 {

	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int mv = Integer.MAX_VALUE;
		int[][] map = new int[51][51];
		
		// max_value로 채우고, i == j일때는 0으로 초기화
		for (int[] m : map) {
			Arrays.fill(m, mv);
		}
		for (int i = 0; i < 51; i++) {
			map[i][i] = 0;
		}
		
		int N = Integer.parseInt(br.readLine());
		
		// 인접그래프로 바꾸기
		while(true) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(a == -1 && b == -1) break;
			map[a][b] = 1;
			map[b][a] = 1;
		}

		// 플로이드 와샬
		for (int k = 1; k < map.length; k++) {			// 경유 정점
			for (int i = 1; i < map.length; i++) {		// 출발 정점
				if(k == i) continue;
				for (int j = 1; j < map.length; j++) {	// 도착정점
					if(k == j || i == j) continue;
					// 출발점에서 도착점 가는 가중치를 갱신한다
					if(map[i][k]!=mv  && map[k][j]!=mv  &&  map[i][j] > map[i][k] + map[k][j]) {
						map[i][j] = map[i][k] + map[k][j];
					}
				}
			}
		}	
		
		// 회장후보점수, 후보의 수
		int min = N-1;
		int cnt = 0;
		
		for (int i = 1; i < map.length; i++) {
			// 해당 행에서의 최대값
			int max = 0;
			for (int j = 1; j < map.length; j++) {
				if(i == j || map[i][j] == mv) continue;
				if(max < map[i][j]) {
					max = Math.max(max, map[i][j]); 
				}
			}
			if(max == 0) continue;
			// 행에서의 최대값이 min 보다 작다면 새로운 회장 후보
			if(min > max) {
				 // 싹지우고 새로운 후보를 맞이한다
				 min = max;
				 sb.delete(0, sb.length());
				 sb.append(i + " ");
				 cnt = 1;
			}else if(min == max) {	// 같은 점수라면 너도 회장후보야~
				cnt++;
				sb.append(i + " ");
			}
		}
		System.out.println(min + " " + cnt);
		System.out.println(sb);
		
	}
}
