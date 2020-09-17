package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1579_암호_만들기 {

	private static StringBuilder sb = new StringBuilder();
	private static int L,C;
	private static char[] alpha;
	private static boolean[] visited;
	private static String vowel = "aeiou";
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		alpha= new char[C];
		visited = new boolean[C];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			alpha[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(alpha);
		//System.out.println(Arrays.toString(alpha));
		
		dfs(0,0,"");
		System.out.println(sb);
	}
	// cnt: 현재 비밀문자 수  , // r: 깊이 	// ans: 현재까지의 비밀문자 
	private static void dfs(int cnt, int r, String ans) {
		
		// 만약 cnt가 해당 길이라면?
		if(cnt == L) {
			// 조건 확인
			if(checkVowel(ans)) {
				sb.append(ans).append("\n");
			}
			return;
		}
		// 남아 있는 알파벳보다 현재의 비밀번호가 더길다면? ( 어차피 안되지~)
		if(L-cnt > C-r) {
			return;
		}

		for (int i = r; i < C; i++) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(cnt+1,i+1,ans+alpha[i]);
				visited[i] = false;
			}else {
				dfs(cnt,i+1,ans);
			}
		}
	}
	
	// 모음 1개이상, 자음 2개이상인가..?
	private static boolean checkVowel(String ans) {
		int v = 0;
		int nv = 0;
		
		for (int i = 0; i < ans.length(); i++) {
			if(vowel.indexOf(ans.charAt(i)) > -1) {
				v++;
			}else {
				nv++;
			}
		}
		
		if(v>=1 && nv>=2) {
			return true;
		}else {
			return false;
		}
		
	}
}
