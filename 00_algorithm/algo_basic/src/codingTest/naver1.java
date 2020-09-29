package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class naver1 {

	private static StringBuilder sb = new StringBuilder();
	public static int R =2;
	public static int n = 9;
	public static int[] result;
	public static int[] ans;
	public static int ansCheck =0;
	public static int[][] edges = {{0,2},{2,1},{2,4},{3,5},{5,4},{5,7},{7,6},{6,8}};
	public static List<Integer>[] list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		System.out.println(Arrays.toString(solution(n, edges)));
	}
	
	public static int[] solution(int n, int[][] edges) {
		int[] answer = {};
		
		list = new ArrayList[n];
		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < edges.length; i++) {
			list[edges[i][0]].add(edges[i][1]);
			list[edges[i][1]].add(edges[i][0]);
		}
//		System.out.println(Arrays.toString(list));
		result = new int[R];
		ans = new int[2];
		nCrRecursion(0, 0);
		System.out.println(Arrays.toString(ans));
		return ans;
		
	}
	
	public static void nCrRecursion(int r, int k) {
		if(ansCheck == 1) return; 
		if(r == R) {
			//System.out.println(Arrays.toString(result));
			if(check(result)) {
				ans[0] = result[0];
				ans[1] = result[1];
				ansCheck =1;
			}
			return;
		}
		for (int i = k; i < n-1; i++) {
			result[r] = i;
			nCrRecursion(r+1,i+1);
		}
	}

	private static boolean check(int[] result) {
		for (int i = 0; i < result.length; i++) {
			int[] tmp = edges[result[i]];
			list[tmp[0]].remove((Integer)tmp[1]);
			list[tmp[1]].remove((Integer)tmp[0]);
		}
		//System.out.println(Arrays.toString(list));
		// 확인
		int cnt = 0;
		int s = (n/3)-1;
		int flag = 0;
		for (int i = 0; i < list.length; i++) {
			if(list[i].size() == s) cnt++;
			else if(list[i].size() > s) flag = 1;
		}
		if(cnt == 3 && flag ==0) {
			System.out.println(Arrays.toString(result));
			return true;
		};
		
		for (int i = 0; i < result.length; i++) {
			int[] tmp = edges[result[i]];
			list[tmp[0]].add(tmp[1]);
			list[tmp[1]].add(tmp[0]);
		}
		//System.out.println(Arrays.toString(list));
		//System.out.println();
		return false;
	}

}
