package rhtn_homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.plaf.synth.SynthScrollBarUI;

import boj.Solution4408_자기방으로돌아가기_부권남;

public class PROG_문자클러스터링 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PROG_문자클러스터링  prog = new PROG_문자클러스터링();
		String str1 ="aa1+aa2";
		String str2 = "AAAA12";
		System.out.println(prog.solution(str1, str2));
	}
	
	public int solution(String str1, String str2) {
        int answer = 0;
        
        int len = Math.max(str1.length(), str2.length());
        
        
        char[] s1 = str1.toLowerCase().toCharArray();
        char[] s2 = str2.toLowerCase().toCharArray();
        
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        
        for (int i = 0; i < len-1; i++) {
			if(i<s1.length-1 && Character.isLetter(s1[i]) && Character.isLetter(s1[i+1])) {
				list1.add((s1[i]+"") + (s1[i+1]+ ""));
			}
			if(i<s2.length-1 && Character.isLetter(s2[i]) && Character.isLetter(s2[i+1])) {
				list2.add((s2[i] +"") + (s2[i+1]+ ""));
			}
		}
        Collections.sort(list1);
        Collections.sort(list2);

        if(list1.size() == 0 && list2.size() == 0) return 65536;
        
        List<String> intersection = new ArrayList<>();
        List<String> union = new ArrayList<>();
        
        
        for (String s : list1) {
        	// 같은 수가 존재해서 지워진다면, 겹치는 수이므로 교집합
			if(list2.remove(s)) {
				intersection.add(s);
			}
			// list1의 모든수를 유니온에
			union.add(s);
		}
        // 교집합이 빠진 list2를 유니온에
        for (String s : list2) {
        	union.add(s);
		}
        
        
        answer = (int)((double)intersection.size() / (double)union.size() * 65536);
        
        
        return answer;
    }

}
