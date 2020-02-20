package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11728_배열합치기 {
	
	private static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int[] arrN = new int[N];
		int M = Integer.parseInt(st.nextToken());
		int[] arrM = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arrN[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			arrM[i] = Integer.parseInt(st.nextToken());
		}
		
		arr = new int[M+N];
		
		int li = 0;
		int ri = 0;
		int ti = 0;
		
		while(li < N && ri < M){		// 양쪽 배열에 모두 값이 남아 있을때
			if(arrN[li]<arrM[ri]) {
				arr[ti++] = arrN[li++];
			}else {
				arr[ti++] = arrM[ri++];
			}
		}
		while(li< N) {
			arr[ti++] = arrN[li++];
		}
		while(ri< M) {
			arr[ti++] = arrM[ri++];
		}
		
		//System.out.println(Arrays.toString(arr));
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i]).append(" ");
		}
		System.out.println();
	}
	
/*	public static void mergeSort(int low, int high) {
		int middle = (low + high) /2;
		if(low == high) return;
		mergeSort(low, middle);
		mergeSort(middle+1, high);
		merge(low, middle, high);
		
	}
	
	public static void merge(int low, int middle ,int high) {
		int[] tmp = new int[arr.length];
		int li = low;
		int ri = middle+1;
		int ti = low;
		
		while(li<=middle && ri<= high){		// 양쪽 배열에 모두 값이 남아 있을때
			if(arr[li]<arr[ri]) {
				tmp[ti++] = arr[li++];
			}else {
				tmp[ti++] = arr[ri++];
			}
		}
		while(li<=middle) {
			tmp[ti++] = arr[li++];
		}
		while(ri<= high) {
			tmp[ti++] = arr[ri++];
		}
		for (int i = low; i <= high; i++) {
			arr[i] =tmp[i];
		}
	}*/

}
