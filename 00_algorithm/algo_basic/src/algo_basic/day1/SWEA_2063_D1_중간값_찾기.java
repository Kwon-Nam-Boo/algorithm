package algo_basic.day1;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_2063_D1_중간값_찾기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num =sc.nextInt();
		
		int[] middle = new int[num];
		for(int i = 0 ;i<num; i++) {
			middle[i] = sc.nextInt();
		}
		Arrays.sort(middle);
		System.out.println(middle[middle.length/2]);
		//System.out.println(Arrays.toString(middle));
	}
	

}
