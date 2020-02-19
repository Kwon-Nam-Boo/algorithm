package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10972_다음수열 {

	private static int[] arr;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		//System.out.println(Arrays.toString(arr));
		
		// next permutation
		// i 찾기
		int i;
		for (i=arr.length-2; i>=0 ; i--) {
				if(arr[i]<arr[i+1]){
					break;
				}
		}
		if(i<0) {
			System.out.println("-1");
		}else {
			// j찾기
			int j;
			for (j = arr.length-1; j >= 0; j--) {
				if(arr[i] < arr[j]) {
					break;
				}
			}
			// 스왑
			swap(i,j);
			//
			for (int a = i+1, b = arr.length-1; a< b; a++,b--) {
				swap(a,b);
			}
			for (int j2 = 0; j2 < arr.length; j2++) {
				System.out.print(arr[j2] + " ");
			}
		}
		
	}
	public static void swap(int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

}
