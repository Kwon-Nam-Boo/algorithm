package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;


public class BOJ_17837_새로운게임2 {

	private static StringBuilder sb = new StringBuilder();
	private static int N,K;
	private static int[][] map;
	private static List<horse>[][] chess;
	private static Pair[] horseMap;
	private static int[][] dir = {{0,0},{0,1},{0,-1},{-1,0},{1,0}};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		// 체스판 크기, 말의 개수
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		// 맵, 체스맵, 말의 좌표맵
		map = new int[N][N];
		chess = new ArrayList[N][N];
		horseMap = new Pair[K+1];
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				chess[r][c] = new ArrayList<>();
			}
		}
		// 채스맵은 리스트의 이중배열로
		for (int i = 1; i <= K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			chess[r][c].add(new horse(i, Integer.parseInt(st.nextToken())));
			horseMap[i] = new Pair(r,c);
		}
		
		int cnt =0;
		while(true) {
			cnt++;
			// 턴을 돌려본다
			if(!turn()) break;
			if(cnt==1001) {
				cnt =-1;
				break;
			}
		}
		System.out.println(cnt);
	}
	//
	private static boolean turn() {
		for (int i = 1; i <= K; i++) {
			// 원하는 말의 리스트 좌표
			Pair p = horseMap[i];
			// 해당 리스트에서 원하는 idx말의 위치값
			int t = 0;
			
			// 1. 우선 해당 i가 리스트에 있는 위치를 알아내자
			for (int j = 0; j < chess[p.r][p.c].size(); j++) {
				if(chess[p.r][p.c].get(j).idx == i) {
					t = j;
					break;
				}
			}
			// 갈 방향
			int cd = chess[p.r][p.c].get(t).dir;
			// 갈 곳
			int nr = dir[cd][0] + p.r;
			int nc = dir[cd][1] + p.c;
			
			// 2-1. 파란색일 경우, 벽일 경우
			if(!isIn(nr,nc) || map[nr][nc]==2) {
				// 방향전환
				if(cd==1) cd =2;
				else if(cd==2) cd =1;
				else if(cd==3) cd =4;
				else cd = 3;
				chess[p.r][p.c].get(t).dir = cd;
				nr = dir[cd][0] + p.r;
				nc = dir[cd][1] + p.c;
				//2-1-1. 뒤에도 빈칸이거나 파란벽이면? 가만히
				if(!isIn(nr,nc) || map[nr][nc]==2) continue;
			}
			// 2. 해당 말의 위에 올려진 말까지 다 빼주고, 남은 말은 남겨둔다 
			List<horse> tmp = new ArrayList<>();
			for (int j = 0; j < t+1; j++) {
				tmp.add(chess[p.r][p.c].get(0));
				chess[p.r][p.c].remove(0);
			}
			// 2-2. 흰칸일 경우 , 빼준말을 살포시 올려주자
			if( map[nr][nc]==0) {
				for (int j = 0; j < tmp.size(); j++) {
					chess[nr][nc].add(j, tmp.get(j));
				}
			}
			// 2-3. 빨간칸일 경우, 빼준말을 역순으로 올려주자
			if(map[nr][nc]==1) {
				for (int j = 0; j < tmp.size(); j++) {
					chess[nr][nc].add(0, tmp.get(j));
				}
			}
			// 위치 수정(좌표 최신화)
			for (int j = 0; j < tmp.size(); j++) {
				horseMap[tmp.get(j).idx].r = nr;
				horseMap[tmp.get(j).idx].c = nc;
			}
			// 4개이상 쌓였음. 종료조건
			if(chess[nr][nc].size() >= 4) return false;
		}
		return true;
	}
	// 말의 idx와 방향
	public static class horse{
		int idx, dir;

		public horse(int idx, int dir) {
			super();
			this.idx = idx;
			this.dir = dir;
		}

		@Override
		public String toString() {
			return "horse [idx=" + idx + ", dir=" + dir + "]";
		}

	}
	// 좌표 (r,c)
	public static class Pair{
		int r,c;

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
	
	public static boolean isIn(int r, int c) {
		return r>=0 && c>=0 && r<N && c<N;
	}
}
