package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2661_좋은수열 {

	private static StringBuilder sb = new StringBuilder();
	private static int N,flag;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		flag = 0;
		String ans="1";
		dfs(1,ans);
		
	}
	public static void dfs(int r, String ans) {
		if(flag == 1) return;
		
		if(r == N) {
			flag = 1;
			System.out.println(ans);
			return;
		}else {
			for (int i = 1; i <= 3; i++) {
				if(check(ans + Integer.toString(i),r)) {
					dfs(r+1,ans+Integer.toString(i));
				};
			}
		}
		
	}
	private static boolean check(String tmp,int r) {
		int start = r;
		int end = r+1;
		
		for (int j = 1; j <= (tmp.length()/2); j++) {
			if(tmp.substring(start-j,end-j).equals(tmp.substring(start, end))) {
				return false;
			}
			start-=1;
		}
		return true;
	}
	
}
