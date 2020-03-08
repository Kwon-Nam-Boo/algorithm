package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1907_D5_모래성쌓기 {
	
	private static int R;
	private static int C;
	private static Queue<Pair> queue;
	private static int[][] map;
	private static int[][] dir= {{-1,0},{1,0},{0,1},{0,-1},{1,1},{-1,-1},{1,-1},{-1,1}};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <= TC; t++) {
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new int[R][C];
			queue = new LinkedList<>();
			for (int r = 0; r < R; r++) {
				String src =br.readLine();
				for (int c = 0; c < C; c++) {
					if(src.charAt(c)=='.') {
						map[r][c] = 0;
						queue.offer(new Pair(r,c));
					}else {
						map[r][c] = src.charAt(c) -'0';
					}
				}
			}
			
			int count=0;
			
			while(true) {
				if(queue.isEmpty()) break;
				bfs();
				count++;
			}
			sb.append(count-1).append("\n");
		}
		System.out.println(sb);

	}
	public static boolean isIn(int r, int c) {
		return r>=0 && c>=0 && r<R && c<C;
	}
	public static class Pair{
		int x;
		int y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}	
	}
	public static void bfs() {
		int size = queue.size();
		while(size>0) {
			Pair p = queue.poll();
			for (int i = 0; i < dir.length; i++) {
				int a = dir[i][0] + p.x;
				int b = dir[i][1] + p.y;
				if(isIn(a,b) && map[a][b] !=0 && map[a][b] !=9) {	// 숫자를 발견하면
					map[a][b]--;					// 밀어버린다.
					if(map[a][b]==0) {				//  다밀렸으면
						queue.offer(new Pair(a,b));			// 새로운 wave가 될것이다.
					}
				}
			}
			size--;
		}
	}
	

}
