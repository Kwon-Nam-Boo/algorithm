package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class coupang1 {

	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = 14;
		System.out.println(Arrays.toString(solution(N)));
	}
	public static int[] solution(int N){
		int big = 1;
		int idx = 2;
		
		for (int i = 2; i <=9; i++) {
			int ans = 1;
			int tmp = N;
			while(tmp>=i){
				if(tmp%i!=0){
					ans*=(tmp%i);
					//System.out.println(ans);
				}
				tmp/=i;
			}
			ans*=tmp;
			if(ans >= big) {
				big = ans;
				idx = i;
			}
//			System.out.println(ans);
//			System.out.println();
		}
		int[] answer = new int[2];
		answer[0] = idx;
		answer[1] = big;
		return answer;
	}
	
}
