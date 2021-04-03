package codingTest2;

import java.util.Arrays;

public class dev_02 {
	
	public static void main(String[] args) {
		int rows = 6;
		int columns= 6;
		int[][] queries = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};
	   System.out.println(Arrays.toString(solution(rows, columns, queries)));
	}
	
	public static  int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] map = new int[rows][columns];
        int cnt = 1;
        for (int r = 0; r < map.length; r++) {
			for (int c = 0; c < map[r].length; c++) {
				map[r][c] = cnt;
				cnt++;
			}
		}
        //dd
        for (int i = 0; i < queries.length; i++) {
			rotate(rows, columns,map, queries[i], i, answer);
//			for (int r = 0; r < map.length; r++) {
//				System.out.println(Arrays.toString(map[r]));
//			}
//			System.out.println();
		}
        return answer;
    }

	private static void rotate(int rows, int columns, int[][] map, int[] is, int i, int[] answer) {
		int[][] copy = new int[rows][columns];
		
		for (int r = 0; r < map.length; r++) {
			for (int c = 0; c < map[r].length; c++) {
				copy[r][c] = map[r][c];
			}
		}
		
		int x1 = is[0]-1;
		int y1 = is[1]-1;
		int x2 = is[2]-1;
		int y2 = is[3]-1;
		
		int min = map[x1][y1];
			
		for (int c = y1; c < y2; c++) {
			copy[x1][c+1] = map[x1][c];
			min = Math.min(copy[x1][c+1], min);
		}
		for (int r = x1; r < x2; r++) {
			copy[r+1][y2] = map[r][y2];
			min = Math.min(copy[r+1][y2], min);
		}

		for (int c = y2; c > y1; c--) {
			copy[x2][c-1] = map[x2][c];
			min = Math.min(copy[x2][c-1], min);
		}
		
		for (int r = x2; r > x1; r--) {
			copy[r-1][y1] = map[r][y1];
			min = Math.min(copy[r-1][y1], min);
		}
		
		answer[i] = min;

		for (int r = 0; r < map.length; r++) {
			for (int c = 0; c < map[r].length; c++) {
				 map[r][c] = copy[r][c];
			}
		}
	}

}
