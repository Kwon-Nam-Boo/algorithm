package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test2 {

	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		System.out.println(solution("ZAZAAAAZAZA"));
	}
	
	public static int solution(String name) {
        int answer = 0;
		int cnt = 0;
		char[] nick = name.toCharArray();
        boolean[] check = new boolean[nick.length];
        
        for(int i = 0 ; i < nick.length ; ++i) {
        	if(nick[i] != 'A') {
        		cnt++;
        	} else check[i] = true;
        }
        
        int idx = 0;
        for(int i = 0 ; i < cnt ; ++i) {
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
        	answer += changeAlphabet(idx, nick);
        }
        return answer;
    }
	
    private static int changeAlphabet(int i, char[] nick) {
        int up = nick[i] - 'A';
        int down = 'Z' - nick[i] + 1;
        
        if(up > down) {
            return down;
        } else {
            return up;
        } 
    }
}
