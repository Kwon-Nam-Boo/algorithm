package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16234_인구이동 {

	private static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
	private static int[][] map;
	private static int[][] mapClone;
	private static boolean[][] visited;
	private static List<Pair> list;
	private static int N;
	private static int L;
	private static int R;
	private static boolean flag;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		visited = new boolean[N][N];
		list = new ArrayList<>();
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt=0;
		while(true) {
			flag = false;
			visited = new boolean[N][N];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if(!visited[r][c]) {
						bfs(new Pair(r,c));
					}
				}
			}
			if(!flag) break;
			cnt++;
			
		}
		System.out.println(cnt);
		
	} // end of main
	public static void bfs(Pair p) {
		list.clear();
		int result = 0;
		Queue<Pair> queue = new LinkedList<>();
		queue.offer(p);
		visited[p.x][p.y] = true;
		
		while(!queue.isEmpty()) {
			Pair tmp = queue.poll();
			list.add(tmp);
			result+= map[tmp.x][tmp.y];
			
			for (int i = 0; i < dir.length; i++) {
				int nx = dir[i][0] + tmp.x;
				int ny = dir[i][1] + tmp.y;
				
				if(isIn(nx,ny)) {
					int gap = Math.abs(map[nx][ny]- map[tmp.x][tmp.y]);
					if(gap >= L && gap <=R &&!visited[nx][ny]) {
						visited[nx][ny] = true;
						queue.offer(new Pair(nx,ny));
					}
				}
			}
		}
		if(list.size()==1) {
			return;
		}
		flag = true;
		result/=list.size();
		for (int i = 0; i < list.size(); i++) {
			map[list.get(i).x][list.get(i).y]=result;
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
	
	public static boolean isIn(int r, int c) {
		return r>=0 && c>=0 && r<N && c<N;
	}
} // end of class
