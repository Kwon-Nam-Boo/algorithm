package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14503_로봇청소기 {
	
	private static int R;
	private static int C;
	private static int ans;
	private static int sx;
	private static int sy;
	private static int sd;
	private static int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}}; // 0:북 1:동 2:남 3:서
	private static int[][] map;
	private static boolean[][] clean;
	

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		clean = new boolean[R][C];
		st = new StringTokenizer(br.readLine());
		sx = Integer.parseInt(st.nextToken());
		sy = Integer.parseInt(st.nextToken());
		sd = Integer.parseInt(st.nextToken());
		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		ans = 0;
		bfs(new Pair(sx,sy,sd));
		System.out.println(ans);
		
	}
	public static boolean isIn(int r, int c) {
		return r>=0 && c>=0 && r< R && c < C;
	}
	public static class Pair{
		int x;
		int y;
		int d;
		public Pair(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
	public static void bfs(Pair start) {
		Queue<Pair> queue = new LinkedList<>();
		queue.offer(start);
		clean[start.x][start.y] = true;
		ans++;
		int c = 0;
		
		while(!queue.isEmpty()) {
			Pair tmp = queue.poll();
			
			// 종료 조건 , 후진 조건
			if(c == 4) {
				int bd = (tmp.d+2) % 4;						// 뒤로 회전
				int bx = tmp.x + dir[bd][0];				// 현재의 뒤쪽 x
				int by = tmp.y + dir[bd][1];				// 현재의 뒤쪽 y
				if(map[bx][by] ==1) {						// 뒤가 벽이라면 작동 중지
					return;
				}else {										// 벽이 아니라면
					queue.offer(new Pair(bx,by,tmp.d));		// 방향을 유지하고 뒤로 후진!
					c=0;									// 회전 초기화
					continue;
				}
			}
			
			int ld = (tmp.d+3) % 4;							// 왼쪽 회전
			int lx = tmp.x + dir[ld][0];					// 현재의 왼쪽 x
			int ly = tmp.y + dir[ld][1];					// 현재의 왼쪽 y
				
			if(isIn(lx,ly) && !clean[lx][ly] && map[lx][ly]!=1) {	// 범위 안에 있고 벽이 아닌데 청소한적이 없다..?
				queue.offer(new Pair(lx,ly,ld));			// 그방향으로 회전하고 1칸전진
				clean[lx][ly] = true;						// 청소 ...
				ans++;										// 청소를 센다
				c=0;										// 지금까지 회전한 경우 초기화
				continue;									// 다음 큐로 이동
				
			}else {											// 왼쪽 이 범위 안에 없거나?, 청소를 햇거나?, 벽이라면?
				queue.offer(new Pair(tmp.x,tmp.y,ld));		// 방향만 바꿔준다.
				c++;										// 회전 횟수를 카운트
				continue;
			}
			
		}
	}
}
