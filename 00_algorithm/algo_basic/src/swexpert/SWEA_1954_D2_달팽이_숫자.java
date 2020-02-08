package swexpert;


import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1954_D2_달팽이_숫자 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		int TC = sc.nextInt();
		
		
		for (int i = 1; i <= TC; i++) {
			int size = sc.nextInt();
			int[][] arr = new int[size][size];		// 저장할 배열
			int start = 0;							// 시작(끝) 위치 조정
			int end=0;								// 끝(시작) 위치 조정
			int time = 0;							// 횟수
			int num =1;								// 숫자 입력
			while(time < size) {
				
				for (int j = start; j < (size-end); j++) {				// 행파트 arr 에 저장
					if(time % 2 ==0) {									// 횟수가 짝수라면  왼쪽에서 오른쪽
						arr[start][j]=num;		
					}else {
						arr[(size-end)][(size-end)-j+start-1]=num;		// 홀수 라면 오른쪽에서 왼쪽
					}
					num++;
				}
				
				if(time % 2 ==0) end++;									// 행 저장 후 size 줄이기 
				else start++;
					
				for (int k = end; k < size -start ; k++) {				// 열파트 arr 에 저장
					if(time % 2 ==0) {
						arr[k][size -end] = num;						// 짝수라면 위에서 아래로
					}else {
						arr[size-start-k +end-1][start-1] =num;			// 홀수라면 아래에서 위로
					}
					num++;
				}
				time++;
			}
			
			sb.append("#").append(i).append("\n");
			for (int r = 0; r < arr.length; r++) {
				for (int c = 0; c < arr.length; c++) {
					sb.append(arr[r][c]).append(" ");
				}
				sb.append("\n");
			}
			
		}
		System.out.println(sb);	
	}

}