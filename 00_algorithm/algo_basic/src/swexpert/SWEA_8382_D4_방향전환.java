package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_8382_D4_방향전환 {
	
	private static int N,SX,SY,DY,DX;
	private static int result;
	private static boolean[][][] visited;
	private static int[][] dirW = {{0,-1},{0,1}};
	private static int[][] dirH = {{-1,0},{1,0}};
	

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int TC =Integer.parseInt(br.readLine());
		for (int i = 1; i <= TC; i++) {
			sb.append("#").append(i).append(" ");
			N =201;
			visited = new boolean[N][N][2];
			st = new StringTokenizer(br.readLine());
			SX = Integer.parseInt(st.nextToken())+100;
			SY = Integer.parseInt(st.nextToken())+100;
			DX = Integer.parseInt(st.nextToken())+100;
			DY = Integer.parseInt(st.nextToken())+100;
			result = Integer.MAX_VALUE;
			bfs();
			sb.append(result).append("\n");
			
		}
		System.out.println(sb);
	}
	public static class Pair{
		int x;
		int y;
		int c;
		boolean d;												// true: H , false: W 방향을 의미한다.
		public Pair(int x, int y,int c, boolean d) {
			this.x = x;
			this.y = y;
			this.c = c;
			this.d = d;
		}
	}
	public static boolean isIn(int r, int c) {
		return r>=0 && c>=0 && r<N && c<N; 
	}
	
	public static void bfs() {
		Queue<Pair> queue = new LinkedList<>();
		queue.offer(new Pair(SX,SY,0,true));
		queue.offer(new Pair(SX,SY,0,false));
		visited[SX][SY][0] =true;
		visited[SX][SY][1] =true;
		
		while(!queue.isEmpty()) {
			
			Pair p = queue.poll();
			// 정답 조건
			if(DX == p.x && DY == p.y) {
				result = p.c;
				return;
			}
			if(p.d) {						// h 이동
				for (int i = 0; i < dirH.length; i++) {		
					int a = dirH[i][0] + p.x;
					int b = dirH[i][1] + p.y;
					if(isIn(a,b) && !visited[a][b][0]){
						queue.offer(new Pair(a,b,p.c+1,!p.d));
						visited[a][b][0] =true;
					}
				}
			}else {																
				for (int i = 0; i < dirW.length; i++) {		
					int a = dirW[i][0] + p.x;
					int b = dirW[i][1] + p.y;
					if(isIn(a,b) && !visited[a][b][1]){
						queue.offer(new Pair(a,b,p.c+1,!p.d));
						visited[a][b][1] =true;
					}
				}
			}	
		}
	}
}
