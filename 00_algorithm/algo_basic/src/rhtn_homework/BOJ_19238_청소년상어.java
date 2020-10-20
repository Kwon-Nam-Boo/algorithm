package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_19238_청소년상어 {

	private static StringBuilder sb = new StringBuilder();
	private static Pair[][] map;
	private static Pair[][] mapClone;
	private static List<Pair> list;
	private static int[][] dir = {{-1,0},{-1,-1},{0,-1},{1,-1},{1,0},{1,1},{0,1},{-1,1}};
	private static int ans;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		map = new Pair[4][4];
		mapClone = new Pair[4][4];
		//
		list = new ArrayList<>();
		list.add(new Pair(-1,-1,-1,-1));
		int cnt = 0;
		for (int r = 0; r < 4; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < 4; c++) {
				map[r][c] = new Pair(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),r,c);
				if(r ==0 && c ==0) {
					cnt = map[r][c].x;
					map[r][c].x = -1;
					continue;
				}
				int a = map[r][c].x;
				int b = map[r][c].dir;
				list.add(new Pair(a,b, r, c));
			}
		}
		Collections.sort(list);
		Pair shark = new Pair(-1, map[0][0].dir, 0, 0);
		ans = 0;
		dfs(map,shark, cnt);
		System.out.println(ans);
	}
	
	private static void dfs(Pair[][] map, Pair shark, int cnt) {
		moveFish(map);
		for (int i = 1; i <= 4; i++) {
			int nr = dir[shark.dir-1][0]*i + shark.r;
			int nc = dir[shark.dir-1][1]*i + shark.c;
			if(!isIn(nr,nc)) {
				 ans = Math.max(ans, cnt);
				 return;
			}
			// 물고기라면?
			if(map[nr][nc].x !=0) {
				// 넘겨줄 map 생성
				Pair[][] next_map = new Pair[4][4];
				for (int r = 0; r < 4; r++) {
					for (int c = 0; c < 4; c++) {
						next_map[r][c] = new Pair(map[r][c].x,map[r][c].dir,r,c);
					}
				}
				// 상어 위치 이동 및 원래위치 0으로
				int tmp = next_map[nr][nc].x;
				next_map[shark.r][shark.c].x = 0;
				next_map[nr][nc].x = -1;
				// 물고기 리스트 최신화
				initList(next_map);
				dfs(next_map, new Pair(-1, next_map[nr][nc].dir, nr, nc),cnt + tmp);
				// 물고기 리스트 최신화
				initList(map);
			}
		}
		
	}
	// 생선 이동
	private static void moveFish(Pair map[][]) {
		for (int i = 1; i < list.size(); i++) {
			Pair p = list.get(i);
			for (int j = 0; j < 8; j++) {
				int nr = dir[(p.dir+j-1)%8][0] + p.r;
				int nc = dir[(p.dir+j-1)%8][1] + p.c;
				// 상어나, 벽일 경우 패스
				if(!isIn(nr,nc) || map[nr][nc].x == -1) {
					 continue;
				}
				else {
					// 현재 방향 최신화
					p.dir = (p.dir+j-1)%8 +1;
					map[p.r][p.c].dir = p.dir;
					
					// swap x,dir
					int px = map[p.r][p.c].x;
					int pdir = map[p.r][p.c].dir;
					int tx = map[nr][nc].x;
					int tdir = map[nr][nc].dir;
					map[nr][nc].x = px;
					map[nr][nc].dir = pdir;
					map[p.r][p.c].x = tx;
					map[p.r][p.c].dir = tdir;
					// 물고기 리스트 최신화
					initList(map);
					break;
				}
			}	
		}
	}
	// 물고기 리스트 최신화
	private static void initList(Pair map[][]) {
		list.clear();
		list.add(new Pair(-1,-1,-1,-1));
		for (int r = 0; r < 4; r++) {
			for (int c = 0; c < 4; c++) {
				int a = map[r][c].x;
				int b = map[r][c].dir;
				if(map[r][c].x >0) list.add(new Pair(a,b,r,c));
			}
		}
		Collections.sort(list);
	}
	
	public static class Pair implements Comparable<Pair>{
		int x,dir,r,c;

		public Pair(int x, int dir, int r, int c) {
			super();
			this.x = x;
			this.dir = dir;
			this.r = r;
			this.c = c;
		}
		
		// x가 작은순으로 정렬
		@Override
		public int compareTo(Pair o) {
			Integer x1 = this.x;
			Integer x2 = o.x;
			return x1.compareTo(x2);
		}
		
	}
	private static boolean isIn(int r, int c) {
		return r>=0 && c>=0 && r<4 && c<4;
	}
	
}
