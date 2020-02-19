package algo_ad.day1;

import java.util.HashMap;
import java.util.Map;

public class MoneyChangeGreedy {

	private static int[] coins = {500,400,100,50,10};
	private static Map<Integer, Integer> map = new HashMap<>();
	
	public static void main(String[] args) {
		int target = 800;
		
		for (int i = 0; i < coins.length; i++) {
			// 각 동전마다 시작해서 빼보기
			map.clear();
			changeMoneyLoop(target, i);
		}
	}
	
	public static void changeMoneyLoop(int target, int from) {
		int change = 0;
		for (int i = from; i < coins.length; i++) {
			// 1. 해 선택
			change +=coins[i];
			handleMap(coins[i], 1);
			//2. 실행 가능성 확인
			if(change > target) {
				change-=coins[i];
				handleMap(coins[i], -1);
				continue;
			}
			
			//3. 해 검사
			if(change < target) {
				i--;
			}else {
				System.out.println("빙고" + map);
				break;
			}
		}
		
	}
	
	public static void handleMap(Integer key, Integer val) {
		// 처음이면 신규 추가, 아니면 업데이트
		if(map.containsKey(key)) {
			map.put(key, map.get(key)+val);
		}else {
			map.put(key, val);
		}
	}

}
