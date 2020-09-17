package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ebay_2 {

	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int num = 8;
		int[] cards = {1,4,6}; 
		solution(num, cards);
	}
	public static int solution(int num, int[] cards) {
	      
	        int d[] = new int[num + 1];
	        for (int i = 1; i <= num; i++) {
				d[i] =-1;
				for (int j = 0; j < cards.length; j++) {
					if(cards[j] <=i) {
						// 0보다 작으면 패스
						if (d[i - cards[j]] < 0) continue;
	                    if (d[i] < 0) d[i] = d[i - cards[j]] + 1;
	                    else if (d[i - cards[j]] + 1 < d[i]) d[i] = d[i - cards[j]] + 1;
					}
				}
			}
	        
	        return d[num];
	}
}
