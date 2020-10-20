package rhtn_homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class cheetsheet {

	private static int[] arr = {1,2,3,4}; 
	private static boolean[] visited; 
	private static int R = 2;
	private static int[] result;
	public static ArrayList<Integer> list = new ArrayList<>();
	
	public static void main(String[] args) {
		result = new int[R];
		visited = new boolean[arr.length];
		nPr(0);
		System.out.println();
		nPrSwap(0);
		System.out.println();
		//System.out.println(Arrays.toString(arr));
		Arrays.sort(arr);
		NP();
		Arrays.sort(arr);
		System.out.println();
		nCr(0,0);
		result = new int[R];
		System.out.println();
		nCrDef(4,2);
		System.out.println();
		subSetBit();
		System.out.println();
		subSetList(0,0);
		
		visited = new boolean[arr.length];
		subSetRecursion(0);
	}
	
	private static void subSetRecursion(int i) {
		if(i == arr.length) {
			print();
			return;
		}
		visited[i] = false;
		subSetRecursion(i+1);
		visited[i] = true;
		subSetRecursion(i+1);
	}

	private static void print() {
		for (int i = 0; i < visited.length; i++) {
			if(visited[i]){
				System.out.print(arr[i] + " ");
			}
		}
		System.out.println();
	}

	private static void subSetList(int d, int r) {
		System.out.println(list);
		if(r == arr.length) return;
		for (int i = d; i < arr.length; i++) {
			list.add(arr[i]);
			subSetList(i+1, r+1);
			list.remove(list.size()-1);
		}
		
	}

	private static void subSetBit() {
		for (int i = 0; i < 1<<arr.length; i++) {
			List<Integer> list = new LinkedList<>();
			for (int j = 0; j < arr.length; j++) {
				if((i & (1<<j)) > 0) list.add(arr[j]);
			}
			System.out.println(list);
		}
		
	}

	private static void nCrDef(int n, int r) {
		if(r == 0) {
			System.out.println(Arrays.toString(result));
			return;
		}else if(n<r) {
			return;
		}else {
			result[r-1] = arr[n-1];
			nCrDef(n-1,r-1);
			nCrDef(n-1,r);
		}
	}

	private static void nCr(int d, int r) {
		if(r == R) {
			System.out.println(Arrays.toString(result));
			return;
		}
		for (int i = d; i < arr.length; i++) {
			result[r] = arr[i];
			nCr(i+1,r+1);
		}
	}

	private static void NP() {
		do {
			System.out.println(Arrays.toString(arr));
		}while(nPrNP());
		
	}

	private static boolean nPrNP() {
		int i = 0;
		for (i = arr.length-2; i >=0 ; i--) {
			if(arr[i+1]>arr[i]) break;
		}
		if(i==-1) return false;
		
		int j = 0;
		for (j = arr.length-1; j >=0 ; j--) {
			if(arr[j]>arr[i]) break;
		}
		swap(i,j);
		
		for (int a = i+1, b = arr.length-1 ; a < b; a++, b--) {
			swap(a,b);
		}
		
		return true;
	}

	private static void nPrSwap(int r) {
		if(r == R) {
			System.out.println(Arrays.toString(Arrays.copyOfRange(arr, 0, R)));
			return;
		}
		for (int i = r; i < arr.length; i++) {
			swap(i,r);
			nPrSwap(r+1);
			swap(i,r);
		}
		
	}
	
	public static void swap(int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}

	public static void nPr(int r) {
		if(r == R) {
			System.out.println(Arrays.toString(result));
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if(!visited[i]) {
				result[r] = arr[i];
				visited[i] = true;
				nPr(r+1);
				visited[i] = false;
			}
		}
	}
}
