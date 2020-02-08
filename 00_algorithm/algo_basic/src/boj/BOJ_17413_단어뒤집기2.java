package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BOJ_17413_단어뒤집기2 {
	
	private static Stack<String> stack = new Stack<>();			// 스택
	private static List<String> result;							// 결과를 넣을 리스트
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String src = br.readLine();
		String[] splited = src.split("");
		result= new ArrayList<>();
		
		int count =0;
		while(true) {
			if(count == splited.length) {		// 종료 조건 --> 문장을 끝까지 검색했다면
				while(!stack.isEmpty()) {		// 스택에 남은 문자를 pop()해서 출력문에 넣는다.
					String tmp =stack.pop();
					result.add(tmp);
				}
				break;
			}
			if(splited[count].equals(" ")) {	// 만약 공백일 경우
				while(!stack.isEmpty()) {
					String tmp =stack.pop();	// 스택이 비어버릴떄 까지 pop해서  ">" 포함 출력문에 넣는다. 
					result.add(tmp);
				}
				result.add(splited[count]);
			}else if(splited[count].equals("<")){	// "<" 일경우
				while(!stack.isEmpty()) {			// 우선  스택이 비어버릴떄 까지 pop해서 출력문에 넣는다.
					String tmp =stack.pop();
					result.add(tmp);
				}
						
				while(true) {						// "<"를 출력문에 넣고 ">"를 만날때까지 나온 모든 문자를 출력문에 넣는다.
					result.add(splited[count]);
					if(splited[count].equals(">")) {
						break;
					}
					count++;
				}
				
				
			}else {									// 만약 알파벳이나 숫자라면 스택에 넣어둔다.
				stack.push(splited[count]);
			}
			count++;
		}
		for (int i = 0; i < result.size(); i++) {
			System.out.print(result.get(i));
		}
		
		
	}

}