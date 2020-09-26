package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16916_부분_문자열 {

	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String word = br.readLine();
		String pattern = br.readLine();
		System.out.println(KMP(word,pattern));
	}
	// KMP 알고리즘
	// j는 pattern, i는 word의 index로 서로를 비교한다
	public static int KMP(String word, String pattern) {
		int[] pi = getPi(pattern);
		int j = 0;
		for (int i = 0; i < word.length(); i++) {
			// 패턴이 일치하지 않으면? 이전의 pi값이 매칭할 패턴의 시작 위치다
			while(j>0 && word.charAt(i) !=pattern.charAt(j))
				j = pi[j-1];
			// j가 패턴 길이까지 도달했다면 매칭 완료(끝) , 아니라면 j를 증가
			if(word.charAt(i)==pattern.charAt(j)) {
				if(j == pattern.length()-1) return 1;
				else j++;
			}
		}
		return 0;
		
	}
	
	// pattern의 해당 위치에서 접두사 == 접미사인 부분의 최대길이를 pi에 저장한다(pi를 기반으로 패턴이 틀렷을때 재시작 위치를 조정한다)
	// j는 오른쪽, i는 왼쪽에서 시작하여 서로를 비교한다
	public static int[] getPi(String pattern) {
		int[] pi = new int[pattern.length()];
		int j = 0;
		for (int i = 1; i < pi.length; i++) {
			// j가 0이 아니면서 패턴이 일치하지 않는다면 , 이전 pi의 값이 시작 위치다(그 사이는 확인할 필요가 없다)
			while(j>0 && pattern.charAt(i)!=pattern.charAt(j)) {
				j = pi[j-1];
			}
			// 패턴이 같다면 현재의 최대길이를 저장해두자
			if(pattern.charAt(i)==pattern.charAt(j)) {
				pi[i] = ++j;
			}
		}
		
		return pi;
	}
	
}
