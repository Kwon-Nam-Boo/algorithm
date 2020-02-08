package algo_basic.day6;

import java.util.Arrays;

public class Permutation_Recur {
	
	//사용 가능한 후보군 - 자식들
	static char[] candidates = {'A','B','C'};
	
	// 방문 여부 체크
	static boolean[] visited = new boolean[candidates.length];

	public static void dfs(char[] tmp , int r) {
		if(r == candidates.length) {
			printSolution(tmp);
		}else {
			for (int i = 0; i < candidates.length; i++) {
				if(!visited[i]) {
					visited[i] =true;
					tmp[r] = candidates[i];
					dfs(tmp, r+1);
					visited[i] =false;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		dfs(new char[candidates.length], 0);
	}
	public static void printSolution(char[] tmp) {
		System.out.println(Arrays.toString(tmp));
	}

}
