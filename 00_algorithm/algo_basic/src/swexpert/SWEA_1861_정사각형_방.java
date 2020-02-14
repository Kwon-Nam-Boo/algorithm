package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1861_정사각형_방 {

	private static int N;
	private static int count;
	private static int max;
	private static int result;
	private static int[][] map;
	private static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		//
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= TC; i++) {
			sb.append("#").append(i).append(" ");
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			count =0;
			max = 1;
			result = Integer.MAX_VALUE;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					bfs(r,c);
					if(count > max) {
						max = count;
						result =map[r][c];
					}else if(count == max){
						result = map[r][c] > result ? result: map[r][c];
					}
					count=0;	
				}
			}
			sb.append(result).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
	

	}
	
	public static void bfs(int x, int y) {
		Queue<Pair> queue = new LinkedList<>();
		queue.offer(new Pair(x,y));
		count++;
		while(!queue.isEmpty()) {
			Pair tmp = queue.poll();
			
			for (int i = 0; i < dir.length; i++) {
				int a = tmp.x + dir[i][0];
				int b = tmp.y + dir[i][1];
				
				if(isIn(a,b) && map[a][b] == map[tmp.x][tmp.y]+1) {
					queue.offer(new Pair(a,b));
					count++;
					break;
				}
			}
			
		}
	
	}
	public static class Pair{
		int x;
		int y;
		@Override
		public String toString() {
			return "Pair [x=" + x + ", y=" + y + "]";
		}
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
	
	public static boolean isIn(int r, int c) {
		return r >=0 && c>= 0 && r < N && c< N;
	}

}
