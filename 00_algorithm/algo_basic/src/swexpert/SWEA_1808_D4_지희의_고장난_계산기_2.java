package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1808_D4_지희의_고장난_계산기_2 {
	
	private static boolean[] num;
	private static int X;
	private static int total;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int TC =Integer.parseInt(br.readLine());
		for (int i = 1; i <= TC; i++) {
			sb.append("#").append(i).append(" ");
			total = Integer.MAX_VALUE;
			num = new boolean[10];
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if(tmp==1) num[j] =true;
			}
			X = Integer.parseInt(br.readLine());
			dfs(X,0);
			total = total == Integer.MAX_VALUE ? -1 : total;
			sb.append(total).append("\n");
		}
		System.out.println(sb);
	}

	private static int dfs(int x, int cnt) {
		if(check(x+"")) {
			if(cnt ==0) {
				total = len(x)+1;
			}
			return len(x)+1;
		}
		int result =-1;
		for (int i = 2, end =(int) Math.sqrt(x)+1; i < end; i++) {
			if(x % i == 0 && check(i+"")) {
				int len1 = len(i)+1;
				int len2 = dfs(x/i, cnt+1);
				if(len2 >-1) {
					result = len1 + len2;
					if(result < total && x == X) {
						total = result;
					}
				}
			}
		}
		return result;
		
	}
	
	public static int len(int x) {
	        return (int)Math.log10(x) + 1;
	    }
	
	public static boolean check(String x) {
		for (char c : x.toCharArray()) {
			if(!num[c -'0']) {
				return false;
			}
		}
		return true;
	}

}
