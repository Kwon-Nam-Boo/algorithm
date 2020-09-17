package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class PRO_L2_문자열_압축 {

	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String word =  "dddccc";
		System.out.println(solution(word));
	}
	
	public static int solution(String s) {
        int answer = s.length();
        int result = 0;
        
        for (int i = 1; i <= s.length()/2; i++) {
        	
        	List<String> list = new ArrayList<>();
        	// x: i크기로 나눈 조각의 개수
			int x = s.length() / i;
			// i 길이의 조각으로 잘라 list 생성
			for (int j = 0; j < s.length(); j=j+i) {
				if(j+i > s.length())  break;
				else list.add(s.substring(j,j+i));
			}
			int tail = s.length() % i;
			//System.out.println(list);
			// 압축한 경우 체크
			int same = 1;
			result = i;
			for (int j = 1; j < list.size(); j++) {
				// 앞 뒤가 같다면
				if(list.get(j-1).equals(list.get(j))) {
					same++;
				}else{
					if(same > 1) result+=(i+(int)(Math.log10(same)+1));
					else result+=i;
					
					same = 1;
				}
				//System.out.println(result);
			}
			if(same > 1) result+=((int)(Math.log10(same)+1));
			
			answer = Math.min(result + tail, answer);
			//System.out.println(result);
		}
       // System.out.println(answer);
        return answer;
    }
}
