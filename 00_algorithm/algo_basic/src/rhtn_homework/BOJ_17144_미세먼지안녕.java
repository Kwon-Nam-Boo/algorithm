package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17144_미세먼지안녕 {

	private static StringBuilder sb = new StringBuilder();
	private static int R,C,T;
	private static int[][] map, mapClone;
	private static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
	private static int up, down;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		mapClone = new int[R][C];
		
		boolean flag = true;
		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c] == -1 && flag) {
					up = r;
					down = r+1;
					flag = false;
				}
			}
		}
		// 미세먼지 확인 -> 해당 먼지들 확산 -> 공기청정의 순서로 로직은 돌아간다
		for (int i = 0; i < T; i++) {
			searchDust();
			airClean();
		}
		// 미세먼지 개수 출력
		System.out.println(count());
	}
	
	private static int count() {
		int cnt=0;
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if(map[r][c]>0) cnt+=map[r][c];
			}
		}
		return cnt;
	}
	// 공기 청정(이동시킨다, 공기 청정기 부분만 유의해서)
	private static void airClean() {
		// 윗부분 오른쪽, 왼쪽
		for (int i = 0; i < C-1; i++) {
			mapClone[up][i+1] = map[up][i];
			mapClone[0][C-i-2] = map[0][C-i-1];
		}
		mapClone[up][1] = 0;
		// 위아래
		for (int i = 0; i < up; i++) {
			mapClone[i+1][0]=map[i][0];
			mapClone[up-i-1][C-1]=map[up-i][C-1];
		}
		mapClone[up][0] = -1;
		
		// 아래부분 오른쪽, 왼쪽
		for (int i = 0; i < C-1; i++) {
			mapClone[down][i+1] = map[down][i];
			mapClone[R-1][C-i-2] = map[R-1][C-i-1];
		}
		mapClone[down][1] = 0;
		//위아래
		for (int i = down; i < R-1; i++) {
			mapClone[i+1][C-1]=map[i][C-1];
			mapClone[R+down-i-2][0]=map[R+down-i-1][0];
		}
		mapClone[down][0] = -1;
		
		// 초기화
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				map[r][c] = mapClone[r][c];
				mapClone[r][c] = 0;
			}
		}
		
	}
	// 먼지 위치에서 확산 실행
	private static void searchDust() {
		
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if(map[r][c]>0) diffusion(r,c);
			}
		}
		// 초기화
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				map[r][c] = mapClone[r][c];
			}
		}
	}
	
	// 확산시킨다
	private static void diffusion(int r, int c) {
		
		int dust = map[r][c]/5;
		int cnt = 0;
		for (int i = 0; i < dir.length; i++) {
			int nr = dir[i][0] + r;
			int nc = dir[i][1] + c;
			if(isIn(nr,nc) && map[nr][nc] != -1) {
				mapClone[nr][nc]+=dust;
				cnt++;
			}
		}
		mapClone[r][c]+=map[r][c]-(dust*cnt);
	}

	
	public static boolean isIn(int r, int c) {
		return r>=0 && c>=0 && r < R && c< C;
	}
}
