package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Neo_1 {

	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String word = "UUUUU";
		System.out.println(solution(word));
		
	}
	
	public static int solution(String word) {
        int answer = 0;
        
        String w = "";
        for (int i = 0; i < 5; i++) {
        	if(word.length()-1 < i) {
        		w+="0";
        		continue;
        	}
			if(word.charAt(i) == 'A') w+= "1";
			else if(word.charAt(i) == 'E') w+= "2";
			else if(word.charAt(i) == 'I') w+= "3";
			else if(word.charAt(i) == 'O') w+= "4";
			else if(word.charAt(i) == 'U') w+= "5";
		}
        
        
        boolean flag = true;
        int cnt =0;
        for (int i = 10000; i < 55556; i++) {
			flag = true;
			String tmp = Integer.toString(i);
			
			// 5이상 검거
			for (int j = 0; j < 5; j++) {
				if(tmp.charAt(j) > '5') {
					flag =false;
					break;
				}
			}
			// 0 다음 숫자 검거
        	for (int j = 1; j < 5; j++) {
				if(tmp.charAt(j-1) == '0' && tmp.charAt(j) !='0') {
					flag =false;
					break;
				}
			}
        	
        	if(flag) {
        		cnt++;
        		if(tmp.equals(w)) {
        			answer = cnt;
        			break;
        		}
        	}
		}
        
        return answer;
    }
}
