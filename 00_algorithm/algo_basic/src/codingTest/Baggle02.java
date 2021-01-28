package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baggle02 {

	private static StringBuilder sb = new StringBuilder();
	private static int[] arr, len;
	private static int y,ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = 7;
		int[][] relation = {{1,5},{5,2},{5,6},{1,3},{1,4},{3,7}};
		String[] dirname = {"root","abcd","cs","hello","etc","hello","solution"};

		solution(N, relation, dirname);
		
	}
	public static int solution(int N, int[][] relation, String[] dirname) {
        arr = new int[N+1];
        len = new int[N];
        arr[1] = 0;

        for (int i = 0; i < relation.length; i++) {
			arr[relation[i][1]] = relation[i][0];
		}
        
        len[0] = dirname[0].length();
        
        for (int i = 1; i < len.length; i++) {
			len[i] = dirname[i].length()+1;
		}
        for (int i = 1; i < N+1; i++) {
        	 findSet(0,i, dirname,i);
		}
       
        System.out.println(ans);
        return ans;

    }

	public static int findSet(int z, int x, String[] dirname,int x1) {
		// 1이면 끝낸다
		if(arr[x] == 0) {
			z+=len[x-1];
			len[x1-1] = z;
			ans = Math.max(ans, z);
			arr[x1] = 0;
			return 0;
		}
		else {		// 그게 아니면  다시 탐색한다
			z+=len[x-1];
			int tmp = findSet(z, arr[x], dirname,x1);
			return tmp;
		}
	}
}
