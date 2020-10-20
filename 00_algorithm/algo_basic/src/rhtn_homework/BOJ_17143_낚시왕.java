package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_17143_낚시왕 {

	private static StringBuilder sb = new StringBuilder();
	private static int R,C,M,ans,fish;
	private static Pair[][] map;
	private static Pair[][] mapClone;
	private static int[][] dir = {{0,0},{-1,0},{1,0},{0,1},{0,-1}};
	private static List<Pair> list;
	private static PriorityQueue<Pair> pq;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new Pair[R][C];
		mapClone = new Pair[R][C];
		list = new ArrayList<>();
		pq = new PriorityQueue<>();
		fish = -1;
		
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int r =Integer.parseInt(st.nextToken())-1;
			int c =Integer.parseInt(st.nextToken())-1;
			int s =Integer.parseInt(st.nextToken());
			int d =Integer.parseInt(st.nextToken());
			int z =Integer.parseInt(st.nextToken());
			map[r][c] = new Pair(r,c,i,s,d,z);
			//pq.offer(new Pair(r,c,i,s,d,z));
		}

		ans =0;
		
//		// 1. 오른쪽 이동
//		for (int i = 0; i < C; i++) {
//			// 2.낚시
//			fishing(i);
//			//3. 상어이동
//			moveshark();
//
//		}

		System.out.println(ans);
		
	}
	
	private static void moveshark() {
		
		while(!pq.isEmpty()) {
			Pair p = pq.poll();
			int r = p.r;
			int c = p.c;
			int idx = p.idx;
			if(idx == fish) {
				fish = -1;
				continue;
			}
			int s = p.s;
			int d = p.d;
			int z = p.z;
			
//			for (int j = 0; j < s; j++) {
//				int nr = dir[d][0] + r;
//				int nc = dir[d][1] + c;
//				// 벽이아니라면
//				if(!isIn(nr,nc)){ // 벽이라면 회전
//					d = flip(d);
//					nr = dir[d][0] + r;
//					nc = dir[d][1] + c;
//				}
//				 r = nr;
//				 c = nc;
//			}
			mvShark(r,c,idx,s,d,z);
			//mapClone[r][c] = new Pair(r, c, idx, s, d, z);
		}
		searchShark();
		initMap();
		
	}

	private static void mvShark(int r, int c,int idx, int s, int d, int z) {
		int[] arr =new int[2];
		if(d==4) {
			int nc = 2*(C-1) - c + s;
			nc = nc % (2*(C-1));
			int nd = 3;
			if(nc >= C-1) {
				nc = 2*(C-1)-nc;
				nd = 4;
			}
			//System.out.println(nc +":" + nd);
			mapClone[r][nc] = new Pair(r, nc, idx, s, nd, z);
		}
		else if(d==3) {
			int nc = c + s;
			nc = nc % (2*(C-1));
			int nd = 3;
			if(nc >= C-1) {
				nc = 2*(C-1) -nc;
				nd = 4;
			} 
			//System.out.println(nc +":" + nd);
			mapClone[r][nc] = new Pair(r, nc, idx, s, nd, z);
		}
		else if(d==1) {
			int nr = 2*(R-1) - r + s;
			nr = nr % (2*(R-1));
			int nd = 2;
			if(nr >= R-1) {
				nr = 2*(R-1) - nr;
				nd = 1;
			}
			//System.out.println(nr +":" + nd);
			mapClone[nr][c] = new Pair(nr, c, idx, s, nd, z);
		}else{
			int nr = r + s;
			nr = nr % (2*(R-1));
			int nd = 2;
			if(nr >= R-1) {
				nr = 2*(R-1) -nr;
				nd = 1;
			} 
			//System.out.println(nr +":" + nd);
			mapClone[nr][c] = new Pair(nr, c, idx, s, nd, z);
		}
	}

	private static void initMap() {
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
			if(mapClone[r][c] == null) map[r][c] = null;
			else {
				int x = mapClone[r][c].r;
				int y = mapClone[r][c].c;
				int idx = mapClone[r][c].idx;
				int s = mapClone[r][c].s;
				int d = mapClone[r][c].d;
				int z = mapClone[r][c].z;
				map[r][c] = new Pair(x, y, idx, s, d, z);
				}
			}
		}
		for (Pair[] p:mapClone) {
			Arrays.fill(p, null);
		}
	}

	private static void searchShark() {
		//list.clear();
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if(mapClone[r][c] != null) {
					int x = mapClone[r][c].r;
					int y = mapClone[r][c].c;
					int idx = mapClone[r][c].idx;
					int s = mapClone[r][c].s;
					int d = mapClone[r][c].d;
					int z = mapClone[r][c].z;
					//pq.offer(new Pair(x, y, idx, s, d, z));
					pq.offer(mapClone[r][c]);
				}
			}
		}
	}


	private static void fishing(int person) {
		for (int i = 0; i < R; i++) {
			if(map[i][person] != null) {
				ans+=map[i][person].z;
				fish = map[i][person].idx;
				map[i][person] = null;
				return;
			}
		}
		
	}

	public static class Pair implements Comparable<Pair>{
		int r,c,idx,s,d,z;

	

		public Pair(int r, int c, int idx, int s, int d, int z) {
			super();
			this.r = r;
			this.c = c;
			this.idx = idx;
			this.s = s;
			this.d = d;
			this.z = z;
		}

		@Override
		public int compareTo(Pair o) {
			Integer z1 = this.z;
			Integer z2 = o.z;
			return z1.compareTo(z2);
		}
		
		
	}
	
	public static boolean isIn(int r, int c) {
		return r>=0 && c>=0 && r<R && c <C;
	}
}
