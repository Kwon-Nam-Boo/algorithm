package algo_basic.day1.io;

import java.util.Arrays;

public class CountingSort {
	private static int[] input = {0,4,1,3,1,2,4,1};
	//private static int[] sorted;
	private static int[] counts;
	
	public static void main(String[] args) {
		
		// 최대값 
		int max = 0 ;
		for (int i = 0; i < input.length; i++) {
			max = Math.max(max,input[i]);
		}
		
		int[] counts = new int[max+1];
		
		
		for(int i = 0; i < input.length; i++) {
			counts[input[i]]++;
		}		
		
		//System.out.println(Arrays.toString(counts));
		
		for (int i = 0; i < counts.length-1; i++) {
			counts[i+1] = counts[i] + counts[i+1];
		}
		
		int[] sorted = new int[input.length];
		
		for (int i = input.length-1; i >= 0; i--) {
			sorted[counts[input[i]]-1] = input[i];
			counts[input[i]]--;
		}
		
		
		System.out.println(Arrays.toString(sorted));
	}

}
