package swexpert;


import java.util.Scanner;

public class SWEA_1954_D2_달팽이_숫자_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		int TC = sc.nextInt();
		
		
		for (int i = 1; i <= TC; i++) {
			int size = sc.nextInt();
			int[][] arr = new int[size][size];		// 저장할 배열
			int change =1;							// 증가 감소를 위한 숫자
			int si = size;							// 점점 작아질 배열의 크기
			int num =1;								// 들어갈 숫자
			int a = 0; int b = -1;					
			while(true) {
				for (int j = 0; j < si; j++) {
					b+=change;
					arr[a][b]=num;
					num++;
				}
				si--;
				if(si == 0) break;
				for (int j = 0; j < si; j++) {
					a+=change;
					arr[a][b]=num;
					num++;
				}
				change*=-1;							// 증가, 감소 변경
			}
			for (int r = 0; r < size; r++) {
				for (int c = 0; c < size; c++) {
					System.out.print(arr[r][c] + " ");
				}
				System.out.println();
			}
			
		}

	}

}