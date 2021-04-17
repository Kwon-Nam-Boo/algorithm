package samsungTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14499_주사위굴리기 {
	
	private static int N,M,x,y,K;
	private static int[][] map;
	private static int[][] dir = {{0,0},{0,1},{0,-1},{-1,0},{1,0}};
	private static int[] comm;
	// 0. 상단 1. 뒤쪽  2.오른쪽  3.왼쪽 4.앞쪽 5.바닥  
	private static int[] dice;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for (int r = 0; r < N; r++) {
			st  = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c]= Integer.parseInt(st.nextToken());
			}
		}
		comm = new int[K];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			comm[i] = Integer.parseInt(st.nextToken());
		}
		
		dice = new int[6];
		for (int i = 0; i < comm.length; i++) {
			moveDice(comm[i]);
		}
		
		
	}
	private static void moveDice(int i) {
		
		// 다음 좌표로
		int nx = dir[i][0] + x;
		int ny = dir[i][1] + y;
		// 범위 밖이면 그냥 끝냄
		if(!isIn(nx,ny)) return;
		x+=dir[i][0];
		y+=dir[i][1];
		
		// 남쪽이동이라면
		if(i == 4) {
			rotate(0,4,5,1);
		}else if(i == 3) {	// 북쪽 이동이라면
			rotate(0,1,5,4);
		}else if(i == 2) {	// 서쪽
			rotate(0,3,5,2);
		}else{				// 동쪽 
			rotate(0,2,5,3);
		}
		// 조건에 따라수행
		if(map[x][y] == 0) map[x][y] = dice[5];
		else {
			dice[5] = map[x][y];
			map[x][y] = 0;
		}
		System.out.println(dice[0]);
	}
	
	
	private static boolean isIn(int r, int c) {
		return r>=0 && c>=0 && r< N && c <M;
	}
	
	public static void rotate(int a, int b, int c, int d) {
		int tmp = dice[a];
		dice[a] = dice[d];
		dice[d] = dice[c];
		dice[c] = dice[b];
		dice[b] = tmp;
	}


}
