package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1868_D4_파핑파핑_지뢰찾기 {
	
	private static int N;
	private static char[][] map;
	private static int[][] dir = {{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}}; //팔방향
	private static boolean[][] visited;
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <= TC; t++) {
			sb.append("#").append(t).append(" ");
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];
			visited = new boolean[N][N];
			for (int r = 0; r < N; r++) {
				String src = br.readLine();
				for (int c = 0; c < N; c++) {
					map[r][c] = src.charAt(c);
				}
			}
			
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if(map[r][c] == '.') {
						boolean flag =true;
						for (int i = 0; i < dir.length; i++) {
							int nr = dir[i][0] + r;
							int nc = dir[i][1] + c;
							if(!isIn(nr,nc)) continue; // 범위를 벗어나면 패스
							if(map[nr][nc]=='*') {
								flag =false;
								break;
							}
						}
						if(flag) {
							map[r][c]='0';
						}
					}
				}
			}
		
			int count=0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if(map[r][c]=='0' && !visited[r][c]) {
						bfs(new Pair(r,c));
						count++;
					}
				}
			}
			sb.append(count+check()).append("\n");
			
		}
		System.out.println(sb);

	}
	public static void bfs(Pair start) {
		Queue<Pair> queue = new LinkedList<>();
		queue.offer(start);
		visited[start.x][start.y] =true;
		
		while(!queue.isEmpty()) {
			Pair tmp = queue.poll();
			for (int i = 0; i < dir.length; i++) {
				int nx = dir[i][0] + tmp.x;
				int ny = dir[i][1] + tmp.y;
				if(isIn(nx,ny)){
					if(!visited[nx][ny] && map[nx][ny] =='0'){	// 0이면 큐에 넣고 방문처리
						queue.offer(new Pair(nx,ny));
						visited[nx][ny] =true;
					}
					else if(!visited[nx][ny]) { 			//  0이 아닌 값이면 방문처리만
						visited[nx][ny] =true;
					}
				}
			}
		}
		
	}
	public static int check() {
		int count=0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if(map[r][c]=='.' && !visited[r][c]) {
					count++;
				}
			}
		}
		return count;
	}
	
	public static boolean isIn(int r, int c) {
		return r>=0 && c>=0 && r< N && c < N;
	}
	
	public static class Pair{
		int x;
		int y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
