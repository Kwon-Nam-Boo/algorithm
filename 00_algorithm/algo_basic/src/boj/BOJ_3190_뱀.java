package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_3190_뱀 {
	
	private static int N;
	private static int apple;
	private static int change;
	private static int[][] map;
	private static int[][] dir = {{-1,0},{0,-1},{1,0},{0,1}};	// 상좌하우
	private static HashMap<Integer, Character> turn;

	public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		apple = Integer.parseInt(br.readLine());
		for (int i = 0; i < apple; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			// 사과 
			map[x][y] =1;
		}
		change = Integer.parseInt(br.readLine());
		turn = new HashMap<>();
		for (int i = 0; i < change; i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			char v = st.nextToken().charAt(0);
			turn.put(k,v);
		}
	
		// 시작은 오른쪽 등등의 초기화 작업
		int result = 0;
		int k = 0;
		int currDir = 3;
		Deque<Pair> dq = new ArrayDeque<Pair>();
		dq.offer(new Pair(0,0));
		map[0][0] = 2;
		
		// 벽이나 몸체에 닿을때 까지 반복
		while(true) {
			Pair tmp = dq.peek();
		
			int nx = tmp.x + dir[currDir][0];
			int ny = tmp.y + dir[currDir][1];
			
			// 뱀이 갈수 있는 영역 이면 간다.
			
			if(isIn(nx,ny) && map[nx][ny]!=2) {
				// 빈곳이라면 --> 꼬리를 자른다
				if(map[nx][ny]==0){
					Pair l = dq.pollLast();
					map[l.x][l.y]= 0;
				}
				// 사과든 빈곳이든 앞칸으로 나아간다. --> 큐 맨앞으로 보내준다
				dq.addFirst(new Pair(nx,ny));
				map[nx][ny]= 2;
				
			}else {
				result = k;
				break;
			}
			k++;
			// map에 있는 값이라면 방향전환
			if(turn.get(k)!=null) {
				// 왼쪽으로 방향전환 
				if(turn.get(k) == 'L') {
					currDir = (currDir+1)%4;
				}
				if(turn.get(k) == 'D') {
					currDir = (currDir+3)%4;
				}
			}
		}
		System.out.println(result+1);
		
	}
	public static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < N;
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
}
