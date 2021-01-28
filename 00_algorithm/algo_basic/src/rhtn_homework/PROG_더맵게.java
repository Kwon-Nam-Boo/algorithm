package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class PROG_더맵게 {

	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[] scoville = {1, 2, 3, 9, 10, 12};
		int K =7;
		System.out.println(solution(scoville, K));
		
	}
	
	public static int solution(int[] scoville, int K) {
        int answer = 0;
        Arrays.sort(scoville);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++) {
			pq.offer(scoville[i]);
		}
        
        while(true) {
        	if(pq.size() == 1) {
        		answer = -1;
        		break;
        	}
        	int s1 = pq.poll();
            int s2 = pq.poll();
            pq.offer(s1+(s2*2));
            answer++;
            if(pq.peek() >= K) break;
        }
        
        return answer;
    }
}
