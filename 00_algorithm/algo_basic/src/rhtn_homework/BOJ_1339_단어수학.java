package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1339_단어수학 {
	
	private static int N;
	private static String[] word;
	private static int[] alpha;
	private static List<Integer> count;
	private static boolean[] visited;
	private static int ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		N = Integer.parseInt(br.readLine());
		alpha = new int[27];
		Arrays.fill(alpha, -1);
		count = new ArrayList<>();
		word = new String[N];
		for (int i = 0; i < N; i++) {
			word[i] = br.readLine();
			char[] line = word[i].toCharArray();
			for (int j = 0; j < line.length; j++) {
				// 처음보는 알파벳이면
				if(alpha[line[j]-65]==-1) {
					alpha[line[j]-65]=-2;
					count.add(line[j]-65);
				}
			}
		}
		visited = new boolean[10];
		ans=0;
		nPr(0);
		System.out.println(ans);
	}

	

	private static void nPr(int d) {
		
		if(d == count.size()) {
			ans = Math.max(ans, check());
			return;
		}
		
		for (int j = 9; j >= 10-count.size(); j--) {
			
			//미방문 상태
			if(!visited[j]){
				visited[j] =true;
				alpha[count.get(d)] = j;
				nPr(d+1);
				visited[j] = false;
				alpha[count.get(d)] = -2;
			}
				
		}
		
	}

	private static int check() {
		int total = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < word.length; i++) {
			sb.append(word[i]);
			
			for (int j = 0; j < word[i].length(); j++) {
				int a = alpha[sb.charAt(j)-65];
				sb.setCharAt(j, (char) (a+'0'));
			}
			total+=Integer.parseInt(sb.toString());
			sb = new StringBuilder();
		}
		return total;
	}
	
	

}
