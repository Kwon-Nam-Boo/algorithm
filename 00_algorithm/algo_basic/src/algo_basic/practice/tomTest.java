package algo_basic.practice;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.plaf.synth.SynthScrollBarUI;

public class tomTest {
	
	public static char[] N = {'A','B','C','D'};
	public static int R =2;
	public static char[] result;
	public static boolean[] visited;
	public static ArrayList<Character> list = new ArrayList<>();
	
	public static void main(String[] args) {
		visited = new boolean[N.length];
		result = new char[R];
		//nPrVisted(0);
		result = new char[R];
		//nCrRecursion(0, 0);
		subSetBit();
		System.out.println();
	}
	
	private static void subSetBit() {
		for (int i = 0; i < 1<<N.length; i++) {
			list = new ArrayList<>();
			for (int j = 0; j < N.length; j++) {
				if((i & 1<<j) > 0) list.add(N[j]);
			}
			System.out.println(list);
		}
		
	}

	private static void nCrRecursion(int d, int k) {
		
		if(d == R) {
			System.out.println(Arrays.toString(result));
			return;
		}
		for (int i = k; i < N.length; i++) {
			result[d] = N[i];
			nCrRecursion(d+1, i+1);
		}
		
	}

	private static void nPrVisted(int d) {
		
		if(d == R) {
			System.out.println(Arrays.toString(result));
			return;
		}
		
		for (int i = 0; i < N.length; i++) {
			if(!visited[i]){
				visited[i] = true;
				result[d] = N[i];
				nPrVisted(d+1);
				visited[i] = false;
			}
		}
		
	}
}
