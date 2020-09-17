package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Toss_6 {

	private static StringBuilder sb = new StringBuilder();


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringTokenizer st1;
		
		String input = br.readLine();
		
		st = new StringTokenizer(input, ";");
		
		int a = st.countTokens();
		int[][] map = new int[a][a];
		int[][] dir = {{-1,0},{1,0},{0,1},{0,-1}};
		
		for (int i = 0; i < a; i++) {
			String tmp = st.nextToken();
			st1 = new StringTokenizer(tmp, " ");
			for (int j = 0; j < a; j++) {
				map[i][j] = Integer.parseInt(st1.nextToken());
			}
		}
		
		int count = 0;
		for (int r = 0; r < a; r++) {
			for (int c = 0; c < a; c++) {
				if(map[r][c] == 1) {
					for (int i = 0; i < dir.length; i++) {
						int px = dir[i][0] + r;
						int py = dir[i][1] + c;
						if(map[px][py] == 0) {
							count++;
						}
					}
				}
			}
		}
		System.out.println(count);
		
		
	}
	
	
	
}
