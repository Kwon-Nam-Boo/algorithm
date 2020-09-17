package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Kakao_1 {

	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		//String new_id = "...!@BaT#*..y.abcdefghijklm";
		//String new_id = "abcdefghijklmn.p";
		//String new_id = "z-+.^.";
		String new_id = "=.=";
		System.out.println(solution(new_id));
	}
	
	public static String solution(String new_id) {
        String answer = "";
        String filter = "-._0123456789";
        
        // 1단계
        char[] word = new_id.toLowerCase().toCharArray();
    
       
        new_id ="";
        // 2단계
        for (int i = 0; i < word.length; i++) {
			if((word[i]>=97 && word[i]<=122) || filter.indexOf(word[i]) > -1) {
				new_id+=word[i];
			}
		}
       
        word = new_id.toCharArray();
        new_id = Character.toString(word[0]);
        
        // 3단계
        for (int i = 1; i < word.length; i++) {
			if(word[i-1] =='.' && word[i] =='.') continue;
			new_id+=word[i];
		}
       
        // 4단계
        if(new_id.equals(".")) {
        	new_id="";
        }else {
        	if(new_id.charAt(0)=='.') {
            	new_id= new_id.substring(1);
            }
            if(new_id.charAt(new_id.length()-1) =='.') {
            	new_id= new_id.substring(0, new_id.length()-1);
            }
        }

        // 5단계
        if(new_id.length() == 0) new_id = "a";
        
        // 6단계
        if(new_id.length() >=16) {
        	new_id = new_id.substring(0, 15);
        }
        if(new_id.charAt(new_id.length()-1) =='.') {
        	new_id= new_id.substring(0, new_id.length()-1);
        }

        // 7단계
        if(new_id.length() <=2) {
        	char tmp = new_id.charAt(new_id.length()-1);
        	while(new_id.length() < 3) {
        		new_id+=tmp;
        	}
        }
       
        return new_id;
    }
}
