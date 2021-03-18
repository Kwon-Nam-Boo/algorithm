package rhtn_homework;import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class PROG_합승택시요금 {
	
	private final static int max = Integer.MAX_VALUE;
	private static int[][] map = new int[201][201];
	
	public static void main(String[] args) {
		int n = 6;
		int s = 4;
		int a = 6;
		int b = 2;
		int[][] fares = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};
		System.out.println(solution(n, s, a, b, fares));
	}
	
	public static int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = max;
        
        for (int r = 1; r <= 200; r++) {
			for (int c = 1; c <= 200; c++) {
				map[r][c] = max;
			}
		}
        
        for (int i = 0; i < fares.length; i++) {
        	int x = fares[i][0];
        	int y = fares[i][1];
        	int v = fares[i][2];
        	map[x][y] =v;
        	map[y][x] =v;
		}
        
        // 경유
        for (int i = 1; i < 201; i++) {
        	// a -> i -> b
			for (int r = 1; r < 201; r++) {
				if(i == r) {
					map[r][r] = 0;
					continue;
				}
				for (int c = 0; c < 201; c++) {
					if(i == c || r == c){
						map[c][c] = 0;
						continue;
					}
					if(map[r][i] !=max && map[i][c] !=max && (map[r][i] + map[i][c] < map[r][c]))
						map[r][c] = map[r][i] + map[i][c];
				}
				
			}
		}
        
        for (int i = 1; i <=n ; i++) {
			answer = Math.min(answer, map[i][s]+ map[i][a]+map[i][b]);
		}
        return answer;
        
    }
	
	
}
