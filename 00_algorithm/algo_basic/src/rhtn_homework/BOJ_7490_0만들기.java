package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_7490_0만들기 {
	
	private static int N;
	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			N = Integer.parseInt(br.readLine());
			dfs(2,12, new StringBuilder("1 2"));
			dfs(1,1, new StringBuilder("1"));
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int i ,int sum, StringBuilder str) {
		
		if(i == N) {
			if(sum == 0)
				sb.append(str).append("\n");
			return;
		}
		
		
		if(i+2 <= N) {
			// 붙어있는 수
			int num = ((i+1)*10+(i+2));
			dfs(i+2,sum+num,str.append("+").append(i+1).append(" " +(i+2)));
			str.setLength(str.length()-4);
		}
		dfs(i+1,sum+(i+1),str.append("+").append(i+1));
		str.setLength(str.length()-2);
		if(i+2 <= N) {
			// 붙어있는 수
			int num = ((i+1)*10+(i+2));
			dfs(i+2,sum-num,str.append("-").append(i+1).append(" " +(i+2)));
			str.setLength(str.length()-4);
		}
		dfs(i+1,sum-(i+1),str.append("-").append(i+1));
		str.setLength(str.length()-2);
		
	}

}
