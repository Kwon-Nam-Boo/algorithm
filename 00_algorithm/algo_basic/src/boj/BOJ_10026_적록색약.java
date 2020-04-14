package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_10026_적록색약 {

	private static int N;
	private static char[][] map;
	private static boolean[][] visited;
	private static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		visited = new boolean[N][N];
		for (int r = 0; r < N; r++) {
			char[] src = br.readLine().toCharArray();
			for (int c = 0; c < N; c++) {
				map[r][c] = src[c];
			}
		}
		
		
		
		int nor =0;
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				// 색맹이 아님 
				if(!visited[r][c]) {
					bfs(new Pair(r,c));
					nor++;
				}
				
			}
		}
		greenToRed();
		for (boolean[] v: visited) {
			Arrays.fill(v, false);
		}
		
		int unor =0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if(!visited[r][c]) {
					bfs(new Pair(r,c));
					unor++;
				}
			}
		}
		System.out.println(nor + " " + unor);
	
		
	}
	private static void greenToRed() {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if(map[r][c] == 'G') {
					map[r][c] = 'R';
				}
			}
		}
		
	}
	public static void bfs(Pair p) {
		Queue<Pair> queue = new LinkedList<>();
		queue.offer(p);
		visited[p.x][p.y]=true;
		char start = map[p.x][p.y];
		
		while(!queue.isEmpty()) {
			Pair tmp = queue.poll();
			for (int i = 0; i < dir.length; i++) {
				int nx = dir[i][0]+tmp.x;
				int ny = dir[i][1]+tmp.y;
				// 범위안에 존재 , 같은 색깔이며 , 방문한적이 없는곳으로
				if(isIn(nx,ny) && !visited[nx][ny] && map[nx][ny] == start) {
					queue.offer(new Pair(nx,ny));
					visited[nx][ny] =true;
				}
			}
		}
		
	}
	public static class Pair{
		int x;
		int y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
	public static boolean isIn(int r , int c) {
		return r>=0 && c>=0 && r< N && c< N;
	}
}
