package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_5653_T_줄기세포배양 {

	private static int N;
	private static int M;
	private static int K;
	private static int A;
	private static int B;
	
	private static Pair[][] map;
	private static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
	private static StringBuilder sb;
	
	

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= TC; i++) {
			sb.append("#").append(i).append(" ");
			st =  new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			A = N+K;
			B = M+K;
			map = new Pair[A][B];
			
			for (int r = 0; r < A; r++) {
				for (int c = 0; c < B; c++) {
					map[r][c] = new Pair(r,c,0,0,0);
				}
			}
		
			/*for (int r = A/2-1; r < A/2-1+N; r++) {
				st =  new StringTokenizer(br.readLine());
				for (int c =B/2-1; c < B/2-1+M; c++) {
					map[r][c] = new Pair(r,c,Integer.parseInt(st.nextToken()),0,0);
				}
			}*/
			for(int r = K/2; r < K/2+N; r++) {
				st =  new StringTokenizer(br.readLine());
				for (int c =K/2; c < K/2+M; c++) {
					map[r][c] = new Pair(r,c,Integer.parseInt(st.nextToken()),0,0);
				}
			}
			virus();
			
		}
		System.out.println(sb);
		
		
		
	} // end of main
	
	
	private static void virus() {
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		
		// K시간 동안 돌린다 ~
		for (int j = 1; j <= K; j++) {
			
			/*for (int r = 0; r < A; r++) {
				for (int c = 0; c < B; c++) {
					System.out.print(map[r][c].v + " ");
				}
				System.out.println();
			}System.out.println();*/
			
			for (int r = 0; r < A; r++) {
				for (int c = 0; c < B; c++) {
					// 죽은 세포가 아니고, 세포가 0이 아닐때 
					if(map[r][c].state != -1 && map[r][c].v !=0 ) {
						// 활성화 된 세포를 만나게 되면 ..? 큐에넣기
						if(map[r][c].state == 1) {
							pq.offer(map[r][c]);
						}
						// 시간이 증가한다
						map[r][c].time++;
						
						// 만약 시간과 v가 같다면??? --> 활성화 시켜주자
						if(map[r][c].v == map[r][c].time) {
							map[r][c].state = 1;
						}
						// 만약 시간과 v*2가 같다면??? --> dead 시켜주자
						if(map[r][c].v *2 == map[r][c].time) {
							map[r][c].state = -1;
						}
					}
					
				}
			}
			
			while(!pq.isEmpty()) {
				Pair tmp = pq.poll();
				
				for (int i = 0; i < dir.length; i++) {
					int nx = dir[i][0] + tmp.x;
					int ny = dir[i][1] + tmp.y;
					// 빈칸인 경우
					if(map[nx][ny].v == 0) {
						map[nx][ny] = new Pair(nx,ny,tmp.v,0,0);
					}
				}
			}
			
		}//end of K
		
		// 세포 개수 세기
		int cnt =0;
		for (int j1 = 0; j1 < A; j1++) {
			for (int j2 = 0; j2 < B; j2++) {
				if(map[j1][j2].state != -1 && map[j1][j2].v !=0) {
					cnt++;
				}
			}
			
		}
		sb.append(cnt).append("\n");
		
	}


	public static class Pair implements Comparable<Pair>{
		int x,y,v;
		int state;	// 상태 -1:dead 0:deactivate 1:activate
		int time;	// 시간
		
		public Pair(int x, int y, int v, int state, int time) {
			super();
			this.x = x;
			this.y = y;
			this.v = v;
			this.state = state;
			this.time = time;
		}

		@Override
		public int compareTo(Pair o) {
			Integer v1 = this.v;
			Integer v2 = o.v;
			
			return v2.compareTo(v1);
		}
			
	}
}// end of class
