package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PRO_L2_조이스틱 {

	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String name ="AZAAAAAAZAZ";
		// A: 65 Z:90
		//System.out.println('J' -'A');
		//System.out.println('Z' - 'J' +1);
		System.out.println(solution(name));
		
	}
	
	public static int solution(String name) {
        int answer = 0;
        
        char[] nick = name.toCharArray();
        // 고친 알파벳
        boolean[] check = new boolean[nick.length];
        
        // 고쳐야할 알파벳 수
        int cnt = 0;
        
        for(int i = 0 ; i < nick.length ; ++i) {
        	if(nick[i] != 'A') {
        		cnt++;
        	} else check[i] = true;	// 이미 고친 알파벳이다
        }
        
        // 현재 위치
        int idx = 0;
        for (int i = 0; i < cnt; i++) {
        	// 이미 다 고쳣다면 안고친 right, left를 찾는다 
			if(check[idx]) {
				
				int lidx = idx;
        		int ridx = idx;
        		int left = 0;
        		int right = 0;
        		
        		while(check[lidx]) {
        			if(lidx == 0) lidx = nick.length - 1;
        			else lidx--;
        			left++;
        		}
        		
        		while(check[ridx]) {
        			ridx = (ridx + 1) % nick.length;
        			right++;
        		}
        		
        		if(left >= right) {
        			idx = ridx;
        			answer += right;
        		} else {
        			idx = lidx;
        			answer += left;
        		}
			}
			check[idx] = true;
        	answer += changeAlpha(nick[idx]);
		}
        return answer;
    }
	
	public static int changeAlpha(char alpha) {
		return Math.min(alpha - 'A', 'Z' - alpha +1);
	}
	
}
