package codingTest2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lin02 {
	
	private static String word = "~!@#$%^&*"; 
	public static void main(String[] args) {
		String inp_str = "AaTa+!12-3";
		System.out.println(Arrays.toString(solution(inp_str)));
	}
	
	public static int[] solution(String inp_str) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>(); 
        // 1. password 길이
        if(!(inp_str.length()>=8 && inp_str.length()<=15)) list.add(1);
        
        // 2. 4종류의 그룹 확인
        char[] ans = inp_str.toCharArray();
        for (int i = 0; i < ans.length; i++) {
        	char c = ans[i];
			if(!(Character.isLetterOrDigit(c) || word.contains(c + ""))) {
				list.add(2);
				break;
			}
		}
        System.out.println(list);
        return answer;
    }
}
