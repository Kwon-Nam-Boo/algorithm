package rhtn_homework;

import java.util.*;

public class BOJ_1242_소풍 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();	// 전체 크기
		int K = sc.nextInt();	// 술래 간격(불변)
		int M = sc.nextInt()-1;	// 동호의 번호
		//System.out.println(test(N,K,M));
		
		int cnt = 0;
	
		while(N >= 1) {
			int removed = (K-1)% N;
			if(removed == M) {
				cnt++;
				break;
			}
			M = M-K;
			while(M <0) {
				M+=N;
			}
			N--;
			cnt++;
		}
		System.out.println(cnt);
	}

	private static int test(int n, int k, int m) {
		int start = 0;
		int ans = 1;
		while(true) {
			int removed = (start + k -1) %n;
			if(removed == m) {
				break;
			}
			if(removed <m) {
				m--;
			}
			if(removed >m) {
				
			}
			start = removed;
			n--;
			ans++;
			System.out.println(n +" " + k + " " + m);
		}
		return ans;
	}

	
}
