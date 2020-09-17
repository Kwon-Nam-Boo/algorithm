package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Neo_3 {

	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[][] board = {{1,1,4,3},{3,2,1,4},{3,1,4,2},{2,1,3,3}};
		System.out.println(solution(board));
		
	}
	
	public static int solution(int[][] board) {
        int answer = 0;
        int len = board.length;
        
        for (int r = 0; r < len; r++) {
			for (int c = 0; c < len; c++) {
				answer+=check(r,c,len, board);
			}
		}
        return answer;
    }
	
	private static int check(int r, int c, int len, int[][] board) {
		
		int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
		int ans = 0;
		
		for (int i = 0; i < dir.length; i++) {
			int nr = dir[i][0] + r;
			int nc = dir[i][1] + c;
			// 옮겨보기
			boolean flag = false;
			if(isIn(nr,nc,len) && board[nr][nc] != board[r][c]) {
				swap(r,c,nr,nc,board);
				for (int[] a : board) {
					System.out.println(Arrays.toString(a));
				}
				int tmp = board[r][0];
				int cnt = 1;
				// 가로로 만들어 지는가 ..?
				for (int j = 1; j < len; j++) {
					if(tmp == board[r][j]) cnt++;
					else {
						tmp = board[r][j];
						cnt =1;
					}
					if(cnt == 3) flag = true;
				}
				tmp = board[0][c];
				cnt = 1;
				// 세로로 만들어 지는가 ..?
				for (int j = 1; j < len; j++) {
					if(tmp == board[j][c]) cnt++;
					else {
						tmp = board[j][c];
						cnt = 1;
					}
					if(cnt == 3) flag = true;
				}
				
				tmp = board[nr][0];
				cnt = 1;
				// 가로로 만들어 지는가 ..?
				for (int j = 1; j < len; j++) {
					if(tmp == board[nr][j]) cnt++;
					else {
						tmp = board[nr][j];
						cnt =1;
					}
					if(cnt == 3) flag = true;
				}
				tmp = board[0][nc];
				cnt = 1;
				// 세로로 만들어 지는가 ..?
				for (int j = 1; j < len; j++) {
					if(tmp == board[j][nc]) cnt++;
					else {
						tmp = board[j][nc];
						cnt = 1;
					}
					if(cnt == 3) flag = true;
				}
				
				
				
				swap(nr,nc,r,c,board);
				System.out.println();
			}
		}
		return ans;
	}
	
	private static void swap(int r, int c, int nr, int nc, int[][] board) {
		int tmp =0;
		tmp = board[r][c];
		board[r][c] = board[nr][nc];
		board[nr][nc] =tmp;
	}

	public static boolean isIn(int r, int c, int len) {
		return r >=0 && c>=0 && r < len && c < len; 
	}
}
