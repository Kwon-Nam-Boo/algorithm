package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17070_파이프_옮기기_1_bfs_fail {

	private static int N,ans;
	private static int[][] map;
	private static int[][] dir = {{0,1},{1,0},{1,1}};	// 오른쪽  , 아래쪽, 대각선
	private static boolean[][] pipeRule = {{true,false,true},{false,true,true},{true,true,true}};
	private static boolean[][][] visited;
	private static Queue<Pair> queue;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N][3];
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		queue = new LinkedList<>();
		queue.offer(new Pair(0,0,0,1));
		bfs();
		
		System.out.println(ans);
		
	}
	private static void bfs() {
		
		ans=0;
		
		while(!queue.isEmpty()) {
			Pair p = queue.poll();
			
			if(p.ex == N-1 && p.ey == N-1) {
				ans++;
				continue;
			};
			int pipDir = checkDir(p);	// 현재 파이프의 모양 0 , 1, 2 순으로 정리
			
			for (int i = 0; i < dir.length; i++) {
				int rx = p.ex + dir[i][0];
				int ry = p.ey + dir[i][1];
				
				// 범위안에 있으며  ,현재모양에서 갈수 있는 위치인지, 가야하는위치가 벽이 아니라면
				if(isIn(rx,ry) && !visited[rx][ry][pipDir] && pipeRule[pipDir][i] && map[rx][ry]==0) {
					//if(map[rx][ry]!=0) break;
					// i가 2 --> 대각선일 경우 3칸이 모두 빈칸이어야한다
					if(i == 2){
						// 둘중 하나라도 빈칸이 아니라면 못간다
						if(map[p.ex+1][p.ey] != 0 || map[p.ex][p.ey+1]!=0) continue;
					}
					queue.offer(new Pair(p.ex,p.ey,rx,ry));
					visited[p.ex][p.ey][pipDir] = true;
				}
			}
		}
		
	}
	
	private static int checkDir(Pair p) {
		if(p.fx+1 == p.ex && p.fy+1 == p.ey) {
			return 2;
		}
		else if(p.fy+1 == p.ey) {
			return 0;
		}else {
			return 1;
		}
		
	}
	public static class Pair{
		int fx,fy,ex,ey;

		public Pair(int fx, int fy, int ex, int ey) {
			super();
			this.fx = fx;
			this.fy = fy;
			this.ex = ex;
			this.ey = ey;
		}

		@Override
		public String toString() {
			return "Pair [fx=" + fx + ", fy=" + fy + ", ex=" + ex + ", ey=" + ey + "]";
		}

	}
	
	public static boolean isIn(int r ,int c) {
		return r>=0 && c >=0 && r< N && c < N;
	}

}
