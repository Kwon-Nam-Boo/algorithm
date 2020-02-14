package algo_basic.practice;

import java.util.ArrayList;
import java.util.Arrays;

public class PCSpractice {

	public static char[] N = {'A','B','C','D'};
	public static int R =2;
	public static char[] result;
	public static boolean[] visited;
	public static ArrayList<Character> list = new ArrayList<>();
	
	public static void main(String[] args) {
		// 순열
		result = new char[R];
		visited = new boolean[N.length];
		nPr(0);
		System.out.println();
		// 조합
		result = new char[R];
		nCr(0,0);
		System.out.println();
		// 부분집합
		subSet(0,0);
		System.out.println();
	}
	
	public static void nPr(int d) {			// 순열
		if(d == R) {
			System.out.println(Arrays.toString(result));
			return;
		}
		
		for (int i = 0; i < N.length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				result[d] = N[i];
				nPr(d+1);
				visited[i] =false;
			}
		}
	}
	
	public static void nCr(int d, int k) {		// 조합
		if(d == R) {
			System.out.println(Arrays.toString(result));
			return;
		}
		for (int i = k; i < N.length; i++) {
			result[d] = N[i];
			nCr(d+1,i);
		}
	}
	
	public static void subSet(int d, int k) {	// 부분집합
		System.out.println(list);
		if(d == N.length) {
			return;
		}
		for (int i = k; i < N.length; i++) {
			list.add(N[i]);
			subSet(d+1,i+1);
			list.remove(list.size()-1);
		}	
	}
	
	
}
