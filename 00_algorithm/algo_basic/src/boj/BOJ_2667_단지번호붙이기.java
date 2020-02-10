package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2667_단지번호붙이기 {
	
	private static int N;
	private static int count;
	private static int area;
	private static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
	private static String[][] map;
	private static boolean[][] visited;

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new String[N][N];
		visited = new boolean[N][N];
		
		for (int r = 0; r < N; r++) {
			map[r]= br.readLine().split("");
		}
		//System.out.println(Arrays.deepToString(map));
		count=0;
		
		List<Integer> tmp = new ArrayList<>();
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if(map[r][c].equals("1") && !visited[r][c]) {
					bfs(r,c);
					count++;
					tmp.add(area);
					//sb.append(area).append("\n");
				}
			}
			
		}
		System.out.println(count);
		Collections.sort(tmp);
		for (int i = 0; i < tmp.size(); i++) {
			System.out.println(tmp.get(i));
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
	
	public static void bfs(int r, int c) {
		area=0;
		Queue<Pair> queue = new LinkedList<>();
		queue.offer(new Pair(r,c));
		visited[r][c]= true;
		area++;
		while(!queue.isEmpty()) {
			Pair tmp = queue.poll();
			for (int i = 0; i < dir.length; i++) {
				int nx = tmp.x + dir[i][0];
				int ny = tmp.y + dir[i][1];
				if(isIn(nx,ny) && map[nx][ny].equals("1") && !visited[nx][ny]) {
					queue.offer(new Pair(nx,ny));
					visited[nx][ny]= true;
					area++;
				}
			}
		}
	}
	public static boolean isIn(int r, int c) {
		return r >= 0 && c>= 0 && c < N && r <N;
 	}
}
