package algo_basic.day5;

import java.util.Arrays;

public class p233_Nqueen_dfs {
	
	private static int size =15;
	private static int[][] map = new int[size][size];

	
	public static void dfs(int row) {
		if(row==size) {
			//끝까지 도달 --> 상태 확인
			if(isPromising()) {
				for(int[] line: map) {
				System.out.println(Arrays.toString(line));
				}
				System.out.println();
				System.out.println("배치 가능하다!");
				System.exit(0);
			}
			return;
		}else {
			for (int c = 0; c < size; c++) {
				map[row][c] = 1;
				dfs(row+1);
				map[row][c] = 0;
			}
		}
	
	}
	// 맨 마지막 까지 돌을 놧으니 이제 이 행동이 적합한지 확인하는 메소드
	public static boolean isPromising() {
		for (int r = 0; r < size; r++) {
			for (int c = 0; c < size; c++) {
				if(map[r][c] == 1) {
					// 위로 쭉 가면서 수직위와 대각선으로 체크
					for (int k = 1; k <= r; k++) {
						if(map[r-k][c]==1) {
							return false;
						}
						if(c-k >=0 && map[r-k][c-k]==1) {	// 범위 안에 있으면서 대각선이 1인경우
							return false;
						}
						if(c+k <size && map[r-k][c+k]==1) {		
							return false;
						}
					}
				}
			}
		}
		return true;
	}
	

	public static void main(String[] args) {
		dfs(0);

	}

}
