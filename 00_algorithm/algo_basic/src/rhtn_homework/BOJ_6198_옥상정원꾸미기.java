package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class BOJ_6198_옥상정원꾸미기 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// 해당 건물을 쳐다볼수 있는 건물의 수의 합(주의. 정답 자체가 int를 넘어버릴수도 있다)
		long ans = 0;
		
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < N; i++) {
			int build =Integer.parseInt(br.readLine());
			// 스택이 비어있지 않으면서, 맨위 값보다 작은게 들어올때까지 반복 ...
			while(!stack.isEmpty() && stack.peek() <= build) {
				// 크거나 같은 값이 들어온다면 현재 값을 pop한다
				stack.pop();
				// 해당 건물을 볼수 있는수는 stack에 쌓인 크기이다.
				ans += stack.size();
			}
			stack.push(build);
		}

		while(!stack.isEmpty()) {
			stack.pop();
			ans += stack.size();
		}
		System.out.println(ans);
	}
	


}
