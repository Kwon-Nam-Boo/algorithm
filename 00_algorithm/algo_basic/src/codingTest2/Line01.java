package codingTest2;

import java.util.Arrays;
import java.util.HashMap;

public class Line01 {

	public static void main(String[] args) {
		String[] table = {"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"};
		String[] languages = {"PYTHON", "C++", "SQL"};
		int[] preference = {7,5,5};
		
		String a="a";
		String b="b";
		
		System.out.println(solution(table, languages, preference));
	}
	
	public static String solution(String[] table, String[] languages, int[] preference) {
		HashMap<String, Integer> hm = new HashMap<>();
		
        String answer = "";
        
        int ans = 0;
        for (int i = 0; i < table.length; i++) {
			String[] lang = table[i].split(" ");
			hm = new HashMap<>();
			for (int j = 5; j >=1; j--) {
				hm.put(lang[6-j], j);
			}
			int cnt = 0;
			//System.out.println(hm);
			
			for (int j = 0; j < languages.length; j++) {
				if(hm.containsKey(languages[j]))
					cnt+=(hm.get(languages[j])*preference[j]);
			}
			
			if(ans < cnt) {
				ans = cnt;
				answer = lang[0];
			}else if(ans == cnt) {
				if(answer.compareTo(lang[0]) > 0){
					answer = lang[0];
				}
			}
		}
        
        return answer;
    }
}
