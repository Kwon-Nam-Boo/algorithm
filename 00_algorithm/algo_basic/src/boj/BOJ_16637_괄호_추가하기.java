package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import org.xml.sax.InputSource;

public class BOJ_16637_괄호_추가하기 {
	
	private static int N;
	private static int max;
	private static char[] input;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		input = br.readLine().toCharArray();
		//System.out.println(Arrays.toString(input));
		max = Integer.MIN_VALUE;
		dfs(1,0,input[0]-'0',false);
		System.out.println(max);
		
	}
	public static void dfs(int idx,int pre_re, int re, boolean isBracket) {
		if(idx>= N) {
			max = Math.max(max, re);
			//System.out.println(re);
			return;
		}		
		// 연산자 까지해서 두칸 점프, 현재값은 과거값이되며 , 현재값은 계산된 값이 된다. , 괄호를 사용한게 아닌 그냥 계산 -> false
		dfs(idx+2, re, cal(re,input[idx],input[idx+1]-'0'),false);
		
		// 괄호를 연속으로(괄호안에 괄호) 사용할수 없다.
		if(idx>1 && !isBracket){
			// 현재 값이 아닌 과거값과 지금 만든 괄호값을 연산해야 한다 
			int brackCal = cal(input[idx-1]-'0',input[idx],input[idx+1]-'0');
			dfs(idx+2, 0, cal(pre_re, input[idx-2],brackCal),true);
		}
		
	}
	public static int cal(int a, char op,int b) {
		switch(op) {
			case '+':
				return a+b;
			case '-':
				return a-b;
			case '*':
				return a*b;
		}
		return 0;
	}
}
