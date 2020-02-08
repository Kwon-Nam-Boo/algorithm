package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2567_색종이2 {
	
	private static int N;
	private static boolean[][] arr;
	private static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		// arr = new boolean[102][102];
		arr = new boolean[102][102];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())+1;
			int y = Integer.parseInt(st.nextToken())+1;
			
			for (int r = x; r < x+10; r++) {
				for (int c = y; c < y+10; c++) {
					arr[r][c] = true;
				}
			}
			
		}
		
		int count =0;									// 둘레 길이 측정
		for (int r = 0; r < 102; r++) {
			for (int c = 0; c < 102; c++) {
				for (int k = 0; k < dir.length; k++) {
					if(arr[r][c] == true) break;		// 현재 값은 false 위치에 만 있어야한다.
					int nr = r + dir[k][0];
					int nc = c + dir[k][1];
					if(isIn(arr,nr,nc) && arr[nr][nc]== true) {	// 옆칸값이 배열을 벗어나지 않고 true이면 카운트
						count++;
					}
				}
			}
		}
		System.out.println(count);
		
	}
	
	public static boolean isIn(boolean[][] arr, int row, int col) {
		return row >=0 && col >=0 && row < arr.length && col < arr.length;
	}

}
