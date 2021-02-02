package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_merge_sort {
	
	private static int[] arr;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		merge_sort(0,arr.length-1);
		// merge sort
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		
	}

	private static void merge_sort(int start, int end) {
		if(start< end) {
			int mid = (start+ end) / 2;
			merge_sort(start, mid);
			merge_sort(mid+1, end);
			merge(start, end , mid);
		}
		
	}

	private static void merge(int start, int end, int mid) {
		int p = start;
		int q = mid+1;
		int idx = p;
		
		int[] tmp = new int[arr.length];
		
		while(p<=mid && q<=end) {
			if(arr[p] <= arr[q]) {
				tmp[idx++] = arr[p++];
			}else {
				tmp[idx++] = arr[q++];
			}
		}
		while(p<=mid)
			tmp[idx++] = arr[p++];
		while(q<=end)
			tmp[idx++] = arr[q++];
		
		for (int i = start; i <= end; i++) {
			arr[i] = tmp[i];
		}
	}

}
