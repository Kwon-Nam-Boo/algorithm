package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class PRO_L2_수식_최대화 {
	/*
	 * 상혁이 코드와 유사함 베끼려고 한건 아니고, 그냥 전체적으로 훑다가 머리에 박혀서 그만 ..
	 * 
	 */
	private static StringBuilder sb = new StringBuilder();
	private static char[] operator = {'*','+','-'};
	private static char[] op;
	private static boolean[] visited;
	private static List<Long> numList;
	private static List<Character> opList;
	private static long ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String expression = "50*6-3*2";
		System.out.println(solution(expression));
		
	}
	public static long solution(String expression) {
		numList = new ArrayList<>();
		opList = new ArrayList<>();
		String num = "";
		for (int i = 0; i < expression.length(); i++) {
			char c = expression.charAt(i);
			// 숫자면
			if(c -'0' >= 0 && c -'0' <= 9 ) {
				num+=c;
			}else {
				numList.add(Long.parseLong(num));
				num = "";
				opList.add(c);
			}
		}
		numList.add(Long.parseLong(num));

		visited = new boolean[3];
		op = new char[3];
		ans = 0;
		dfs(0);		
		System.out.println(ans);
        return ans;
	 }
	private static void dfs(int i) {
		if(i == 3) {
			List<Long> numCopy = new ArrayList<>(numList);
			List<Character> opCopy = new ArrayList<>(opList);

			for (int j = 0; j < 3; j++) {
				
				for (int k = 0; k < opCopy.size(); k++) {
					// 현재 우선 순위에 대한 연산자이면
					if(op[j] == opCopy.get(k)) {
						// 해당 위치에 해당하는 숫자 두개를 계산한다
						Long tmp = cal(numCopy.get(k), numCopy.get(k+1), op[j]);
						// 계산후 제거
						numCopy.remove(k);
						numCopy.remove(k);
						numCopy.add(k, tmp);
						opCopy.remove(k);
						k--;
					}
					
				}
			
			}

			ans = Math.max(ans, Math.abs(numCopy.get(0)));
			return;
		}
		for (int j = 0; j < operator.length; j++) {
			if(!visited[j]) {
				visited[j] = true;
				op[i] = operator[j];
				dfs(i+1);
				visited[j] = false;
			}
		}
		
	}
	private static long cal(long a, long b, char x) {
		if(x =='+') return a+b;
		else if(x =='-') return a-b;
		else return a*b;
	}
}
