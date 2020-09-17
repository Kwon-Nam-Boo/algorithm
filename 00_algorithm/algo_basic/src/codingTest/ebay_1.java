package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ebay_1 {

	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = 1;
		//int[][] simulation_data = {{0, 3}, {2, 5}, {4, 2}, {5, 3}};
		int[][] simulation_data = {{2, 3}, {5, 4}, {6, 3}, {7, 4}};
		solution(N,simulation_data);
		
	}
	
	
	public static int solution(int N, int[][] simulation_data) {
	        int answer = 0;
	        int m = simulation_data.length;
	        // 창구
	        int[] win = new int[N];
	        Arrays.fill(win, -1);
	        
	        Queue<Integer> queue = new LinkedList<>();
	        // 대기 번호, 상담 순서
	        int i = 0, j = 0;
	        while(true) {
	        	counting(win,queue);
	        	
	        	if(j < m && i == simulation_data[j][0]) {
	        		int tmp = checkNull(win);
	        		// 비어있다면
	        		if(tmp >  -1) {
	        			win[tmp] = simulation_data[j][1];
	        		}else {
	        			queue.offer(simulation_data[j][1]);
	        		}
	        		j++;
	        	}
	        	i++;
	        	//System.out.println(Arrays.toString(win) + ":" +queue);
	        	if(j == m && queue.isEmpty()) {
	        		break;
	        	}
	        	
	        	if(!queue.isEmpty()) {
	        		answer += queue.size();
	        	}
	        }
	        System.out.println(answer);
	        return answer;
	    }
	
	public static int checkNull(int[] win) {
		
		for (int i = 0; i < win.length; i++) {
			if(win[i] == -1) return i;
		}
		return -1;
	}
	public static void counting(int[] win, Queue<Integer> queue) {
		
		for (int i = 0; i < win.length; i++) {
			if(win[i] != -1) win[i]--;
			if(win[i] == 0 && !queue.isEmpty()) {
				win[i] = queue.poll();
			}
			if(win[i] == 0) win[i] =-1;
		}
	}
}
