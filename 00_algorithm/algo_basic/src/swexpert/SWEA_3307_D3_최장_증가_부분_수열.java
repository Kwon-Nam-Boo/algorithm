package swexpert;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_3307_D3_최장_증가_부분_수열 {
	

	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();

		
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int TC = s.nextInt();
		
		for (int i = 1; i <= TC; i++) {
			int[] checkArray;
			int[] numArray;
			int Subseq = s.nextInt();
			sb.append("#").append(i).append(" ");
			checkArray = new int[Subseq];
			numArray = new int[Subseq];
			for (int j = 0; j < Subseq; j++) {
				numArray[j] = s.nextInt();
			}
			sb.append(find2(checkArray, numArray)).append("\n");
		}
			
		System.out.println(sb);
		
		long end = System.currentTimeMillis();
		System.out.println( "실행 시간 : " + ( end - start )/1000.0 );

		
	}
	
	public static int find2(int[] checkArray ,int[] numArray) {
		
		int max =0;
		
		checkArray[0] =1;
		
		for (int i = 1; i < numArray.length; i++) {
			checkArray[i] = 1;
			for(int j = 0;j<i;j++) {
				if(numArray[i]> numArray[j] && checkArray[j]+1 > checkArray[i])
					checkArray[i] = checkArray[j]+1;
			}
			if(max < checkArray[i])
				max = checkArray[i];
		}
		return max;
	}
	
	

}
