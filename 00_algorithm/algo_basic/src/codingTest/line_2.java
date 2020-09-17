package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class line_2 {

	private static StringBuilder sb = new StringBuilder();
	private static List<Integer> list;
	private static List<Integer> ans;
	private static List<Integer> stop;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
//		int[] ball = {1, 2, 3, 4, 5, 6};
//		int[] order = {6, 2, 5, 1, 4, 3};
		
		int[] ball = {11, 2, 9, 13, 24};
		int[] order = {9, 2, 13, 24, 11};
		
		System.out.println(Arrays.toString(solution(ball, order)));
		
	}
	
	public static int[] solution(int[] ball, int[] order) {
		
		int[] answer = {};
		answer = new int[ball.length];
        list = new ArrayList<>();
        ans = new ArrayList<>();
        stop = new ArrayList<>();
        
        for (int i = 0; i < ball.length; i++) {
			list.add(ball[i]);
		}
        
        for (int i = 0; i < order.length; i++) {
        	// stop 에 넣어주고 체크함수
        	stop.add(order[i]);
			
        	while(true) {
        		if(!check()) {
        			 break;
        		}
        	}
			
		}
  
        for (int i = 0; i < answer.length; i++) {
        	String tmp = ans.get(i).toString();
			answer[i] = Integer.parseInt(tmp);
		}
        return answer;
    }
	

	
	public static boolean check() {
		//
		if(list.size() ==0) return false;
		int s = list.get(0);
		int e = list.get(list.size()-1);
		
		for (int i = 0; i < stop.size(); i++) {
			if(s == stop.get(i)) {
				list.remove(0);
				ans.add(s);
				stop.remove(i);
				return true;
			}else if(e == stop.get(i)) {
				list.remove(list.size()-1);
				ans.add(e);
				stop.remove(i);
				return true;
			}
		}
		return false;
	}
}
