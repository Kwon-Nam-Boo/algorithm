package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_스타트_택시 {

	private static StringBuilder sb = new StringBuilder();
	// guestNum: 현재 게스트의 idx값
	private static int N,M,G,ans,guestNum;
	
	private static int[][] map;
	private static boolean[][] visited;
	private static int[][] dir = {{-1,0},{0,-1},{0,1},{1,0}};
	
	// 시작점, 유저 위치, 각유저 고착 위치
	private static Pair start;
	private static List<Pair> guestS;
	private static List<Pair> guestE;
	
	private static Queue<Pair> queue;
	private static PriorityQueue<Pair> pq;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken())+1;
		M = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		visited = new boolean[N][N];
		
		for (int r = 1; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 1; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		start = new Pair(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),G);
		
		
		guestS = new ArrayList<>();
		guestE = new ArrayList<>();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			guestS.add( new Pair(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),0));
			guestE.add( new Pair(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),0));
			
		}
		ans = G;
		guestNum = -1;
		
		// 1. 시작점 부터 시작한다
		queue = new LinkedList<>();
		queue.offer(start);
		
		pq = new PriorityQueue<>();
		
		
		for (int i = 0; i < M; i++) {
			// 초기화
			queue = new LinkedList<>();
			pq = new PriorityQueue<>();
			visited = new boolean[N][N];
			queue.offer(start);
			
			// 2. 가까운 게스트를 찾아서 이동한다 .(연료가 바닥나거나, 해당 게스트로 가는길이 막혓다면 종료!)
			if(!goToGuest()) {
				ans =-1;
				break;
			}
			
			// 초기화
			visited = new boolean[N][N];
			queue = new LinkedList<>();
			queue.offer(start);
			
			// 3. 해당 게스트의 도착지점까지 이동한다.
			if(!goToDest()) {
				ans =-1;
				break;
			}
			
		}
		System.out.println(ans);
		
	}
	
	public static boolean goToGuest() {
		// 출발점에 게스트가 존재하는 경우 -> 현재 위치부터 그냥 바로 시작한다
		if(search(start.r,start.c)>-1) {
			start = new Pair(start.r,start.c,ans);
			guestS.remove(guestNum);
			return true;
		}
		
		// 가까운 게스트 찾기
		while(!queue.isEmpty()){
			Pair p = queue.poll();
			// 만약 pq(게스트의 우선순위큐)가 비어있거나 연료가 0으로 떨어졋다면 실패!
			if(pq.isEmpty() && p.g== 0) return false;
			for (int i = 0; i < dir.length; i++) {
				int nr = dir[i][0] + p.r;
				int nc = dir[i][1] + p.c;
				
				if(isIn(nr,nc) && map[nr][nc]!=1 && !visited[nr][nc]) {
					// 만약 시작점에 도착했다면, pq에 추가
					if(search(nr,nc)>-1 && p.g !=0) {
						// 게스트 까지 간 거리를 담아서 넘겨준다
						pq.offer(new Pair(nr,nc,ans-p.g+1));
					}
					// 연료가 하나씩 줄어든다
					queue.add(new Pair(nr,nc,p.g-1));
					visited[nr][nc] = true;
				}
			}
		}
		// 게스트를 찾지 못햇다면 실패
		if(pq.isEmpty()) return false;
		
		// 맨앞이 가장 가까운 게스트이다()
		Pair tmp = pq.poll();
		ans = ans - tmp.g;
		// 시작위치를 변경하고 해당 게스트를 제거한다
		start = new Pair(tmp.r,tmp.c,ans);
		search(tmp.r,tmp.c);
		guestS.remove(guestNum);
		return true;
	}
	
	public static boolean goToDest() {
		//출발 지점에 도착지점이 있는 경우  -> 현재 위치부터 그냥 바로 시작한다
		if(guestE.get(guestNum).r == start.r && guestE.get(guestNum).c == start.c ) {
			start = new Pair(start.r,start.c,ans);
			guestE.remove(guestNum);
			return true;
		}
		// 해당 게스트의 도착위치 가기
		while(!queue.isEmpty()){
			Pair p = queue.poll();
			
			for (int i = 0; i < dir.length; i++) {
				int nr = dir[i][0] + p.r;
				int nc = dir[i][1] + p.c;
				if(isIn(nr,nc) && map[nr][nc]!=1 && !visited[nr][nc]) {
					// 만약 시작점에 도착했다면
					if(guestE.get(guestNum).r == nr && guestE.get(guestNum).c == nc) { 
						// 쓴연료 빼고 2배만큼 충전
						ans = p.g-1 + 2*(ans -p.g +1);
						// 시작위치를 변경하고 해당 게스트를 제거한다
						start = new Pair(nr,nc,ans);
						guestE.remove(guestNum);
						return true;
					// 시작점이 아니라면
					}else {
						queue.add(new Pair(nr,nc,p.g-1));
						visited[nr][nc] = true;
					}
				}
			}
			// 연료가 떨어지면 끝
			if(p.g-1 == 0) return false;
		}
		return false;
	}
	
	
	public static class Pair implements Comparable<Pair>{
		int r,c,g;

		public Pair(int r, int c,int g) {
			super();
			this.r = r;
			this.c = c;
			this.g = g;
		}

		
		// 게스트 선택 조건(최단거리, 같으면 행이 작은수, 행도 같으면 열이 작은수)
		@Override
		public int compareTo(Pair o) {
			Integer o1r = o.r;
			Integer o1c = o.c;
			Integer o1g = o.g;
			Integer o2r = this.r;
			Integer o2c = this.c;
			Integer o2g = this.g;
			if(o1g == o2g) {
				if(o1r == o2r) {
					return o2c.compareTo(o1c);
				}return o2r.compareTo(o1r);
			} return o2g.compareTo(o1g);
		}


		
	}
	public static boolean isIn(int r, int c) {
		return r>0 && c>0 && r < N && c < N;
	}
	// 해당 guestS에 해당 r,c의 시작위치가 있는지 없는지 확인 하고 해당 idx 저장
	public static int search(int r, int c) {
		for (int i = 0; i < guestS.size(); i++) {
			if(guestS.get(i).c ==c && guestS.get(i).r ==r) {
				 guestNum = i;
				 return i;
			}
		}
		return -1;
	}
}
