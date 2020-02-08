package ja;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class JA_1809_탑 {
	
	public static int[] top;
	public static Stack<Integer> stack = new Stack<>();
	public static int[] result;
	
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		top = new int[N];
		result = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			top[i] = Integer.parseInt(st.nextToken());
		}
		razer();
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
		System.out.println();
	}
	
	public static void razer() {
		
		stack.push(0);		// stack에는 top값의 index값을 넣는다 .. 0
		result[0] = 0;		// 시작은 0
		
		for (int i = 1; i < result.length; i++) {
			while(top[stack.peek()] < top[i]){		// 만약 스택 안 의 내용이 바깥보다 작으면
				result[i] = stack.pop()+1;			// pop하고  해당 index를 저장한다. (안의 내용이 커질때 까지)
				if(stack.isEmpty()) {				// 그러다가 스택이 텅텅비면
					stack.push(i);					// 현재 top값보다 큰게 없다 즉, 만나지 않음
					result[i] = 0;					// 
				}
			}
			if(top[stack.peek()] > top[i]) {	// 안의 내용이  바깥보다 크면
				result[i] = stack.peek()+1;		// 스택안의 index값을 저장하고
				stack.push(i);					// 스택을 쌓는다.
				
				
			}
			
		}
		
	}
	
}
