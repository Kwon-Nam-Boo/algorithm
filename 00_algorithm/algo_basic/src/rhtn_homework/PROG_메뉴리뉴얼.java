package rhtn_homework;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PROG_메뉴리뉴얼 {
	
	List<HashMap<String, Integer>> foodMaps = new ArrayList<>();
	private static int[] maxMaps = new int[11];
	
	public static void main(String[] args) {
		String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
		int[] course = {2,3,4};
		
		PROG_메뉴리뉴얼  lc = new PROG_메뉴리뉴얼();
		System.out.println(Arrays.toString(lc.solution(orders, course)));
	}
	
	
	public String[] solution(String[] orders, int[] course) {
		
		for (int i = 0; i < 11; i++) {
			foodMaps.add(new HashMap<>());
		}
		for (String str : orders) {
			char[] arr = str.toCharArray();
			Arrays.sort(arr);
			// 재귀로 각 케이스를 만들어 나간다
			comb(arr,0,new StringBuilder());
		}
		
		ArrayList<String> list = new ArrayList<>(); 
		for (int len : course) {
			for (Map.Entry<String, Integer> entry : foodMaps.get(len).entrySet()) {
				if(entry.getValue() >=2 && maxMaps[len]== entry.getValue()){
					list.add(entry.getKey());
				};
			}
		}
		Collections.sort(list);
		
        String[] answer = new String[list.size()];
        for (int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i);
		}
        return answer;
    }


	private void comb(char[] str, int d, StringBuilder part) {
		
		//종료 조건
		if(d == str.length) {
			int len = part.length();
			// 2 이하라면 해줄 필요가 없다
			if(len>=2) {
				// 현재 문자열의 카운트(올려준값)
				int cnt = foodMaps.get(len).getOrDefault(part.toString(),0) +1;
				foodMaps.get(len).put(part.toString(), cnt);
				maxMaps[len] = Math.max(maxMaps[len] , cnt);
			}
			return;
		}
		
		// 1. 현재위치를 더해서 가는 경우
		comb(str,d+1,part.append(str[d]));
		// 원상태로 복구
		part.setLength(part.length()-1);
		// 2. 현재 위치를 지나 가는 경우
		comb(str,d+1,part);
	}
	
	
}
