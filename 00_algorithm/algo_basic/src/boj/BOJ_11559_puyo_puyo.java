package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11559_puyo_puyo {

	private static StringBuilder sb = new StringBuilder();
	private static char[][] map;
	private static boolean[][] visited;
	private static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
	private static List<Pair> list = new ArrayList<>();
	private static boolean isBomb = false;		// 폭발 flag
	private static int chain;					// 체인수(답)
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		map = new char[12][6];
		
		for (int c = 0; c < 12; c++) {
			map[c]= br.readLine().toCharArray();
		}
	
		chain=0;		
		
		while(true) {
			gravity();
			
			visited = new boolean[12][6];
			isBomb = false;
			
			for (int r = 0; r < 12; r++) {
				for (int c = 0; c < 6; c++) {
					if(map[r][c]!='.') checkBFS(new Pair(r,c));
				}
			}
			
			if(isBomb) chain++;	// 한번도 폭발하지않았다면 종료, 아니면 카운트
			else break;
		}

		System.out.println(chain);
	}


	private static void checkBFS(Pair p) {
		
		Queue<Pair> queue = new LinkedList<>();
		queue.add(p);
		visited[p.x][p.y] = true;
		list = new ArrayList<>();
		
		while(!queue.isEmpty()) {
			Pair tmp = queue.poll();
			list.add(tmp);			// 개수 확인용
			for (int i = 0; i < dir.length; i++) {
				int px = dir[i][0] + tmp.x;
				int py = dir[i][1] + tmp.y;
				if(isIn(px,py) && !visited[px][py] && map[px][py] == map[p.x][p.y]) {
					queue.add(new Pair(px,py));
					visited[px][py] = true;
				}
			}
		}
		if(list.size()>3) {			// 만약 4개이상 이면 ?
			for (int i = 0; i < list.size(); i++) {		// '.' 으로 다 바꿔준다
				map[list.get(i).x][list.get(i).y] = '.';
				isBomb =true;							// flag값
			}
		}
	}


	private static void gravity() {			
		for (int i = 10; i >= 0; i--) {			// 맨 밑보다 한칸 위에서 부터 시작(맨 밑에 있다면 어차피 가만히 냅두면 되서 의미없기 때문에)
			for (int j = 0; j < 6; j++) {
				
				for (int k = 11; k > i; k--) {	// 맨 밑에서 해당 i 위치 사이에 가장 밑에 잇는 '.'으로 떨어질 것이다
					if(map[i][j] !='.') {
						if(map[k][j]=='.') {
							map[k][j] = map[i][j];
							map[i][j] = '.';
						}
					}
				}
			}
		}
	}
	
	private static class Pair{
		int x,y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Pair [x=" + x + ", y=" + y + "]";
		}
		
	}
	
	public static boolean isIn(int r, int c) {
		return r>=0 && c>=0 && r < 12 && c < 6;
	}
	
}
