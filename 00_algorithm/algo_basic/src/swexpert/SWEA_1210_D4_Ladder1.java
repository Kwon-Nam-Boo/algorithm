package swexpert;

import java.util.Arrays;
import java.util.Scanner;

 

public class SWEA_1210_D4_Ladder1 {
	
	
	public static int[][] tmp2 = new int[100][100];		

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		
		for (int i = 1; i <= 10; i++) {
			int TC = sc.nextInt();
			
			for (int r = 99; r >=0; r--) {			
				for (int c = 0; c < 100; c++) {			// tmp2에 압력값 저장하나 도착점을 위로 시작점 아래로 저장
					tmp2[r][c] = sc.nextInt();
				}
			}

			int start=0;

			for (int k=0; k< 100; k++) {				// 시작점 위치 찾기
				   if (tmp2[0][k] == 2) {
					start = k;
				    break;
				   }
			}											// 답 입력
			sb.append("#").append(i).append(" ").append(ladderfind(start)).append("\n");
		}
		System.out.println(sb);
	}

	public static int ladderfind(int goal) {				// 도착점 찾기 함수

		int i = 0;

		while(i <= 99) {
			if( goal > 0 && tmp2[i][goal-1] == 1) {		// 왼쪽으로 이동 (goal이 0보다 작으면 넘어감 && 연산이므로 뒤는 무시)
				tmp2[i][goal] = 0;						// 현재 위치를 0으로 초기화해서 못돌아가게 막음
				goal--;
			}

			else if(goal < 99 && tmp2[i][goal+1] == 1) {	// 오른쪽으로 이동
				tmp2[i][goal] = 0;
				goal++;
			}
			else {											// 밑으로 이동
				i++;
			}
		}
		return goal;
	}
}
	
