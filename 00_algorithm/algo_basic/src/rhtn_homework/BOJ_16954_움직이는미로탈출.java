package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class BOJ_16954_움직이는미로탈출 {
	
	private static char[][] map = new char[8][8];
	private static char[][] nextMap = new char[8][8];
	
	// 8방향 + 제자리(밑에방향의 경우는 없을줄 알았는데 있더라 ...)
	private static int[][] dir = {{-1,0},{-1,1},{-1,-1},{0,1},{0,-1},{0,0},{1,0},{1,1},{1,-1}};

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 8; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < 8; j++) {
				nextMap[i][j] = map[i][j];
			}
		}
		System.out.println(bfs());

	}



	private static int bfs() {
		PriorityQueue<Pair> queue = new PriorityQueue<>();
		queue.offer(new Pair(7,0));
		
		// 사실 8바퀴 안에 쇼부가 난다
		while(!queue.isEmpty()) {
			
			int l = queue.size();
			
			// 벽돌이동의 가정값 구하기 , 근데 만약 brick이 비었다? 무조건 1이다(무조건 탈출가능하기 때문)
			if(brick()) return 1;
			
			// 한 바퀴만큼 작업
			for (int i = 0; i < l; i++) {
				Pair p = queue.poll();
				for (int j = 0; j < dir.length; j++) {
					int nr = dir[j][0] + p.r;
					int nc = dir[j][1] + p.c;
					if(isIn(nr,nc) && nextMap[nr][nc]=='.' && map[nr][nc]=='.') {
						if(nr == 0 && nc ==7) return 1;
						queue.offer(new Pair(nr,nc));
					}
				}
			}
			
			// 사실상 진짜 벽돌이동(map을 다을 벽돌로 교체)
			change();
		}
		return 0;
	}

	private static boolean brick() {
		boolean check =false;
		for (int i = 6; i >=0; i--) {
			for (int j = 0; j < 8; j++) {
				nextMap[i+1][j] = map[i][j];
				if(nextMap[i+1][j] == '#') check=true;
			}
		}
		Arrays.fill(nextMap[0], '.');
		if(check) return false;
		else return true;
	}
	
	
	private static void change() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				map[i][j] = nextMap[i][j];
			}
		}
	}

	public static boolean isIn(int r, int c) {
		return r>=0 && c>=0 && r<8 && c<8;
	}


	public static class Pair implements Comparable<Pair>{
		int r,c;

		public Pair(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
		@Override
		public int compareTo(Pair o) {
			if(this.r == o.r) {
				return Integer.compare(o.c, this.c);
			}else {
				return Integer.compare(this.r, o.r);
			}
		}
		
		
		
	}

}
