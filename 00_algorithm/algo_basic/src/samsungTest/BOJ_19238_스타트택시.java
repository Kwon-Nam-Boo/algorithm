package samsungTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_19238_스타트택시 {
	
	private static int N,M,gas, ans, desIdx;
	private static int[][] map;
	private static boolean[][] visited;
	private static int[][] dir = {{-1,0},{0,-1},{1,0},{0,1}};
	private static Pair start;
	private static List<Pair> customer;
	private static List<Pair> dest;
	
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		gas = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		start = new Pair(Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())-1, gas);
		customer = new ArrayList<>();
		dest = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			customer.add(new Pair(Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())-1,0));
			dest.add(new Pair(Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())-1,0));
		}
		
		ans = 0;
		// 가야할 곳의 idx입니다
		desIdx = -1;
		
		// 가야할 손님을 찾는다
		for (int i = 0; i < M; i++) {
			// 손님을 찾아 이동합니다
			goNextCustomer();
			if(ans == -1) break;
			// 해당 손님의 목적지로 이동합니다
			goNextDest();
			if(ans == -1) break;
		}
		System.out.println(ans);
	}
	
	private static void goNextDest() {
		// 만약 시작하자마자 도착점이라면? 해당경우 삭제후 return만 해주면됨
		if(dest.get(desIdx).r == start.r && dest.get(desIdx).c == start.c){
			dest.remove(desIdx);
			ans = start.g;
			return;
		}
		
		visited = new boolean[N][N];
		Queue<Pair> queue = new LinkedList<>();
		queue.offer(start);
		visited[start.r][start.c] = true;
		
		while(!queue.isEmpty()) {
			
			Pair p = queue.poll();
			
			for (int i = 0; i < dir.length; i++) {
				int nr = dir[i][0] + p.r;
				int nc = dir[i][1] + p.c;
				if(isIn(nr,nc) && !visited[nr][nc] && map[nr][nc] == 0) {
					// 해당 위치가 도착점이라면 값 갱신후 고객삭제
					if(dest.get(desIdx).r == nr && dest.get(desIdx).c == nc) {
						start.r = nr;
						start.c = nc;
						start.g = 2*start.g - p.g + 1;
						dest.remove(desIdx);
						ans = start.g;
						return;
					}
					if(p.g-1 > 0) {
						queue.offer(new Pair(nr,nc,p.g-1));
						visited[nr][nc] = true;
					}
					
				}
			}
		}
		// 만약 도착점을 찾지못하면 -1
		ans = -1;
		return;
		
	}


	private static void goNextCustomer() {
		// 시작하자마자 고객이 있다면? 고객삭제후 리턴
		if(checkCustomer(start.r,start.c)) {
			customer.remove(desIdx);
			return;
		}
		visited = new boolean[N][N];
		
		
		Queue<Pair> queue = new LinkedList<>();
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		queue.offer(start);
		visited[start.r][start.c] = true;
		
		while(!queue.isEmpty()) {
			
			Pair p = queue.poll();
			
			for (int i = 0; i < dir.length; i++) {
				int nr = dir[i][0] + p.r;
				int nc = dir[i][1] + p.c;
				if(isIn(nr,nc) && !visited[nr][nc] && map[nr][nc] == 0) {
					// 고객을 찾았다면 우선 pq에 넣어주자
					if(checkCustomer(nr,nc)) {
						pq.offer(new Pair(nr,nc,p.g-1));
					}
					if(p.g-1 > 0) {
						queue.offer(new Pair(nr,nc,p.g-1));
						visited[nr][nc] = true;
					}
					
				}
			}
		}
		
		// 만약 도착점을 찾지못하면 -1
		if(pq.isEmpty()) ans = -1;
		
		else {	// PQ중 가장 처음값이 우리가 원하는 값일 것이다.
			Pair p = pq.poll();
			// 해당 idx를 구하기위해 그냥 한번 돌린다
			checkCustomer(p.r, p.c);
			customer.remove(desIdx);
			start = new Pair(p.r, p.c, p.g);
		}
		return;
		
	}

	private static boolean checkCustomer(int r , int c) {
		for (int i = 0; i < customer.size(); i++) {
			Pair cus = customer.get(i);
			if(cus.r == r && cus.c ==c) {
				desIdx = i;
				return true;
			}
		}
		return false;
	}

	public static class Pair implements Comparable<Pair>{
		int r,c, g;

		
		public Pair(int r, int c, int g) {
			super();
			this.r = r;
			this.c = c;
			this.g = g;
		}


		@Override
		public String toString() {
			return "Pair [r=" + r + ", c=" + c + ", g=" + g + "]";
		}
		
		
		@Override
		public int compareTo(Pair o) {
			if(this.g == o.g) {
				if(this.r == o.r) {
					return Integer.compare(this.c, o.c);
				}
				return Integer.compare(this.r, o.r);
			}
			return Integer.compare(o.g, this.g);
		}

		
	}
	
	public static boolean isIn(int r, int c) {
		return r>=0 && c>=0 && c< N && r<N;
	}
}
