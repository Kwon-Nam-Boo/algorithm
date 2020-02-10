package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1926_그림 {
	
	private static int count;
	private static int[][] P;
	private static int[][] visited;
	private static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		P = new int[N][M];
		visited = new int[N][M];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				P[r][c] =  Integer.parseInt(st.nextToken());
			}
		}
		
		int max = 0;
		int co = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if(P[r][c] == 1 && visited[r][c] == 0) {
					bfs(r,c);
					max = Math.max(max, count);
					co++;
				}
			}
		}
		sb.append(co).append("\n").append(max);
		System.out.println(sb);
	}
	public static void bfs(int r, int c) {
		count =0;
		Queue<Pair> queue = new LinkedList<>();
		queue.offer(new Pair(r,c));
		visited[r][c] = 1;
		
		while(!queue.isEmpty()) {
			Pair tmp = queue.poll();
			count++;
			for (int i = 0; i < dir.length; i++) {
				int a = tmp.x + dir[i][0];
				int b = tmp.y + dir[i][1];
				if(isIn(a,b) && visited[a][b] == 0 && P[a][b]==1) {
					queue.offer(new Pair(a,b));
					visited[a][b]=1;
				}
			}
			
		}
		
	}
	
	public static class Pair{				// 큐에 (x,y)인덱스 값을 저장하기 위해 class 생성
		int x;
		int y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
	public static boolean isIn(int r, int c) {
		return r>=0 && c>=0 && r < P.length && c < P[0].length;
	}
	

}
