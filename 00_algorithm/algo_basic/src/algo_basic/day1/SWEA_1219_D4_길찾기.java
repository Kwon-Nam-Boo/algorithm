package algo_basic.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1219_D4_길찾기 {
	public static int count = 0;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for (int i = 1; i <= 10; i++) {
			sb.append("#").append(i).append(" ");
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			 int[] arr = new int[100];
			 int[] arr2 = new int[100];
			
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				if(arr[x]==0) arr[x] = y;
				else arr2[x] =y;
			}
			count =0;
			find(arr,arr2,0);
			sb.append(count).append("\n");
		}
		System.out.println(sb);
	}
	public static void find(int[] arr, int[] arr2, int c) {
		if(count==1) return;
		if(arr[c] ==99 || arr2[c] ==99) {
			count=1;
			return;
		}
		
		if(arr[c]==0) {
		
			return;
		}
		find(arr,arr2,arr[c]);
		
		if(arr2[c]==0) {
			
			return;
		}
		find(arr,arr2,arr2[c]);
		
	}
}
