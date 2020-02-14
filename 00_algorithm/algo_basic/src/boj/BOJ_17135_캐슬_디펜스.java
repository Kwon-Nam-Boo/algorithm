package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17135_캐슬_디펜스 {
	
	private static int N;
	private static int M;
	private static int D;
	private static int kill;
	private static int max;
	private static int[] result;
	private static int[][] map;
	private static int[][] map1;
	private static int archer =3;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());		// 행!
		M = Integer.parseInt(st.nextToken());		// 열!
		D = Integer.parseInt(st.nextToken());		// 화살 범위!
		map = new int[N][M];						// 맵!
		map1 = new int[N][M];						// 임시맵!
		result =new int[archer];					// 궁수 조합 위치!				
		kill =0;									// 죽인수 !
		
		for (int r = 0; r < N; r++) {							// 맵에 정보 저장
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		max = Integer.MIN_VALUE;					// 가장 많이 죽인 수!
		nCr(0,0);									// 조합!
		System.out.println(max);					// 정답
		
	}
	
	public static void nCr(int r, int k) {
		if(r == archer) {									// 일정한 조합 값이 있다면
			copy();											//우선 MAP을 카피한 MAP1을 부른다
			while(true) {
				for (int i = 0; i < result.length; i++) {	// 각각의 궁수가 특정값에 표적을 삼는다.
					shot(result[i]);
				}
				kill();										// 쏜다
				move();										// 병사가 이동한다.
				if(check()) {								// 모두 끝났는지 확인한다.
					max = Math.max(max, kill);
					kill = 0;
					break;
				}	
			}
			return;
		}
		for (int i = k; i < M; i++) {						// 조합 값 제조!
			result[r] = i;
			nCr(r+1,i+1);
		}
	}
	
	public static boolean isIn(int r, int c) {				// 배열 안에 있는가?
		return r >=0 && c >=0 && r < N && c < M;
	}
	
	public static void shot(int a) {
		for (int i = 1; i <= D; i++) {						// 최소 거리부터 확인
			int start = a-(i-1);					
			int end = a+(i-1);
			for (int j = start; j <= end; j++) {			// 해당 범위안에 타겟이 있는가?
				int k = N - i + Math.abs(a-j);
				if(!isIn(k,j)) continue;					// 범위 밖이면 컨틴뉴
					if(map1[k][j] >=1) {	
						map1[k][j] = 2;						// 있으면 지목
						return;
				}
			
			}
			
		}
		return;
	}
	public static void move() {								// 한칸씩 아래로 이동
		for (int r = N-2; r >= 0; r--) {
			for (int c = 0; c < M; c++) {
				map1[r+1][c] = map1[r][c];
			}
		
		}
		for (int c = 0; c < M; c++) {
			map1[0][c] = 0;
		}
		
	}
	public static boolean check() {							// 모든 배열이 비었는지 확인
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if(map1[r][c] == 1) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static boolean kill() {							// 2인 타겟을 죽이고 카운트
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if(map1[r][c] == 2) {
					map1[r][c] = 0;
					kill++;
				}
			}
		}
		return true;
	}
	
	public static void copy() {								// 배열 복사
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				map1[r][c] = map[r][c];
			}
		}
	}
	

}
