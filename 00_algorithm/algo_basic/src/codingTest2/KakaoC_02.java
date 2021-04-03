package codingTest2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KakaoC_02 {
	
	private static int ans;
	private static int n;
	private static int[] result;

	public static void main(String[] args) {
		int[][] needs = {{1, 0, 0}, {1, 1, 0}, {1, 1, 0}, {1, 0, 1}, {1, 1, 0}, {0, 1, 1}};
		int r = 5;
		System.out.println(solution(needs, r));
	}
	
	public static int solution(int[][] needs, int r) {
       
        ans = 0;
        result = new int[2];
        nCr(0,0,r,needs);
        return ans;
    }
	

	public static void nCr(int d, int k, int r, int[][] needs) {
		
		if(d == 2) {
			// 우선 전체 개수 중에서
			int cnt = needs.length;
			for (int i = 0; i < needs.length; i++) {
				for (int j = 0; j < needs[i].length; j++) {
					// i번 물건을 만드는데 j가 필요하다면
					if(needs[i][j] == 1) {
						boolean isIn = false;
						// result 배열을 뒤져본다. 만약 두개중 없다면? cnt감소
						for (int j2 = 0; j2 < 2; j2++) {
							if(result[j2] == j) {
								isIn = true;
								break;
							}
						}
						if(!isIn) cnt--;
					}
					// 백트레킹 , 만약 cnt가 이미 답보다 적다면 더할 필요가 없다
					if(ans>cnt) return;
				}
			}
			ans = Math.max(ans, cnt);
			return;
		}
		
		for (int i = k; i <= r; i++) {
			result[d] = i;
			nCr(d+1,i+1,r,needs);
		}
	}
}
