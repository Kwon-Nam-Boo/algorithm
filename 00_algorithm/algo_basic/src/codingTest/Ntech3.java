package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ntech3 {

	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[] histogram = {6, 5, 7, 3, 4, 2};
		System.out.println(solution(histogram));
	}
	public static int solution(int[] histogram) {
        int answer = 0;
        int start = 0;
        int end = histogram.length-1;
        
        while(start < end) {
        	int h = Math.min(histogram[start], histogram[end]);
        	int w = end - start -1;
        	answer = Math.max(h*w, answer);
        	if(histogram[start] > histogram[end]) end--;
        	else start++;
        }
        return answer;
    }
}
