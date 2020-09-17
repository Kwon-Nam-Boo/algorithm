package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 다리만들기2_크루스칼 {
	
	private static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
	private static int R,C, islandIdx;
	private static int[][] map;
	private static List<Pair> p;
	private static int INF = Integer.MAX_VALUE;
	private static int[] parents,rank;
	

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//br = new BufferedReader(new StringReader(src));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		
		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 1. 다른 번호로 바꾸기 
		islandIdx = 2;
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if(map[r][c] ==1) {
					bfs(r,c);
					islandIdx++;
				}
			}
		}
		
		//2. Pair list 만들기
		p = new ArrayList<>();
		
		//3. 각 섬별로 거리 찾기
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (map[r][c] > 1) {
					makeP(r, c);
				}
			}
		}
		
		Collections.sort(p);
		System.out.println(p);
		parents = new int[islandIdx-2];
		rank = new int[islandIdx-2];
		
		int cnt= 0;
		int result = 0;
		
		for (int i = 0; i < islandIdx-2; i++) {
			makeSet(i);
		}
		
		for (int i = 0; i < p.size(); i++) {
			
			int px = findSet(p.get(i).x);
			int py = findSet(p.get(i).y);
			
			// 부모가 같다면 (이어져있다면) 패스
			if(px == py) continue;
			
			union(px,py);
			result+= p.get(i).w;
			cnt++;
			if(cnt == islandIdx-3) break;
		}
		if(cnt!=islandIdx-3) {
			System.out.println(-1);
		}else {
			System.out.println(result);
		}
		
		
	}
	private static void makeSet(int x){
		parents[x] =x;
	}
	private static int findSet(int x) {
		if(x == parents[x]) {
			return x;
		}else {
			parents[x] = findSet(parents[x]);
			return parents[x];
		}
	}
	private static void union(int x, int y) {
		int fx = findSet(x);
		int fy = findSet(y);
		
		if(rank[fx] > rank[fy]) {
			parents[fy] = fx;
		}else {
			parents[fx] = fy;
			if(rank[fx] == rank[fy]) {
				rank[fy]++;
			}
		}
	}
	
	private static void makeP(int r, int c) {
		int base = map[r][c];
		
		for (int i = 0; i < dir.length; i++) {
			for (int l = 1;; l++) {
				int nr = dir[i][0]*l + r; 
				int nc = dir[i][1]*l + c;
				
				// 벽에 부딪힌 경우 or 자기 자신과 부딛힌경우
				if(!isIn(nr,nc) || map[nr][nc] == base) {
					break;
				}else if(map[nr][nc] == 0) {	// 빈칸인 경우
					continue;
				}else {
					if(l>2) {
						boolean flag = true;
						for (int j = 0; j < p.size(); j++) {
							if(p.get(j).equals(new Pair(map[nr][nc]-2, base-2,l-1))) {
								p.get(j).w = Math.min(p.get(j).w, l-1);
								flag = false;
								break;
							}
						}
						if(flag) {
							p.add(new Pair(map[nr][nc]-2, base-2,l-1));
						}else {
							break;
						}
					}
					break;
				}
			}
		}
		
		
	}

	private static void bfs(int r, int c) {
		Queue<Pair> queue = new LinkedList<>();
		queue.offer(new Pair(r,c,0));
		map[r][c] =islandIdx;
		
		while(!queue.isEmpty()) {
			Pair p = queue.poll();
			
			for (int i = 0; i < dir.length; i++) {
				int nr = dir[i][0] + p.x;
				int nc = dir[i][1] + p.y;
				if(isIn(nr,nc) && map[nr][nc] == 1) {
					queue.offer(new Pair(nr,nc,0));
					map[nr][nc] =islandIdx;
				}
			}
		}
		
	}
	public static class Pair implements Comparable<Pair>{
		int x,y,w;

		public Pair(int x, int y,int w) {
			super();
			this.x = x;
			this.y = y;
			this.w = w;
		}
		
		

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pair other = (Pair) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}


		@Override
		public String toString() {
			return "Pair [x=" + x + ", y=" + y + ", w=" + w + "]";
		}



		@Override
		public int compareTo(Pair o) {
			Integer w1 = this.w;
			Integer w2 = o.w;
			
			return w1.compareTo(w2);
		}
		
	}
	public static boolean isIn(int r, int c) {
		return r>=0 & c>=0 && r<R && c<C;
	}
	
	static String src = "7 8\r\n" + 
			"0 0 0 0 0 0 1 1\r\n" + 
			"1 1 0 0 0 0 1 1\r\n" + 
			"1 1 0 0 0 0 0 0\r\n" + 
			"1 1 0 0 0 1 1 0\r\n" + 
			"0 0 0 0 0 1 1 0\r\n" + 
			"0 0 0 0 0 0 0 0\r\n" + 
			"1 1 1 1 1 1 1 1";
}
