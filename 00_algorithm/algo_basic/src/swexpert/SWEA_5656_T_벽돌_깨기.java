package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_5656_T_벽돌_깨기 {
	
	private static int N;
	private static int R;
	private static int C;
	private static int min;
	private static boolean flag;
	private static int[][] map;
	private static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
	private static boolean[][] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= TC; t++) {
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			map = new int[R][C];
			for (int r = 0; r < R; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < C; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
					if(map[r][c]!=0) {
					}
				}
			}
			flag = false;
			min = Integer.MAX_VALUE;
			dfs(0,map);
			sb.append(min).append("\n");
		}
		System.out.println(sb);
	}
	public static void dfs(int r ,int [][] m) {
		if(flag) return;
		if(r == N) {
			min = Math.min(min, checkBrick(m));
			if(min==0) flag=true;
			return;
		}
		
		for (int c = 0; c < C; c++) {		// 세로 요소 중 하나에 구슬을 떨구기 때문에
			int[][] mapClone = new int[R][C];
			mapCopy(mapClone, m);				// map 클론은 이전 map을 복사한 요소 값이다
			
			// mapCopy에서 구슬을 떨어 트려 없애고 배열을 정리 해줘야한다.
			DropMarble(c, mapClone);
			dfs(r+1,mapClone);	
				
		}
		
	}
	public static void DropMarble(int c, int[][] mapClone) {	// 위치 c에서 구슬을 떨군다
		for (int r = 0; r < R; r++) {		
			if(mapClone[r][c] != 0) {		// 벽돌에서만 실행
				//System.out.println(r+":"+c);
				removeBrick(mapClone ,new Pair(r,c));				// 해당 벽돌을 제거
				downBrick(mapClone);				// 해당 벽돌을 중력으로 내린다.
				break;
			}
		}
	}
	
	public static void removeBrick(int[][] mapClone, Pair start) {		//bfs
		visited = new boolean[R][C];
		Queue<Pair> queue = new LinkedList<>();
		queue.offer(start);
		visited[start.x][start.y] = true;
		
		while(!queue.isEmpty()) {
			Pair tmp = queue.poll();
			int size = mapClone[tmp.x][tmp.y]-1;		// 벽돌의 숫자만큼 폭발 시켜야 하니깐
			mapClone[tmp.x][tmp.y] = 0;					// 현재 벽돌 없애기
			for (int i = 1; i <= size; i++) {
				for (int j = 0; j < dir.length; j++) {
					int nx = dir[j][0]*i + tmp.x;		// 길이안의 큐 다돌리기
					int ny = dir[j][1]*i + tmp.y;
					if(isIn(nx,ny) && mapClone[nx][ny]>0 && !visited[nx][ny]) {
						queue.offer(new Pair(nx,ny));
						visited[nx][ny] =true;
					}
				}
			}
		}
		
	}
	public static void downBrick(int[][] mapClone) {

		for (int c = 0; c < C; c++) {
			int d = R;
			for (int r = R-1; r >=0 ; r--) {
				if(mapClone[r][c] !=0 ) {		// 만약 0이 아닌 벽돌을 만낫다면  벽돌을 쌓는다.(밑에서 부터 확인하므로 순서대로된다)
					d--;
					mapClone[d][c] = mapClone[r][c];		// 아니면 벽돌을 쌓는다.
					if(r!=d) mapClone[r][c] = 0;
				}

			}
		}
	}
	public static int checkBrick(int[][] mapClone) {
		int sum=0;
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
					if(mapClone[r][c]!=0) sum++;
				}
		}
		return sum;
	}
	public static void mapCopy(int[][] mapClone, int[][] m){
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
					mapClone[r][c] = m[r][c];
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
	public static boolean isIn(int r, int c) {
		return r>=0 && c>=0 && r < R && c< C;
	}
}
