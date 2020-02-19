package algo_ad.day1;

import java.util.Arrays;

public class CombinationTest {

	private static char[] chars = {'A','B','C','D'};
	public static void main(String[] args) {
		//chars에서 3개를 뽀는 조합을 만들어보자
		int r = 3;
		//makeCombination(r, new char[r],0);
		
		// 조합의 정의를 활용
		makeCombination(chars.length, r, new char[r]);
		
	}
	// 조합의 정의를 황용 nCr = n-1Cr-1 + n-1Cr
	private static void makeCombination(int n, int r, char[] temp) {
		if(r==0) {
			System.out.println(Arrays.toString(temp));
			return;
		}else if(n<r) {
			return;
		}else {
			temp[r-1] = chars[n-1];	// n,r은 모두 개수, 우리가 사용하는 것은  idx(0부터 시작);
			makeCombination(n-1, r-1, temp);
			makeCombination(n-1, r, temp);
		}
		
	}
	
	private static void makeCombination(int r, char[] temp, int si) {
		// base case
		if(r == 0) {
			System.out.println("visited: " + Arrays.toString(temp));
			return;
		}
		// inductive case
		else {
			for (int i = si; i < chars.length; i++) {
				temp[r-1] = chars[i];
				makeCombination(r-1, temp,i+1);
			
			}
		}
	}
}


