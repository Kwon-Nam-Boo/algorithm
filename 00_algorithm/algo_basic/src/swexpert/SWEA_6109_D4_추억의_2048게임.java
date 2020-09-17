package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class SWEA_6109_D4_추억의_2048게임 {

	private static int n;
	private static String dir;
	private static int[][] map;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());

		for (int t = 1; t <= TC; t++) {
			sb.append("#").append(t).append("\n");
			st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());
			dir = st.nextToken();
			
			map = new int[n][n];
			
			for (int r = 0; r < n; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < n; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			move(dir);
			
			for (int i = 0; i <n; i++) {
				for (int j = 0; j < n; j++) {
					sb.append(map[i][j]).append(" ");
				}
				sb.append("\n");
				
			}
		}
		System.out.println(sb);
		
	}

	private static void move(String dir) {
		Stack<Integer> stack = new Stack<>();
		switch (dir) {
		case "right":
			for (int r = 0; r < n; r++) {
				boolean changed = false;
				for (int c = n-1; c >=0 ; c--) {
					if(map[r][c] == 0) {
						continue;
					}else if(stack.isEmpty() || changed || !stack.peek().equals(map[r][c])) { // 스택이 비어있거나 서로 다른 수일경우에는
						stack.push(map[r][c]);
						changed = false;
					}else if(stack.peek().equals(map[r][c]) && !changed){		// 만약 수가 겹친다면?
						stack.pop();
						stack.push(map[r][c]*2);
						changed = true;
					}
				}
				int tmp = n - stack.size();
				
				for (int i = 0; i < tmp; i++) {
					stack.push(0);
				}
				
				
				for (int c = 0; c < n; c++) {
					map[r][c] = stack.pop();
				}
			}
			break;
			
		case "left":
			for (int r = 0; r < n; r++) {
				boolean changed = false;
				for (int c = 0; c <n ; c++) {
					if(map[r][c] == 0) {
						continue;
					}else if(stack.isEmpty() ||changed ||!stack.peek().equals(map[r][c])) { // 스택이 비어있거나 서로 다른 수일경우에는
						stack.push(map[r][c]);
						changed = false;
					}else if(stack.peek().equals(map[r][c]) && !changed){		// 만약 수가 겹친다면?
						stack.pop();
						stack.push(map[r][c]*2);
						changed = true;
					}
				}
				int tmp = n - stack.size();
				
				for (int i = 0; i < tmp; i++) {
					stack.push(0);
				}
				
				
				for (int c = n-1; c >=0 ; c--) {
					map[r][c] = stack.pop();
				}
			}
			break;
		
		case "up":
		for (int c = 0; c < n; c++) {
			boolean changed = false;
			for (int r = 0; r <n ; r++) {
				if(map[r][c] == 0) {
					continue;
					
				}else if(stack.isEmpty() ||changed || !stack.peek().equals(map[r][c])) { // 스택이 비어있거나 서로 다른 수일경우에는
					stack.push(map[r][c]);
					changed = false;
					
				}else if(stack.peek().equals(map[r][c]) && !changed){		// 만약 수가 겹친다면?
					stack.pop();
					stack.push(map[r][c]*2);
					changed = true;
				
				}
			}
			int tmp = n - stack.size();
			
			for (int i = 0; i < tmp; i++) {
				stack.push(0);
			}
			
			
			for (int r = n-1; r >=0 ; r--) {
				map[r][c] = stack.pop();
			}
		}
		break;
		
		case "down":
			for (int c = 0; c < n; c++) {
				boolean changed = false;
				for (int r = n-1; r >=0 ; r--) {
					if(map[r][c] == 0) {
						continue;
						
					}else if(stack.isEmpty() || changed || !stack.peek().equals(map[r][c])) { // 스택이 비어있거나 서로 다른 수일경우에는
						stack.push(map[r][c]);
						changed = false;
						
					}else if(stack.peek().equals(map[r][c]) && !changed){		// 만약 수가 겹친다면?
						stack.pop();
						stack.push(map[r][c]*2);
						changed = true;
					
					}
				}
				int tmp = n - stack.size();
				
				for (int i = 0; i < tmp; i++) {
					stack.push(0);
				}
				
				for (int r = 0; r < n ; r++) {
					map[r][c] = stack.pop();
				}
			}
			break;
		}
	} // end of move

} // end of class
