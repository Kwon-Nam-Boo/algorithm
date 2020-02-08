package algo_basic.day1.io;

import java.util.Arrays;

public class BubbleSort {
	private static int[] bubble = {55,7,78,12,42};
	
	public static void main(String[] args) {

		for (int i = 0; i < bubble.length; i++) {
			for (int j = 0; j < bubble.length-(i+1); j++) {
				if(bubble[j] > bubble[j+1]) {
					swap(j ,j+1);
				}
				
			}
			System.out.println(Arrays.toString(bubble));
			
		}
	}
	
	public static void swap(int a , int b) {
			int tmp;
			tmp = bubble[a];
			bubble[a] = bubble[b];
			bubble[b] = tmp;
	}
	

}
