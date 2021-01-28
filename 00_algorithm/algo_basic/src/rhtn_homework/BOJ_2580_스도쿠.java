package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2580_스도쿠 {

	public static List<Pair> blank;
	public static int[][] map;
	public static boolean end;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		map = new int[9][9];
		blank = new ArrayList<>();
		for (int r = 0; r < map.length; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < map.length; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c] == 0) blank.add(new Pair(r,c));
			}
		}
		end = false;
		dfs(0);
		
	}
	
	private static void dfs(int d) {
		// 종료 플래그
		if(end) return;
		
		// 종료 및 출력
		if(d == blank.size()) {
			end = true;
			for (int r = 0; r < map.length; r++) {
				for (int c = 0; c < map.length; c++) {
					System.out.print(map[r][c] + " ");
				}
				System.out.println();
			}
			return;
		}
		
		int nr = blank.get(d).r;
		int nc = blank.get(d).c;
		
		// dfs
		for (int i = 1; i < 10; i++) {
			if(!checkSquare(changeNum(nr), changeNum(nc),i)) continue;
			if(!checkLine(nr, nc, i)) continue;
			
			map[nr][nc] = i;
			dfs(d+1);
			// 종료 플래그
			if(end) return;
			map[nr][nc] = 0;
			
		}
		
	}
	
	// 가로, 세로 줄에 이미 있는 숫자인지 판별
	private static boolean checkLine(int nr, int nc, int i) {
		for (int r = 0; r < 9; r++) {
			if(map[r][nc] == i) return false; 
		}
		for (int c = 0; c < 9; c++) {
			if(map[nr][c] == i) return false; 
		}
		return true;
	}
	
	// 3*3 삼각형 안에 이미 있는 숫자인지 판별
	private static boolean checkSquare(int cr, int cc,int i) {
		for (int r = cr; r < cr+3 ; r++) {
			for (int c = cc; c < cc+3; c++) {
				if(map[r][c] == i) return false;
			}
		}
		return true;
	}

	public static class Pair{
		int r, c;

		public Pair(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Pair [r=" + r + ", c=" + c + "]";
		}
		
	}
	
	// 9분할한 3*3 사각형의 시작점으로 치환
	public static int changeNum(int num) {
		switch (num) {
		case 0:
		case 1:
		case 2:
			return 0; 
		case 3:
		case 4:
		case 5:
			return 3; 
		case 6:
		case 7:
		case 8:
			return 6; 
		}
		return num;
	}
	
}
