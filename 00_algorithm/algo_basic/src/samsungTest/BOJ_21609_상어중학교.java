package samsungTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_21609_상어중학교 {

	private static int N,M, gr,gc,max, grain;
	private static int[][] map;
	private static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
	private static boolean[][] visited;
	private static boolean[][] visited2;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		
		// 0 은 무지개 , -1은 돌 , -2는 빈칸으로 할것이다
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		int ans = 0;
		while(true) {
			visited = new boolean[N][N];
			
			max = 0;
			gr = -1;
			gc = -1;
			grain = 0;
			
			// 가장 큰 블럭덩어리 찾기
			findBlock();
			// 종료 조건: 만약위의 블럭찾기를  한번도 하지 못했다면? 
			if(max == 0) break;
			// 블럭제거하기
			removeBlock(gr,gc);
			ans+=(max*max);

			// 중력 -> 회전 -> 중력
			gravity();
			rotate();
			gravity();
			
		}
		System.out.println(ans);

		
	}
	private static void findBlock() {
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				// 방문한적 없고, 일반 블럭에 한에서만 bfs를 돌린다
				if(!visited[r][c] && map[r][c] > 0) {
					bfs(r,c);
				}
			}
		}
		
	}
	// 4. 격자가 90도 반시계 방향으로 회전한다
	private static void rotate() {
		int[][] mapClone = new int[N][N];
		
		// 회전된걸 임시map에 넣어두고 , 그걸 다시 map으로
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				mapClone[r][c] = map[c][N-1-r];
			}
		}
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				map[r][c] = mapClone[r][c];
			}
		}
		
	}
	// 3. 격자에 중력이 작용한다
	private static void gravity() {
		Queue<Integer> queue = new LinkedList<>();
		
		for (int c = 0; c < N; c++) {
			queue = new LinkedList<>();
			for (int r = N-1; r >= 0; r--) {
				// 역순으로 빈칸이 아니라면 넣어둔다
				if(map[r][c] != -2) {
					queue.offer(map[r][c]);
				}
				// 만약 돌맹이가 아니라면(블럭이라면) 싹비운다
				if(map[r][c] >=0) {
					map[r][c] = -2;
				}
			}
			
			for (int r = N-1; r >= 0; r--) {
				// 큐가 비었다면, 더이상 넣어줄 블럭이없는것
				if(queue.isEmpty()) break;
				// 빈칸이라면 넣어준다
				if(queue.peek() != -1 && map[r][c] == -2) map[r][c] = queue.poll();
				// 만약 넣어줄 블럭이 -1이라면, 만날때 까지 넘긴다
				else if(queue.peek() == -1 && map[r][c] != -1) continue;
				// 만약 넣어줄 블럭이 -1이라면, -1을 만났다면 큐에서 빼주기만 한다
				else if(queue.peek() == -1 && map[r][c] == -1) queue.poll();
				
			}
		}
		
	}
	
	// 2. 1에서 찾은 블록 그룹의 모든 블록을 제거한다
	// gr,gc를 넣어서 bfs를 돌리고 해당블럭그룹을 -2(빈칸)으로 바꿔준다
	private static void removeBlock(int r, int c) {
		Queue<Pair> queue = new LinkedList<>();
		queue.offer(new Pair(r,c));
		int stand = map[r][c];
		map[r][c] = -2;
		
		while(!queue.isEmpty()) {
			Pair p = queue.poll();
			
			for (int i = 0; i < dir.length; i++) {
				int nr = dir[i][0] + p.r;
				int nc = dir[i][1] + p.c;
				if(isIn(nr,nc) && (map[nr][nc] == stand || map[nr][nc] == 0)){
					queue.offer(new Pair(nr,nc));
					map[nr][nc] = -2;
				}
			}
		}
	}
	
	// 1. 크기가 가장 큰 블록 그룹을 찾는다.
	private static void bfs(int r, int c) {
		// 해당위치에서의 그룹을 만들기위해 따로 방문처리를 만들어 사용한다
		visited2 = new boolean[N][N];
		Queue<Pair> queue = new LinkedList<>();
		queue.offer(new Pair(r,c));
		visited2[r][c] = true;
		visited[r][c] = true;
		// 현재 그룹에서의 블럭개수, 기준점, 무지개개수
		int cnt = 1 , sr = r, sc = c , rain = 0;
		int stand = map[r][c];

		while(!queue.isEmpty()) {
			Pair p = queue.poll();
			
			for (int i = 0; i < dir.length; i++) {
				int nr = dir[i][0] + p.r;
				int nc = dir[i][1] + p.c;
				// 범위안에 있고, 방문하지 않은 점중에서 무지개 or 시작점의 색깔일 경우 그룹화 가능
				if(isIn(nr,nc) && !visited2[nr][nc] && (map[nr][nc] == stand || map[nr][nc] == 0)){
					cnt++;
					queue.offer(new Pair(nr,nc));
					visited2[nr][nc] = true;
					visited[nr][nc] = true;
					
					if(map[nr][nc] ==0) rain++;
					// 기준블럭 찾기(무지개 블럭은 제외)
					else if(map[nr][nc] !=0) {
						// 작은행
						if(sr> nr) {
							sr = nr;
							sc = nc;
						}else if(sr == nr) {
							// 작은열
							if(sc > nc) {
								sr = nr;
								sc = nc;
							}
						}
					}
					
				}
			}
		}
		// cnt가 1 -> 블록그룹의 조건에 불충분할시 넘어간다
		if(cnt == 1) return;
		
		// 블록그룹중에서 
		// 조건1. 가장 큰 블럭이면
		if(max < cnt) {
			max = cnt;
			gr = sr;
			gc = sc;
			grain = rain;
		}else if(max == cnt) {
			// 조건 2. 무지개블럭이 많을것부터
			if(grain < rain) {
				max = cnt;
				gr = sr;
				gc = sc;
				grain = rain;
			}else if(grain == rain) {
				// 조건3. 행이 큰것부터
				if(gr < sr) {
					max = cnt;
					gr = sr;
					gc = sc;
					grain = rain;
				}else if(gr == sr) {
					// 조건. 열이 큰것부터 
					if(gc < sc) {
						max = cnt;
						gr = sr;
						gc = sc;
						grain = rain;
					}
				}
			}
			
		}
		
		
	}

	public static class Pair{
		int r, c;

		public Pair(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	
	public static boolean isIn(int r, int c) {
		return r>=0 && c>=0 && r<N && c<N;
	}
}
