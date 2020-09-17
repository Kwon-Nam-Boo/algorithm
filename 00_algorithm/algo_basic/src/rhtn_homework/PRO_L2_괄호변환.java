package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class PRO_L2_괄호변환 {

	private static StringBuilder sb = new StringBuilder();
	private static int idx;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String p = "()))((()";
		System.out.println(solution(p));
	}
	
	public static String solution(String p) {
		if(p.isEmpty()) return p;
		
		boolean correct = isCorrect(p);
		
		String u = p.substring(0,idx);
		String v =p.substring(idx, p.length());
		
		if(correct) {
			return u + solution(v);
		}else {
			String answer = "(" + solution(v) +")";
			String tmp = "";
	        for (int i = 1; i < u.length()-1; i++) {
				if(u.charAt(i) == '(') tmp+=')';
				else tmp+='(';
			}
	        return answer + tmp;
		}
    }
	
	public static boolean isCorrect(String p){
		boolean res = true;
		Stack<Character> stack = new Stack<>();
		int left = 0 , right =0;
		
		for (int i = 0; i < p.length(); i++) {
			char a = p.charAt(i);
			if(a == '(') {
				left++;
				stack.push(a);
			}else {
				right++;
				// 올바른 괄호 문자열이 아니다
				if(stack.isEmpty()) res = false;
				else stack.pop();
			}
			if(left == right) {
				idx = i+1;
				return res;
			}
			
		}
		
		return res;
		
	}
}
