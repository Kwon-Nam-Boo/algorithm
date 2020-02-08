package algo_basic.day2;

import java.util.Arrays;
import java.util.Scanner;

import javax.sound.midi.Synthesizer;

public class SWEA_1210_D4_Ladder1 {
	
	public static int [][] dirs ={{0,-1},{0,1}}; // 하 , 좌 , 우 
	public static int[][] tmp2 = new int[100][100];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		
		for (int i = 0; i < 10; i++) {
			
			// 함수
			int TC = sc.nextInt();
	
			for (int r = 99; r >=0; r--) {			//tmp에 넣기
				for (int c = 0; c < 100; c++) {
					tmp2[r][c] = sc.nextInt();
				}
			}
			System.out.println(Arrays.toString(tmp2[0]));
			int start=0;
			for (int k=0; k< 100; k++) {
				   if (tmp2[0][k] == 2) {
					start = k;
				    break;
				   }
			}
			//System.out.println(start);
			traversal(start);
			
		}
	}
	
	public static void traversal(int start) {
		
		int i = 0;
		int answer = start;
		
		for (int d = 0; d < dirs.length; d++) {
			int nc = answer +dirs[d][1];
			if(isIn(nc)) {

			}
			
			
			/*while(i <= 99) {
				if(tmp2[i][answer-1] == 1) {
					tmp2[i][answer] = 0;
					answer--;
				}
				else if(tmp2[i][answer+1] == 1) {
					tmp2[i][answer] = 0;
					answer++;
				}
				else {
					i++;
				}
				
			
		}*/
			
		}
		System.out.println(answer);
	}
	public static boolean isIn(int col) {
		return 0<=col  && col<tmp2[0].length;
	}
	
	
}
