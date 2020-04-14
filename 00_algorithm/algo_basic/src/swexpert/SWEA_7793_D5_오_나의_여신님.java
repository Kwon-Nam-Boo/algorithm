package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_7793_D5_오_나의_여신님 {
	
	private static int N;
	private static int M;
	private static Pair D;
	private static Pair S;
	private static int ans;
	private static char[][] map;
	private static boolean[][] visitD;
	private static boolean[][] visitS;
	private static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
	private static Queue<Pair> queueD;
	private static Queue<Pair> queueS;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <= TC; t++) {
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(br.readLine());
			N =Integer.parseInt(st.nextToken());
			M =Integer.parseInt(st.nextToken());
			map = new char[N][M];
			visitD = new boolean[N][M];
			visitS = new boolean[N][M];
			queueD = new LinkedList<>();
			queueS = new LinkedList<>();
			for (int r = 0; r < N; r++) {
				String tmp =br.readLine();
				for (int c = 0; c < M; c++) {
					map[r][c] = tmp.charAt(c);
					if(map[r][c] == '*') {		//악마라면
						queueD.offer(new Pair(r,c,0));
						visitD[r][c] = true;
					}
					if(map[r][c] == 'D') {		// 도착점
						D = new Pair(r,c,0);
					}
					if(map[r][c] == 'S') {		// 시작점
						S = new Pair(r,c,0);
						queueS.offer(S);
						visitS[r][c] = true;
					}
				}
			}
			ans=0;
			bfs();
			if(ans ==0) {
				sb.append("GAME OVER").append("\n");
			}else {
				sb.append(ans).append("\n");
			}
		}	
		System.out.println(sb);
	}
	public static void bfs() {
		
		while(!queueS.isEmpty()) {
			int sizeD = queueD.size();
			int sizeS = queueS.size();
			for (int i = 0; i < sizeD; i++) {
				Pair de = queueD.poll();
				for (int j = 0; j < dir.length; j++) {	// 바이러스
					int nx = dir[j][0] + de.x;
					int ny = dir[j][1] + de.y;
					if(!isIn(nx,ny)) continue;		// 범위 안에 있어야하고
					// 벽이나 여신이나니고 방문한적이 없어야한다.
					if(map[nx][ny] == 'X' || map[nx][ny] == 'D' || visitD[nx][ny]) continue;
					visitD[nx][ny] =true;
					
					queueD.offer(new Pair(nx,ny,0));
				}
			}
			
			for (int i = 0; i < sizeS; i++) {
				Pair s = queueS.poll();
				// 정답조건
				if(s.x == D.x && s.y == D.y) {
					ans = s.c;
					return;
				}
				for (int j = 0; j < dir.length; j++) {	// S
					int nx = dir[j][0] + s.x;
					int ny = dir[j][1] + s.y;
					if(!isIn(nx,ny)) continue;		// 범위 안에 있어야하고
					// 벽이 아니고 바이러스도, 나도 방문한적이 없어야 한다.
					if(map[nx][ny] == '*' ||map[nx][ny] == 'X' || visitS[nx][ny] || visitD[nx][ny]) continue;
					visitS[nx][ny] =true;
					queueS.offer(new Pair(nx,ny,s.c+1));
				}
			}
		}
		
	}
	
	public static class Pair{
		int x;
		int y;
		int c;
		public Pair(int x, int y,int c) {
			this.x = x;
			this.y = y;
			this.c = c;
		}
	}
	public static boolean isIn(int r, int c) {
		return r>=0 && c>=0 && r < N && c< M;
	}
}
