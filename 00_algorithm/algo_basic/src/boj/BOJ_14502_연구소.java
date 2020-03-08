package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14502_연구소 {
	
	private static int R;
	private static int C;
	private static int max = Integer.MIN_VALUE;
	//private static int Count;
	private static Pair[] result;
	private static int[][] map;
	private static int[][] mapClone;
	private static boolean[][] visited;
	private static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
	private static Queue<Pair> queue = new LinkedList<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		visited = new boolean[R][C];
		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());		// 배열 저장
				if(map[r][c]==2) {
					queue.offer(new Pair(r,c));						// 바이러스 큐에 넣어두기
				}
			}
		}
		result = new Pair[3];
		nCr(0,0);
		System.out.println(max);
		

	}
	public static void bfs() {
		while(!queue.isEmpty()) {
			Pair tmp = queue.poll();
			for (int i = 0; i < dir.length; i++) {
				int a = tmp.x +dir[i][0];
				int b = tmp.y +dir[i][1];
				if(a>=0 && b>=0 && a<R && b < C && !visited[a][b] && mapClone[a][b] == 0){
					queue.offer(new Pair(a,b));
					mapClone[a][b] =2;
					visited[a][b] = true;
				}
			}
		}
	}
	
	
	public static void nCr(int r, int k) {
		if(r == 3) {
			copyMap();							// 현재 만들어진 벽 3개를 추가한 mapClone을
			bfs();								// bfs 돌려본다
			max = Math.max(max, countSafe());	// 안전 구역이 가장 많은걸 저장한다.
			return;
		}
		for (int i = k; i < R*C; i++) {
			int nr = i / C;
			int nc = i % C; 
			if(map[nr][nc]!=0) continue;
			result[r] = new Pair(nr,nc);
			nCr(r+1,i+1);
		}
		
	}
	
	public static class Pair{						// (x,y)
		int x;
		int y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void copyMap() {					// Map을 복사 및 임의의 벽 3개 세우기
		mapClone = new int[R][C];
		visited = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				mapClone[i][j] = map[i][j];
				if(mapClone[i][j]==2) {				// 복사하면서 현재 바이러스를 큐와 visited에 넣는다
					queue.offer(new Pair(i,j));	
					visited[i][j] = true;
				}
			}
		}
		for (int i = 0; i < 3; i++) {				// 벽 추가
			mapClone[result[i].x][result[i].y]=1;   
		}
	}
	public static int countSafe() {					// 안전 영역이 몇개 인가?
		int count = 0;
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if(mapClone[r][c]==0) count++;
			}
		}
		return count;
	}
}
