package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_2382_T_미생물_격리 {
	
	private static int N;			// 크기
	private static int M;			// 경과 시간
	private static int K;			// 군집 수
	private static Queue<micro> queue;
	private static micro[][] map;
	private static int[][] dir= {{},{-1,0},{1,0},{0,-1},{0,1}}; // 상: 1, 하: 2, 좌: 3, 우: 4

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <= TC; t++) {
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new micro[N][N];
			queue = new LinkedList<>();
			for (int k = 0; k < K; k++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());		// 세로위치
				int y = Integer.parseInt(st.nextToken());		// 가로위치
				int c = Integer.parseInt(st.nextToken());		// 미생물 수
				int d = Integer.parseInt(st.nextToken());		// 이동방향
				queue.offer(new micro(x,y,c,d,c));
			}
			
			
			for (int k = 0; k < M; k++) {
				for (micro[] m1 : map) {			// map 초기화 (항상 새 도화지에 시작한다)
					Arrays.fill(m1, null);
				}
				bfs();
			}
			
			int sum=0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {		// 마지막 map의 값을 다 더해준다.
					if(map[i][j]!=null) {
						sum+=map[i][j].c;
					}
				}
			}
			sb.append(sum).append("\n");
		}
		System.out.println(sb);
	}

	public static void bfs() {
		int size = queue.size();
		
		while(size>0) {
			micro m = queue.poll();
			int nx = m.x + dir[m.d][0];		// 현재 세로 위치 + 이동방향 한칸 이동
			int ny = m.y + dir[m.d][1];		// 현재 가로 위치 + 이동방향 한칸 이동
			int nc = m.c;
			int nd = m.d;
			int nm = m.c;					// 현재 map에 들어온 미생물중 많았던 미생물 수
			if(!outOfBound(nx, ny)){			// 울타리 안에 없다면
				nc = m.c /2;
				if(nd%2==0) {				// 미생물 타노스, 방향 전환
					nd--;
				}else {
					nd++;
				}
			}
			if(map[nx][ny] == null) {				// 아직 map에 들어온적이 없다면
				map[nx][ny] = new micro(nx, ny, nc, nd, nm);
			}else {
				map[nx][ny].c+=nc;
				if(map[nx][ny].m < nm) {			// 들어올 미생물이 더 큰 값이라면
					map[nx][ny].d = nd;				// 큰값으로 방향, m 값 바꾼다
					map[nx][ny].m = nm;
				}
			}
			size--;
		}
		for (int i = 0; i < N; i++) {							
			for (int j = 0; j < N; j++) {
				if(map[i][j]!=null) queue.offer(map[i][j]);		// 현재의 map에 있는 수를 queue에 넣는다.
			}
		}
	}
	
	public static class micro{
		int x;
		int y;
		int c;
		int d;
		int m;
		
		public micro(int x, int y, int c, int d, int m) {
			this.x = x;
			this.y = y;
			this.c = c;
			this.d = d;
			this.m = m;
		}
	
	}
	
	public static boolean outOfBound(int r, int c) {		// 울타리 안에 있는가
		return r>0 && c>0 && r< N-1 && c< N-1;
	}
}
