package algo_basic.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class test {
	
	public static char[] N = {'A','B','C','D'};
	public static int R =2;
	public static char[] result;
	public static boolean[] visited;
	public static ArrayList<Character> list;
	public static void main(String[] args) {
		// nPrVisted
		result = new char[R];
		visited = new boolean[N.length];
		nPrVisted(0);
		System.out.println();
		// nPrSwap
		result = new char[R];
		nPrSwap(0);
		System.out.println();
		// NP
		NP();
		// nCr
		Arrays.sort(N);
		result = new char[R];
		nCrRecursion(0, 0);
		System.out.println();
		//nCrDef
		result = new char[R];
		nCrDef(N.length, R);
		System.out.println();
		// subSetBit
		subSetBit();
		System.out.println();
		// subSetList
		list = new ArrayList<>();
		subSetList(0, 0);
		System.out.println();
		// subSetRecursion
		subSetRecursion(0);
		
		
		
		
	}
	public static void nPrVisted(int r) {
		if(r == R) {
			System.out.println(Arrays.toString(result));
			return;
		}
		for (int i = 0; i < N.length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				result[r] =N[i];
				nPrVisted(r+1);
				visited[i] =false;
			}
		}
		
	}
	public static void nPrSwap(int r) {				// 완벽히 외워보자
		if(r == R) {
			System.out.println(Arrays.toString(Arrays.copyOfRange(N, 0, R)));
			return;
		}
		for (int i = r; i < N.length; i++) {
			swap(i,r);
			nPrSwap(r+1);
			swap(i,r);
		}
		
	}
	public static void swap(int a, int b) {
		char tmp = N[a];
		N[a] = N[b];
		N[b] = tmp;
	}
	
	public static void NP() {
		do {
			System.out.println(Arrays.toString(N));
		}while(nPrNP());
	
	}
	
	
	public static boolean nPrNP() {
		int i;
		for (i = N.length-2; i >= 0 ; i--) {
			if(N[i+1]> N[i]) {
				break;
			}
		}
		if(i <0) {
			return false;
		}
		int j;
		for (j = N.length-1; j >=0 ; j--) {
			if(N[j]> N[i]) {
				break;
			}
		}
		swap(i,j);
		for (int a = i+1, b = N.length-1; a < b; a++, b--) {
			swap(a,b);
		}
		return true;
	}
	
	public static void nCrRecursion(int r, int k) {
		if(r == R) {
			System.out.println(Arrays.toString(result));
			return;
		}
		for (int i = k; i < N.length; i++) {
			result[r] = N[i];
			nCrRecursion(r+1, i+1);
		}
	}
	
	public static void nCrDef(int n, int r) {
		if(r == 0) {
			System.out.println(Arrays.toString(result));
			return;
		}else if(r>n) {
			return;
		}
		result[r-1] = N[n-1];
		
		nCrDef(n-1, r-1);
		nCrDef(n-1, r);
		
	}
	
	public static void subSetBit() {
		for (int i = 0; i < (1<<N.length); i++) {
			List<Character> tmp = new ArrayList<>();
			for (int j = 0; j < N.length; j++) {
				if((i &(1<<j))>0) {
					tmp.add(N[j]);
				}
			}
			System.out.println(tmp);
		}
	}
	
	public static void subSetList(int r, int k) {
		System.out.println(list);
		if(r == N.length) {
			return;
		}
		for (int i = k; i < N.length; i++) {
			list.add(N[i]);
			subSetList(r+1,i+1);
			list.remove(list.size()-1);
		}
	}
	public static void subSetRecursion(int r) {
		if(r == N.length) {
			print();
			return;
		}
		visited[r] =true;
		subSetRecursion(r+1);
		visited[r] = false;
		subSetRecursion(r+1);
	}
	public static void print() {
		for (int i = 0; i < visited.length; i++) {
			if(visited[i]){
				System.out.print(N[i] + " ");
			}
		}
		System.out.println();
	}
		
}