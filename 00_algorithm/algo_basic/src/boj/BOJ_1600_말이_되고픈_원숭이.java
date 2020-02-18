package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1600_말이_되고픈_원숭이 {

	private static int K;
	private static int W;
	private static int H;
	private static int[][] map;
	private static int[][] visited;
	// 상하좌우 + 1시,2시 + 4시,5시 + 7시,8시+ 10시,11시
	private static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1},{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1}};
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new int[H][W];
		visited = new int[H][W];
		for (int r = 0; r < H; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < W; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		//System.out.println(Arrays.deepToString(map));
		bfs(new Pair(0,0));
		/*for (int i = 0; i < H; i++) {
			System.out.println(Arrays.toString(visited[i]));
		}*/
		System.out.println(visited[H-1][W-1]-1);
	}
	public static void bfs(Pair p) {
		Queue<Pair> queue = new LinkedList<>();
		queue.offer(p);
		visited[p.x][p.y] = 1;
		
		while(!queue.isEmpty()) {
			Pair tmp = queue.poll();
			for (int i = 0; i < dir.length; i++) {
				int a = tmp.x +dir[i][0];
				int b = tmp.y +dir[i][1];
				if(isIn(a,b) && visited[a][b] == 0 && map[a][b] == 0) {
					if(i > 3 && K >0) {									// 횟수가 남아있고 말처럼 가는 것이라면 
						queue.offer(new Pair(a,b));						// 횟수를 줄이고 말처럼 뛴다
						visited[a][b] = visited[tmp.x][tmp.y]+1;
						K--;
					}else if(i > 3 && K == 0) {							// 횟수가 없는데 말처럼 가는 차례라면
						break;											// 뒤에 말처럼 가는경우는 더이상 볼 필요도 없다
					}else {
						queue.offer(new Pair(a,b));						// 원숭이 처럼 가는경우
						visited[a][b] = visited[tmp.x][tmp.y]+1;
					}
					
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
		
		@Override
		public String toString() {
			return "Pair [x=" + x + ", y=" + y + "]";
		}
		
		
	}
	public static boolean isIn(int r, int c) {
		return r>=0 && c>=0 && r < H && c < W;
	}

}
