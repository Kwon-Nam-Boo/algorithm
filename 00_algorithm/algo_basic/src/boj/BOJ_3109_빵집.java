package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3109_빵집 {
	
	private static boolean flag;
	private static int R;
	private static int C;
	private static int count;
	private static String[][] map;
	private static int[] dir= {-1,0,1};
	

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new String[R][C];
		
		for (int r = 0; r < R; r++) {
			map[r] = br.readLine().split("");
		}
		count =0;
		
		for (int i = 0; i < R; i++) {
				flag =false;
				dfs(i,0);
		}
		System.out.println(count);
		
	}
	
	public static void dfs(int r, int c) {		
		if(c == C-1) {
			count++;
			flag =true;
			return;
		}
		for (int j = 0; j < dir.length; j++) {
			int a = r + dir[j];
			if(!flag && isIn(a,c+1) && !map[a][c+1].equals("x")) {
				map[a][c+1]= "x";
				dfs(a,c+1);
			} 
		}
	}
	
	public static boolean isIn(int r, int c) {
		return r >= 0 && r < R && c>=0 && c<C;
	}
	
}
