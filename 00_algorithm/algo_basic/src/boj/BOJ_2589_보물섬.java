package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2589_보물섬 {

	private static int R;
	private static int C;
	private static int max;
	private static char[][] map;
	private static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
	private static boolean[][] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//br = new BufferedReader(new StringReader(src));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[R][C];
		for (int r = 0; r < R; r++) {
			map[r] =br.readLine().toCharArray();
		}
		/*for (int r = 0; r < R; r++) {
			System.out.println(Arrays.toString(map[r]));
		}*/
		max =Integer.MIN_VALUE;
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if(map[r][c]=='L') {
					bfs(new Pair(r,c));
					for (boolean[] v1 : visited) {
						Arrays.fill(v1, false);
					}
				}
			}
		}
		System.out.println(max);
	}
	public static void bfs(Pair start) {
		Queue<Pair> queue = new LinkedList<>();
		queue.offer(start);
		visited[start.x][start.y] =true;
		
		int count =0;
		
		while(!queue.isEmpty()) {
			
			int size = queue.size();
			
			for (int s = 0; s < size; s++) {
				Pair tmp = queue.poll();
				for (int i = 0; i < dir.length; i++) {
					int nx = dir[i][0] + tmp.x;
					int ny = dir[i][1] + tmp.y;
					if(isIn(nx,ny) && !visited[nx][ny] && map[nx][ny]=='L') {
						queue.offer(new Pair(nx,ny));
						visited[nx][ny] = true;
					}
				}
			}
			count++;
		}
		max = Math.max(max, count-1);
	}
	
	public static boolean isIn(int r , int c) {
		return r>=0 && c>=0 && r<R && c<C;
	}
	
	public static class Pair{
		int x;
		int y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	private static String src="5 7\r\n" + 
			"WLLWWWL\r\n" + 
			"LLLWLLL\r\n" + 
			"LWLWLWW\r\n" + 
			"LWLWLLL\r\n" + 
			"WLLWLWW";
}	
