package rhtn_homework;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2751_수정렬하기2 {
	
	private static int[] arr;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		merge_sort(0, arr.length-1);
		for (int i = 0; i < N; i++) {
			bw.append(arr[i] +"\n");
		}
		bw.flush();
		bw.close();
	}

	private static void merge_sort(int start, int end) {
		if(start < end) {
			int mid = (start +end) /2;
			merge_sort(start, mid);
			merge_sort(mid+1, end);
			merge(start, mid , end);
		}
		
	}

	private static void merge(int start, int mid, int end) {
		int p = start;
		int q = mid +1;
		int idx = 0;
		
		int[] tmp = new int[end-start+1];
		
		while(p<=mid && q<=end) {
			if(arr[p] <= arr[q]) {
				tmp[idx++] = arr[p++];
			}else {
				tmp[idx++] = arr[q++];
			}
		}
		while(p<=mid) {
			tmp[idx++] = arr[p++];
		}
		while(q<=end) {
			tmp[idx++] = arr[q++];
		}
		for (int i = start; i <= end; i++) {
			arr[i] = tmp[i-start];
		}
	}

}
