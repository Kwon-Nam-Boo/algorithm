package samsungTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_15685_드래곤커브 {
	
	private static int N;
	private static int[][] map;
	private static int[][] dir = {{0,1},{-1,0},{0,-1},{1,0}};
	

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[101][101];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			dragonCurve(x,y,d,g);
		}
		int cnt = 0;
		
		for (int r = 0; r < map.length -1; r++) {
			for (int c = 0; c < map.length-1 ; c++) {
				if(map[r][c] == 1 && map[r+1][c] == 1 && map[r][c+1] == 1 && map[r+1][c+1] == 1) cnt++;
			}
		}
		
		System.out.println(cnt);
	
		
		
	}

	private static void dragonCurve(int x, int y, int d, int g) {
		
		List<Integer> list = new ArrayList<>();
		list.add(d);
		// 방향 구하기
		for (int i = 0; i < g; i++) {
			for (int j = list.size()-1; j >=0; j--) {
				list.add((list.get(j)+1)%4);
			}
		}
		
		map[x][y] = 1;
		int nx = x;
		int ny = y;
		
		for (int i = 0; i < list.size(); i++) {
			nx = dir[list.get(i)][0] + nx;
			ny = dir[list.get(i)][1] + ny;
			map[nx][ny] = 1;
		}
		
		
	}

}
