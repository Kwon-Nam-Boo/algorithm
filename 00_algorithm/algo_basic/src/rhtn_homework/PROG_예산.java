package rhtn_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PROG_예산 {

	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[] d = {2,2,3,3};
		int budget = 10;
		System.out.println(solution(d, budget));
		
	}
	
	public static int solution(int[] d, int budget) {
        int answer = 0;
        
        Arrays.sort(d);
        
        for (int i = 0; i < d.length; i++) {
			budget-=d[i];
			if(budget <0)
				break;
			else
				answer++;
		}
        return answer;
    }
}
