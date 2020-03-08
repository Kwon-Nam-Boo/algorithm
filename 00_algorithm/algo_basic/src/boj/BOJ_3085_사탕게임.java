package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_3085_사탕게임 {

	private static int N;
	private static String[][] map;
	private static int[][] dir = {{1,0}, {0,1}};					// 0,0에서 내려가면서 하게되면 위,왼쪽은 어차피 중복되므로 확인 할 필요 x 
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		N = Integer.parseInt(br.readLine());
		map = new String[N][N];
		
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().split("");
		}
		
		int max = check();											// 아무것도 스왑안한 상태가 우선 최대값이겟지?
	
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				for (int i = 0; i < dir.length; i++) {
					int a = r + dir[i][0];
					int b = c + dir[i][1];
					if(isIn(a,b) && !map[r][c].equals(map[a][b])) {
						swap(new Pair(r,c), new Pair(a,b));			// 스왑해서
						max = Math.max(max, check());				// 체크! 하고 최대 값 저장
						swap(new Pair(r,c), new Pair(a,b));			// 다시 원상복구
						
					}
				}
			}
		}
		System.out.println(max);
	}
	
	public static class Pair{
		int x;
		int y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void swap(Pair a, Pair b) {
		String tmp = map[a.x][a.y];
		map[a.x][a.y] = map[b.x][b.y];
		map[b.x][b.y] = tmp;
	}
	
	public static boolean isIn(int r, int c) {
		return r>=0 && c>=0 && r< N && c< N;
	}
	
	public static int check() {
		int max = 1;
		int count =1;
		for (int r = 0; r < N; r++) {						// 가로 찾기
			String tmp = map[r][0];							// 처음 비교할 기준 색
			for (int c = 1; c < N; c++) {
				if(tmp.equals(map[r][c])) {					// 만약 연속으로 같은게 나왔다면?
					count++;								// 카운트
					max = Math.max(max, count);				// 현재의 최대값이면 저장
				}
				else {
					tmp = map[r][c];						// 다른게 나왔다면? 현재값을 기준색으로 바꾼다
					count=1;								// 카운트는 현재 기준색부터 시작이므로 초기화
				}
			}
			count=1;
		}

		for (int c = 0; c < N; c++) {						//세로 찾기
			String tmp = map[0][c];
			for (int r = 1; r < N; r++) {
				if(tmp.equals(map[r][c])) {
					count++;
					max = Math.max(max, count);
				}
				else {
					tmp = map[r][c];
					count=1;
				}
			}
			count=1;
		}
		return max;
	}
}
