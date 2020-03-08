package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_5430_AC {
	
	private static Deque<Integer> dq;
	private static boolean dir;
	private static boolean err;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		
		
		for (int i = 0; i < TC; i++) {
			
			dir = true;									// 원 상태 (앞부터)
			err = false;
			String src = br.readLine();
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), ",[]");
			dq = new ArrayDeque<>();
			
			while(st.hasMoreTokens()) {
				dq.add(Integer.parseInt(st.nextToken()));
			}
			//System.out.println(dq);
			
			for (int j = 0; j < src.length(); j++) {
				if(src.charAt(j) == 'R') {
					dir = !dir;
				}
				if(src.charAt(j) == 'D') {
					if(dq.isEmpty()) {
						err = true;
						break;
					}
					if(dir) {							// 앞 제거
						dq.poll();
					}else {								// 뒤 제거
						dq.pollLast();
					}
				}
			}
			if(dir && !err) {							// 앞방향 일경우
				sb.append("[");
				while(!dq.isEmpty()) {
					sb.append(dq.poll());
					if(dq.isEmpty()) break;
					sb.append(",");
				}
				sb.append("]");
				
			}else if (!dir && !err){					// 뒷발향 일경우
				sb.append("[");
				while(!dq.isEmpty()) {
					sb.append(dq.pollLast());
					if(dq.isEmpty()) break;
					sb.append(",");
				}
				sb.append("]");
				//System.out.println(Arrays.toString(tmp));
			}else if(err) {
				sb.append("error");
				//System.out.println("error");
			}
			sb.append("\n");
			
		}
		System.out.println(sb);
	}
	
}
