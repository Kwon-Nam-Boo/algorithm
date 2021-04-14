package samsungTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class BOJ_13460_구슬탈출2 {

	private static int N,M, ans;
	private static int[] result;
	private static char[][] map;
	private static Pair R,B;
	private static boolean RtoD, BtoD;
	
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ans = Integer.MAX_VALUE;
		map = new char[N][M];
		
		
		for (int r = 0; r < N; r++) {
			map[r] = br.readLine().toCharArray();
			for (int c = 0; c < M; c++) {
				if(map[r][c] == 'R') {
					 R = new Pair(r,c);
					 map[r][c] = '.';
				}
				else if(map[r][c] == 'B') {
					B = new Pair(r,c);
					 map[r][c] = '.';
				}
			}
		}
		result = new int[10];												// 10번의 이동 중복순열을 담을 배열
		nPr(0);
		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
		
	}
	
	public static void nPr(int r){											// 10개의 이동의 중복수열을 제작한다.
		if(r == 10) {
			int re = checkResult();											// 함수: 10개의 이동을 시켜보고 확인한다.
			if(re > 0 && re < ans) {										// -1(골 도착실패) 가 아니면서 최소 횟수를 저장
				ans = re;
				//System.out.println(Arrays.toString(result));
			}
			return;
		}
		for (int i = 0; i < 4; i++) {
			if(r == 0 || result[r-1]!= i) {									// 가지치기 같은 이동이 연속으로 나오는 경우는 제외한다.
				result[r] = i;												// 위로 두번 해봣자 위로 한번 이동한거와 다를게 없으니깐
				nPr(r+1);
			}
		}
	}
	
	private static int checkResult() {
		int a = -1;
		RtoD = false;
		BtoD = false;
		
		Pair r = new Pair(R.r ,R.c);
		Pair b = new Pair(B.r ,B.c);
		Go g;
		for (int i = 0; i < result.length; i++) {							//10개의 move를 돌린다.
			g = move(result[i], i+1 , r , b);
			
			if(BtoD) break;
			// 빨간색만 들어갔다면? 종료 조건
			if(RtoD) {
				//System.out.println(RtoD + " " + BtoD);
				a = g.cnt;
				break;
			}
			
			r = new Pair(g.r.r , g.r.c);
			b = new Pair(g.b.r, g.b.c);

		}
		return a;	
		
	}
	
	private static Go move(int dir, int cnt ,Pair r, Pair b) {
		// 위쪽으로 이동 일경우
		if(dir == 0) {
			// 높이가 높은곳 먼저 구슬이동
			if(r.r<= b.r) {
				// R 먼저
				r.r = moveUp(r.r ,r.c , 0, b.r, b.c);
				// B 이후
				b.r = moveUp(b.r ,b.c , 1, r.r, r.c);
			}else {
				// B 먼저
				b.r = moveUp(b.r ,b.c , 1, r.r, r.c);
				// R 이후
				r.r = moveUp(r.r ,r.c , 0, b.r, b.c);
			}
			
		}else if(dir == 1) {
			// 높이가 낮은곳 먼저 구슬이동
			if(r.r > b.r) {
				// R 먼저
				r.r = moveDown(r.r ,r.c ,0, b.r, b.c);
				// B 이후
				b.r = moveDown(b.r ,b.c ,1,r.r ,r.c);
			}else {
				// B 먼저
				b.r = moveDown(b.r ,b.c ,1,r.r ,r.c);
				// R 이후
				r.r = moveDown(r.r ,r.c ,0, b.r, b.c);
			}
						
		}else if(dir == 2) {	// 왼쪽
			// 너비가 왼쪽인곳 높은곳 먼저 구슬이동
			if(r.c < b.c) {
				// R 먼저
				r.c = moveLeft(r.r ,r.c ,0, b.r, b.c);
				// B 이후
				b.c = moveLeft(b.r ,b.c ,1,r.r ,r.c);
			}else {
				// B 먼저
				b.c = moveLeft(b.r ,b.c ,1,r.r ,r.c);
				// R 이후
				r.c = moveLeft(r.r ,r.c ,0, b.r, b.c);
			}
						
		}else if(dir == 3) {
			// 높이가 높은곳 먼저 구슬이동
			if(r.c >= b.c) {
				// R 먼저
				r.c = moveRight(r.r ,r.c ,0, b.r, b.c);
				// B 이후
				b.c = moveRight(b.r ,b.c ,1,r.r ,r.c);
			}else {
				// B 먼저
				b.c = moveRight(b.r ,b.c ,1,r.r ,r.c);
				// R 이후
				r.c = moveRight(r.r ,r.c ,0, b.r, b.c);
			}			
		}
		return new Go(dir, cnt, r, b);
	}

	private static int moveRight(int r, int c, int color, int or, int oc) {
		for (int i = c+1; i < M ; i++) {
			if(map[r][i]  == 'O') {
				if(color == 0)
					RtoD = true;
				else
					BtoD = true;
				c =-1;
				break;
			}
			// 벽이나 구슬을 만나면
			if(map[r][i] == '#' || (r == or && i == oc)) break;
			c++;
		}
		return c;
	}

	private static int moveLeft(int r, int c, int color, int or, int oc) {
		
		for (int i = c-1; i >=0 ; i--) {
			if(map[r][i]  == 'O') {
				if(color == 0)
					RtoD = true;
				else
					BtoD = true;
				c =-1;
				break;
			}
			// 벽을 만나면 
			if(map[r][i] == '#' || (r == or && i == oc)) break;
			
			c--;
		}
		return c;
	}

	private static int moveDown(int r, int c, int color, int or, int oc) {
		
		for (int i = r+1; i < N ; i++) {
			if(map[i][c]  == 'O') {
				if(color == 0)
					RtoD = true;
				else
					BtoD = true;
				r =-1;
				break;
			}
			// 벽을 만나면 
			if(map[i][c] == '#' || (i == or && c == oc) ) break;
			r++;
		}
		return r;
	}

	private static int moveUp(int r, int c, int color, int or, int oc) {
		
		for (int i = r-1; i >=0 ; i--) {
			if(map[i][c]  == 'O') {
				if(color == 0)
					RtoD = true;
				else
					BtoD = true;
				r =-1;
				break;
			}
			// 벽을 만나면 
			if(map[i][c] == '#' || (i == or && c == oc)) break;
			r--;
		}
		return r;
	}

	public static class Go{
		int dir, cnt;
		Pair r, b;
		
		public Go(int dir, int cnt, Pair r, Pair b) {
			super();
			this.dir = dir;
			this.cnt = cnt;
			this.r = r;
			this.b = b;
		}

		@Override
		public String toString() {
			return "Go [dir=" + dir + ", cnt=" + cnt + ", r=" + r + ", b=" + b + "]";
		}
		
		
	
	}

	public static class Pair{
		int r, c;
		
		public Pair(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Pair [r=" + r + ", c=" + c + "]";
		}		
		
	}

}
