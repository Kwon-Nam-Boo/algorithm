package algo_basic.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Pcstest {
	
	public static char[] N = {'A','B','C','D'};
	public static int R =2;
	public static char[] result;
	public static boolean[] visited;
	public static ArrayList<Character> list = new ArrayList<>();
	
	public static void main(String[] args) {
		// nPrVisted
		visited = new boolean[N.length];
		result = new char[R];
		nPrVisted(0);
		System.out.println();
		// nPrSwap
		nPrSwap(0);
		System.out.println();
		// NP()
		NP();
		System.out.println();
		Arrays.sort(N);
		// nCr
		result = new char[R];
		nCrRecursion(0, 0);
		System.out.println();
		//nCr
		nCrDef(N.length, R);
		System.out.println();
		//subSetBit
		subSetBit();
		System.out.println();
		// subSetList
		subSetList(0, 0);
		System.out.println();
		// subSetRecursion
		visited = new boolean[N.length];
		subSetRecursion(0);
	}
	public static void nPrVisted(int r) {
		// 
		if(r == R) {
			System.out.println(Arrays.toString(result));
			return;
		}
		for (int i = 0; i < N.length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				result[r] = N[i]; 
				nPrVisted(r+1);
				visited[i] = false;
			}
		}
		
	}
	public static void nPrSwap(int d){
		if(d == R) {
			System.out.println(Arrays.toString(Arrays.copyOfRange(N, 0, R)));
			//System.out.println(Arrays.toString(N));
		}
		for (int i = d; i < N.length; i++) {
			swap(i,d);
			nPrSwap(d+1);
			swap(i,d);
			
		}
	}
	public static void swap(int n, int m) {
		char tmp;
		tmp = N[n];
		N[n] = N[m];
		N[m] = tmp;
	
	}
	public static void NP() {
		do {
			System.out.println(Arrays.toString(N));
		}while(nPrNP());
	}
	
	public static boolean nPrNP() {
		
		int a;
		for (a = N.length-2; a >=0; a--) {
			if(N[a] < N[a+1]) break;
		}
		if(a<0) return false;
		
		int b;
		for (b = N.length-1; b >=0; b--) {
			if(N[a]<N[b]) break;
		}
		
		swap(a,b);
		
		for (int i = a+1, j = N.length-1; i<j; i++,j--) {
			swap(i,j);
		}
		
		return true;
	}
	
	public static void nCrRecursion(int r, int k) {
		if(r == R){
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
		}else if(n<r){
			return;
		}
		else {
			result[r-1] = N[n-1];
			nCrDef(n-1, r-1);
			nCrDef(n-1, r);
		}
	}
	
	public static void subSetBit() {
		for (int i = 0; i < (1<<N.length); i++) {
			List<Character> tmp = new ArrayList<>();
			for (int j = 0; j < N.length; j++) {
				if((i & 1<<j) > 0) {
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
			subSetList(r+1, i+1);
			list.remove(list.size()-1);
		}
	
	}
	public static void subSetRecursion(int r) {
		if(r == N.length) {
			print();
			return;
		}
		visited[r] = false;
		subSetRecursion(r+1);
		visited[r] = true;
		subSetRecursion(r+1);

	}
	public static void print() {
		
		for (int i = 0; i < N.length; i++) {
			if(visited[i]) {
				System.out.print(N[i] + " ");
			}
		}
		System.out.println();
	}
		
}