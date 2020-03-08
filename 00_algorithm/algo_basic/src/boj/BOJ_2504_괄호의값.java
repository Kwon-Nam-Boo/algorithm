package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_2504_괄호의값 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String src = br.readLine();
		
		Stack<String> stack = new Stack<>();
		int result = 0;
		int RB =0;
		int SB =0;
		boolean err = false;
		
		for (int i = 0; i < src.length(); i++) {
			String a = String.valueOf(src.charAt(i));
			if(err) break;
			
			if(a.equals("(")) {							// 여는 괄호의 경우 스택에 넣기
				stack.push(a);
				RB++;
			}
			else if(a.equals(")")) {					// 닫는 괄호의 경우
				RB--;
				if(RB>=0) {								// 정상인 경우만
					if(stack.peek().equals("(")){		// 만약  () 라면 
						stack.pop();
						stack.push("2");
					}else {				
						int re = 0;
						
						while(!stack.isEmpty()) {						// x), [), (x), [x) 등등의 경우
							if(checkNum(stack.peek())) {
								re+=Integer.parseInt(stack.pop());
							}
							else if(stack.peek().equals("[")) {
								err = true;
								break;
							}
							else {
								stack.pop();							// (x)
								re*=2;
								stack.push(Integer.toString(re));
								break;
							}
						}
					}
				}
				else {						// 열린 경우보다 닫힌 경우가 많다면
					err = true;
					break;
				}
			}
			
			else if(a.equals("[")) {							// 여는 괄호의 경우 스택에 넣기
				stack.push(a);
				SB++;
			}
			
			else if(a.equals("]")) {					// 닫는 괄호의 경우
				SB--;
				if(SB>=0) {								// 정상인 경우만
					if(stack.peek().equals("[")){		// 만약  [] 라면 
						stack.pop();
						stack.push("3");
					}else {				
						int re = 0;
						
						while(!stack.isEmpty()) {						// x), [), (x), [x) 등등의 경우
							if(checkNum(stack.peek())) {
								re+=Integer.parseInt(stack.pop());
							}
							else if(stack.peek().equals("(")) {
								err = true;
								break;
							}
							else {
								stack.pop();						// [x]
								re*=3;
								stack.push(Integer.toString(re));
								break;
							}
						}
					}
				}
				else {						// 열린 경우보다 닫힌 경우가 많다면
					err = true;
					break;
				}
			}
			
		}
		if(err || RB !=0 || SB !=0) {		// 위에서 발견한 에러 이거나 RB와 SB에 수가 남아 있을 경우
			result = 0;
		}else {
			while(!stack.isEmpty()) {
	            result += Integer.parseInt(stack.pop());	// 남아있는 수를 다 더한다.
	        }
		}
		System.out.println(result);

	}
	public static boolean checkNum(String num) {
		char n;
		for (int i = 0; i < num.length(); i++) {
			if(!Character.isDigit(num.charAt(i))){		// 숫자가 아니라면 fail
				return false;
			}
			
		}
		return true;
	}

}
