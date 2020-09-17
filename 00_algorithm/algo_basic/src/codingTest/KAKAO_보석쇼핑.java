package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class KAKAO_보석쇼핑 {

	private static StringBuilder sb = new StringBuilder();
	private static String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
	//private static String[] gems = {"XYZ", "XYZ", "XYZ"};
	private static HashSet<String> gemsSet;
	private static int gemSize,start,end,ansX, ansY, len;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		System.out.println(Arrays.toString(solution(gems)));
	
	}
	 private static int[] solution(String[] gems) {
	        int[] answer;
	     
	        start = 0;
			gemsSet = new HashSet<>();
			
			for (int i = 0; i < gems.length; i++) {
				gemsSet.add(gems[i]);
			}
			gemSize = gemsSet.size();
			
			HashMap<String, Integer> gemMap = new HashMap<>();
			
			len = gems.length;
			ansX = 0;
			ansY = gems.length-1;
			
			int cnt=0;
			boolean flag = false;
			for (end = 0; end < gems.length; end++) {
				
				if(gemMap.containsKey(gems[end]))
				gemMap.put(gems[end], gemMap.get(gems[end])+1);
				else{
					gemMap.put(gems[end], 1);
					cnt++;
				}
		
				while(cnt == gemSize) {	// 조건 만족할 때는
					if(len > end -start +1){
						len = end -start +1;
						ansX = start;
						ansY = end;
					}
					if(gemSize == len) {
						flag =true;
						break;
					}
					++start;
					if(gemMap.get(gems[start-1]) == 1) {	// 이제 사라진다면?
						--cnt;
						gemMap.remove(gems[start-1]);
					}else {
						gemMap.put(gems[start-1], gemMap.get(gems[start-1])-1);
					}
				}
				if(flag) break;
				
			}
			answer = new int[2];
			answer[0] = ansX+1;
			answer[1] = ansY+1;
	        
	        return answer;
	    }
	

}
