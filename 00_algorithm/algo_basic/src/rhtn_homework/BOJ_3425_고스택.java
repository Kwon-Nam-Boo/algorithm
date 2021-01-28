package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_3425_고스택 {

	public static StringBuilder sb = new StringBuilder();
	public static Stack<Long> stack;
	public static boolean error;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		stack = new Stack<>();
		String[] comm = new String[100001];
		
		//QUIT 플래그
		int endFlag = 0;
		while(true) {
			
			// 명령어 저장
			int cnt = 0;
			while(true) {
				String tmp = br.readLine();
				if(tmp.equals("QUIT")) {
					endFlag =1;
					break;
				}
				// 명령어 END
				if(tmp.equals("END")) break;
				comm[cnt++] = tmp;
			}
			if(endFlag == 1) break;
			
			// 명령어 실행
			int num = Integer.parseInt(br.readLine());
			for (int i = 0; i < num; i++) {
				long input = Integer.parseInt(br.readLine());
				stack.push(input);
				for (int j = 0; j < cnt; j++) {
					goStack(comm[j]);
					// 해당 명령어 과정에 에러가 있다면 break(안걸면 에러 가능성있음)
					if(error) break;
				}
				
				// 스택이 아예 비었거나 에러라면 오류
				if(stack.isEmpty() || error) {
					sb.append("ERROR").append("\n");
				}else{
					long ans = stack.pop();
					// 하나의 스택값만 존재할경우 출력, 아님 에러
					if(stack.isEmpty()) {
						sb.append(ans).append("\n");
					}else {
						sb.append("ERROR").append("\n");
					}
				}
				// 에러 객체, 스택 초기화 과정
				stack = new Stack<>();
				error = false;
			}
			sb.append("\n");
			br.readLine();
			
		}
		System.out.print(sb);
		
	}

	private static void goStack(String tmp) {
		long s1,s2;

		switch (tmp) {
		case "POP":
			if(emptyStack()) break;
			stack.pop();
			break;
		case "INV":
			if(emptyStack()) break;
			s1 = stack.pop()*-1;
			stack.push(s1);
			break;
		case "DUP":
			if(emptyStack()) break;
			stack.push(stack.peek());
			break;
		case "SWP":
			if(emptyStack()) break;
			s1 = stack.pop();
			if(emptyStack()) break;
			s2 = stack.pop();
			stack.push(s1);
			stack.push(s2);
			break;	
		case "ADD":
			if(emptyStack()) break;
			s1 = stack.pop();
			if(emptyStack()) break;
			s1+=stack.pop();
			if(numOverflow(s1))break;
			stack.push(s1);
			break;	
		case "SUB":
			if(emptyStack()) break;
			s1 = stack.pop();
			if(emptyStack()) break;
			s1=stack.pop()-s1;
			if(numOverflow(s1))break;
			stack.push(s1);
			break;	
		case "MUL":
			if(emptyStack()) break;
			s1 = stack.pop();
			if(emptyStack()) break;
			s1*=stack.pop();
			if(numOverflow(s1))break;
			stack.push(s1);
			break;
		case "DIV":
			if(emptyStack()) break;
			s1 = stack.pop();
			if(s1 == 0) {
				error = true;
				break;
			}
			if(emptyStack()) break;
			s2 = stack.pop();
			long div = Math.abs(s2) / Math.abs(s1);
			
			//음수 조건
			if(!((s2 > 0 && s1 >0) || (s2 <0 && s1< 0))) {
				div = -div;
			}
			if(numOverflow(div))break;
			stack.push(div);
			break;
		case "MOD":
			if(emptyStack()) break;
			s1 = stack.pop();
			if(s1 == 0) {
				error = true;
				break;
			}
			if(emptyStack()) break;
			s2 = stack.pop();
			
			long mod = Math.abs(s2) % Math.abs(s1);
			//음수 조건
			if(s2<0) {
				mod = -mod;
			}
			if(numOverflow(mod))break;
			stack.push(mod);
			break;
		default:
			String[] num = tmp.split(" ");
			stack.push(Long.parseLong(num[1]));
			break;
		}
		
	}
	
	// 스택이 비었을 경우 에러처리
	public static boolean emptyStack(){
		if(stack.isEmpty()){
			error = true;
		}
		return error;
		
	}
	// 수가 넘어갈경우 에러처리
	public static boolean numOverflow(long num){
		if(num > 1000000000|| num < -1000000000) {
			error = true;
		}
		return error;
	}

}
