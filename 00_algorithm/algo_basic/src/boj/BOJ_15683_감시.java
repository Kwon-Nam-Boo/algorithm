package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15683_감시 {
	
	private static int N;
	private static int M;
	private static int ccSize;
	private static int min;
	private static int[][] map;
	private static int[][] mapClone;
	private static int[][] dir = {{-1,0},{0,-1},{1,0},{0,1}};	// 상 우 하 좌
	private static List<Pair> cctv;
	private static int[] cctvDir;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N =Integer.parseInt(st.nextToken());
		M =Integer.parseInt(st.nextToken());
		map =new int[N][M];
		mapClone =new int[N][M];
		cctv = new ArrayList<>();
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				mapClone[r][c] = map[r][c];
				if(map[r][c]!=0 && map[r][c]!=6) {		// cctv를 좌표를 따로 저장해둔다.
					cctv.add(new Pair(r,c));
				}
			}
		}
		
		ccSize = cctv.size();
		cctvDir = new int[ccSize];			// 현재 cctv의 방향에 대한 조합이 담길 것이다. 
		min = N*M;
		cctv_nPr(0);
		System.out.println(min);
		
	}
	public static void cctv_nPr(int r) {		//  모든 cctv의 가능한 방향 --> 중복 순열
		if(min == 0) return;					//  가지치기
		if(r == ccSize) {
			cctv_kind();						// 가능한 방향중 하나를 함수로 체크한다.
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			cctvDir[r] = i;
			cctv_nPr(r+1);
		}
		
	}
	
	public static void cctv_kind() {				// 해당 종류의 cctv에서의 동작을 나타내는 함수 
		for (int i = 0; i < cctvDir.length; i++) {
			Pair curr = cctv.get(i);
			int currDir = cctvDir[i];
			switch(mapClone[curr.x][curr.y]){		// 해당 순서의 cctv 종류
				
				case 1:								// 단방향일 경우
					move(curr, currDir);
					break;
				case 2:								// 앞뒤 방향
					move(curr, currDir);
					move(curr, (currDir+2)%4);
					break;
				case 3:								// 직각
					move(curr, currDir);
					move(curr, (currDir+1)%4);
					break;
				case 4:
					move(curr, currDir);			// 3방향
					move(curr, (currDir+1)%4);
					move(curr, (currDir+3)%4);
					break;
				case 5:
					move(curr, currDir);			// 4방향
					move(curr, (currDir+1)%4);
					move(curr, (currDir+2)%4);
					move(curr, (currDir+3)%4);
					break;
	
			}
		}
		check();									// 최소 사각지대의 수 검사 및 clone 초기화
		
		if(min == 0) return;						// 가지치기
	}
	private static void move(Pair curr, int currDir) {
		
		int currX = curr.x + dir[currDir][0];
		int currY = curr.y + dir[currDir][1];
		
		if(!isIn(currX,currY)) return;				// 벽이거나 , 범위를 벗어나면 끝
		if(mapClone[currX][currY]==6) return;		
		if(mapClone[currX][currY]==0) {
		mapClone[currX][currY]= mapClone[curr.x][curr.y];	// 빈곳은 해당 cctv의 번호를 매겨주자 
		}
		move(new Pair(currX,currY),currDir);				// 다음칸 이동
		
	}
	public static void check() {
		int count =0;
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if(mapClone[r][c] ==0) {
					count++;
				}
			}
		}
		
		min = Math.min(min,count);				// 최소 크기 찾기
		
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {		// 초기화
				mapClone[r][c] = map[r][c];
			}
		}
	}

	public static class Pair{
		int x;
		int y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return "Pair [x=" + x + ", y=" + y + "]";
		}
		
	}
	public static boolean isIn(int r, int c){
		return r>=0 && c>=0 && r < N && c < M;
	}
}
