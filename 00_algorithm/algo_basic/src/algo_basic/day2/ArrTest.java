package algo_basic.day2;

public class ArrTest {
	
	public static int[][] arr = {{1,2,3}, {4,5,6}, {7,8,9}};
	
	public static void main(String[] args) {
		
		int a =10;
		int[] arr1 = new int[4];		// int를 담는 배열
		int[][] arr2 = new int[3][5];		// int의 배열을 담는 배열
		
		
		//행순회
		for (int r = 0; r < arr.length; r++) {
			for (int c = 0; c< arr[r].length; c++) {
				System.out.print(arr[r][c] + " ");
				
			}
			System.out.println();
		}
		System.out.println();
		//열순회
		for (int c = 0; c< arr[0].length; c++) {
			for (int r = 0; r < arr2.length; r++) {
				System.out.print(arr[r][c] + " ");
			}
			System.out.println();
		}
		
		//지그재그		짝수일때는 그대로 가고 홀수일때는 거꾸로
		for (int r = 0; r < arr.length; r++) {
			for (int c = 0; c< arr[r].length; c++) {
				System.out.print(arr[r][c + (arr[r].length-1-2*c)*(r%2)] + " ");
			}
			System.out.println();
		}
		
		
		
	}
	
	
	
}
