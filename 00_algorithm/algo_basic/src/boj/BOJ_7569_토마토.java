package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7569_토마토 {

	private static int[][][] tomato;
	private static int N,M,H;
	//private static boolean[][][] visited;
	private static int[][] dir = {{0,-1,0},{0,1,0},{0,0,-1},{0,0,1},{-1,0,0},{1,0,0}};
	private static Queue<Pair> ripe = new LinkedList<>();
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		tomato = new int[H][M][N];
		//visited = new boolean[H][M][N];
		
		for (int h = 0; h < H; h++) {			
			for (int r = 0; r < M; r++) {		
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {	
					tomato[h][r][c] = Integer.parseInt(st.nextToken());
					if(tomato[h][r][c]==1) {
						ripe.add(new Pair(h,r,c));
					}
				}
			}
		}
		
		for (int i = 0; i < H; i++) {
			System.out.println(Arrays.deepToString(tomato[i]));
		}
		
		int count=0;
		while(true) {
			bfs();
			if(ripe.isEmpty()) {
				break;
			}
			count++;
		}
		
		System.out.println(count);
		for (int i = 0; i < H; i++) {
			System.out.println(Arrays.deepToString(tomato[i]));
		}
		
		
	}
	
	public static class Pair{
		int h;
		int c;
		int r;
		public Pair(int h, int c, int r) {
			this.h = h;
			this.c = c;
			this.r = r;
		}
		
	}
	
	public static void bfs() {
		int ripeSize = ripe.size();
		
		for (int i = 0; i < ripeSize; i++) {
			Pair tmp = ripe.poll();
			for (int j = 0; j < dir.length; j++) {
				int nh = tmp.h + dir[j][0];
				int nc = tmp.c + dir[j][1];
				int nr = tmp.r + dir[j][2];
				if(isIn(nh,nc,nr) && tomato[nh][nc][nr]==0){
					tomato[nh][nc][nr] = 1;
					ripe.add(new Pair(nh,nc,nr));
				}
			}
		}
		
		
	}
	
	public static boolean isIn(int h, int c, int r) {
		return r >=0 && c >=0 && h>=0 && r < N && c < M &&  h < H ;
	}
	
	//public

}
