package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10815_숫자카드 {
	
	private static int N,M;
	private static boolean flag;
	private static int[] arr;
	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int a = Integer.parseInt(st.nextToken());
			flag = false;
			BinarySearch(0,N-1,a);
		}
		System.out.println(sb);
	}

	private static void BinarySearch(int f, int e, int a) {
		int mid = (f + e)/2;
		
		// 종료 조건
		if(arr[mid] == a) {
			sb.append("1" + " ");
			return;
		}
		if(f == e && arr[mid] != a) {
			sb.append("0" + " ");
			return;
		}
		
		// 원하는 값보다 중간값이 크다면
		if(arr[mid] > a) {
			BinarySearch(f, mid, a);	
		}else if(arr[mid] < a){
			BinarySearch(mid+1, e, a);
		}
	}
}
