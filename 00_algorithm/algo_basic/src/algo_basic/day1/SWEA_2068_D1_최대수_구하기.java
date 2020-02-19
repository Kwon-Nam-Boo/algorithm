package algo_basic.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SWEA_2068_D1_최대수_구하기 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= TC; i++) {
			sb.append("#").append(i).append(" ");
			int max = Integer.MIN_VALUE;
			st = new StringTokenizer(br.readLine());
			for(int j=1;j <=10; j++) {
				int num = Integer.parseInt(st.nextToken());
				if(num >max) max =num;
			}
			sb.append(max).append("\n");
		}
		System.out.println(sb);
	}

}
