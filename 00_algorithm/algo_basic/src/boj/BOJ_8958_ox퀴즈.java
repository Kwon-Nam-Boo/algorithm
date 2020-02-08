package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_8958_ox퀴즈 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		for (int i = 0; i < TC; i++) {
			String ox = br.readLine();
			int count =0;
			int result = 0;
			for (int j = 0; j < ox.length(); j++) {
				if(ox.charAt(j)=='O') {
					count++;
					result+=count;
				}else {
					count=0;
				}
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}

}
