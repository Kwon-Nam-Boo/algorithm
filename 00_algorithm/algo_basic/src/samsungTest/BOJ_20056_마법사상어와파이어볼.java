package samsungTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_20056_마법사상어와파이어볼 {
	
	private static int N,M,K, ans;
	private static List<Pair>[][] map;
	private static List<Pair>[][] mapClone;
	private static int[][] dir = {{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new ArrayList[N][N];
		mapClone = new ArrayList[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = new ArrayList<>();
				mapClone[i][j] = new ArrayList<>();
			}
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			map[r][c].add(new Pair(m,s,d));
		}
		int cnt = 0;
		ans = 0;
		while(true) {
			cnt++;
			// 1. 파이어볼 옮기기
			moveFireball();
			fireballFunc();
			if(cnt == K) break;
		}
		checkFireBall();
		System.out.println(ans);
	}
	
	private static void checkFireBall() {
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				for (int i = 0; i < map[r][c].size(); i++) {
					 ans += map[r][c].get(i).m;
				}
			}
		}
		
	}

	private static void fireballFunc() {
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if(mapClone[r][c].size() >= 2) {
					int m = 0 , s = 0 , d = 0;
					boolean isSame = true;
					
					for (int i = 0; i < mapClone[r][c].size(); i++) {
						Pair p = mapClone[r][c].get(i);
						m+=p.m;
						s+=p.s;
						if(i == 0) {
							if(p.d %2 == 1) d = 1;
						}else {
							if(p.d %2 != d) isSame = false; 
						}
					}
					m/=5;
					// 질량이 0이라면 소멸이니 해줄필요가 없다
					if(m == 0) continue;
					s/=mapClone[r][c].size();
					// 방향 정하기
					if(isSame) {
						for (int i = 0; i < 8; i+=2) {
							map[r][c].add(new Pair(m, s, i));
						}
					}else {
						for (int i = 1; i < 8; i+=2) {
							map[r][c].add(new Pair(m, s, i));
						}
					}
				}
				else if(mapClone[r][c].size() == 1){
					Pair p = mapClone[r][c].get(0);
					map[r][c].add(new Pair(p.m,p.s,p.d));
				}
			}
		}
		// map초기화
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				mapClone[i][j] = new ArrayList<>();
			}
		}
	}

	private static void moveFireball() {
		
		// clone에 파이어볼을 옮겨준다
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				for (int i = 0; i < map[r][c].size(); i++) {
					Pair p = map[r][c].get(i);
					int nr, nc;
					
					// 만약 양수로 범위를 벗어나면 나머지를 구한다
					if(dir[p.d][0]*p.s + r >= 0) {
						nr = (dir[p.d][0]*p.s + r)% N;
					}else {	// 음수로 범위를 벗어나면 해당 숫자보다 큰 N의 배수를 구하고 빼준다 
						int tmp = -(dir[p.d][0]*p.s + r) / N;
						if(-(dir[p.d][0]*p.s + r) % N > 0) tmp++;
						nr = tmp * N + dir[p.d][0]*p.s + r;
					}
					
					if(dir[p.d][1]*p.s + c >= 0) {
						nc = (dir[p.d][1]*p.s + c)% N;
					}else {
						int tmp = -(dir[p.d][1]*p.s+c) / N;
						if(-(dir[p.d][1]*p.s + c) % N > 0) tmp++;
						nc = tmp * N + dir[p.d][1]*p.s +c;
					}
					mapClone[nr][nc].add(new Pair(p.m, p.s, p.d));
				}
			}
		}
		// map초기화
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = new ArrayList<>();
			}
		}
		
	}

	public static class Pair{
		
		int m, s, d;

		public Pair(int m, int s, int d) {
			super();
			this.m = m;
			this.s = s;
			this.d = d;
		}

		@Override
		public String toString() {
			return "Pair [m=" + m + ", s=" + s + ", d=" + d + "]";
		}

		
	}
	
}
