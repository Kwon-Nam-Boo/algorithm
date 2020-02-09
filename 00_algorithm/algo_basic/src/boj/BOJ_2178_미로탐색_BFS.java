package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178_미로탐색_BFS {
	
	private static int N;
	private static int M;
	private static int cnt=0;
	private static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
	private static String[][] maze;
	private static int[][] visited;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		maze = new String[N][M];
		visited = new int[N][M];
		
		for (int r = 0; r < N; r++) {
			maze[r] = br.readLine().split("");
		}
		
		findBfs(0,0);
		System.out.println(visited[N-1][M-1]);
	}
	
	public static class Pair{				// 큐에 (x,y)인덱스 값을 저장하기 위해 class 생성
		int x;
		int y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
	
	public static void findBfs(int r, int c) {
		Queue<Pair> queue = new LinkedList<>();				// 큐 생성
		queue.offer(new Pair(r,c));
		visited[r][c] = 1;									// 처음위치는 1을 넣어준다(초기화)
		
		while(!queue.isEmpty()) {
			Pair tmp = queue.poll();						// 큐에서 처음껄 꺼내서
			for (int i = 0; i < dir.length; i++) {
				int nx = tmp.x + dir[i][0];					// 방향을 넣어준다 (상하좌우)
				int ny = tmp.y + dir[i][1];
				// 범위 안에 있으면서 길위에 있으며 방문한적이 없으면
				if(isIn(nx,ny) && maze[nx][ny].equals("1") && visited[nx][ny]==0) { 
					queue.offer(new Pair(nx,ny));					// 큐에 넣고
					visited[nx][ny] = visited[tmp.x][tmp.y]+1;		// 이동 카운트를 늘린다.	
				}
			}
		}
		
	}
	public static boolean isIn(int r, int c) {
		return r>=0 && c>=0 && r < N && c < M;
	}

}
