package samsungTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_3190_뱀 {

	private static int N,K,L,head;
	private static List<Pair> apple;
	private static int[] time;
	private static String[] turn;
	private static Deque<Pair> dq;
	private static int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}}; // 상우하좌
	private static boolean end;
	private static boolean[][] visited;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		// 보드크기, 사과 개수, 사과위치
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		apple = new ArrayList<>();
		
		for (int i = 0; i < K ; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			apple.add(new Pair(r,c));
		}
		// 뱀 변환 횟수
		L = Integer.parseInt(br.readLine());
		time = new int[L];
		turn = new String[L];
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			turn[i] = st.nextToken();
		}
		// dq는 사실상 뱀의 몸체 head는 방향이다
		dq = new ArrayDeque<>();
		dq.offer(new Pair(0,0));
		visited = new boolean[N][N];
		visited[0][0] = true;
		head = 1;
		end = false;
		
		int cnt = 0;
		int t = 0;
		
		while(true) {
			snakeHead();
			cnt++;
			if(end) break;
			// 2.사과 체크하기
			checkApple();
			if(t!= L && time[t] == cnt) {
				moveDir(turn[t]);
				t++;
			}
			
		}
		System.out.println(cnt);
	}
	
	private static void moveDir(String d) {
		// 오른쪽으로 90도 회전이라면
		if(d .equals("D")) {
			head = (head+1)%4;
		}else {
			head = (head+3)%4;
		}
		
	}

	private static void checkApple() {
		Pair p = dq.peekFirst();
		
		for (int i = 0; i < apple.size(); i++) {
			Pair tmp = apple.get(i);
			if(tmp.r == p.r && tmp.c == p.c) {
				apple.remove(i);
				return;
			}
		}
		Pair tail = dq.pollLast();
		visited[tail.r][tail.c] = false;
		return;
	}

	private static void snakeHead() {
		Pair p = dq.peekFirst();
		
		int nr = dir[head][0]+ p.r;
		int nc = dir[head][1]+ p.c;
		
		// 범위 밖에 있거나 ..?, 몸체가 존재한다면 ..? (현재로 끝!)
		if(!isIn(nr,nc) || visited[nr][nc]) {
			end = true;
			return;
		}
		dq.addFirst(new Pair(nr,nc));
		visited[nr][nc] = true;
		
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
	
	private static boolean isIn(int r, int c) {
		return r>=0 && c>=0 && r<N && c< N;
	}

}
