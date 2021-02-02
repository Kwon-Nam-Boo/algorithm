package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2143_두배열의합 {
	
	private static List<Integer> subN;
	private static List<Integer> subM;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		int N = Integer.parseInt(br.readLine());
		int[] arrN = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arrN.length; i++) {
			arrN[i] = Integer.parseInt(st.nextToken());
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] arrM = new int[M];	
		for (int i = 0; i < arrM.length; i++) {
			arrM[i] = Integer.parseInt(st.nextToken());
		}
		
		subN = new ArrayList<>();
		subM = new ArrayList<>();
		makeSub(subN, arrN);
		makeSub(subM, arrM);
		Collections.sort(subN);
		Collections.sort(subM);

		long ans =0;

		for (int i = 0; i < subN.size(); i++) {
			int stand = T - subN.get(i);
			ans+=findLast(subM, stand)- findStart(subM, stand);
	
		}
		System.out.println(ans);
	}
	
	
	private static int findStart(List<Integer> list, int stand) {
		int start = 0;
		int end = list.size();
		
		while(start < end) {
			int mid = (start+end)/2;
			// 기준값보다 크거나 같다면
			if(stand <= list.get(mid)) {
				end = mid;
			}else { // 기준값보다 작다면
				start = mid+1;
			}
		}
		return start;
	}
	
	private static int findLast(List<Integer> list, int stand) {
		int start = 0;
		int end = list.size();
		
		while(start <end) {
			int mid = (start+end)/2;
			
			if(stand < list.get(mid)) {
				end = mid;
			}else { 
				start = mid+1;
			}
		}
		return start;
		
	}
	
	// 부 배열 만들기
	public static void makeSub(List<Integer> list, int[] arr) {
		int sum = 0;
		
		for (int i = 0; i < arr.length; i++) {
			sum = arr[i];
			list.add(sum);
			for (int j = i+1; j < arr.length; j++) {
				sum+=arr[j];
				list.add(sum);
			}
		}
		
	}

}
