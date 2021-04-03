package codingTest2;

import java.util.*;

public class KakaoC_01 {

	public static void main(String[] args) {
		int[] gift_cards = {5, 4, 5, 4, 5};
		int[] wants = {1, 2, 3, 5, 4};
		
		System.out.println(solution(gift_cards, wants));
	}
	
	public static int solution(int[] gift_cards, int[] wants) {
        int answer = gift_cards.length;
        int[] count = new int[100001];
        
        for (int i = 0; i < gift_cards.length; i++) {
        	int idx = gift_cards[i];
			count[idx]++;
		}
        for (int i = 0; i < wants.length; i++) {
        	int idx = wants[i];
			if(count[idx]> 0) {
				count[idx]--;
				answer--;
			}
		}
        
        return answer;
    }

}
