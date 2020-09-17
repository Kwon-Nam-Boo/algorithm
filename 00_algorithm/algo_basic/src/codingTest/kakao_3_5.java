package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class kakao_3_5 {

	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
		String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
		
		System.out.println(Arrays.toString(solution(info,query)));
	}
	
	public static int[] solution(String[] info, String[] query) {
	     int[] answer = new int[query.length];
	     
	     
	     String[][] table = new String[info.length][5];
	     
	     for (int i = 0; i < info.length; i++) {
			String tmp = info[i];
			String[] array = tmp.split(" ");
			for (int j = 0; j < array.length; j++) {
				table[i][j] = array[j];
			}
		}
//	    for (String[] strings : table) {
//			System.out.println(Arrays.toString(strings));
//		}
	   
	    List<Integer> numList;
	    
	    for (int i = 0; i < query.length; i++) {
	    	String tmp = query[i];
	    	String[] array = tmp.split(" ");
	    	
	    	HashMap<Integer, Integer> numL = new HashMap<>();
	    	numList = new ArrayList<>();
	    	
	    	int k =0;
	    	for (int j = 0; j < array.length; j+=2) {
				if(array[j].equals("-")) continue;
				
				// 테이블 탐색
				k =0;
				while(k < numList.size()) {
					if(table[numL.get(k)][j/2].equals(array[j]))
					if(!table[numList.get(k)][j/2].equals(array[j])) {
						 numList.remove(k);
						 
					}else {
						k++;
					}
				}
				
			}
	    	int k2 =0;
	    	while(k2 < numList.size()) {
	    		if(Integer.parseInt(table[numList.get(k2)][4]) < Integer.parseInt(array[7])) {
	    			numList.remove(k2);
	    		}else {
	    			k2++;
	    		}
			}
	    	//System.out.println(numList);
	    	answer[i] = numList.size();
		}
	    
	    
	    return answer;
	}
}
