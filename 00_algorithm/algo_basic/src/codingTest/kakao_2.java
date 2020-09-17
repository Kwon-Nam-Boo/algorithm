package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class kakao_2 {

	private static StringBuilder sb = new StringBuilder();
	private static List<Character> food;
	private static List<String> tmp;
	private static List<String> ans;
	private static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String[] orders = {"XYZ", "XWY", "WXA"};
		int[] course = {2,3,4};
		System.out.println(Arrays.toString(solution(orders, course)));
	}
	
	 public static String[] solution(String[] orders, int[] course) {
	        String[] answer = {};
	        food = new ArrayList<>();
	        
	        ans = new ArrayList<>();
	        // 우선 단품 리스트를 만든다
	        for (int i = 0; i < orders.length; i++) {
				for (int j = 0; j < orders[i].length(); j++) {
					if(!food.contains(orders[i].charAt(j))) {
						food.add(orders[i].charAt(j));
					}
				}
			}
	        // 그 알파벳 정렬도 해둔다
	        
	        Collections.sort(food);
	        for (int i = 0; i < course.length; i++) {
				int cour = course[i];
				// 2부터 시작
				max = 2;
				tmp = new ArrayList<>();
				nCrRecursion(0,0,"",cour,orders);
				for (int j = 0; j < tmp.size(); j++) {
					ans.add(tmp.get(j));
				}
			}
	        Collections.sort(ans);
	        answer = new String[ans.size()];
	        for (int i = 0; i < answer.length; i++) {
				answer[i] = ans.get(i);
			}
	        return answer;
	 }
	 // 평범한 nCr
	 public static void nCrRecursion(int r, int k, String result, int cour, String[] orders) {
			if(r == cour) {
				int cnt = 0;
				for (int j = 0; j < orders.length; j++) {
					// 없다면
					boolean flag = true;
					for (int i = 0; i < result.length(); i++) {
						if(orders[j].indexOf(result.charAt(i)) < 0) {
							 flag = false;
							 break;
						}
					}
					if(flag) cnt++;
				}
				// max면 리스트에 추가
				if(max == cnt) {	
					tmp.add(result);
				}else if(max < cnt) { // 넘어가면 현재까지 모은거 지우고 추가
					max = cnt;
					tmp.clear();
					tmp.add(result);
				}
				return;
			}
			
			for (int i = k; i < food.size(); i++) {
				nCrRecursion(r+1,i+1,result+ food.get(i),cour,orders);
			}
		}
}
