package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class line_1 {

	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[][] boxes = {{1, 2}, {2, 1}, {3, 3}, {4, 5}, {5, 6}, {3, 3}};
		System.out.println(solution(boxes));
	}
	 public static int solution(int[][] boxes) {
	        int answer = -1;
	        
	        List<Integer> list = new ArrayList<>();
	        for (int i = 0; i < boxes.length; i++) {
				for (int j = 0; j < boxes[i].length; j++) {
					list.add(boxes[i][j]);
				}
			}
	        Collections.sort(list);
	        
	        int cnt = 0;
	        for (int i = 0; i < list.size()-1; i++) {
				if(list.get(i) == list.get(i+1)) {
					cnt++;
					i++;
				}
			}
	     
	        return boxes.length - cnt;
	 }
	
}
