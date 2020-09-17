package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1953_T_탈주범_검거 {
	
	private static int n, m, r, c, l, count; 
	private static int[][] map;
	private static boolean[][] visit;
	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};
	// 파이프 가용 유무를 미리 설정해둔다
	private static boolean[][] status = { {true, true, true, true}, {true, false, true, false},		
			{false, true, false, true}, {true, true, false, false}, {false, true, true, false},
			{false, false, true, true}, {true, false, false, true} };

	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++){
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());
			
			map = new int[n][m];
			visit = new boolean[n][m];
			count = 0;
			for (int i = 0; i < n; i++){
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < m; j++){
					map[i][j] = Integer.parseInt(st.nextToken());
					}
			}
			bfs();
			System.out.println("#" + t + " " + count);
		}

	}
	private static void bfs(){
		Queue<Pair> queue = new LinkedList<>();
		queue.add(new Pair(r, c));
		visit[r][c] = true;
		int nx, ny;
		
		while (l-- > 0){
			int len = queue.size();
			for (int t = 0; t < len; t++){
				Pair target = queue.poll();
				
				count++;
				for (int i = 0; i < 4; i++){
					nx = target.x + dx[i];
					ny = target.y + dy[i];
					int type = map[target.x][target.y];
					if (status[type - 1][i] && isValid(nx, ny)){ 	// 현재위치에서 이동이가능한가?
						if (map[nx][ny] != 0 && !visit[nx][ny]) { 	// 이동위치에 파이프가 있는가?
							int nType = map[nx][ny];
							if (status[nType - 1][(i+2) % 4]){		// 이동한위치에서도 현재위치로 돌아올수 있는가?
								queue.add(new Pair(nx, ny));
								visit[nx][ny] = true; // 방문 처리
								}
							}
						}
					}
				}
			}
			
		}
	private static boolean isValid(int x, int y){
		return x >=0 && y>=0 && x < n && y<m;
	}
}

class Pair{
	int x;
	int y;
	
	public Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString() {
		return "Pair [x=" + x + ", y=" + y + "]";
	}
	
	
}


