package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_19237_어른상어 {

	private static StringBuilder sb = new StringBuilder();
	private static int[][] dir = {{0,0},{-1,0},{1,0},{0,-1},{0,1}};
	private static int N,M,K;
	private static Pair[][] map;
	private static Pair[][] mapClone;
	private static int[][][] prior;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		// 격자크기, 상어수, 냄새 생명주기
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		// map과 clone
		map = new Pair[N][N];
		mapClone = new Pair[N][N];
		
		// 상어리스트, 쫒아낼 상어 리스트
		List<Shark> list = new ArrayList<>();
		List<Integer> rmlist = new ArrayList<>();
		
		// 입력된 값을 넣는다
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = new Pair(false,Integer.parseInt(st.nextToken()), 0);
				if(map[r][c].shark !=0) {
					map[r][c].smell = K;
					map[r][c].isIn = true;
					list.add(new Shark(r, c, map[r][c].shark ,-1));
				}
				mapClone[r][c] = map[r][c];
			}
		}

		// 상어를 역순으로 정렬(idx가 큰 상어는 작은 상어한테 쫒겨나기 때문에 먼저 실행하려고)
		st = new StringTokenizer(br.readLine());
		Collections.sort(list);
		for (int i = M-1; i >= 0; i--) {
			list.get(i).dir = Integer.parseInt(st.nextToken());
		}
		// 우선순위 저장
		prior = new int[M][4][4];
		for (int n = 0; n < M; n++) {
			for (int r = 0; r < 4; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < 4; c++) {
					prior[n][r][c] = Integer.parseInt(st.nextToken());
				}
			}
		}

		int q =0;
		while(true) {
			// 1000초가 넘어가면 -1 출력
			if(q == 1001) {
				q = -1;
				break;
			}
			// 상어 한마리만 남으면 끝!
			if(list.size()==1) break;
			// 남은 상어를 이동시킨다
			for (int i = 0; i < list.size(); i++) {
				// 4방향으로 빈칸 유무 flag
				boolean noNull = true;
				// 현재상어의 4방향 탐색(빈칸찾기)
				for (int j = 1; j < dir.length; j++) {
					Shark sh = list.get(i);
					int px = dir[prior[sh.num-1][sh.dir-1][j-1]][0] + sh.x;
					int py = dir[prior[sh.num-1][sh.dir-1][j-1]][1] + sh.y;
					
					// 만약 빈칸이라면(아직 안옮긴것과 비교해서)
					if(isIn(px,py) && map[px][py].smell == 0) {
						// 냄새를 남긴다
						mapClone[sh.x][sh.y].isIn = false;
						// 만약 이미 상어가 있다면 쫓아버리게 따로 리스트에 저장해둔다
						if(mapClone[px][py].isIn) {
							rmlist.add(mapClone[px][py].shark);
						}
						// 이동한다
						mapClone[px][py] = new Pair(true, mapClone[sh.x][sh.y].shark, K+1);
						list.set(i, new Shark(px, py, sh.num, prior[sh.num-1][sh.dir-1][j-1]));
						noNull=false;
						break;
					}
				}
				// 빈칸이 없다면 자신의 냄새가 있는 칸의 방향
				if(noNull) {
					for (int j = 1; j < dir.length; j++) {
						Shark sh = list.get(i);
						int px = dir[prior[sh.num-1][sh.dir-1][j-1]][0] + sh.x;
						int py = dir[prior[sh.num-1][sh.dir-1][j-1]][1] + sh.y;
						
						// 만약 빈칸이라면(아직 안옮긴것과 비교해서)
						if(isIn(px,py) && map[px][py].shark == mapClone[sh.x][sh.y].shark) {
							// 냄새를 남긴다
							mapClone[sh.x][sh.y].isIn=false;
							// 이동한다
							mapClone[px][py] = new Pair(true, mapClone[sh.x][sh.y].shark, K+1);
							list.set(i, new Shark(px, py, sh.num, prior[sh.num-1][sh.dir-1][j-1]));
							break;
						}
					}
				}
			}
			// 쫒아낼 리스트에 있는 상어를 삭제한다
			for (int i = 0; i < rmlist.size(); i++) {
				for (int j = 0; j < list.size(); j++) {
					if(list.get(j).num == rmlist.get(i)) {
						list.remove(j);
						break;
					}
				}
			}
			// 냄새 카운트를 하나씩 다운
			rmSmell();
			// map을 mapClone으로 초기화
			init();
			q++;
		}
		System.out.println(q);
		
	}
	private static void rmSmell() {
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if(mapClone[r][c].smell>0) mapClone[r][c].smell--;
			}
		}
		
	}
	private static void init() {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				map[r][c] = mapClone[r][c];
			}
		}
	}
	
	public static class Shark implements Comparable<Shark>{
		int x,y,num,dir;

		public Shark(int x, int y, int num, int dir) {
			super();
			this.x = x;
			this.y = y;
			this.num = num;
			this.dir = dir;
		}

		@Override
		public int compareTo(Shark o) {
			Integer num1= this.num;
			Integer num2 = o.num;
			return num2.compareTo(num1);
		}
	}
	
	public static class Pair{
		Boolean isIn;
		int shark, smell;
		
		public Pair(Boolean isIn, int shark, int smell) {
			super();
			this.isIn = isIn;
			this.shark = shark;
			this.smell = smell;
		}
	}
	public static boolean isIn(int r, int c) {
		return r>=0 && c>=0 && r<N && c<N; 
	}
}
