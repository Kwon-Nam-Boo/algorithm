package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baggle04 {

	private static StringBuilder sb = new StringBuilder();
	private static int[] arr, len;
	private static int y;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = 7;
		int[][] relation = {{1,2},{2,5},{2,6},{1,3},{1,4},{3,7}};
		String[] dirname = {"root","abcd","cs","hello","etc","hello","solution"};
		solution(N, relation, dirname);
	}
	
	 public static int solution(int N, int[][] relation, String[] dirname) {
	        int answer = dirname[1].length();
	        arr = new int[N+1];
	        arr[1] = 0;
	        for (int i = 0; i < relation.length; i++) {
				arr[relation[i][1]] = relation[i][0];
			}
	        System.out.println(Arrays.toString(arr));
	        
	        answer = dirname[1].length();
	        for (int i = 1; i < N+1; i++) {
	        	y = 0;
	        	System.out.println(findSet(i, dirname));
	        	answer = Math.max(answer, findSet(i, dirname));
	     
			}
	        return answer;
	    }
		public static int findSet(int x, String[] dirname) {
			// 1이면 끝낸다
			if(arr[x] == 0) {
				y+=dirname[0].length();
				//System.out.println(y);
				return y;
			}
			else {		// 그게 아니면  다시 탐색한다
				y+=(dirname[x-1].length()+1);
				int tmp = findSet(arr[x], dirname);
				return tmp;
			}
		}
}
