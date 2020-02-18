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
	
	}
	public static void nCr(int r, int k) {
		
	}
	
	public static void subSet(int r, int k) {
		
	}
	
	public static void subSet2() {

	}
}