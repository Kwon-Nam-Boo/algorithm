package algo_basic.practice;

import java.util.ArrayList;
import java.util.Arrays;

public class Pcstest {
	
	public static char[] N = {'A','B','C','D'};
	public static int R =2;
	public static char[] result;
	public static boolean[] visited;
	public static ArrayList<Character> list = new ArrayList<>();
	
	public static void main(String[] args) {
		//순열
		result = new char[R];
		visited = new boolean[N.length];
		nPr(0);
		System.out.println();
		//조합
		result = new char[R];
		nCr(0,0);
		System.out.println();
		// 부분집합
		subSet(0,0);
		System.out.println();
		// 부분집합(비트)
		subSet2();
	}
	public static void nPr(int r) {
		if(r ==R) {
			System.out.println(Arrays.toString(result));
			return;
		}
		for (int i = 0; i < N.length; i++) {
			if(!visited[i]) {
				visited[i] =true;
				result[r] = N[i];
				nPr(r+1);
				visited[i] =false;
			}
		}
	
	}
	public static void nCr(int r, int k) {
		if(r ==R) {
			System.out.println(Arrays.toString(result));
			return;
		}
		for (int i = k; i < N.length; i++) {
			result[r] = N[i];
			nCr(r+1,i+1);
				
		}
	}
	
	public static void subSet(int r, int k) {
		System.out.println(list);
		if(r == N.length) {
			return;
		}
		for (int i = k; i < N.length; i++) {
			list.add(N[i]);
			subSet(r+1,i+1);
			list.remove(list.size()-1);
				
		}
	}
	
	public static void subSet2() {
		for (int i = 0; i < (1<<N.length); i++) {
			list = new ArrayList<>();
			for (int j = 0; j < N.length; j++) {
				if((i & (1<<j)) > 0){
					list.add(N[j]);
				}
			}
			System.out.println(list);
		}

	}
}