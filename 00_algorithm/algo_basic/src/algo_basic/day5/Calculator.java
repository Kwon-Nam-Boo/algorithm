package algo_basic.day5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Calculator {
	private static String src ="2+(3*4)/5";
	
	private static Stack<Character> stack = new Stack<>();  // step1에서 사용할 스택 char
	private static Stack<Integer> stack2 = new Stack<>();	//step2를 위한 스택 int
	//후위 표현식을 저장 할 리스트 
	private static List<Character> postLine = new ArrayList<>();
	private static List<Integer> result = new ArrayList<>();		// 결과 리스트
	
	public static void makePost2() {		// step1 중위를 후위로 바꿔준다
		
		for (int i = 0; i < src.length(); i++) {
			char token = src.charAt(i);
			int tokenOrder = getInStackOrder(token);
			if(tokenOrder ==0) {
				postLine.add(token);
			}else if(token=='(') {	// 여는 괄호는 무조건 push!
				stack.push(token);
			}else if(token ==')') { // 여는 괄호를 만날때 까지 pop --> 출력
				while(true) {
					char top =stack.pop();	
					if(top == '(') {	// 여는 괄호를 만나면 끝!
						break;
					}else {
						postLine.add(top);	// 아직이면 그사이를 출력!
					}
				}
			}else{						// 나머지의 경우
				while(!stack.isEmpty()) {
					char top = stack.peek();
					if(getInStackOrder(top) >= tokenOrder) {  //스택 안  vs 스택 밖
						postLine.add(stack.pop());
					}else {
						break;
					}
				}
				stack.push(token);
			}
			
		}
		// 남은 스택 처리
		while(!stack.isEmpty()) {			// 남은 녀석은 뺴주면서 넣어준다.
			postLine.add(stack.pop());
		}
		System.out.println(postLine);
	}
	
	
	public static void calculatePost(){		// step 2  후위를 가지고 계산하기
		for (int i = 0; i < postLine.size(); i++) {
			char token = postLine.get(i);
			int tokenOrder = getInStackOrder(token);
			if(tokenOrder ==0) {
				stack2.push(token -'0');
			}else {
				int b = stack2.pop();
				int a = stack2.pop();
				stack2.push(getCal(token,a,b));
			}
		}
		System.out.println(stack2.pop());
		
	}
	public static int getCal(char c, int a, int b) {
		if(c=='*') {
			return a*b;
		}
		else if(c=='/') {
			return a/b;
		}
		else if(c=='-') {
			return a-b;
		}
		else{
			return a+b;
		}
	}
	
	
	public static int getInStackOrder(char c) {
		if(c=='*'|| c=='/') {
			return 4;
		}
		else if(c=='+'|| c=='-') {
			return 3;
		}
		else if(c=='('|| c==')') {
			return 1;
		}else {
			return 0;
		}
	}
	
	
	public static void main(String[] args) {
		//src를 후위 표기법으로 교체하자
		
		makePost2();
		calculatePost();
	}

}
