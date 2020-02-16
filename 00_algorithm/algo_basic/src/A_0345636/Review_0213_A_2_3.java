package A_0345636;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Review_0213_A_2_3 {
	
	private static char[] N= {'A','B','C','D'};
	private static int R = 2;
	private static char[] result;
	private static List<Character> resultL = new ArrayList<>();
	private static boolean[] visited;
	
	
	public static void nPr(int r) {							// 순열(백트래킹)
		if(r == R) {
			System.out.println(Arrays.toString(result));
			return;
		}
		for (int i = 0; i < N.length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				result[r] = N[i];
				nPr(r+1);
				visited[i] = false;
			}
		}
	}
	
	public static void nPrOver(int r) {						// 중복순열
		if(r == R) {
			System.out.println(Arrays.toString(result));	
			return;
		}
		for (int i = 0; i < N.length; i++) {
				result[r] = N[i];
				nPr(r+1);
		}
	}
	
	public static void nCrFor() {							// 중복 일반 반복문 ( 개수 조절이 어려움) for문이 r 개 필요
		for (int i = 0; i < N.length; i++) {
			for (int j = i+1; j < N.length; j++) {
				System.out.println("[" + N[i] + ", " + N[j] +"]");
			}
		}
	}
	
	public static void nCr(int r, int k) {					// 중복
		if(r == R) {
			System.out.println(Arrays.toString(result));
			return;
		}
		for (int i = k; i < N.length; i++) {
				result[r] = N[i];
				nCr(r+1,i+1);
			}
	}
	
	public static void subSet(int r, int k) {		// 부분집합(재귀)
		System.out.println(resultL);
		if(r == N.length) {
			return;
		}
		for (int i = k; i < N.length; i++) {
			resultL.add(N[i]);
			subSet(r+1,i+1);
			resultL.remove(resultL.size()-1);
		}
	}
	public static void subSetBit() {
		
		for (int i = 0; i < 1<<N.length; i++) {
			List<Character> subset = new ArrayList<>();
			for (int j = 0; j < N.length; j++) {
				if((i & (1<< j)) > 0) {
					subset.add(N[j]);
				}
			}
			System.out.println(subset);
		}
	}
	
	
	public static void main(String[] args) {
		// 순열 
		result = new char[R];
		visited = new boolean[N.length];
		nPr(0);
		System.out.println();
		// 중복 순열
		result = new char[R];
		nPrOver(0);
		System.out.println();
		// 조합(반복)
		result = new char[R];
		nCrFor();
		System.out.println();
		// 조합
		result = new char[R];
		nCr(0,0);
		System.out.println();
		// 부분집합(재귀)
		subSet(0,0);
		System.out.println();
		// 부분집합(비트)
		subSetBit();
		
	}

}
