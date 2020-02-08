package algo_basic.day2;

public class Traversal {
	public static int [][] arr = {{1,2,3},{4,5,6},{7,8,9}};
	public static int [][] arr2 = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
	public static int [][] dirs ={{-1,0},{1,0},{0,-1},{0,1}}; // 상 , 하 , 좌 , 우
	public static int [][] dirsx ={{-1,-1},{1,1},{-1,1},{1,-1}};
	
	// 어떤 점을 중심으로 4방향에 있는 요소들의 총합은?
	public static void main(String[] args) {
		
		//traversal();
		//traversal4C();
		traversal2();
	}
	public static void traversal() {
		for (int r = 0; r < arr.length; r++) {
			for (int c = 0; c < arr[r].length; c++) {
				int sum =0;
				for (int d = 0; d < dirs.length; d++) {
					// 방향에 따른 새로운 row, col 결정
					int nr = r +dirs[d][0];
					int nc = r +dirs[d][1];
					if(isIn(nr, nc)) {
						sum+=arr[nr][nc];
					}
					
				}
				System.out.printf("%d, %d 주변 요소의 합은 %d\n",r,c,sum);
			}
		}
	}
	
	public static void traversal4C() {
		for (int r = 0; r < arr.length; r++) {
			for (int c = 0; c < arr[r].length; c++) {
				int sum =0;
				for (int d = 0; d < dirsx.length; d++) {
					// 방향에 따른 새로운 row, col 결정
					int nr = r +dirsx[d][0];
					int nc = r +dirsx[d][1];
					
					if(isIn(nr, nc)) {
						sum+=arr[nr][nc];

					}
					
				}
				System.out.printf("%d, %d 주변 요소의 합은 %d\n",r,c,sum);
			}
		}
		
	
	}
	public static void traversal2() {
		int sum =0;
		for (int r = 0; r < arr2.length; r++) {
			for (int c = 0; c < arr2[r].length; c++) {
				int absSum =0;
				int base =arr2[r][c];
				for (int d = 0; d < dirs.length; d++) {
					// 방향에 따른 새로운 row, col 결정
					int nr = r +dirs[d][0];
					int nc = c +dirs[d][1];
					if(isIn2(nr, nc)) {
						absSum+=Math.abs(arr2[nr][nc]-base);
					}
					
				}
				sum += absSum;

				System.out.printf("%d, %d 주변 요소의 합은 %d\n",r,c,absSum);
			}
		}
		System.out.println(sum);
	}
	

	// 점들이 배열 안에 있나 ..?
	public static boolean isIn(int row, int col) {
		return 0<=row && 0<=col && row<arr.length && col<arr[0].length;
	}
	public static boolean isIn2(int row, int col) {
		return 0<=row && 0<=col && row<arr2.length && col<arr2[0].length;
	}

}
