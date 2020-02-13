package algo_basic.day7;

import java.util.Arrays;
import java.util.Scanner;

public class CombinationTest {
	
	private static int N;
	private static int M;
	private static char[] result;
	public static char[] chars = {'A','B','C','D'};
	private static boolean[] visited;
	public static void main(String[] args) {
		// 4개의 원소에서 2개를 선택하는 순열을 구하시오
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		result = new char[M];
		visited = new boolean[N];
		//makePermutation(0);
		makeCombination(0 , 0);
		
	}
	public static void makePermutation(int r) {
		if(M == r) {
			System.out.println(Arrays.toString(result));
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(!visited[i]) {
			visited[i]= true;
			result[r] = chars[i];
			makePermutation(r+1);
			visited[i]= false;
			}
		}
		
	}
	public static void makeCombination(int r, int start) {
		if(M == r) {
			System.out.println(Arrays.toString(result));
			return;
		}
		
		for (int i = start ; i < N; i++) {
			result[r] = chars[i];
			makeCombination(r+1, i+1);
		}
		
	}
	
}
