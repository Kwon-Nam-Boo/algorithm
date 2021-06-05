package samsungTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class test {
	
	private static int n;
	
	public static final int BLACK = -1;
    public static final int RAINBOW = 0;
    public static final int EMPTY = 6;
	private static int[][] map;
	
	public static void main(String[] args) throws IOException{
		n = 4;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
	    map = new int[n][n];
		for (int r = 0; r < n; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < n; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		gravity();
		
		for (int r = 0; r < n; r++) {
			System.out.println(Arrays.toString(map[r]));
		}
		
	}
	
	
	public static void gravity() {
        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == EMPTY) {

                    for (int k = i - 1; k >= 0; k--) {
                        if (map[k][j] == BLACK) break;
                        if (map[k][j] != EMPTY) {
                            map[i][j] = map[k][j];
                            map[k][j] = EMPTY;
                            break;
                        }
                    }


                }
            }
        }
    }
}
