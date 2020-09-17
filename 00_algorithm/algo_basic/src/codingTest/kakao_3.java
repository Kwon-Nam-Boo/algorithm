package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class kakao_3 {

	private static StringBuilder sb = new StringBuilder();
	private static int j;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String[] info = {"java backend junior pizza 150","python backend senior chicken 50",
				"python frontend senior chicken 210","python frontend senior chicken 150",
				"cpp backend senior pizza 260","java backend junior chicken 80"};
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
	    	
	    	numList = new LinkedList<>();
	    	// 초기화
	    	for (int j = 0; j < info.length; j++) {
				numList.add(j);
			}
	    	Collections.sort(numList, new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					Integer i1 = Integer.parseInt(table[o1][4]);
					Integer i2 = Integer.parseInt(table[o2][4]);
					
					return i2.compareTo(i1);
				}
			});
	    	
	    	int k =0;
	    	
	    	for (j = 0; j < array.length; j+=2) {
				if(array[j].equals("-")) continue;
				
				// 테이블 탐색
				k =0;
				while(k < numList.size()) {
					if(!table[numList.get(k)][j/2].equals(array[j])) {
						 numList.remove(k);
						
					}else {
						k++;
					}
				}
				//System.out.println(numList);
			}
	    	int k2 =0;
	    	
	    	while(k2 < numList.size()) {
	    		if(Integer.parseInt(table[numList.get(k2)][4]) >= Integer.parseInt(array[7])) {
	    			k2++;
	    		}
	    		else break;
			}
	    	
	    	//answer[i] = numList.size();
	    	answer[i] = k2;
		}
	    
	    
	    return answer;
	}
}
