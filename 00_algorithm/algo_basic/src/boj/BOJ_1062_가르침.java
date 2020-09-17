package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1062_가르침 {
	
	private static int N,K,max;
	private static List<Character> alpha;
	private static List<Character> result;
	private static String sheet ="antic";
	private static String[] word;

	
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		alpha = new ArrayList<>();
		
		word = new String[N];
		for (int i = 0; i < N; i++) {
			word[i] = br.readLine();
		}
		
		if(K<5) {	// K가 5개 이하라면
			System.out.println(0);
		}else {
			K-=5;
			// 단어 뽑기 
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < word[i].length(); j++) {
					char w = word[i].charAt(j);
					if(!alpha.contains(w) && sheet.indexOf(w)<0){
						alpha.add(word[i].charAt(j));
					}
				}
			}
			if(K >= alpha.size()) {
				System.out.println(N);
			}else {
				result = new ArrayList<>();
				max =0;
				nCr(0,0);
				System.out.println(max);
			}
			
		}
		
	}
	
	public static void nCr(int r, int k) {
		if(r == K) {
			max= Math.max(max, test());
			return;
		}
		for (int i = k; i < alpha.size(); i++) {
			result.add(alpha.get(i));
			nCr(r+1,i+1);
			result.remove(result.size()-1);
		}
	}

	private static int test() {
		int count = N;
		for (int i = 0; i < N; i++) {
			for (int j = 4; j < word[i].length()-4; j++) {
				char w = word[i].charAt(j);
				if(!result.contains(w) && sheet.indexOf(w)<0){
					count--;
					break;
				}
			}
		}
		return count;
	}
	
}
