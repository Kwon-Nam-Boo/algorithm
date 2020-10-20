package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class pcsTest {

	public static StringBuilder sb = new StringBuilder();
	public static int[] arr= {1,2,3,4};
	public static int[] result;
	public static boolean[] visited;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		result = new int[2];
		visited = new boolean[arr.length];
//		nPr(0);
//		System.out.println();
//		result = new int[2];
//		nCr(0,0);
//		System.out.println();
//		subSet();
		Pair[] plist = new Pair[1];
		plist[0] = new Pair(1, 1);
		Pair[] test = new Pair[1];
		test = plist.clone();
		plist[0].c = 3;
		System.out.println(Arrays.toString(plist));
		System.out.println(Arrays.toString(test));
		
		int[] arr = new int[1];
		arr[0] = 1;
		int[] arr2 = new int[1];
		arr2 =arr.clone();
		arr2[0] = 2;
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(arr2));
	}
	
	public static class Pair{
		int r,c;

		public Pair(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "pair [r=" + r + ", c=" + c + "]";
		}
		
	}
	
	private static void subSet() {
		for (int i = 0; i < 1<<arr.length; i++) {
			List<Integer> list = new ArrayList<>();
			for (int j = 0; j < arr.length; j++) {
				if((i & (1<<j))>0) list.add(arr[j]);
			}
			System.out.println(list);
		}
		
	}

	private static void nCr(int d, int k) {
		if(d == result.length) {
			System.out.println(Arrays.toString(result));
			return;
		}
		for (int i = k; i < arr.length; i++) {
			result[d] = arr[i];
			nCr(d+1,i+1);
		}
		
	}

	private static void nPr(int d) {
		if(d == result.length) {
			System.out.println(Arrays.toString(result));
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				result[d] = arr[i];
				nPr(d+1);
				visited[i] = false;
			}
		}
	}
}
