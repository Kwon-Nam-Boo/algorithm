package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_7396_D5_종구의_딸이름_짓기 {
	
	private static int N;
	private static int M;
	private static String ans;
	private static int[][] dir = {{1,0},{0,1}};
	private static char[][] map;
	private static boolean[][] visited;
	private static Queue<Pair> queue;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <= TC; t++) {
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new char[N][M];
			visited = new boolean[N][M];
			for (int r = 0; r < N; r++) {
				map[r] = br.readLine().toCharArray();
			}
			
			queue = new LinkedList<>();
			queue.offer(new Pair(0,0));
			ans= map[0][0] +"";
			for (int i = 0; i < N+M-2; i++) {		// 한 사이클 마다 bfs()를 돌린다

				bfs();
			}
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}
	public static void bfs() {
		int size = queue.size();
		List<Pair> list = new LinkedList<>();
		while(size>0) {
			Pair p = queue.poll();
			for (int i = 0; i < dir.length; i++) {
				int nx = dir[i][0] + p.x;
				int ny = dir[i][1] + p.y;
				
				if(isIn(nx,ny) && !visited[nx][ny]) {	// 만약 방문한적 없고 범위안 있는 수라면
					visited[nx][ny] =true;
					if(list.isEmpty()) {				// 리스트가 비었다 --> 현재 최단 알파벳
						list.add(new Pair(nx,ny));
					}else {
						Pair tmp = list.get(0);							// 비어있지 않다면..? 크기 확인!
						if( map[tmp.x][tmp.y]> map[nx][ny]) {			// 현재 알파벳이 리스트 안에 있는 알파벳보다 작다면
							list.clear();
							list.add(new Pair(nx,ny));					// 현재 알파벳으로 나아간다.
						}else if(map[tmp.x][tmp.y] ==  map[nx][ny]) {	// 알파벳이 같다면 ..?
							list.add(new Pair(nx,ny));					// 현재 알파벳도 탐색 해봐야한다.
						}
																		// 현재 알파벳이 크다면 탐색할 필요 없다.
					}
				}
			}
			size--;
		}
		queue.addAll(list);
		ans+=map[list.get(0).x][list.get(0).y];
		
	}
	public static boolean isIn(int r, int c) {
		return r>=0 && c>=0 && r<N && c<M;
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
