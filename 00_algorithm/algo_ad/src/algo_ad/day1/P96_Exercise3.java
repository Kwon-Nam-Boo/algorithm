package algo_ad.day1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P96_Exercise3 {
	
	private static int max = Integer.MIN_VALUE;
	private static int R = 2;
	private static int[] result;
	private static boolean[] visited;
	private static int[] arr = {-1,3,-9,6,7,-6,1,5,4,-2};
	private static List<Integer> list = new ArrayList<>();
	public static void main(String[] args) {
		// subset
		subSet(0,0);
		System.out.println();
		// combinamtion
		result = new int[R];
		nCr(0,0);
		System.out.println(max);
		// permutation
		result = new int[R];
		visited = new boolean[arr.length];
		nPr(0);
	}
	public static void nPr(int r) {
		if(r == R) {
			for (int i = 0; i < result.length; i++) {
				if(result[i]<0) {
					return;
				}
			}
			System.out.println(Arrays.toString(result));
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if(!visited[i]) {
				visited[i] =true;
				result[r] = arr[i];
				nPr(r+1);
				visited[i] =false;
			}
		}
	}
	
	public static void nCr(int r , int k) {
		if(r == R) {
			int sum =0;
			for (int i = 0; i < result.length; i++) {
				sum+= result[i];
			}
			max = Math.max(max, sum);
			return;
		}
		for (int i = k; i < arr.length; i++) {
			result[r] = arr[i];
			nCr(r+1,i+1);
		}
		
	}
	
	public static void subSet(int r , int k) {
		int sum = 0;
		for (int i = 0; i < list.size(); i++) {
			sum+=list.get(i);
		}
		if(sum == 0) {
			System.out.println(list);
		}
		if(r == arr.length) {
			return;
		}
		for (int i = k; i < arr.length; i++) {
			list.add(arr[i]);
			subSet(r+1,i+1);
			list.remove(list.size()-1);
		}
	}
}
